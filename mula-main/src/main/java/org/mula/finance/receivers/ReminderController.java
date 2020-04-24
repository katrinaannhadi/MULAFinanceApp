/* Mula */

package org.mula.finance.receivers;

import android.content.*;
import android.net.*;

import androidx.annotation.NonNull;

import org.mula.finance.notifications.*;
import org.mula.finance.core.AppScope;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.reminders.ReminderScheduler;
import org.mula.finance.core.ui.NotificationTray;
import org.mula.finance.core.utils.DateUtils;

import javax.inject.*;

@AppScope
public class ReminderController
{
    @NonNull
    private final ReminderScheduler reminderScheduler;

    @NonNull
    private final NotificationTray notificationTray;

    @NonNull
    private Preferences preferences;

    @Inject
    public ReminderController(@NonNull ReminderScheduler reminderScheduler,
                              @NonNull NotificationTray notificationTray,
                              @NonNull Preferences preferences)
    {
        this.reminderScheduler = reminderScheduler;
        this.notificationTray = notificationTray;
        this.preferences = preferences;
    }

    public void onBootCompleted()
    {
        reminderScheduler.scheduleAll();
    }

    public void onShowReminder(@NonNull Habit habit,
                               Timestamp timestamp,
                               long reminderTime)
    {
        notificationTray.show(habit, timestamp, reminderTime);
        reminderScheduler.scheduleAll();
    }

    public void onSnoozePressed(@NonNull Habit habit, final Context context)
    {
        showSnoozeDelayPicker(habit, context);
    }

    public void onSnoozeDelayPicked(Habit habit, int delayInMinutes)
    {
        reminderScheduler.snoozeReminder(habit, delayInMinutes);
        notificationTray.cancel(habit);
    }

    public void onSnoozeTimePicked(Habit habit, int hour, int minute)
    {
        long time = DateUtils.getUpcomingTimeInMillis(hour, minute);
        reminderScheduler.scheduleAtTime(habit, time);
        notificationTray.cancel(habit);
    }

    public void onDismiss(@NonNull Habit habit)
    {
        notificationTray.cancel(habit);
    }

    private void showSnoozeDelayPicker(@NonNull Habit habit, Context context)
    {
        context.sendBroadcast(new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS));
        Intent intent = new Intent(context, SnoozeDelayPickerActivity.class);
        intent.setData(Uri.parse(habit.getUriString()));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
