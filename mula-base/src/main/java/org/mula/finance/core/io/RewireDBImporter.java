/* Mula */

package org.mula.finance.core.io;

import androidx.annotation.*;

import org.mula.finance.core.database.Cursor;
import org.mula.finance.core.database.Database;
import org.mula.finance.core.database.DatabaseOpener;
import org.mula.finance.core.models.Frequency;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.ModelFactory;
import org.mula.finance.core.models.Reminder;
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.models.WeekdayList;
import org.mula.finance.core.utils.DateUtils;

import java.io.*;
import java.util.*;

import javax.inject.*;

/**
 * Class that imports database files exported by Rewire.
 */
public class RewireDBImporter extends AbstractImporter
{
    private ModelFactory modelFactory;

    @NonNull
    private final DatabaseOpener opener;

    @Inject
    public RewireDBImporter(@NonNull HabitList habits,
                            @NonNull ModelFactory modelFactory,
                            @NonNull DatabaseOpener opener)
    {
        super(habits);
        this.modelFactory = modelFactory;
        this.opener = opener;
    }

    @Override
    public boolean canHandle(@NonNull File file) throws IOException
    {
        if (!isSQLite3File(file)) return false;

        Database db = opener.open(file);
        Cursor c = db.query("select count(*) from SQLITE_MASTER " +
                            "where name='CHECKINS' or name='UNIT'");

        boolean result = (c.moveToNext() && c.getInt(0) == 2);

        c.close();
        db.close();
        return result;
    }

    @Override
    public void importHabitsFromFile(@NonNull File file) throws IOException
    {
        Database db = opener.open(file);
        db.beginTransaction();
        createHabits(db);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    private void createHabits(Database db)
    {
        Cursor c = null;

        try
        {
            c = db.query("select _id, name, description, schedule, " +
                         "active_days, repeating_count, days, period " +
                         "from habits");
            if (!c.moveToNext()) return;

            do
            {
                int id = c.getInt(0);
                String name = c.getString(1);
                String description = c.getString(2);
                int schedule = c.getInt(3);
                String activeDays = c.getString(4);
                int repeatingCount = c.getInt(5);
                int days = c.getInt(6);
                int periodIndex = c.getInt(7);

                Habit habit = modelFactory.buildHabit();
                habit.setName(name);
                habit.setDescription(description == null ? "" : description);

                int periods[] = { 7, 31, 365 };
                int numerator, denominator;

                switch (schedule)
                {
                    case 0:
                        numerator = activeDays.split(",").length;
                        denominator = 7;
                        break;

                    case 1:
                        numerator = days;
                        denominator = (periods[periodIndex]);
                        break;

                    case 2:
                        numerator = 1;
                        denominator = repeatingCount;
                        break;

                    default:
                        throw new IllegalStateException();
                }

                habit.setFrequency(new Frequency(numerator, denominator));
                habitList.add(habit);

                createReminder(db, habit, id);
                createCheckmarks(db, habit, id);

            } while (c.moveToNext());
        }
        finally
        {
            if (c != null) c.close();
        }
    }

    private void createCheckmarks(@NonNull Database db,
                                  @NonNull Habit habit,
                                  int rewireHabitId)
    {
        Cursor c = null;

        try
        {
            String[] params = { Integer.toString(rewireHabitId) };
            c = db.query(
                "select distinct date from checkins where habit_id=? and type=2",
                params);
            if (!c.moveToNext()) return;

            do
            {
                String date = c.getString(0);
                int year = Integer.parseInt(date.substring(0, 4));
                int month = Integer.parseInt(date.substring(4, 6));
                int day = Integer.parseInt(date.substring(6, 8));

                GregorianCalendar cal = DateUtils.getStartOfTodayCalendar();
                cal.set(year, month - 1, day);

                habit.getRepetitions().toggle(new Timestamp(cal));
            } while (c.moveToNext());
        }
        finally
        {
            if (c != null) c.close();
        }
    }

    private void createReminder(Database db, Habit habit, int rewireHabitId)
    {
        String[] params = { Integer.toString(rewireHabitId) };
        Cursor c = null;

        try
        {
            c = db.query(
                "select time, active_days from reminders where habit_id=? limit 1",
                params);

            if (!c.moveToNext()) return;
            int rewireReminder = Integer.parseInt(c.getString(0));
            if (rewireReminder <= 0 || rewireReminder >= 1440) return;

            boolean reminderDays[] = new boolean[7];

            String activeDays[] = c.getString(1).split(",");
            for (String d : activeDays)
            {
                int idx = (Integer.parseInt(d) + 1) % 7;
                reminderDays[idx] = true;
            }

            int hour = rewireReminder / 60;
            int minute = rewireReminder % 60;
            WeekdayList days = new WeekdayList(reminderDays);

            Reminder reminder = new Reminder(hour, minute, days);
            habit.setReminder(reminder);
            habitList.update(habit);
        }
        finally
        {
            if (c != null) c.close();
        }
    }
}