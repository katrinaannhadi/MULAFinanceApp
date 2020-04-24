/* Mula */

package org.mula.finance.widgets

import android.content.*
import android.view.*
import org.mula.finance.activities.common.views.*
import org.mula.finance.utils.*
import org.mula.finance.widgets.views.*
import org.mula.finance.core.models.Habit

class FrequencyWidget(
        context: Context,
        widgetId: Int,
        private val habit: Habit,
        private val firstWeekday: Int
) : BaseWidget(context, widgetId) {

    override fun getOnClickPendingIntent(context: Context) =
            pendingIntentFactory.showHabit(habit)

    override fun refreshData(v: View) {
        val widgetView = v as GraphWidgetView
        widgetView.setTitle(habit.name)
        widgetView.setBackgroundAlpha(preferedBackgroundAlpha)
        (widgetView.dataView as FrequencyChart).apply {
            setFirstWeekday(firstWeekday)
            setColor(PaletteUtils.getColor(context, habit.color))
            setFrequency(habit.repetitions.weekdayFrequency)
        }
    }

    override fun buildView() =
            GraphWidgetView(context, FrequencyChart(context))

    override fun getDefaultHeight() = 200
    override fun getDefaultWidth() = 200
}
