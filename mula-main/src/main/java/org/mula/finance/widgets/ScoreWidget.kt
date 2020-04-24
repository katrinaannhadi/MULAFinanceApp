/* Mula */

package org.mula.finance.widgets

import android.content.*
import android.view.*
import org.mula.finance.activities.common.views.*
import org.mula.finance.activities.habits.show.views.*
import org.mula.finance.utils.*
import org.mula.finance.widgets.views.*
import org.mula.finance.core.models.Habit

class ScoreWidget(
        context: Context,
        id: Int,
        private val habit: Habit
) : BaseWidget(context, id) {

    override fun getOnClickPendingIntent(context: Context) =
            pendingIntentFactory.showHabit(habit)

    override fun refreshData(view: View) {
        val size = ScoreCard.BUCKET_SIZES[prefs.defaultScoreSpinnerPosition]
        val scores = when(size) {
            1 -> habit.scores.toList()
            else -> habit.scores.groupBy(ScoreCard.getTruncateField(size),
                                         prefs.firstWeekday)
        }

        val widgetView = view as GraphWidgetView
        widgetView.setBackgroundAlpha(preferedBackgroundAlpha)
        (widgetView.dataView as ScoreChart).apply {
            setIsTransparencyEnabled(true)
            setBucketSize(size)
            setColor(PaletteUtils.getColor(context, habit.color))
            setScores(scores)
        }
    }

    override fun buildView() =
            GraphWidgetView(context, ScoreChart(context)).apply {
                setTitle(habit.name)
            }

    override fun getDefaultHeight() = 300
    override fun getDefaultWidth() = 300
}
