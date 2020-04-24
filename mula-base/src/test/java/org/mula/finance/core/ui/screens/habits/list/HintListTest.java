/* Mula */

package org.mula.finance.core.ui.screens.habits.list;

import org.mula.finance.core.*;
import org.junit.*;
import org.mockito.*;
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.utils.DateUtils;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class HintListTest extends BaseUnitTest
{
    private HintList hintList;

    private String[] hints;

    @Mock
    private Preferences prefs;

    private Timestamp today;

    private Timestamp yesterday;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        today = DateUtils.getToday();
        yesterday = today.minus(1);

        hints = new String[]{ "hint1", "hint2", "hint3" };
        hintList = new HintList(prefs, hints);
    }

    @Test
    public void pop() throws Exception
    {
        when(prefs.getLastHintNumber()).thenReturn(-1);
        assertThat(hintList.pop(), equalTo("hint1"));
        verify(prefs).updateLastHint(0, today);

        when(prefs.getLastHintNumber()).thenReturn(2);
        assertNull(hintList.pop());
    }

    @Test
    public void shouldShow() throws Exception
    {
        when(prefs.getLastHintTimestamp()).thenReturn(today);
        assertFalse(hintList.shouldShow());

        when(prefs.getLastHintTimestamp()).thenReturn(yesterday);
        assertTrue(hintList.shouldShow());
    }
}