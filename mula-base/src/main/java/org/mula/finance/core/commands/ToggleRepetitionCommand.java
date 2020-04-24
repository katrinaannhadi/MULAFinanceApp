/* Mula */

package org.mula.finance.core.commands;

import androidx.annotation.*;

import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.HabitNotFoundException;
import org.mula.finance.core.models.Timestamp;

/**
 * Command to toggle a repetition.
 */
public class ToggleRepetitionCommand extends Command
{
    @NonNull
    private HabitList list;

    final Timestamp timestamp;

    @NonNull
    final Habit habit;

    public ToggleRepetitionCommand(@NonNull HabitList list,
                                   @NonNull Habit habit,
                                   Timestamp timestamp)
    {
        super();
        this.list = list;
        this.timestamp = timestamp;
        this.habit = habit;
    }

    @Override
    public void execute()
    {
        habit.getRepetitions().toggle(timestamp);
        list.update(habit);
    }

    @NonNull
    public Habit getHabit()
    {
        return habit;
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
        execute();
    }

    public static class Record
    {
        @NonNull
        public String id;

        @NonNull
        public String event = "Toggle";

        public long habit;

        public long repTimestamp;

        public Record(@NonNull ToggleRepetitionCommand command)
        {
            id = command.getId();
            Long habitId = command.habit.getId();
            if (habitId == null) throw new RuntimeException("Habit not saved");

            this.repTimestamp = command.timestamp.getUnixTime();
            this.habit = habitId;
        }

        public ToggleRepetitionCommand toCommand(@NonNull HabitList habitList)
        {
            Habit h = habitList.getById(habit);
            if (h == null) throw new HabitNotFoundException();

            ToggleRepetitionCommand command;
            command = new ToggleRepetitionCommand(
                habitList, h, new Timestamp(repTimestamp));
            command.setId(id);
            return command;
        }
    }
}