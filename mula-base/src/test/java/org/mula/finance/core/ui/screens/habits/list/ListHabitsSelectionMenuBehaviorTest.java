/* Mula */

package org.mula.finance.core.ui.screens.habits.list;

import org.mula.finance.core.*;
import org.junit.*;
import org.mockito.*;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.ui.callbacks.OnColorPickedCallback;
import org.mula.finance.core.ui.callbacks.OnConfirmedCallback;

import java.util.*;

import static java.util.Arrays.*;
import static java.util.Collections.*;
import static junit.framework.TestCase.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

public class ListHabitsSelectionMenuBehaviorTest extends BaseUnitTest
{
    @Mock
    private ListHabitsSelectionMenuBehavior.Screen screen;

    @Mock
    private ListHabitsSelectionMenuBehavior.Adapter adapter;

    private ListHabitsSelectionMenuBehavior behavior;

    private Habit habit1, habit2, habit3;

    @Captor
    private ArgumentCaptor<OnColorPickedCallback> colorPickerCallback;

    @Captor
    private ArgumentCaptor<OnConfirmedCallback> deleteCallback;

    @Test
    public void canArchive() throws Exception
    {
        when(adapter.getSelected()).thenReturn(asList(habit1, habit2));
        assertFalse(behavior.canArchive());

        when(adapter.getSelected()).thenReturn(asList(habit2, habit3));
        assertTrue(behavior.canArchive());
    }

    @Test
    public void canEdit() throws Exception
    {
        when(adapter.getSelected()).thenReturn(singletonList(habit1));
        assertTrue(behavior.canEdit());

        when(adapter.getSelected()).thenReturn(asList(habit1, habit2));
        assertFalse(behavior.canEdit());
    }

    @Test
    public void canUnarchive() throws Exception
    {
        when(adapter.getSelected()).thenReturn(asList(habit1, habit2));
        assertFalse(behavior.canUnarchive());

        when(adapter.getSelected()).thenReturn(singletonList(habit1));
        assertTrue(behavior.canUnarchive());
    }

    @Test
    public void onArchiveHabits() throws Exception
    {
        assertFalse(habit2.isArchived());
        when(adapter.getSelected()).thenReturn(singletonList(habit2));
        behavior.onArchiveHabits();
        assertTrue(habit2.isArchived());
    }

    @Test
    public void onChangeColor() throws Exception
    {
        assertThat(habit1.getColor(), equalTo(8));
        assertThat(habit2.getColor(), equalTo(8));
        when(adapter.getSelected()).thenReturn(asList(habit1, habit2));

        behavior.onChangeColor();

        verify(screen).showColorPicker(eq(8), colorPickerCallback.capture());
        colorPickerCallback.getValue().onColorPicked(30);
        assertThat(habit1.getColor(), equalTo(30));
    }

    @Test
    public void onDeleteHabits() throws Exception
    {
        Long id = habit1.getId();
        assertNotNull(id);
        assertNotNull(habitList.getById(id));
        when(adapter.getSelected()).thenReturn(singletonList(habit1));

        behavior.onDeleteHabits();

        verify(screen).showDeleteConfirmationScreen(deleteCallback.capture());
        deleteCallback.getValue().onConfirmed();
        assertNull(habitList.getById(id));
    }

    @Test
    public void onEditHabits() throws Exception
    {
        List<Habit> selected = asList(habit1, habit2);
        when(adapter.getSelected()).thenReturn(selected);
        behavior.onEditHabits();
        verify(screen).showEditHabitsScreen(selected);
    }

    @Test
    public void onUnarchiveHabits() throws Exception
    {
        assertTrue(habit1.isArchived());
        when(adapter.getSelected()).thenReturn(singletonList(habit1));
        behavior.onUnarchiveHabits();
        assertFalse(habit1.isArchived());
    }

    @Override
    public void setUp() throws Exception
    {
        super.setUp();

        habit1 = fixtures.createShortHabit();
        habit1.setArchived(true);
        habit2 = fixtures.createShortHabit();
        habit3 = fixtures.createShortHabit();
        habitList.add(habit1);
        habitList.add(habit2);
        habitList.add(habit3);

        behavior =
            new ListHabitsSelectionMenuBehavior(habitList, screen, adapter,
                commandRunner);
    }

}
