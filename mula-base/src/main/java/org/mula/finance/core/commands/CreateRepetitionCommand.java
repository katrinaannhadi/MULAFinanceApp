/* Mula */

package org.mula.finance.core.commands;

import androidx.annotation.*;

import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.HabitNotFoundException;
import org.mula.finance.core.models.Repetition;
import org.mula.finance.core.models.RepetitionList;
import org.mula.finance.core.models.Timestamp;

/**
 * Command to toggle a repetition.
 */
public class CreateRepetitionCommand extends Command
{
    @NonNull
    final Habit habit;

    final Timestamp timestamp;

    final int value;

    @Nullable
    Repetition previousRep;

    @Nullable
    Repetition newRep;

    public CreateRepetitionCommand(@NonNull Habit habit,
                                   Timestamp timestamp,
                                   int value)
    {
        this.timestamp = timestamp;
        this.habit = habit;
        this.value = value;
    }

    @Override
    public void execute()
    {
        RepetitionList reps = habit.getRepetitions();

        previousRep = reps.getByTimestamp(timestamp);
        if (previousRep != null) reps.remove(previousRep);

        newRep = new Repetition(timestamp, value);
        reps.add(newRep);

        habit.invalidateNewerThan(timestamp);
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
        if(newRep == null) throw new IllegalStateException();
        habit.getRepetitions().remove(newRep);

        if (previousRep != null) habit.getRepetitions().add(previousRep);
        habit.invalidateNewerThan(timestamp);
    }

    public static class Record
    {
        @NonNull
        public String id;

        @NonNull
        public String event = "CreateRep";

        public long habit;

        public long repTimestamp;

        public int value;

        public Record(CreateRepetitionCommand command)
        {
            id = command.getId();
            Long habitId = command.habit.getId();
            if(habitId == null) throw new RuntimeException("Habit not saved");

            this.habit = habitId;
            this.repTimestamp = command.timestamp.getUnixTime();
            this.value = command.value;
        }

        public CreateRepetitionCommand toCommand(@NonNull HabitList habitList)
        {
            Habit h = habitList.getById(habit);
            if(h == null) throw new HabitNotFoundException();

            CreateRepetitionCommand command;
            command = new CreateRepetitionCommand(
                h, new Timestamp(repTimestamp), value);
            command.setId(id);
            return command;
        }
    }
}