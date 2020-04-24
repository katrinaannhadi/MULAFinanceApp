/* Mula */

package org.mula.finance.intents

import android.content.*
import android.content.ContentUris.*
import android.net.*
import org.mula.finance.core.AppScope
import org.mula.finance.core.models.Habit
import org.mula.finance.core.models.HabitList
import org.mula.finance.core.models.Timestamp
import org.mula.finance.core.utils.DateUtils
import javax.inject.*

@AppScope
class IntentParser
@Inject constructor(private val habits: HabitList) {

    fun parseCheckmarkIntent(intent: Intent): CheckmarkIntentData {
        val uri = intent.data ?: throw IllegalArgumentException("uri is null")
        return CheckmarkIntentData(parseHabit(uri), parseTimestamp(intent))
    }

    private fun parseHabit(uri: Uri): Habit {
        val habit = habits.getById(parseId(uri)) ?:
                    throw IllegalArgumentException("habit not found")
        return habit
    }

    private fun parseTimestamp(intent: Intent): Timestamp {
        val today = DateUtils.getToday().unixTime
        var timestamp = intent.getLongExtra("timestamp", today)
        timestamp = DateUtils.getStartOfDay(timestamp)

        if (timestamp < 0 || timestamp > today)
            throw IllegalArgumentException("timestamp is not valid")

        return Timestamp(timestamp)
    }

    class CheckmarkIntentData(var habit: Habit, var timestamp: Timestamp)
}
