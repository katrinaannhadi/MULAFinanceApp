/* Mula */

package org.mula.finance.core.commands;

import androidx.annotation.*;

import org.mula.finance.core.AppScope;
import org.mula.finance.core.tasks.Task;
import org.mula.finance.core.tasks.TaskRunner;

import java.util.*;

import javax.inject.*;

/**
 * A CommandRunner executes and undoes commands.
 * <p>
 * CommandRunners also allows objects to subscribe to it, and receive events
 * whenever a command is performed.
 */
@AppScope
public class CommandRunner
{
    private TaskRunner taskRunner;

    private LinkedList<Listener> listeners;

    @Inject
    public CommandRunner(@NonNull TaskRunner taskRunner)
    {
        this.taskRunner = taskRunner;
        listeners = new LinkedList<>();
    }

    public void addListener(Listener l)
    {
        listeners.add(l);
    }

    public void execute(final Command command, final Long refreshKey)
    {
        taskRunner.execute(new Task()
        {
            @Override
            public void doInBackground()
            {
                command.execute();
            }

            @Override
            public void onPostExecute()
            {
                for (Listener l : listeners)
                    l.onCommandExecuted(command, refreshKey);
            }
        });
    }

    public void removeListener(Listener l)
    {
        listeners.remove(l);
    }

    /**
     * Interface implemented by objects that want to receive an event whenever a
     * command is executed.
     */
    public interface Listener
    {
        void onCommandExecuted(@NonNull Command command,
                               @Nullable Long refreshKey);
    }
}
