/* Mula */

package org.mula.finance.widgets

import android.appwidget.*
import android.content.*
import android.net.*
import android.view.*
import android.widget.*
import org.mula.finance.core.models.Habit
import org.mula.finance.core.utils.StringUtils

class StackWidget(
        context: Context,
        widgetId: Int,
        private val widgetType: StackWidgetType,
        private val habits: List<Habit>
) : BaseWidget(context, widgetId) {

    override fun getOnClickPendingIntent(context: Context) = null

    override fun refreshData(v: View) {
        // unused
    }

    override fun getRemoteViews(width: Int, height: Int): RemoteViews {
        val manager = AppWidgetManager.getInstance(context)
        val remoteViews = RemoteViews(context.packageName, StackWidgetType.getStackWidgetLayoutId(widgetType))
        val serviceIntent = Intent(context, StackWidgetService::class.java)
        val habitIds = StringUtils.joinLongs(habits.map { it.id!! }.toLongArray())

        serviceIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, id)
        serviceIntent.putExtra(StackWidgetService.WIDGET_TYPE, widgetType.value)
        serviceIntent.putExtra(StackWidgetService.HABIT_IDS, habitIds)
        serviceIntent.data = Uri.parse(serviceIntent.toUri(Intent.URI_INTENT_SCHEME))
        remoteViews.setRemoteAdapter(StackWidgetType.getStackWidgetAdapterViewId(widgetType), serviceIntent)
        manager.notifyAppWidgetViewDataChanged(id, StackWidgetType.getStackWidgetAdapterViewId(widgetType))
        remoteViews.setEmptyView(StackWidgetType.getStackWidgetAdapterViewId(widgetType),
                StackWidgetType.getStackWidgetEmptyViewId(widgetType))
        return remoteViews
    }

    override fun buildView() = null // unused
    override fun getDefaultHeight() = 0 // unused
    override fun getDefaultWidth() = 0 // unused
}
