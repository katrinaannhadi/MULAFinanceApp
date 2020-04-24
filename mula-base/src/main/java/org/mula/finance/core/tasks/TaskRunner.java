/* Mula */

package org.mula.finance.core.tasks;

public interface TaskRunner
{
    void addListener(Listener listener);

    void removeListener(Listener listener);

    void execute(Task task);

    void publishProgress(Task task, int progress);

    int getActiveTaskCount();

    interface Listener
    {
        void onTaskStarted(Task task);

        void onTaskFinished(Task task);
    }
}
