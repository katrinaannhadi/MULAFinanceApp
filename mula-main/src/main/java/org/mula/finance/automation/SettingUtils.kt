package org.mula.finance.automation

import android.content.Intent
import org.mula.finance.core.models.Habit
import org.mula.finance.core.models.HabitList

object SettingUtils {
    @JvmStatic
    fun parseIntent(intent: Intent, allHabits: HabitList): Arguments? {
        val bundle = intent.getBundleExtra(EXTRA_BUNDLE) ?: return null
        val action = bundle.getInt("action")
        if (action < 0 || action > 2) return null
        val habit = allHabits.getById(bundle.getLong("habit")) ?: return null
        return Arguments(action, habit)
    }

    class Arguments(var action: Int, var habit: Habit)
}