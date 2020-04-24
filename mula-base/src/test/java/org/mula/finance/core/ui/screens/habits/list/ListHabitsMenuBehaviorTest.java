/* Mula */

package org.mula.finance.core.ui.screens.habits.list;

import org.mula.finance.core.*;
import org.junit.*;
import org.mockito.*;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.HabitMatcher;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.ui.ThemeSwitcher;

import static junit.framework.TestCase.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mula.finance.core.models.HabitList.Order.*;
import static org.mockito.Mockito.*;

public class ListHabitsMenuBehaviorTest extends BaseUnitTest
{
    private ListHabitsMenuBehavior behavior;

    @Mock
    private ListHabitsMenuBehavior.Screen screen;

    @Mock
    private ListHabitsMenuBehavior.Adapter adapter;

    @Mock
    private Preferences prefs;

    @Mock
    private ThemeSwitcher themeSwitcher;

    @Captor
    private ArgumentCaptor<HabitMatcher> matcherCaptor;

    @Captor
    private ArgumentCaptor<HabitList.Order> orderCaptor;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        behavior =
            new ListHabitsMenuBehavior(screen, adapter, prefs, themeSwitcher);
        clearInvocations(adapter);
    }

    @Test
    public void testInitialFilter()
    {
        when(prefs.getShowArchived()).thenReturn(true);
        when(prefs.getShowCompleted()).thenReturn(true);

        behavior =
            new ListHabitsMenuBehavior(screen, adapter, prefs, themeSwitcher);
        verify(adapter).setFilter(matcherCaptor.capture());
        verify(adapter).refresh();
        verifyNoMoreInteractions(adapter);
        clearInvocations(adapter);

        assertTrue(matcherCaptor.getValue().isArchivedAllowed());
        assertTrue(matcherCaptor.getValue().isCompletedAllowed());

        when(prefs.getShowArchived()).thenReturn(false);
        when(prefs.getShowCompleted()).thenReturn(false);

        behavior =
            new ListHabitsMenuBehavior(screen, adapter, prefs, themeSwitcher);
        verify(adapter).setFilter(matcherCaptor.capture());
        verify(adapter).refresh();
        verifyNoMoreInteractions(adapter);

        assertFalse(matcherCaptor.getValue().isArchivedAllowed());
        assertFalse(matcherCaptor.getValue().isCompletedAllowed());
    }

//    @Test
//    public void testOnCreateHabit()
//    {
//        behavior.onCreateHabit();
//        verify(screen).showCreateHabitScreen();
//    }

    @Test
    public void testOnSortByColor()
    {
        behavior.onSortByColor();
        verify(adapter).setOrder(orderCaptor.capture());
        assertThat(orderCaptor.getValue(), equalTo(BY_COLOR));
    }

    @Test
    public void testOnSortManually()
    {
        behavior.onSortByManually();
        verify(adapter).setOrder(orderCaptor.capture());
        assertThat(orderCaptor.getValue(), equalTo(BY_POSITION));
    }

    @Test
    public void testOnSortScore()
    {
        behavior.onSortByScore();
        verify(adapter).setOrder(orderCaptor.capture());
        assertThat(orderCaptor.getValue(), equalTo(BY_SCORE));
    }

    @Test
    public void testOnSortName()
    {
        behavior.onSortByName();
        verify(adapter).setOrder(orderCaptor.capture());
        assertThat(orderCaptor.getValue(), equalTo(BY_NAME));
    }

    @Test
    public void testOnToggleShowArchived()
    {
        behavior.onToggleShowArchived();
        verify(adapter).setFilter(matcherCaptor.capture());
        assertTrue(matcherCaptor.getValue().isArchivedAllowed());

        clearInvocations(adapter);

        behavior.onToggleShowArchived();
        verify(adapter).setFilter(matcherCaptor.capture());
        assertFalse(matcherCaptor.getValue().isArchivedAllowed());
    }

    @Test
    public void testOnToggleShowCompleted()
    {
        behavior.onToggleShowCompleted();
        verify(adapter).setFilter(matcherCaptor.capture());
        assertTrue(matcherCaptor.getValue().isCompletedAllowed());

        clearInvocations(adapter);

        behavior.onToggleShowCompleted();
        verify(adapter).setFilter(matcherCaptor.capture());
        assertFalse(matcherCaptor.getValue().isCompletedAllowed());
    }

    @Test
    public void testOnViewAbout()
    {
        behavior.onViewAbout();
        verify(screen).showAboutScreen();
    }

    @Test
    public void testOnViewFAQ()
    {
        behavior.onViewFAQ();
        verify(screen).showFAQScreen();
    }

    @Test
    public void testOnViewSettings()
    {
        behavior.onViewSettings();
        verify(screen).showSettingsScreen();
    }

    @Test
    public void testOnToggleNightMode()
    {
        behavior.onToggleNightMode();
        verify(themeSwitcher).toggleNightMode();
        verify(screen).applyTheme();
    }
}