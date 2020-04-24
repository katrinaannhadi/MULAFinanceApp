/* Mula */

package org.mula.finance.widgets

import android.content.*
import android.view.*
import org.mula.finance.widgets.views.*

class EmptyWidget(
        context: Context,
        widgetId: Int
) : BaseWidget(context, widgetId) {

    override fun getOnClickPendingIntent(context: Context) = null
    override fun refreshData(v: View) {}
    override fun buildView() = EmptyWidgetView(context)
    override fun getDefaultHeight() = 200
    override fun getDefaultWidth() = 200
}
