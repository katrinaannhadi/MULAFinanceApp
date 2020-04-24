/* Mula */

package org.mula.finance.core.models.memory;

import androidx.annotation.*;

import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.Streak;
import org.mula.finance.core.models.StreakList;
import org.mula.finance.core.models.Timestamp;

import java.util.*;

public class MemoryStreakList extends StreakList
{
    ArrayList<Streak> list;

    public MemoryStreakList(Habit habit)
    {
        super(habit);
        list = new ArrayList<>();
    }

    @Override
    public Streak getNewestComputed()
    {
        Streak newest = null;

        for (Streak s : list)
            if (newest == null || s.getEnd().isNewerThan(newest.getEnd()))
                newest = s;

        return newest;
    }

    @Override
    public void invalidateNewerThan(Timestamp timestamp)
    {
        list.clear();
        observable.notifyListeners();
    }

    @Override
    protected void add(@NonNull List<Streak> streaks)
    {
        list.addAll(streaks);
        Collections.sort(list, (s1, s2) -> s2.compareNewer(s1));
        observable.notifyListeners();
    }

    @Override
    protected void removeNewestComputed()
    {
        Streak newest = getNewestComputed();
        if (newest != null) list.remove(newest);
    }

    @Override
    public List<Streak> getAll()
    {
        rebuild();
        return new LinkedList<>(list);
    }
}
