/* Mula */

package org.mula.finance.core.models;

import androidx.annotation.*;

import org.mula.finance.core.utils.DateUtils;

import java.util.*;

/**
 * The collection of {@link Streak}s that belong to a habit.
 * <p>
 * This list is populated automatically from the list of repetitions.
 */
public abstract class StreakList
{
    protected final Habit habit;

    protected ModelObservable observable;

    protected StreakList(Habit habit)
    {
        this.habit = habit;
        observable = new ModelObservable();
    }

    public abstract List<Streak> getAll();

    @NonNull
    public List<Streak> getBest(int limit)
    {
        List<Streak> streaks = getAll();
        Collections.sort(streaks, (s1, s2) -> s2.compareLonger(s1));
        streaks = streaks.subList(0, Math.min(streaks.size(), limit));
        Collections.sort(streaks, (s1, s2) -> s2.compareNewer(s1));
        return streaks;
    }

    @Nullable
    public abstract Streak getNewestComputed();

    @NonNull
    public ModelObservable getObservable()
    {
        return observable;
    }

    public abstract void invalidateNewerThan(Timestamp timestamp);

    public synchronized void rebuild()
    {
        Timestamp today = DateUtils.getToday();
        Timestamp beginning = findBeginning();
        if (beginning == null || beginning.isNewerThan(today)) return;

        int checks[] = habit.getCheckmarks().getValues(beginning, today);
        List<Streak> streaks = checkmarksToStreaks(beginning, checks);

        removeNewestComputed();
        add(streaks);
    }

    /**
     * Converts a list of checkmark values to a list of streaks.
     *
     * @param beginning the timestamp corresponding to the first checkmark
     *                  value.
     * @param checks    the checkmarks values, ordered by decreasing timestamp.
     * @return the list of streaks.
     */
    @NonNull
    protected List<Streak> checkmarksToStreaks(Timestamp beginning, int[] checks)
    {
        ArrayList<Timestamp> transitions = getTransitions(beginning, checks);

        List<Streak> streaks = new LinkedList<>();
        for (int i = 0; i < transitions.size(); i += 2)
        {
            Timestamp start = transitions.get(i);
            Timestamp end = transitions.get(i + 1);
            streaks.add(new Streak(start, end));
        }

        return streaks;
    }

    /**
     * Finds the place where we should start when recomputing the streaks.
     *
     * @return
     */
    @Nullable
    protected Timestamp findBeginning()
    {
        Streak newestStreak = getNewestComputed();
        if (newestStreak != null) return newestStreak.getStart();

        Repetition oldestRep = habit.getRepetitions().getOldest();
        if (oldestRep != null) return oldestRep.getTimestamp();
        return null;
    }

    /**
     * Returns the timestamps where there was a transition from performing a
     * habit to not performing a habit, and vice-versa.
     *
     * @param beginning the timestamp for the first checkmark
     * @param checks    the checkmarks, ordered by decresing timestamp
     * @return the list of transitions
     */
    @NonNull
    protected ArrayList<Timestamp> getTransitions(Timestamp beginning, int[] checks)
    {
        ArrayList<Timestamp> list = new ArrayList<>();
        Timestamp current = beginning;
        list.add(current);

        for (int i = 1; i < checks.length; i++)
        {
            current = current.plus(1);
            int j = checks.length - i - 1;

            if ((checks[j + 1] == 0 && checks[j] > 0)) list.add(current);
            if ((checks[j + 1] > 0 && checks[j] == 0)) list.add(current.minus(1));
        }

        if (list.size() % 2 == 1) list.add(current);

        return list;
    }

    protected abstract void add(@NonNull List<Streak> streaks);

    protected abstract void removeNewestComputed();
}
