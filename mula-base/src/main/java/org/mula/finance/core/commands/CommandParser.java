/* Mula */

package org.mula.finance.core.commands;

import androidx.annotation.*;

import com.google.gson.*;

import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.ModelFactory;

import javax.inject.*;

public class CommandParser
{
    private HabitList habitList;

    private ModelFactory modelFactory;

    @Inject
    public CommandParser(@NonNull HabitList habitList,
                         @NonNull ModelFactory modelFactory)
    {
        this.habitList = habitList;
        this.modelFactory = modelFactory;
    }

    @NonNull
    public Command parse(@NonNull String json)
    {
        JsonObject parsed = new JsonParser().parse(json).getAsJsonObject();
        String event = parsed.get("event").getAsString();
        Gson gson = new GsonBuilder().create();

        if (event.equals("Archive")) return gson
            .fromJson(json, ArchiveHabitsCommand.Record.class)
            .toCommand(habitList);

        if (event.equals("ChangeColor")) return gson
            .fromJson(json, ChangeHabitColorCommand.Record.class)
            .toCommand(habitList);

        if (event.equals("CreateHabit")) return gson
            .fromJson(json, CreateHabitCommand.Record.class)
            .toCommand(modelFactory, habitList);

        if (event.equals("CreateRep")) return gson
            .fromJson(json, CreateRepetitionCommand.Record.class)
            .toCommand(habitList);

        if (event.equals("DeleteHabit")) return gson
            .fromJson(json, DeleteHabitsCommand.Record.class)
            .toCommand(habitList);

        if (event.equals("EditHabit")) return gson
            .fromJson(json, EditHabitCommand.Record.class)
            .toCommand(modelFactory, habitList);

        if (event.equals("Toggle")) return gson
            .fromJson(json, ToggleRepetitionCommand.Record.class)
            .toCommand(habitList);

        if (event.equals("Unarchive")) return gson
            .fromJson(json, UnarchiveHabitsCommand.Record.class)
            .toCommand(habitList);

        throw new IllegalStateException("Unknown command");
    }
}
