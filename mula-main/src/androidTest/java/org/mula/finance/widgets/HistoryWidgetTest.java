/* Mula */

package org.mula.finance.widgets;

import androidx.test.filters.*;

import android.widget.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.mula.finance.*;
import org.junit.*;
import org.junit.runner.*;
import org.mula.finance.core.models.Habit;

import java.util.*;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class HistoryWidgetTest extends BaseViewTest
{
    private static final String PATH = "widgets/HistoryWidget/";

    private Habit habit;

    private FrameLayout view;

    @Override
    public void setUp()
    {
        super.setUp();
        setTheme(R.style.WidgetTheme);

        habit = fixtures.createLongHabit();
        HistoryWidget widget = new HistoryWidget(targetContext, 0, habit, Calendar.SUNDAY);
        view = convertToView(widget, 400, 400);
    }

    @Test
    public void testIsInstalled()
    {
        assertWidgetProviderIsInstalled(HistoryWidgetProvider.class);
    }

//    @Test
//    public void testRender() throws Exception
//    {
//        assertRenders(view, PATH + "render.png");
//    }
}
