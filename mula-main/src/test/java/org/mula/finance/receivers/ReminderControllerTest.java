/* Mula */

package org.mula.finance.receivers;

import org.mula.finance.*;
import org.junit.*;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.reminders.ReminderScheduler;
import org.mula.finance.core.ui.NotificationTray;

import static org.mockito.Mockito.*;

public class ReminderControllerTest extends BaseAndroidJVMTest
{

    private ReminderController controller;

    private ReminderScheduler reminderScheduler;

    private NotificationTray notificationTray;

    private Preferences preferences;

    @Override
    public void setUp()
    {
        super.setUp();

        reminderScheduler = mock(ReminderScheduler.class);
        notificationTray = mock(NotificationTray.class);
        preferences = mock(Preferences.class);

        controller = new ReminderController(reminderScheduler,
            notificationTray, preferences);
    }

    @Test
    public void testOnDismiss() throws Exception
    {
        verifyNoMoreInteractions(reminderScheduler);
        verifyNoMoreInteractions(notificationTray);
        verifyNoMoreInteractions(preferences);
    }

    @Test
    public void testOnShowReminder() throws Exception
    {
        Habit habit = mock(Habit.class);
        controller.onShowReminder(habit, Timestamp.ZERO.plus(100), 456);
        verify(notificationTray).show(habit, Timestamp.ZERO.plus(100), 456);
        verify(reminderScheduler).scheduleAll();
    }

    @Test
    public void testOnBootCompleted() throws Exception
    {
        controller.onBootCompleted();
        verify(reminderScheduler).scheduleAll();
    }
}