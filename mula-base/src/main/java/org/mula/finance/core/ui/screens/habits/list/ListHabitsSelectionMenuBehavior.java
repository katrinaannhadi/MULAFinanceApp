/* Mula */

package org.mula.finance.core.ui.screens.habits.list;

import androidx.annotation.*;

import org.mula.finance.core.commands.ArchiveHabitsCommand;
import org.mula.finance.core.commands.ChangeHabitColorCommand;
import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.commands.DeleteHabitsCommand;
import org.mula.finance.core.commands.UnarchiveHabitsCommand;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.ui.callbacks.OnColorPickedCallback;
import org.mula.finance.core.ui.callbacks.OnConfirmedCallback;

import java.util.*;

import javax.inject.*;

public class ListHabitsSelectionMenuBehavior
{
    @NonNull
    private final Screen screen;

    @NonNull
    CommandRunner commandRunner;

    @NonNull
    private final Adapter adapter;

    @NonNull
    private final HabitList habitList;

    @Inject
    public ListHabitsSelectionMenuBehavior(@NonNull HabitList habitList,
                                           @NonNull Screen screen,
                                           @NonNull Adapter adapter,
                                           @NonNull CommandRunner commandRunner)
    {
        this.habitList = habitList;
        this.screen = screen;
        this.adapter = adapter;
        this.commandRunner = commandRunner;
    }

    public boolean canArchive()
    {
        for (Habit h : adapter.getSelected())
            if (h.isArchived()) return false;

        return true;
    }

    public boolean canEdit()
    {
        return (adapter.getSelected().size() == 1);
    }

    public boolean canUnarchive()
    {
        for (Habit h : adapter.getSelected())
            if (!h.isArchived()) return false;

        return true;
    }

    public void onArchiveHabits()
    {
        commandRunner.execute(
            new ArchiveHabitsCommand(habitList, adapter.getSelected()), null);
        adapter.clearSelection();
    }

    public void onChangeColor()
    {
        List<Habit> selected = adapter.getSelected();
        Habit first = selected.get(0);

        screen.showColorPicker(first.getColor(), selectedColor ->
        {
            commandRunner.execute(
                new ChangeHabitColorCommand(habitList, selected, selectedColor),
                null);
            adapter.clearSelection();
        });
    }

    public void onDeleteHabits()
    {
        List<Habit> selected = adapter.getSelected();
        screen.showDeleteConfirmationScreen(() ->
        {
            adapter.performRemove(selected);
            commandRunner.execute(new DeleteHabitsCommand(habitList, selected),
                null);
            adapter.clearSelection();
        });
    }

    public void onEditHabits()
    {
        screen.showEditHabitsScreen(adapter.getSelected());
    }

    public void onUnarchiveHabits()
    {
        commandRunner.execute(
            new UnarchiveHabitsCommand(habitList, adapter.getSelected()), null);
        adapter.clearSelection();
    }

    public interface Adapter
    {
        void clearSelection();

        List<Habit> getSelected();

        void performRemove(List<Habit> selected);
    }

    public interface Screen
    {
        void showColorPicker(int defaultColor,
                             @NonNull OnColorPickedCallback callback);

        void showDeleteConfirmationScreen(
            @NonNull OnConfirmedCallback callback);

        void showEditHabitsScreen(@NonNull List<Habit> selected);
    }
}
