/* Mula */

package org.mula.finance.core.tasks;

public abstract class CancelableTask implements Task
{
    private boolean isCanceled = false;

    @Override
    public synchronized void cancel()
    {
        isCanceled = true;
    }

    @Override
    public synchronized boolean isCanceled()
    {
        return isCanceled;
    }
}
