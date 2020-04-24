/* Mula */

package org.mula.finance.core.ui.screens.habits.list;

import junit.framework.Assert;

import org.mula.finance.core.*;
import org.junit.Test;
import org.mula.finance.core.commands.DeleteHabitsCommand;
import org.mula.finance.core.commands.ToggleRepetitionCommand;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.utils.DateUtils;

import java.util.*;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsEqual.*;
import static org.mockito.Mockito.*;

public class HabitCardListCacheTest extends BaseUnitTest
{
    private HabitCardListCache cache;

    private HabitCardListCache.Listener listener;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        habitList.removeAll();

        for (int i = 0; i < 10; i++)
        {
            if (i == 3) habitList.add(fixtures.createLongHabit());
            else habitList.add(fixtures.createShortHabit());
        }

        cache = new HabitCardListCache(habitList, commandRunner, taskRunner);
        cache.setCheckmarkCount(10);
        cache.refreshAllHabits();
        cache.onAttached();

        listener = mock(HabitCardListCache.Listener.class);
        cache.setListener(listener);
    }

    @Override
    public void tearDown()
    {
        cache.onDetached();
    }

    @Test
    public void testCommandListener_all()
    {
        assertThat(cache.getHabitCount(), equalTo(10));

        Habit h = habitList.getByPosition(0);
        commandRunner.execute(
            new DeleteHabitsCommand(habitList, Collections.singletonList(h)),
            null);

        verify(listener).onItemRemoved(0);
        verify(listener).onRefreshFinished();
        assertThat(cache.getHabitCount(), equalTo(9));
    }

    @Test
    public void testCommandListener_single()
    {
        Habit h2 = habitList.getByPosition(2);
        Timestamp today = DateUtils.getToday();
        commandRunner.execute(new ToggleRepetitionCommand(habitList, h2, today),
            h2.getId());

        verify(listener).onItemChanged(2);
        verify(listener).onRefreshFinished();
        verifyNoMoreInteractions(listener);
    }

    @Test
    public void testGet()
    {
        assertThat(cache.getHabitCount(), equalTo(10));

        Habit h = habitList.getByPosition(3);
        junit.framework.Assert.assertNotNull(h.getId());
        double score = h.getScores().getTodayValue();

        assertThat(cache.getHabitByPosition(3), equalTo(h));
        assertThat(cache.getScore(h.getId()), equalTo(score));

        Timestamp today = DateUtils.getToday();
        int[] actualCheckmarks = cache.getCheckmarks(h.getId());
        int[] expectedCheckmarks =
            h.getCheckmarks().getValues(today.minus(9), today);

        assertThat(actualCheckmarks, equalTo(expectedCheckmarks));
    }

    @Test
    public void testRemoval()
    {
        removeHabitAt(0);
        removeHabitAt(3);

        cache.refreshAllHabits();
        verify(listener).onItemRemoved(0);
        verify(listener).onItemRemoved(3);
        verify(listener).onRefreshFinished();
        assertThat(cache.getHabitCount(), equalTo(8));
    }

    @Test
    public void testRefreshWithNoChanges()
    {
        cache.refreshAllHabits();
        verify(listener).onRefreshFinished();
        verifyNoMoreInteractions(listener);
    }

    @Test
    public void testReorder_onCache()
    {
        Habit h2 = cache.getHabitByPosition(2);
        Habit h3 = cache.getHabitByPosition(3);
        Habit h7 = cache.getHabitByPosition(7);

        cache.reorder(2, 7);

        assertThat(cache.getHabitByPosition(2), equalTo(h3));
        assertThat(cache.getHabitByPosition(7), equalTo(h2));
        assertThat(cache.getHabitByPosition(6), equalTo(h7));
        verify(listener).onItemMoved(2, 7);
        verifyNoMoreInteractions(listener);
    }

    @Test
    public void testReorder_onList()
    {
        Habit h2 = habitList.getByPosition(2);
        Habit h3 = habitList.getByPosition(3);
        Habit h7 = habitList.getByPosition(7);

        assertThat(cache.getHabitByPosition(2), equalTo(h2));
        assertThat(cache.getHabitByPosition(7), equalTo(h7));
        reset(listener);

        habitList.reorder(h2, h7);
        cache.refreshAllHabits();

        assertThat(cache.getHabitByPosition(2), equalTo(h3));
        assertThat(cache.getHabitByPosition(7), equalTo(h2));
        assertThat(cache.getHabitByPosition(6), equalTo(h7));

        verify(listener).onItemMoved(3, 2);
        verify(listener).onItemMoved(4, 3);
        verify(listener).onItemMoved(5, 4);
        verify(listener).onItemMoved(6, 5);
        verify(listener).onItemMoved(7, 6);
        verify(listener).onRefreshFinished();
        verifyNoMoreInteractions(listener);
    }

    protected void removeHabitAt(int position)
    {
        Habit h = habitList.getByPosition(position);
        Assert.assertNotNull(h);
        habitList.remove(h);
    }

}