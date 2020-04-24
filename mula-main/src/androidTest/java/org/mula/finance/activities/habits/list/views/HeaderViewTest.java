/* Mula */

package org.mula.finance.activities.habits.list.views;

import androidx.test.filters.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.mula.finance.*;
import org.junit.*;
import org.junit.runner.*;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.utils.MidnightTimer;

import static org.mockito.Mockito.*;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class HeaderViewTest extends BaseViewTest
{
    public static final String PATH = "habits/list/HeaderView/";

    private HeaderView view;

    private Preferences prefs;

    private MidnightTimer midnightTimer;

    @Override
    @Before
    public void setUp()
    {
        super.setUp();
        prefs = mock(Preferences.class);
        midnightTimer = mock(MidnightTimer.class);
        view = new HeaderView(targetContext, prefs, midnightTimer);
        view.setButtonCount(5);
        measureView(view, dpToPixels(600), dpToPixels(48));
    }

    @Test
    public void testRender() throws Exception
    {
        when(prefs.isCheckmarkSequenceReversed()).thenReturn(false);

        assertRenders(view, PATH + "render.png");

        verify(prefs).isCheckmarkSequenceReversed();
        verifyNoMoreInteractions(prefs);
    }

    @Test
    public void testRender_reverse() throws Exception
    {
        when(prefs.isCheckmarkSequenceReversed()).thenReturn(true);

        assertRenders(view, PATH + "render_reverse.png");

        verify(prefs).isCheckmarkSequenceReversed();
        verifyNoMoreInteractions(prefs);
    }
}