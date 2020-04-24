/* Mula */

package org.mula.finance.core.models.memory;

import androidx.annotation.*;

import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.Repetition;
import org.mula.finance.core.models.RepetitionList;
import org.mula.finance.core.models.Timestamp;

import java.util.*;

/**
 * In-memory implementation of {@link RepetitionList}.
 */
public class MemoryRepetitionList extends RepetitionList
{
    ArrayList<Repetition> list;

    public MemoryRepetitionList(Habit habit)
    {
        super(habit);
        list = new ArrayList<>();
    }

    @Override
    public void add(Repetition repetition)
    {
        list.add(repetition);
        observable.notifyListeners();
    }

    @Override
    public List<Repetition> getByInterval(Timestamp fromTimestamp, Timestamp toTimestamp)
    {
        ArrayList<Repetition> filtered = new ArrayList<>();

        for (Repetition r : list)
        {
            Timestamp t = r.getTimestamp();
            if (t.isOlderThan(fromTimestamp) || t.isNewerThan(toTimestamp)) continue;
            filtered.add(r);
        }

        Collections.sort(filtered,
            (r1, r2) -> r1.getTimestamp().compare(r2.getTimestamp()));

        return filtered;
    }

    @Nullable
    @Override
    public Repetition getByTimestamp(Timestamp timestamp)
    {
        for (Repetition r : list)
            if (r.getTimestamp().equals(timestamp)) return r;

        return null;
    }

    @Nullable
    @Override
    public Repetition getOldest()
    {
        Timestamp oldestTimestamp = Timestamp.ZERO.plus(1000000);
        Repetition oldestRep = null;

        for (Repetition rep : list)
        {
            if (rep.getTimestamp().isOlderThan(oldestTimestamp))
            {
                oldestRep = rep;
                oldestTimestamp = rep.getTimestamp();
            }
        }

        return oldestRep;
    }

    @Nullable
    @Override
    public Repetition getNewest()
    {
        Timestamp newestTimestamp = Timestamp.ZERO;
        Repetition newestRep = null;

        for (Repetition rep : list)
        {
            if (rep.getTimestamp().isNewerThan(newestTimestamp))
            {
                newestRep = rep;
                newestTimestamp = rep.getTimestamp();
            }
        }

        return newestRep;
    }

    @Override
    public void remove(@NonNull Repetition repetition)
    {
        list.remove(repetition);
        observable.notifyListeners();
    }

    @Override
    public long getTotalCount()
    {
        return list.size();
    }

    @Override
    public void removeAll()
    {
        list.clear();
        getObservable().notifyListeners();
    }
}
