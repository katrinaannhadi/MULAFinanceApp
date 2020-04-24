/* Mula */

package org.mula.finance.widgets.views;

import androidx.test.filters.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.mula.finance.*;
import org.mula.finance.utils.*;
import org.junit.*;
import org.junit.runner.*;
import org.mula.finance.core.models.Habit;

import java.io.*;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class CheckmarkWidgetViewTest extends BaseViewTest
{
    private static final String PATH = "widgets/CheckmarkWidgetView/";

    private CheckmarkWidgetView view;

    @Override
    @Before
    public void setUp()
    {
        super.setUp();
        setTheme(R.style.WidgetTheme);

        Habit habit = fixtures.createShortHabit();
        view = new CheckmarkWidgetView(targetContext);
        double score = habit.getScores().getTodayValue();
        float percentage = (float) score;

        view.setActiveColor(PaletteUtils.getAndroidTestColor(0));
        view.setCheckmarkValue(habit.getCheckmarks().getTodayValue());
        view.setPercentage(percentage);
        view.setName(habit.getName());
        view.refresh();
        measureView(view, dpToPixels(100), dpToPixels(200));
    }

    @Test
    public void testRender_checked() throws IOException
    {
        assertRenders(view, PATH + "checked.png");
    }

//    @Test
//    public void testRender_implicitlyChecked() throws IOException
//    {
//        view.setCheckmarkValue(Checkmark.CHECKED_IMPLICITLY);
//        view.refresh();
//        assertRenders(view, PATH + "implicitly_checked.png");
//    }

    @Test
    public void testRender_largeSize() throws IOException
    {
        measureView(view, dpToPixels(300), dpToPixels(300));
        assertRenders(view, PATH + "large_size.png");
    }

//    @Test
//    public void testRender_unchecked() throws IOException
//    {
//        view.setCheckmarkValue(Checkmark.UNCHECKED);
//        view.refresh();
//        assertRenders(view, PATH + "unchecked.png");
//    }
}
