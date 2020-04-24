/* Mula */

package org.mula.finance.core.ui.screens.habits.show;

import androidx.annotation.*;

import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.commands.ToggleRepetitionCommand;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.Timestamp;

import javax.inject.*;

public class ShowHabitBehavior
{
    private HabitList habitList;

    @NonNull
    private final Habit habit;

    @NonNull
    private final CommandRunner commandRunner;

    @NonNull
    private Screen screen;

    @Inject
    public ShowHabitBehavior(@NonNull HabitList habitList,
                             @NonNull CommandRunner commandRunner,
                             @NonNull Habit habit,
                             @NonNull Screen screen)
    {
        this.habitList = habitList;
        this.habit = habit;
        this.commandRunner = commandRunner;
        this.screen = screen;
    }

    public void onEditHistory()
    {
        screen.showEditHistoryScreen();
    }

    public void onToggleCheckmark(Timestamp timestamp)
    {
        commandRunner.execute(
            new ToggleRepetitionCommand(habitList, habit, timestamp), null);
    }

    public interface Screen
    {
        void showEditHistoryScreen();
    }
}
