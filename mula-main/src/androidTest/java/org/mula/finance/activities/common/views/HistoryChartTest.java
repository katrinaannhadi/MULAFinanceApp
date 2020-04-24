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
public class HistoryChartTest extends BaseViewTest
{
    private static final String BASE_PATH = "common/HistoryChart/";

    private HistoryChart chart;

    @Override
    @Before
    public void setUp()
    {
        super.setUp();

        fixtures.purgeHabits(habitList);
        Habit habit = fixtures.createLongHabit();

        chart = new HistoryChart(targetContext);
        chart.setCheckmarks(habit.getCheckmarks().getAllValues());
        chart.setColor(PaletteUtils.getAndroidTestColor(habit.getColor()));
        measureView(chart, dpToPixels(400), dpToPixels(200));
    }

//    @Test
//    public void tapDate_atInvalidLocations() throws Throwable
//    {
//        int expectedCheckmarkValues[] = habit.getCheckmarks().getAllValues();
//
//        chart.setIsEditable(true);
//        tap(chart, 118, 13); // header
//        tap(chart, 336, 60); // tomorrow's square
//        tap(chart, 370, 60); // right axis
//        waitForAsyncTasks();
//
//        int actualCheckmarkValues[] = habit.getCheckmarks().getAllValues();
//        assertThat(actualCheckmarkValues, equalTo(expectedCheckmarkValues));
//    }
//
//    @Test
//    public void tapDate_withEditableView() throws Throwable
//    {
//        chart.setIsEditable(true);
//        tap(chart, 340, 40); // today's square
//        waitForAsyncTasks();
//
//        long today = DateUtils.getStartOfToday();
//        assertFalse(habit.getRepetitions().containsTimestamp(today));
//    }
//
//    @Test
//    public void tapDate_withReadOnlyView() throws Throwable
//    {
//        chart.setIsEditable(false);
//        tap(chart, 340, 40); // today's square
//        waitForAsyncTasks();
//
//        long today = DateUtils.getStartOfToday();
//        assertTrue(habit.getRepetitions().containsTimestamp(today));
//    }

    @Test
    public void testRender() throws Throwable
    {
        assertRenders(chart, BASE_PATH + "render.png");
    }

    @Test
    public void testRender_withDataOffset() throws Throwable
    {
        chart.onScroll(null, null, -dpToPixels(150), 0);
        chart.invalidate();

        assertRenders(chart, BASE_PATH + "renderDataOffset.png");
    }

    @Test
    public void testRender_withDifferentSize() throws Throwable
    {
        measureView(chart, dpToPixels(200), dpToPixels(200));
        assertRenders(chart, BASE_PATH + "renderDifferentSize.png");
    }

    @Test
    public void testRender_withTransparentBackground() throws Throwable
    {
        chart.setIsBackgroundTransparent(true);
        assertRenders(chart, BASE_PATH + "renderTransparent.png");
    }
}
