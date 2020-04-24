/* Mula */

package org.mula.finance.widgets;

import androidx.test.filters.*;

import android.widget.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.mula.finance.*;
import org.junit.*;
import org.junit.runner.*;
import org.mula.finance.core.models.Habit;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class StreakWidgetTest extends BaseViewTest
{
    private static final String PATH = "widgets/StreakWidget/";

    private Habit habit;

    private FrameLayout view;

    @Override
    public void setUp()
    {
        super.setUp();
        setTheme(R.style.WidgetTheme);

        habit = fixtures.createLongHabit();
        StreakWidget widget = new StreakWidget(targetContext, 0, habit);
        view = convertToView(widget, 400, 400);
    }

    @Test
    public void testIsInstalled()
    {
        assertWidgetProviderIsInstalled(StreakWidgetProvider.class);
    }

//    @Test
//    public void testRender() throws Exception
//    {
//        assertRenders(view, PATH + "render.png");
//    }
}
