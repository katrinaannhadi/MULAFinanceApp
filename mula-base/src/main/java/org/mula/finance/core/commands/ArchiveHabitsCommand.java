/* Mula */

package org.mula.finance.core.commands;

import androidx.annotation.*;

import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;

import java.util.*;

/**
 * Command to archive a list of habits.
 */
public class ArchiveHabitsCommand extends Command
{
    final List<Habit> selected;

    final HabitList habitList;

    public ArchiveHabitsCommand(@NonNull HabitList habitList,
                                @NonNull List<Habit> selected)
    {
        super();
        this.habitList = habitList;
        this.selected = new LinkedList<>(selected);
    }

    @Override
    public void execute()
    {
        for (Habit h : selected) h.setArchived(true);
        habitList.update(selected);
    }

    @NonNull
    @Override
    public Record toRecord()
    {
        return new Record(this);
    }

    @Override
    public void undo()
    {
        for (Habit h : selected) h.setArchived(false);
        habitList.update(selected);
    }

    public static class Record
    {
        @NonNull
        public final String id;

        @NonNull
        public final String event = "Archive";

        @NonNull
        public final List<Long> habits;

        public Record(@NonNull ArchiveHabitsCommand command)
        {
            id = command.getId();
            habits = new LinkedList<>();
            for (Habit h : command.selected)
            {
                habits.add(h.getId());
            }
        }

        @NonNull
        public ArchiveHabitsCommand toCommand(@NonNull HabitList habitList)
        {
            List<Habit> selected = new LinkedList<>();
            for (Long id : this.habits) selected.add(habitList.getById(id));

            ArchiveHabitsCommand command;
            command = new ArchiveHabitsCommand(habitList, selected);
            command.setId(id);
            return command;
        }
    }
}