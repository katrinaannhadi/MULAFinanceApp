/* Mula */

package org.mula.finance.core.models.memory;

import androidx.annotation.*;

import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.Score;
import org.mula.finance.core.models.ScoreList;
import org.mula.finance.core.models.Timestamp;

import java.util.*;

public class MemoryScoreList extends ScoreList
{
    ArrayList<Score> list;

    public MemoryScoreList(Habit habit)
    {
        super(habit);
        list = new ArrayList<>();
    }

    @Override
    public void add(List<Score> scores)
    {
        list.addAll(scores);
        Collections.sort(list,
            (s1, s2) -> s2.getTimestamp().compare(s1.getTimestamp()));
        getObservable().notifyListeners();
    }

    @NonNull
    @Override
    public List<Score> getByInterval(@NonNull Timestamp fromTimestamp,
                                     @NonNull Timestamp toTimestamp)
    {
        compute(fromTimestamp, toTimestamp);

        List<Score> filtered = new LinkedList<>();

        for (Score s : list)
        {
            if (s.getTimestamp().isNewerThan(toTimestamp) ||
                s.getTimestamp().isOlderThan(fromTimestamp)) continue;
            filtered.add(s);
        }

        return filtered;
    }

    @Nullable
    @Override
    public Score getComputedByTimestamp(Timestamp timestamp)
    {
        for (Score s : list)
            if (s.getTimestamp().equals(timestamp)) return s;

        return null;
    }

    @Override
    public void invalidateNewerThan(Timestamp timestamp)
    {
        list.clear();
        getObservable().notifyListeners();
    }

    @Override
    @NonNull
    public List<Score> toList()
    {
        computeAll();
        return new LinkedList<>(list);
    }

    @Nullable
    @Override
    protected Score getNewestComputed()
    {
        if (list.isEmpty()) return null;
        return list.get(0);
    }

    @Nullable
    @Override
    protected Score getOldestComputed()
    {
        if (list.isEmpty()) return null;
        return list.get(list.size() - 1);
    }
}
