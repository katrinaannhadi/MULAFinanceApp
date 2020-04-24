/* Mula */
package org.mula.finance.widgets

import android.content.*

class HistoryWidgetProvider : BaseWidgetProvider() {
    override fun getWidgetFromId(context: Context, id: Int): BaseWidget {
        val habits = getHabitsFromWidgetId(id)
        if (habits.size == 1) return HistoryWidget(context,
                                                   id,
                                                   habits[0],
                                                   preferences.firstWeekday)
        else return StackWidget(context, id, StackWidgetType.HISTORY, habits)
    }
}
