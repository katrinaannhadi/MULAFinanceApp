/* Mula */

package org.mula.finance.core.models.memory;

import androidx.annotation.*;

import org.mula.finance.core.models.Checkmark;
import org.mula.finance.core.models.CheckmarkList;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.Timestamp;

import java.util.*;

/**
 * In-memory implementation of {@link CheckmarkList}.
 */
public class MemoryCheckmarkList extends CheckmarkList
{
    ArrayList<Checkmark> list;

    public MemoryCheckmarkList(Habit habit)
    {
        super(habit);
        list = new ArrayList<>();
    }

    @Override
    public void add(List<Checkmark> checkmarks)
    {
        list.addAll(checkmarks);
        Collections.sort(list,
            (c1, c2) -> c2.getTimestamp().compare(c1.getTimestamp()));
    }

    @NonNull
    @Override
    public synchronized List<Checkmark> getByInterval(Timestamp from,
                                                      Timestamp to)
    {
        compute();

        Timestamp newestComputed = new Timestamp(0);
        Timestamp oldestComputed = new Timestamp(0).plus(1000000);

        Checkmark newest = getNewestComputed();
        Checkmark oldest = getOldestComputed();
        if(newest != null) newestComputed = newest.getTimestamp();
        if(oldest != null) oldestComputed = oldest.getTimestamp();

        List<Checkmark> filtered = new ArrayList<>(
            Math.max(0, oldestComputed.daysUntil(newestComputed) + 1));

        for(int i = 0; i <= from.daysUntil(to); i++)
        {
            Timestamp t = to.minus(i);
            if(t.isNewerThan(newestComputed) || t.isOlderThan(oldestComputed))
                filtered.add(new Checkmark(t, Checkmark.UNCHECKED));
            else
                filtered.add(list.get(t.daysUntil(newestComputed)));
        }

        return filtered;
    }

    @Override
    public void invalidateNewerThan(Timestamp timestamp)
    {
        list.clear();
        observable.notifyListeners();
    }

    @Override
    @Nullable
    protected Checkmark getOldestComputed()
    {
        if(list.isEmpty()) return null;
        return list.get(list.size()-1);
    }

    @Override
    @Nullable
    protected Checkmark getNewestComputed()
    {
        if(list.isEmpty()) return null;
        return list.get(0);
    }

}
