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
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.utils.DateUtils;

import java.io.*;
import java.util.*;

import javax.inject.*;

/**
 * Class that imports data from database files exported by Tickmate.
 */
public class TickmateDBImporter extends AbstractImporter
{
    private ModelFactory modelFactory;

    @NonNull
    private final DatabaseOpener opener;

    @Inject
    public TickmateDBImporter(@NonNull HabitList habits,
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
                            "where name='tracks' or name='track2groups'");

        boolean result = (c.moveToNext() && c.getInt(0) == 2);

        c.close();
        db.close();
        return result;
    }

    @Override
    public void importHabitsFromFile(@NonNull File file) throws IOException
    {
        final Database db = opener.open(file);
        db.beginTransaction();
        createHabits(db);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    private void createCheckmarks(@NonNull Database db,
                                  @NonNull Habit habit,
                                  int tickmateTrackId)
    {
        Cursor c = null;

        try
        {
            String[] params = {Integer.toString(tickmateTrackId)};
            c = db.query(
                "select distinct year, month, day from ticks where _track_id=?",
                params);
            if (!c.moveToNext()) return;

            do
            {
                int year = c.getInt(0);
                int month = c.getInt(1);
                int day = c.getInt(2);

                GregorianCalendar cal = DateUtils.getStartOfTodayCalendar();
                cal.set(year, month, day);

                habit.getRepetitions().toggle(new Timestamp(cal));
            } while (c.moveToNext());
        }
        finally
        {
            if (c != null) c.close();
        }
    }

    private void createHabits(Database db)
    {
        Cursor c = null;

        try
        {
            c = db.query("select _id, name, description from tracks",
                new String[0]);
            if (!c.moveToNext()) return;

            do
            {
                int id = c.getInt(0);
                String name = c.getString(1);
                String description = c.getString(2);

                Habit habit = modelFactory.buildHabit();
                habit.setName(name);
                habit.setDescription(description == null ? "" : description);
                habit.setFrequency(Frequency.DAILY);
                habitList.add(habit);

                createCheckmarks(db, habit, id);

            } while (c.moveToNext());
        }
        finally
        {
            if (c != null) c.close();
        }
    }
}
