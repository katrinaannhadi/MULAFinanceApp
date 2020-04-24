/* Mula */

package org.mula.finance.widgets;

import androidx.test.filters.*;

import android.widget.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.mula.finance.*;
import org.junit.*;
import org.junit.runner.*;
import org.mula.finance.core.models.CheckmarkList;
import org.mula.finance.core.models.Habit;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mula.finance.core.models.Checkmark.*;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class CheckmarkWidgetTest extends BaseViewTest
{
    private static final String PATH = "widgets/CheckmarkWidget/";

    private Habit habit;

    private CheckmarkList checkmarks;

    private FrameLayout view;

    @Override
    public void setUp()
    {
        super.setUp();
        setTheme(R.style.WidgetTheme);

        habit = fixtures.createShortHabit();
        checkmarks = habit.getCheckmarks();
        CheckmarkWidget widget = new CheckmarkWidget(targetContext, 0, habit);
        view = convertToView(widget, 200, 250);

        assertThat(checkmarks.getTodayValue(), equalTo(CHECKED_EXPLICITLY));
    }

    @Test
    public void testClick() throws Exception
    {
        Button button = (Button) view.findViewById(R.id.button);
        assertThat(button, is(not(nullValue())));

        // A better test would be to capture the intent, but it doesn't seem
        // possible to capture intents sent to BroadcastReceivers.
        button.performClick();
        sleep(1000);

        assertThat(checkmarks.getTodayValue(), equalTo(UNCHECKED));
    }

    @Test
    public void testIsInstalled()
    {
        assertWidgetProviderIsInstalled(CheckmarkWidgetProvider.class);
    }

    @Test
    public void testRender() throws Exception
    {
        assertRenders(view, PATH + "render.png");
    }
}
