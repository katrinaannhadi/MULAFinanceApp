/* Mula */

package org.mula.finance.core.utils;

import org.mula.finance.core.AppScope;

import java.util.*;
import java.util.concurrent.*;

import javax.inject.*;

/**
 * A class that emits events when a new day starts.
 */
@AppScope
public class MidnightTimer
{
    private final List<MidnightListener> listeners;

    private ScheduledExecutorService executor;

    @Inject
    public MidnightTimer()
    {
        this.listeners = new LinkedList<>();
    }

    public synchronized void addListener(MidnightListener listener)
    {
        this.listeners.add(listener);
    }

    public synchronized void onPause()
    {
        executor.shutdownNow();
    }

    public synchronized void onResume()
    {
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> notifyListeners(),
            DateUtils.millisecondsUntilTomorrow() + 1000,
            DateUtils.DAY_LENGTH, TimeUnit.MILLISECONDS);
    }

    public synchronized void removeListener(MidnightListener listener)
    {
        this.listeners.remove(listener);
    }

    private synchronized void notifyListeners()
    {
        for (MidnightListener l : listeners) l.atMidnight();
    }

    public interface MidnightListener
    {
        void atMidnight();
    }
}
