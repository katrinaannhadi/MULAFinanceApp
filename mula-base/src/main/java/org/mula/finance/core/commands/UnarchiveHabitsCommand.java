/* Mula */

package org.mula.finance.core.commands;

import androidx.annotation.*;

import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;

import java.util.*;

/**
 * Command to unarchive a list of habits.
 */
public class UnarchiveHabitsCommand extends Command
{
    @NonNull
    final HabitList habitList;

    @NonNull
    final List<Habit> selected;

    public UnarchiveHabitsCommand(@NonNull HabitList habitList,
                                  @NonNull List<Habit> selected)
    {
        this.selected = new LinkedList<>(selected);
        this.habitList = habitList;
    }

    @Override
    public void execute()
    {
        for (Habit h : selected) h.setArchived(false);
        habitList.update(selected);
    }

    @Override
    @NonNull
    public Record toRecord()
    {
        return new Record(this);
    }

    @Override
    public void undo()
    {
        for (Habit h : selected) h.setArchived(true);
        habitList.update(selected);
    }

    public static class Record
    {
        @NonNull
        public final String id;

        @NonNull
        public final String event = "Unarchive";

        @NonNull
        public final List<Long> habits;

        public Record(@NonNull UnarchiveHabitsCommand command)
        {
            id = command.getId();
            habits = new LinkedList<>();
            for (Habit h : command.selected)
            {
                if (!h.hasId()) throw new RuntimeException("Habit not saved");
                habits.add(h.getId());
            }
        }

        @NonNull
        public UnarchiveHabitsCommand toCommand(@NonNull HabitList habitList)
        {
            List<Habit> selected = new LinkedList<>();
            for (Long id : this.habits) selected.add(habitList.getById(id));

            UnarchiveHabitsCommand command;
            command = new UnarchiveHabitsCommand(habitList, selected);
            command.setId(id);
            return command;
        }
    }
}