/* Mula */

package org.mula.finance.tasks;

import android.os.*;

import org.mula.finance.core.AppScope;
import org.mula.finance.core.tasks.Task;
import org.mula.finance.core.tasks.TaskRunner;

import java.util.*;

import dagger.*;

@Module
public class AndroidTaskRunner implements TaskRunner
{
    private final LinkedList<CustomAsyncTask> activeTasks;

    private final HashMap<Task, CustomAsyncTask> taskToAsyncTask;

    private LinkedList<Listener> listeners;

    public AndroidTaskRunner()
    {
        activeTasks = new LinkedList<>();
        taskToAsyncTask = new HashMap<>();
        listeners = new LinkedList<>();
    }

    @Provides
    @AppScope
    public static TaskRunner provideTaskRunner()
    {
        return new AndroidTaskRunner();
    }

    @Override
    public void addListener(Listener listener)
    {
        listeners.add(listener);
    }

    @Override
    public void execute(Task task)
    {
        task.onAttached(this);
        new CustomAsyncTask(task).execute();
    }

    @Override
    public int getActiveTaskCount()
    {
        return activeTasks.size();
    }

    @Override
    public void publishProgress(Task task, int progress)
    {
        CustomAsyncTask asyncTask = taskToAsyncTask.get(task);
        if (asyncTask == null) return;
        asyncTask.publish(progress);
    }

    @Override
    public void removeListener(Listener listener)
    {
        listeners.remove(listener);
    }

    private class CustomAsyncTask extends AsyncTask<Void, Integer, Void>
    {
        private final Task task;
        private boolean isCancelled = false;

        public CustomAsyncTask(Task task)
        {
            this.task = task;
        }

        public Task getTask()
        {
            return task;
        }

        public void publish(int progress)
        {
            publishProgress(progress);
        }

        @Override
        protected Void doInBackground(Void... params)
        {
            if(isCancelled) return null;
            task.doInBackground();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            if(isCancelled) return;
            task.onPostExecute();
            activeTasks.remove(this);
            taskToAsyncTask.remove(task);
            for (Listener l : listeners) l.onTaskFinished(task);
        }

        @Override
        protected void onPreExecute()
        {
            isCancelled = task.isCanceled();
            if(isCancelled) return;
            for (Listener l : listeners) l.onTaskStarted(task);
            activeTasks.add(this);
            taskToAsyncTask.put(task, this);
            task.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values)
        {
            task.onProgressUpdate(values[0]);
        }
    }
}
