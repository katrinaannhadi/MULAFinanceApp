/* Mula */

package org.mula.finance.core.ui.widgets;

import androidx.annotation.*;

import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.commands.ToggleRepetitionCommand;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.Repetition;
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.ui.NotificationTray;

import javax.inject.*;

public class WidgetBehavior
{
    private HabitList habitList;

    @NonNull
    private final CommandRunner commandRunner;

    private NotificationTray notificationTray;

    @Inject
    public WidgetBehavior(@NonNull HabitList habitList,
                          @NonNull CommandRunner commandRunner,
                          @NonNull NotificationTray notificationTray)
    {
        this.habitList = habitList;
        this.commandRunner = commandRunner;
        this.notificationTray = notificationTray;
    }

    public void onAddRepetition(@NonNull Habit habit, Timestamp timestamp)
    {
        notificationTray.cancel(habit);
        Repetition rep = habit.getRepetitions().getByTimestamp(timestamp);
        if (rep != null) return;
        performToggle(habit, timestamp);
    }

    public void onRemoveRepetition(@NonNull Habit habit, Timestamp timestamp)
    {
        notificationTray.cancel(habit);
        Repetition rep = habit.getRepetitions().getByTimestamp(timestamp);
        if (rep == null) return;
        performToggle(habit, timestamp);
    }

    public void onToggleRepetition(@NonNull Habit habit, Timestamp timestamp)
    {
        performToggle(habit, timestamp);
    }

    private void performToggle(@NonNull Habit habit, Timestamp timestamp)
    {
        commandRunner.execute(
            new ToggleRepetitionCommand(habitList, habit, timestamp),
            habit.getId());
    }
}
