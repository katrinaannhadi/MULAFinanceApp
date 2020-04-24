/* Mula */

package org.mula.finance.widgets

import android.content.*
import android.view.*
import org.mula.finance.utils.*
import org.mula.finance.widgets.views.*
import org.mula.finance.core.models.Habit

class CheckmarkWidget(
        context: Context,
        widgetId: Int,
        private val habit: Habit
) : BaseWidget(context, widgetId) {

    override fun getOnClickPendingIntent(context: Context) =
            pendingIntentFactory.toggleCheckmark(habit, null)

    override fun refreshData(v: View) {
        (v as CheckmarkWidgetView).apply {
            setBackgroundAlpha(preferedBackgroundAlpha)
            setPercentage(habit.scores.todayValue.toFloat())
            setActiveColor(PaletteUtils.getColor(context, habit.color))
            setName(habit.name)
            setCheckmarkValue(habit.checkmarks.todayValue)
            refresh()
        }
    }

    override fun buildView() = CheckmarkWidgetView(context)
    override fun getDefaultHeight() = 125
    override fun getDefaultWidth() = 125
}
