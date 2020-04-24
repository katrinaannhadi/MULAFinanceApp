/* Mula */

package org.mula.finance.core.commands;

import androidx.annotation.*;

import com.google.gson.*;

import org.mula.finance.core.utils.StringUtils;

/**
 * A Command represents a desired set of changes that should be performed on the
 * models.
 * <p>
 * A command can be executed and undone. Each of these operations also provide
 * an string that should be displayed to the user upon their completion.
 * <p>
 * In general, commands should always be executed by a {@link CommandRunner}.
 */
public abstract class Command
{
    private String id;

    private boolean isRemote;

    public Command()
    {
        id = StringUtils.getRandomId();
        isRemote = false;
    }

    public Command(String id)
    {
        this.id = id;
        isRemote = false;
    }

    public abstract void execute();

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public boolean isRemote()
    {
        return isRemote;
    }

    public void setRemote(boolean remote)
    {
        isRemote = remote;
    }

    @NonNull
    public String toJson()
    {
        return new GsonBuilder().create().toJson(toRecord());
    }

    @NonNull
    public abstract Object toRecord();

    public abstract void undo();
}
