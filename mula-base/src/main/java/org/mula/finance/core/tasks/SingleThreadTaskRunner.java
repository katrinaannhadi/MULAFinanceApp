/* Mula */

package org.mula.finance.core.tasks;

import java.util.*;

public class SingleThreadTaskRunner implements TaskRunner
{
    private List<Listener> listeners = new LinkedList<>();

    @Override
    public void addListener(Listener listener)
    {
        listeners.add(listener);
    }

    @Override
    public void execute(Task task)
    {
        for(Listener l : listeners) l.onTaskStarted(task);
        if(!task.isCanceled())
        {
            task.onAttached(this);
            task.onPreExecute();
            task.doInBackground();
            task.onPostExecute();
        }
        for(Listener l : listeners) l.onTaskFinished(task);
    }

    @Override
    public int getActiveTaskCount()
    {
        return 0;
    }

    @Override
    public void publishProgress(Task task, int progress)
    {
        task.onProgressUpdate(progress);
    }

    @Override
    public void removeListener(Listener listener)
    {
        listeners.remove(listener);
    }
}
