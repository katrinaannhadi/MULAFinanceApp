/* Mula */

package org.mula.finance.widgets

import android.content.*
import android.view.*
import android.view.ViewGroup.*
import android.view.ViewGroup.LayoutParams.*
import org.mula.finance.activities.common.views.*
import org.mula.finance.utils.*
import org.mula.finance.widgets.views.*
import org.mula.finance.core.models.Habit

class StreakWidget(
        context: Context,
        id: Int,
        private val habit: Habit
) : BaseWidget(context, id) {

    override fun getOnClickPendingIntent(context: Context) =
            pendingIntentFactory.showHabit(habit)

    override fun refreshData(view: View) {
        val widgetView = view as GraphWidgetView
        widgetView.setBackgroundAlpha(preferedBackgroundAlpha)
        (widgetView.dataView as StreakChart).apply {
            setColor(PaletteUtils.getColor(context, habit.color))
            setStreaks(habit.streaks.getBest(maxStreakCount))
        }
    }

    override fun buildView(): View {
        return GraphWidgetView(context, StreakChart(context)).apply {
            setTitle(habit.name)
            layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }
    }

    override fun getDefaultHeight() = 200
    override fun getDefaultWidth() = 200
}
