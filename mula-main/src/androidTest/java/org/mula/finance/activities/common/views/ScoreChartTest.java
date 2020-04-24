/* Mula */

package org.mula.finance.activities.common.views;

import androidx.test.filters.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.mula.finance.*;
import org.mula.finance.utils.*;
import org.junit.*;
import org.junit.runner.*;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.utils.DateUtils;

import java.util.*;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class ScoreChartTest extends BaseViewTest
{
    private static final String BASE_PATH = "common/ScoreChart/";

    private Habit habit;

    private ScoreChart view;

    @Override
    @Before
    public void setUp()
    {
        super.setUp();

        fixtures.purgeHabits(habitList);
        habit = fixtures.createLongHabit();

        view = new ScoreChart(targetContext);
        view.setScores(habit.getScores().toList());
        view.setColor(PaletteUtils.getColor(targetContext, habit.getColor()));
        view.setBucketSize(7);
        measureView(view, dpToPixels(300), dpToPixels(200));
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
    public void testRender_withMonthlyBucket() throws Throwable
    {
        view.setScores(habit.getScores().groupBy(DateUtils.TruncateField.MONTH, Calendar.SUNDAY));
        view.setBucketSize(30);
        view.invalidate();

        assertRenders(view, BASE_PATH + "renderMonthly.png");
    }

    @Test
    public void testRender_withTransparentBackground() throws Throwable
    {
        view.setIsTransparencyEnabled(true);
        assertRenders(view, BASE_PATH + "renderTransparent.png");
    }

    @Test
    public void testRender_withYearlyBucket() throws Throwable
    {
        view.setScores(habit.getScores().groupBy(DateUtils.TruncateField.YEAR, Calendar.SUNDAY));
        view.setBucketSize(365);
        view.invalidate();

        assertRenders(view, BASE_PATH + "renderYearly.png");
    }
}
