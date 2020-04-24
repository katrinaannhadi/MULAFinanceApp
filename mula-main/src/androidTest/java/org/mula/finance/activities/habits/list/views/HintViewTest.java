/* Mula */

package org.mula.finance.activities.habits.list.views;

import androidx.test.filters.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.mula.finance.*;
import org.junit.*;
import org.junit.runner.*;
import org.mula.finance.core.ui.screens.habits.list.HintList;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class HintViewTest extends BaseViewTest
{
    public static final String PATH = "habits/list/HintView/";

    private HintView view;

    private HintList list;

    @Before
    @Override
    public void setUp()
    {
        super.setUp();

        list = mock(HintList.class);
        view = new HintView(targetContext, list);
        measureView(view, 400, 200);

        String text =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";

        when(list.shouldShow()).thenReturn(true);
        when(list.pop()).thenReturn(text);

        view.showNext();
        skipAnimation(view);
    }

    @Test
    public void testRender() throws Exception
    {
        assertRenders(view, PATH + "render.png");
    }

    @Test
    public void testClick() throws Exception
    {
        assertThat(view.getAlpha(), equalTo(1f));
        view.performClick();
        skipAnimation(view);
        assertThat(view.getAlpha(), equalTo(0f));
    }
}
