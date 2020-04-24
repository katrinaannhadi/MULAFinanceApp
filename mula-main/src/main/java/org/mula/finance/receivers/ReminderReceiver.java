/* Mula */

package org.mula.finance.receivers;

import android.content.*;
import android.util.*;

import androidx.annotation.Nullable;

import org.mula.finance.*;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.utils.DateUtils;

import static android.content.ContentUris.*;

/**
 * The Android BroadcastReceiver for Loop Habit Tracker.
 * <p>
 * All broadcast messages are received and processed by this class.
 */
public class ReminderReceiver extends BroadcastReceiver
{
    public static final String ACTION_DISMISS_REMINDER =
            "org.mula.finance.ACTION_DISMISS_REMINDER";

    public static final String ACTION_SHOW_REMINDER =
            "org.mula.finance.ACTION_SHOW_REMINDER";

    public static final String ACTION_SNOOZE_REMINDER =
            "org.mula.finance.ACTION_SNOOZE_REMINDER";

    private static final String TAG = "ReminderReceiver";

    @Override
    public void onReceive(@Nullable final Context context, @Nullable Intent intent)
    {
        if (context == null || intent == null) return;
        if (intent.getAction() == null) return;

        HabitsApplication app = (HabitsApplication) context.getApplicationContext();
        HabitsApplicationComponent appComponent = app.getComponent();
        HabitList habits = appComponent.getHabitList();
        ReminderController reminderController = appComponent.getReminderController();

        Log.i(TAG, String.format("Received intent: %s", intent.toString()));

        Habit habit = null;
        long today = DateUtils.getStartOfToday();

        if (intent.getData() != null)
            habit = habits.getById(parseId(intent.getData()));
        final long timestamp = intent.getLongExtra("timestamp", today);
        final long reminderTime = intent.getLongExtra("reminderTime", today);

        try
        {
            switch (intent.getAction())
            {
                case ACTION_SHOW_REMINDER:
                    if (habit == null) return;
                    Log.d("ReminderReceiver", String.format(
                            "onShowReminder habit=%d timestamp=%d reminderTime=%d",
                            habit.id,
                            timestamp,
                            reminderTime));
                    reminderController.onShowReminder(habit,
                            new Timestamp(timestamp), reminderTime);
                    break;

                case ACTION_DISMISS_REMINDER:
                    if (habit == null) return;
                    Log.d("ReminderReceiver", String.format("onDismiss habit=%d", habit.id));
                    reminderController.onDismiss(habit);
                    break;

                case ACTION_SNOOZE_REMINDER:
                    if (habit == null) return;
                    Log.d("ReminderReceiver", String.format("onSnoozePressed habit=%d", habit.id));
                    reminderController.onSnoozePressed(habit, context);
                    break;

                case Intent.ACTION_BOOT_COMPLETED:
                    Log.d("ReminderReceiver", "onBootCompleted");
                    reminderController.onBootCompleted();
                    break;
            }
        }
        catch (RuntimeException e)
        {
            Log.e(TAG, "could not process intent", e);
        }
    }
}
