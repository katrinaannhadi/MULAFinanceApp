/* Mula */

package org.mula.finance.activities.habits.list.views

import android.content.*
import android.view.*
import android.view.View.MeasureSpec.*
import org.mula.finance.*
import org.mula.finance.utils.*

@Suppress("DEPRECATION")
class ShadowView(context: Context) : View(context) {
    init {
        alpha = 0.2f
        background = resources.getDrawable(R.drawable.shadow)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec,
                        dp(2.0f).toInt().toMeasureSpec(EXACTLY))
    }
}