/* Mula */

package org.mula.finance.core.commands;

import androidx.annotation.*;

import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;

import java.util.*;

/**
 * Command to delete a list of habits.
 */
public class DeleteHabitsCommand extends Command
{
    @NonNull
    final HabitList habitList;

    @NonNull
    final List<Habit> selected;

    public DeleteHabitsCommand(@NonNull HabitList habitList,
                               @NonNull List<Habit> selected)
    {
        this.selected = new LinkedList<>(selected);
        this.habitList = habitList;
    }


    @Override
    public void execute()
    {
        for (Habit h : selected)
            habitList.remove(h);
    }

    public List<Habit> getSelected()
    {
        return Collections.unmodifiableList(selected);
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
        throw new UnsupportedOperationException();
    }

    public static class Record
    {
        @NonNull
        public String id;

        @NonNull
        public String event = "DeleteHabit";

        @NonNull
        public List<Long> habits;

        public Record(DeleteHabitsCommand command)
        {
            id = command.getId();
            habits = new LinkedList<>();
            for (Habit h : command.selected)
            {
                if (!h.hasId()) throw new RuntimeException("Habit not saved");
                habits.add(h.getId());
            }
        }

        public DeleteHabitsCommand toCommand(@NonNull HabitList habitList)
        {
            List<Habit> selected = new LinkedList<>();
            for (Long id : this.habits) selected.add(habitList.getById(id));

            DeleteHabitsCommand command;
            command = new DeleteHabitsCommand(habitList, selected);
            command.setId(id);
            return command;
        }
    }
}
