/* Mula */

package org.mula.finance.core.commands;

import androidx.annotation.*;

import com.google.auto.factory.*;

import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.HabitNotFoundException;
import org.mula.finance.core.models.ModelFactory;

/**
 * Command to create a habit.
 */
@AutoFactory
public class CreateHabitCommand extends Command
{
    ModelFactory modelFactory;

    HabitList habitList;

    @NonNull
    Habit model;

    @Nullable
    Long savedId;

    public CreateHabitCommand(@Provided @NonNull ModelFactory modelFactory,
                              @NonNull HabitList habitList,
                              @NonNull Habit model)
    {
        this.modelFactory = modelFactory;
        this.habitList = habitList;
        this.model = model;
    }

    @Override
    public void execute()
    {
        Habit savedHabit = modelFactory.buildHabit();
        savedHabit.copyFrom(model);
        savedHabit.setId(savedId);

        habitList.add(savedHabit);
        savedId = savedHabit.getId();
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
        if (savedId == null) throw new IllegalStateException();

        Habit habit = habitList.getById(savedId);
        if (habit == null) throw new HabitNotFoundException();

        habitList.remove(habit);
    }

    public static class Record
    {
        @NonNull
        public String id;

        @NonNull
        public String event = "CreateHabit";

        @NonNull
        public Habit.HabitData habit;

        @Nullable
        public Long savedId;

        public Record(CreateHabitCommand command)
        {
            id = command.getId();
            habit = command.model.getData();
            savedId = command.savedId;
        }

        public CreateHabitCommand toCommand(@NonNull ModelFactory modelFactory,
                                            @NonNull HabitList habitList)
        {
            Habit h = modelFactory.buildHabit(habit);

            CreateHabitCommand command;
            command = new CreateHabitCommand(modelFactory, habitList, h);
            command.savedId = savedId;
            command.setId(id);
            return command;
        }
    }
}