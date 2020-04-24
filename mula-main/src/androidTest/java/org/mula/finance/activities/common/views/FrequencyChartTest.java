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
public class FrequencyChartTest extends BaseViewTest
{
    public static final String BASE_PATH = "common/FrequencyChart/";

    private FrequencyChart view;

    @Override
    @Before
    public void setUp()
    {
        super.setUp();

        fixtures.purgeHabits(habitList);
        Habit habit = fixtures.createLongHabit();

        view = new FrequencyChart(targetContext);
        view.setFrequency(habit.getRepetitions().getWeekdayFrequency());
        view.setColor(PaletteUtils.getAndroidTestColor(habit.getColor()));
        measureView(view, dpToPixels(300), dpToPixels(100));
    }

    @Test
    public void testRender() throws Throwable
    {
        assertRenders(view, BASE_PATH + "render.png");
    }

    @Test
    public void testRender_withDataOffset() throws Throwable
    {
        view.onScroll(null, null, -dpToPixels(150), 0);
        view.invalidate();

        assertRenders(view, BASE_PATH + "renderDataOffset.png");
    }

    @Test
    public void testRender_withDifferentSize() throws Throwable
    {
        measureView(view, dpToPixels(200), dpToPixels(200));
        assertRenders(view, BASE_PATH + "renderDifferentSize.png");
    }

    @Test
    public void testRender_withTransparentBackground() throws Throwable
    {
        view.setIsBackgroundTransparent(true);
        assertRenders(view, BASE_PATH + "renderTransparent.png");
    }
}
