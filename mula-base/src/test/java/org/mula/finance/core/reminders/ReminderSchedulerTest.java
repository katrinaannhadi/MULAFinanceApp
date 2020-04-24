/* Mula */

package org.mula.finance.core.reminders;

import org.mula.finance.core.*;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.*;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.Reminder;
import org.mula.finance.core.models.WeekdayList;
import org.mula.finance.core.preferences.WidgetPreferences;
import org.mula.finance.core.utils.DateUtils;

import java.util.*;

import static org.mula.finance.core.utils.DateUtils.applyTimezone;
import static org.mula.finance.core.utils.DateUtils.removeTimezone;
import static org.mula.finance.core.utils.DateUtils.setFixedLocalTime;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReminderSchedulerTest extends BaseUnitTest
{
    private final long habitId = 10L;

    private Habit habit;

    private ReminderScheduler reminderScheduler;

    @Mock
    private ReminderScheduler.SystemScheduler sys;

    @Mock
    private WidgetPreferences widgetPreferences;

    @Before
    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        habit = fixtures.createEmptyHabit();
        habit.id = habitId;

        reminderScheduler =
            new ReminderScheduler(commandRunner, habitList, sys, widgetPreferences);

        DateUtils.setFixedTimeZone(TimeZone.getTimeZone("GMT-4"));
    }

    @Test
    public void testScheduleAll()
    {
        long now = unixTime(2015, 1, 26, 13, 0);
        setFixedLocalTime(now);

        Habit h1 = fixtures.createEmptyHabit();
        Habit h2 = fixtures.createEmptyHabit();
        Habit h3 = fixtures.createEmptyHabit();
        h1.setReminder(new Reminder(8, 30, WeekdayList.EVERY_DAY));
        h2.setReminder(new Reminder(18, 30, WeekdayList.EVERY_DAY));
        h3.setReminder(null);
        habitList.add(h1);
        habitList.add(h2);
        habitList.add(h3);

        reminderScheduler.scheduleAll();

        verify(sys).scheduleShowReminder(eq(unixTime(2015, 1, 27, 12, 30)),
            eq(h1), anyLong());
        verify(sys).scheduleShowReminder(eq(unixTime(2015, 1, 26, 22, 30)),
            eq(h2), anyLong());
    }

    @Test
    public void testSchedule_atSpecificTime()
    {
        long atTime = unixTime(2015, 1, 30, 11, 30);
        long expectedCheckmarkTime = unixTime(2015, 1, 30, 0, 0);

        habit.setReminder(new Reminder(8, 30, WeekdayList.EVERY_DAY));
        scheduleAndVerify(atTime, expectedCheckmarkTime, atTime);
    }

    @Test
    public void testSchedule_withSnooze()
    {
        long now = removeTimezone(unixTime(2015, 1, 1, 15, 0));
        setFixedLocalTime(now);

        long snoozeTimeInFuture = unixTime(2015, 1, 1, 21, 0);
        long snoozeTimeInPast = unixTime(2015, 1, 1, 7, 0);
        long regularReminderTime = applyTimezone(unixTime(2015, 1, 2, 8, 30));
        long todayCheckmarkTime = unixTime(2015, 1, 1, 0, 0);
        long tomorrowCheckmarkTime = unixTime(2015, 1, 2, 0, 0);
        habit.setReminder(new Reminder(8, 30, WeekdayList.EVERY_DAY));

        when(widgetPreferences.getSnoozeTime(habitId)).thenReturn(snoozeTimeInFuture);
        reminderScheduler.schedule(habit);
        verify(sys).scheduleShowReminder(snoozeTimeInFuture, habit, todayCheckmarkTime);

        when(widgetPreferences.getSnoozeTime(habitId)).thenReturn(snoozeTimeInPast);
        reminderScheduler.schedule(habit);
        verify(sys).scheduleShowReminder(regularReminderTime, habit, tomorrowCheckmarkTime);
    }

    @Test
    public void testSchedule_laterToday()
    {
        long now = unixTime(2015, 1, 26, 6, 30);
        setFixedLocalTime(now);

        long expectedCheckmarkTime = unixTime(2015, 1, 26, 0, 0);
        long expectedReminderTime = unixTime(2015, 1, 26, 12, 30);

        habit.setReminder(new Reminder(8, 30, WeekdayList.EVERY_DAY));
        scheduleAndVerify(null, expectedCheckmarkTime, expectedReminderTime);
    }

    @Test
    public void testSchedule_tomorrow()
    {
        long now = unixTime(2015, 1, 26, 13, 0);
        setFixedLocalTime(now);

        long expectedCheckmarkTime = unixTime(2015, 1, 27, 0, 0);
        long expectedReminderTime = unixTime(2015, 1, 27, 12, 30);

        habit.setReminder(new Reminder(8, 30, WeekdayList.EVERY_DAY));
        scheduleAndVerify(null, expectedCheckmarkTime, expectedReminderTime);
    }

    @Test
    public void testSchedule_withoutReminder()
    {
        reminderScheduler.schedule(habit);
    }

    public long unixTime(int year, int month, int day, int hour, int minute)
    {
        Calendar cal = DateUtils.getStartOfTodayCalendar();
        cal.set(year, month, day, hour, minute);
        return cal.getTimeInMillis();
    }

    private void scheduleAndVerify(Long atTime,
                                   long expectedCheckmarkTime,
                                   long expectedReminderTime)
    {
        if(atTime == null) reminderScheduler.schedule(habit);
        else reminderScheduler.scheduleAtTime(habit, atTime);
        verify(sys).scheduleShowReminder(expectedReminderTime, habit,
            expectedCheckmarkTime);
    }
}
