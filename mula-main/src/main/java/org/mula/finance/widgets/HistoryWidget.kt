/* Mula */

package org.mula.finance.widgets

import android.app.*
import android.content.*
import android.view.*
import org.mula.finance.activities.common.views.*
import org.mula.finance.utils.*
import org.mula.finance.widgets.views.*
import org.mula.finance.core.models.Habit

class HistoryWidget(
        context: Context,
        id: Int,
        private val habit: Habit,
        private val firstWeekday: Int
) : BaseWidget(context, id) {

    override fun getOnClickPendingIntent(context: Context): PendingIntent {
        return pendingIntentFactory.showHabit(habit)
    }

    override fun refreshData(view: View) {
        val widgetView = view as GraphWidgetView
        widgetView.setBackgroundAlpha(preferedBackgroundAlpha)
        (widgetView.dataView as HistoryChart).apply {
            setFirstWeekday(firstWeekday)
            setColor(PaletteUtils.getColor(context, habit.color))
            setCheckmarks(habit.checkmarks.allValues)
        }
    }

    override fun buildView() =
            GraphWidgetView(context, HistoryChart(context)).apply {
                setTitle(habit.name)
            }

    override fun getDefaultHeight() = 250
    override fun getDefaultWidth() = 250
}
