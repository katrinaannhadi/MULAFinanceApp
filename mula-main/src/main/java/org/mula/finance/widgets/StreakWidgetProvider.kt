/* Mula */
package org.mula.finance.widgets

import android.content.*

class StreakWidgetProvider : BaseWidgetProvider() {
    override fun getWidgetFromId(context: Context, id: Int): BaseWidget {
        val habits = getHabitsFromWidgetId(id)
        if (habits.size == 1) return StreakWidget(context, id, habits[0])
        else return StackWidget(context, id, StackWidgetType.STREAKS, habits)
    }
}
