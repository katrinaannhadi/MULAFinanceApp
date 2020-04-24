/* Mula */

package org.mula.finance.core.reminders;

import androidx.annotation.*;

import org.mula.finance.core.AppScope;
import org.mula.finance.core.commands.ChangeHabitColorCommand;
import org.mula.finance.core.commands.Command;
import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.commands.ToggleRepetitionCommand;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.HabitMatcher;
import org.mula.finance.core.preferences.WidgetPreferences;
import org.mula.finance.core.utils.DateUtils;

import java.util.*;

import javax.inject.*;

@AppScope
public class ReminderScheduler implements CommandRunner.Listener
{
    private final WidgetPreferences widgetPreferences;

    private CommandRunner commandRunner;

    private HabitList habitList;

    private SystemScheduler sys;

    @Inject
    public ReminderScheduler(@NonNull CommandRunner commandRunner,
                             @NonNull HabitList habitList,
                             @NonNull SystemScheduler sys,
                             @NonNull WidgetPreferences widgetPreferences)
    {
        this.commandRunner = commandRunner;
        this.habitList = habitList;
        this.sys = sys;
        this.widgetPreferences = widgetPreferences;
    }

    @Override
    public synchronized void onCommandExecuted(@NonNull Command command,
                                               @Nullable Long refreshKey)
    {
        if (command instanceof ToggleRepetitionCommand) return;
        if (command instanceof ChangeHabitColorCommand) return;
        scheduleAll();
    }

    public synchronized void schedule(@NonNull Habit habit)
    {
        if (habit.getId() == null)
        {
            sys.log("ReminderScheduler", "Habit has null id. Returning.");
            return;
        }

        if (!habit.hasReminder())
        {
            sys.log("ReminderScheduler", "habit=" + habit.id + " has no reminder. Skipping.");
            return;
        }

        long reminderTime = habit.getReminder().getTimeInMillis();
        long snoozeReminderTime = widgetPreferences.getSnoozeTime(habit.getId());

        if (snoozeReminderTime != 0)
        {
            long now = DateUtils.applyTimezone(DateUtils.getLocalTime());
            sys.log("ReminderScheduler", String.format(
                    Locale.US,
                    "Habit %d has been snoozed until %d",
                    habit.getId(),
                    snoozeReminderTime));

            if (snoozeReminderTime > now)
            {
                sys.log("ReminderScheduler", "Snooze time is in the future. Accepting.");
                reminderTime = snoozeReminderTime;
            }
            else
            {
                sys.log("ReminderScheduler", "Snooze time is in the past. Discarding.");
                widgetPreferences.removeSnoozeTime(habit.getId());
            }
        }
        scheduleAtTime(habit, reminderTime);

    }

    public synchronized void scheduleAtTime(@NonNull Habit habit, long reminderTime)
    {
        sys.log("ReminderScheduler", "Scheduling alarm for habit=" + habit.id);

        if (!habit.hasReminder())
        {
            sys.log("ReminderScheduler", "habit=" + habit.id + " has no reminder. Skipping.");
            return;
        }

        if (habit.isArchived())
        {
            sys.log("ReminderScheduler", "habit=" + habit.id + " is archived. Skipping.");
            return;
        }

        long timestamp = DateUtils.getStartOfDay(DateUtils.removeTimezone(reminderTime));
        sys.log("ReminderScheduler",
                String.format(
                        Locale.US,
                        "reminderTime=%d removeTimezone=%d timestamp=%d",
                        reminderTime,
                        DateUtils.removeTimezone(reminderTime),
                        timestamp));

        sys.scheduleShowReminder(reminderTime, habit, timestamp);
    }

    public synchronized void scheduleAll()
    {
        sys.log("ReminderScheduler", "Scheduling all alarms");
        HabitList reminderHabits =
                habitList.getFiltered(HabitMatcher.WITH_ALARM);
        for (Habit habit : reminderHabits)
            schedule(habit);
    }

    public synchronized void startListening()
    {
        commandRunner.addListener(this);
    }

    public synchronized void stopListening()
    {
        commandRunner.removeListener(this);
    }

    public synchronized void snoozeReminder(Habit habit, long minutes)
    {
        long now = DateUtils.applyTimezone(DateUtils.getLocalTime());
        long snoozedUntil = now + minutes * 60 * 1000;
        widgetPreferences.setSnoozeTime(habit.getId(), snoozedUntil);
        schedule(habit);
    }

    public interface SystemScheduler
    {
        void scheduleShowReminder(long reminderTime, Habit habit, long timestamp);

        void log(String componentName, String msg);
    }
}
