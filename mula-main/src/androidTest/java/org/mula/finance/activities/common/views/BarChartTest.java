/* Mula */

package org.mula.finance.activities.common.views;

import androidx.test.filters.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.mula.finance.*;
import org.mula.finance.utils.*;
import org.junit.*;
import org.junit.runner.*;
import org.mula.finance.core.models.CheckmarkList;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.utils.DateUtils;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class BarChartTest extends BaseViewTest
{
    private static final String BASE_PATH = "common/BarChart/";

    private BarChart view;

    @Override
    @Before
    public void setUp()
    {
        super.setUp();
        Habit habit = fixtures.createLongNumericalHabit();
        view = new BarChart(targetContext);
        Timestamp today = DateUtils.getToday();
        CheckmarkList checkmarks = habit.getCheckmarks();
        view.setCheckmarks(checkmarks.getByInterval(today.minus(20), today));
        view.setColor(PaletteUtils.getColor(targetContext, habit.getColor()));
        view.setTarget(200.0);
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
    public void testRender_withTransparentBackground() throws Throwable
    {
        view.setIsTransparencyEnabled(true);
        assertRenders(view, BASE_PATH + "renderTransparent.png");
    }
}
