/* Mula */

package org.mula.finance.intents

import android.app.*
import android.app.AlarmManager.*
import android.content.*
import android.content.Context.*
import android.os.Build.VERSION.*
import android.os.Build.VERSION_CODES.*
import android.util.*
import org.mula.androidbase.AppContext
import org.mula.finance.core.AppScope
import org.mula.finance.core.models.Habit
import org.mula.finance.core.reminders.ReminderScheduler
import org.mula.finance.core.utils.DateFormats
import java.util.*
import javax.inject.*

@AppScope
class IntentScheduler
@Inject constructor(
        @AppContext context: Context,
        private val pendingIntents: PendingIntentFactory
) : ReminderScheduler.SystemScheduler {

    private val manager =
            context.getSystemService(ALARM_SERVICE) as AlarmManager

    fun schedule(timestamp: Long, intent: PendingIntent) {
        Log.d("IntentScheduler",
              "timestamp=" + timestamp + " current=" + System.currentTimeMillis())
        if (timestamp < System.currentTimeMillis()) {
            Log.e("IntentScheduler",
                  "Ignoring attempt to schedule intent in the past.")
            return;
        }
        if (SDK_INT >= M)
            manager.setExactAndAllowWhileIdle(RTC_WAKEUP, timestamp, intent)
        else
            manager.setExact(RTC_WAKEUP, timestamp, intent)
    }

    override fun scheduleShowReminder(reminderTime: Long,
                                      habit: Habit,
                                      timestamp: Long) {
        val intent = pendingIntents.showReminder(habit, reminderTime, timestamp)
        schedule(reminderTime, intent)
        logReminderScheduled(habit, reminderTime)
    }

    override fun log(componentName: String, msg: String) {
        Log.d(componentName, msg)
    }

    private fun logReminderScheduled(habit: Habit, reminderTime: Long) {
        val min = Math.min(5, habit.name.length)
        val name = habit.name.substring(0, min)
        val df = DateFormats.getBackupDateFormat()
        val time = df.format(Date(reminderTime))
        Log.i("ReminderHelper",
              String.format("Setting alarm (%s): %s", time, name))
    }
}
