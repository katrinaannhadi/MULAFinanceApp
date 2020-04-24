/* Mula */

package org.mula.finance.activities.habits.list.views

import android.animation.*
import android.content.*
import android.graphics.*
import android.graphics.Color.*
import android.view.*
import android.view.ViewGroup.LayoutParams.*
import android.widget.*
import org.mula.finance.*
import org.mula.finance.utils.*
import org.mula.finance.core.ui.screens.habits.list.HintList

class HintView(
        context: Context,
        private val hintList: HintList
) : LinearLayout(context) {

    val hintContent: TextView

    init {
        isClickable = true
        visibility = GONE
        orientation = VERTICAL
        val p1 = dp(16.0f).toInt()
        val p2 = dp(4.0f).toInt()
        setPadding(p1, p1, p2, p1)
        setBackgroundColor(resources.getColor(R.color.indigo_500))

        val hintTitle = TextView(context).apply {
            setTextColor(WHITE)
            setTypeface(null, Typeface.BOLD)
            text = resources.getString(R.string.hint_title)
        }

        hintContent = TextView(context).apply {
            setTextColor(WHITE)
            setPadding(0, dp(5.0f).toInt(), 0, 0)
        }

        addView(hintTitle, WRAP_CONTENT, WRAP_CONTENT)
        addView(hintContent, WRAP_CONTENT, WRAP_CONTENT)
        setOnClickListener { dismiss() }
    }

    public override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        showNext()
    }

    fun showNext() {
        if (!hintList.shouldShow()) return
        val hint = hintList.pop() ?: return

        hintContent.text = hint
        requestLayout()

        alpha = 0.0f
        visibility = View.VISIBLE
        animate().alpha(1f).duration = 500
    }

    private fun dismiss() {
        animate().alpha(0f).setDuration(500).setListener(DismissAnimator())
    }

    private inner class DismissAnimator : AnimatorListenerAdapter() {
        override fun onAnimationEnd(animation: android.animation.Animator) {
            visibility = View.GONE
        }
    }
}
