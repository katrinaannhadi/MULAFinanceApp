/* Mula */

package org.mula.finance.activities.habits.list.views

import android.content.*
import android.view.*
import android.view.Gravity.*
import android.view.ViewGroup.LayoutParams.*
import android.widget.*
import org.mula.finance.*
import org.mula.finance.utils.*
import org.mula.androidbase.activities.BaseRootView

class EmptyListView(context: Context) : LinearLayout(context) {
    init {
        orientation = VERTICAL
        gravity = Gravity.CENTER
        visibility = BaseRootView.GONE

        addView(TextView(context).apply {
            text = str(R.string.fa_star_half_o)
            typeface = getFontAwesome()
            textSize = sp(40.0f)
            gravity = CENTER
            setTextColor(sres.getColor(R.attr.mediumContrastTextColor))
        }, MATCH_PARENT, WRAP_CONTENT)

        addView(TextView(context).apply {
            text = str(R.string.no_habits_found)
            gravity = CENTER
            setPadding(0, dp(20.0f).toInt(), 0, 0)
            setTextColor(sres.getColor(R.attr.mediumContrastTextColor))
        }, MATCH_PARENT, WRAP_CONTENT)
    }
}