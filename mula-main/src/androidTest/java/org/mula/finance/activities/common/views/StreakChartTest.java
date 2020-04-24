/* Mula */

package org.mula.finance.activities.common.views;

import androidx.test.filters.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.mula.finance.*;
import org.mula.finance.utils.*;
import org.junit.*;
import org.junit.runner.*;
import org.mula.finance.core.models.Habit;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class StreakChartTest extends BaseViewTest
{
    private static final String BASE_PATH = "common/StreakChart/";

    private StreakChart view;

    @Override
    @Before
    public void setUp()
    {
        super.setUp();

        fixtures.purgeHabits(habitList);
        Habit habit = fixtures.createLongHabit();

        view = new StreakChart(targetContext);
        view.setColor(PaletteUtils.getAndroidTestColor(habit.getColor()));
        view.setStreaks(habit.getStreaks().getBest(5));
        measureView(view, dpToPixels(300), dpToPixels(100));
    }

    @Test
    public void testRender() throws Throwable
    {
        assertRenders(view, BASE_PATH + "render.png");
    }

    @Test
    public void testRender_withSmallSize() throws Throwable
    {
        measureView(view, dpToPixels(100), dpToPixels(100));
        assertRenders(view, BASE_PATH + "renderSmallSize.png");
    }

    @Test
    public void testRender_withTransparentBackground() throws Throwable
    {
        view.setIsBackgroundTransparent(true);
        assertRenders(view, BASE_PATH + "renderTransparent.png");
    }
}
