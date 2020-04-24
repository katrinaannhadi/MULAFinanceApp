/* Mula */

package org.mula.finance.activities.habits.list.views

import android.content.*
import android.view.*
import android.view.View.MeasureSpec.*
import android.widget.*
import org.mula.finance.*
import org.mula.finance.utils.*
import org.mula.finance.core.preferences.Preferences

abstract class ButtonPanelView<T : View>(
        context: Context,
        val preferences: Preferences
) : LinearLayout(context),
    Preferences.Listener {

    var buttonCount = 0
        set(value) {
            field = value
            inflateButtons()
        }

    var dataOffset = 0
        set(value) {
            field = value
            setupButtons()
        }

    var buttons = mutableListOf<T>()

    override fun onCheckmarkSequenceChanged() {
        inflateButtons()
    }

    @Synchronized
    protected fun inflateButtons() {
        val reverse = preferences.isCheckmarkSequenceReversed

        buttons.clear()
        repeat(buttonCount) { buttons.add(createButton()) }

        removeAllViews()
        if (reverse) buttons.reversed().forEach { addView(it) }
        else buttons.forEach { addView(it) }
        setupButtons()
        requestLayout()
    }

    public override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        preferences.addListener(this)
    }

    public override fun onDetachedFromWindow() {
        preferences.removeListener(this)
        super.onDetachedFromWindow()
    }

    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        val buttonWidth = dim(R.dimen.checkmarkWidth)
        val buttonHeight = dim(R.dimen.checkmarkHeight)
        val width = (buttonWidth * buttonCount)
        super.onMeasure(width.toMeasureSpec(EXACTLY),
                        buttonHeight.toMeasureSpec(EXACTLY))
    }

    protected abstract fun setupButtons()
    protected abstract fun createButton(): T
}