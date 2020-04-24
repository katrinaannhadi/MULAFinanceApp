/* Mula */

package org.mula.finance.core.commands;

import androidx.annotation.*;

import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;

import java.util.*;

/**
 * Command to change the color of a list of habits.
 */
public class ChangeHabitColorCommand extends Command
{
    @NonNull
    final HabitList habitList;

    @NonNull
    final List<Habit> selected;

    @NonNull
    final List<Integer> originalColors;

    @NonNull
    final Integer newColor;

    public ChangeHabitColorCommand(@NonNull HabitList habitList,
                                   @NonNull List<Habit> selected,
                                   @NonNull Integer newColor)
    {
        this.habitList = habitList;
        this.selected = selected;
        this.newColor = newColor;
        this.originalColors = new ArrayList<>(selected.size());
        for (Habit h : selected) originalColors.add(h.getColor());
    }

    @Override
    public void execute()
    {
        for (Habit h : selected) h.setColor(newColor);
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
        int k = 0;
        for (Habit h : selected) h.setColor(originalColors.get(k++));
        habitList.update(selected);
    }

    public static class Record
    {
        @NonNull
        public String id;

        @NonNull
        public String event = "ChangeColor";

        @NonNull
        public List<Long> habits;

        @NonNull
        public Integer color;

        public Record(ChangeHabitColorCommand command)
        {
            id = command.getId();
            color = command.newColor;
            habits = new LinkedList<>();
            for (Habit h : command.selected)
            {
                if (!h.hasId()) throw new RuntimeException("Habit not saved");
                habits.add(h.getId());
            }
        }

        public ChangeHabitColorCommand toCommand(@NonNull HabitList habitList)
        {
            List<Habit> selected = new LinkedList<>();
            for (Long id : this.habits) selected.add(habitList.getById(id));

            ChangeHabitColorCommand command;
            command = new ChangeHabitColorCommand(habitList, selected, color);
            command.setId(id);
            return command;
        }
    }
}
