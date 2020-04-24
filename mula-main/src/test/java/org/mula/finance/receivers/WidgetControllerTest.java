/* Mula */

package org.mula.finance.receivers;

import org.mula.finance.*;
import org.junit.*;
import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.ui.NotificationTray;
import org.mula.finance.core.ui.widgets.WidgetBehavior;
import org.mula.finance.core.utils.DateUtils;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsEqual.*;
import static org.mula.finance.core.models.Checkmark.*;
import static org.mockito.Mockito.*;

public class WidgetControllerTest extends BaseAndroidJVMTest
{
    private WidgetBehavior controller;

    private CommandRunner commandRunner;

    private Habit habit;

    private Timestamp today;

    private NotificationTray notificationTray;

    @Override
    public void setUp()
    {
        super.setUp();

        today = DateUtils.getToday();
        habit = fixtures.createEmptyHabit();
        commandRunner = mock(CommandRunner.class);
        notificationTray = mock(NotificationTray.class);
        controller =
            new WidgetBehavior(habitList, commandRunner, notificationTray);
    }

    @Test
    public void testOnAddRepetition_whenChecked() throws Exception
    {
        habit.getRepetitions().toggle(today);
        int todayValue = habit.getCheckmarks().getTodayValue();
        assertThat(todayValue, equalTo(CHECKED_EXPLICITLY));
        controller.onAddRepetition(habit, today);
        verifyZeroInteractions(commandRunner);
    }

    @Test
    public void testOnAddRepetition_whenUnchecked() throws Exception
    {
        int todayValue = habit.getCheckmarks().getTodayValue();
        assertThat(todayValue, equalTo(UNCHECKED));
        controller.onAddRepetition(habit, today);
        verify(commandRunner).execute(any(), isNull());
        verify(notificationTray).cancel(habit);
    }

    @Test
    public void testOnRemoveRepetition_whenChecked() throws Exception
    {
        habit.getRepetitions().toggle(today);
        int todayValue = habit.getCheckmarks().getTodayValue();
        assertThat(todayValue, equalTo(CHECKED_EXPLICITLY));
        controller.onRemoveRepetition(habit, today);
        verify(commandRunner).execute(any(), isNull());
    }

    @Test
    public void testOnRemoveRepetition_whenUnchecked() throws Exception
    {
        int todayValue = habit.getCheckmarks().getTodayValue();
        assertThat(todayValue, equalTo(UNCHECKED));
        controller.onRemoveRepetition(habit, today);
        verifyZeroInteractions(commandRunner);
    }

    @Test
    public void testOnToggleRepetition() throws Exception
    {
        controller.onToggleRepetition(habit, today);
        verify(commandRunner).execute(any(), isNull());
    }
}