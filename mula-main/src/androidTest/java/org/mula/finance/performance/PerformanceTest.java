/* Mula */

package org.mula.finance.performance;

import androidx.test.filters.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.mula.finance.*;
import org.junit.*;
import org.junit.runner.*;
import org.mula.finance.core.models.Habit;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class PerformanceTest extends BaseAndroidTest
{
    private Habit habit;

    @Override
    public void setUp()
    {
        super.setUp();
        habit = fixtures.createLongHabit();
    }

    @Test(timeout = 4000)
    public void testRepeatedGetTodayValue()
    {
        for (int i = 0; i < 100000; i++)
        {
            habit.getScores().getTodayValue();
            habit.getCheckmarks().getTodayValue();
        }
    }

}
