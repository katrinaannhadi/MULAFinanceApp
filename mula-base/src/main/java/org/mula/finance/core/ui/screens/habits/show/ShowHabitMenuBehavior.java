/* Mula */

package org.mula.finance.core.ui.screens.habits.show;

import androidx.annotation.*;

import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.commands.DeleteHabitsCommand;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.Repetition;
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.tasks.ExportCSVTask;
import org.mula.finance.core.tasks.TaskRunner;
import org.mula.finance.core.ui.callbacks.OnConfirmedCallback;
import org.mula.finance.core.utils.DateUtils;

import java.io.*;
import java.util.*;

import javax.inject.*;

import static java.lang.Math.*;


public class ShowHabitMenuBehavior
{
    private HabitList habitList;

    @NonNull
    private final Habit habit;

    @NonNull
    private final TaskRunner taskRunner;

    @NonNull
    private Screen screen;

    @NonNull
    private System system;

    @NonNull
    private CommandRunner commandRunner;

    @Inject
    public ShowHabitMenuBehavior(@NonNull HabitList habitList,
                                 @NonNull Habit habit,
                                 @NonNull TaskRunner taskRunner,
                                 @NonNull Screen screen,
                                 @NonNull System system,
                                 @NonNull CommandRunner commandRunner)
    {
        this.habitList = habitList;
        this.habit = habit;
        this.taskRunner = taskRunner;
        this.screen = screen;
        this.system = system;
        this.commandRunner = commandRunner;
    }

    public void onEditHabit()
    {
        screen.showEditHabitScreen(habit);
    }

    public void onExportCSV()
    {
        List<Habit> selected = Collections.singletonList(habit);
        File outputDir = system.getCSVOutputDir();

        taskRunner.execute(
            new ExportCSVTask(habitList, selected, outputDir, filename ->
            {
                if (filename != null) screen.showSendFileScreen(filename);
                else screen.showMessage(Message.COULD_NOT_EXPORT);
            }));
    }

    public void onDeleteHabit()
    {
        List<Habit> selected = Collections.singletonList(habit);

        screen.showDeleteConfirmationScreen(() -> {
            commandRunner.execute(new DeleteHabitsCommand(habitList, selected),
                    null);
            screen.close();
        });
    }

    public void onRandomize()
    {
        Random random = new Random();
        habit.getRepetitions().removeAll();
        double strength = 50;

        for (int i = 0; i < 365 * 5; i++)
        {
            if (i % 7 == 0) strength = max(0, min(100, strength + 10 * random.nextGaussian()));
            if (random.nextInt(100) > strength) continue;

            int value = 1;
            if (habit.isNumerical())
                value = (int) (1000 + 250 * random.nextGaussian() * strength / 100) * 1000;

            habit.getRepetitions().add(new Repetition(DateUtils.getToday().minus(i), value));
        }

        habit.invalidateNewerThan(Timestamp.ZERO);
    }

    public enum Message
    {
        COULD_NOT_EXPORT, HABIT_DELETED
    }

    public interface Screen
    {
        void showEditHabitScreen(@NonNull Habit habit);

        void showMessage(Message m);

        void showSendFileScreen(String filename);

        void showDeleteConfirmationScreen(
                @NonNull OnConfirmedCallback callback);

        void close();
    }

    public interface System
    {
        File getCSVOutputDir();
    }
}
