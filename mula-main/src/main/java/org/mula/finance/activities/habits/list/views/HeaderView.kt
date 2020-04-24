/* Mula */

package org.mula.finance.activities.habits.list.views

import android.content.*
import android.graphics.*
import android.os.Build.VERSION.*
import android.os.Build.VERSION_CODES.*
import android.text.*
import android.view.View.MeasureSpec.*
import org.mula.finance.*
import org.mula.finance.activities.common.views.*
import org.mula.finance.core.utils.DateUtils.*
import org.mula.finance.utils.*
import org.mula.finance.core.preferences.Preferences
import org.mula.finance.core.utils.MidnightTimer
import java.util.*

class HeaderView(
        context: Context,
        val prefs: Preferences,
        val midnightTimer: MidnightTimer
) : ScrollableChart(context),
    Preferences.Listener,
    MidnightTimer.MidnightListener {

    private var drawer = Drawer()

    var buttonCount: Int = 0
        set(value) {
            field = value
            requestLayout()
        }

    init {
        setScrollerBucketSize(dim(R.dimen.checkmarkWidth).toInt())
        setBackgroundColor(sres.getColor(R.attr.headerBackgroundColor))
        if (SDK_INT >= LOLLIPOP) elevation = dp(2.0f)
    }

    override fun atMidnight() {
        post { invalidate() }
    }

    override fun onCheckmarkSequenceChanged() {
        updateScrollDirection()
        postInvalidate()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        updateScrollDirection()
        prefs.addListener(this)
        midnightTimer.addListener(this)
    }

    override fun onDetachedFromWindow() {
        midnightTimer.removeListener(this)
        prefs.removeListener(this)
        super.onDetachedFromWindow()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawer.draw(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val height = dim(R.dimen.checkmarkHeight)
        setMeasuredDimension(widthMeasureSpec, height.toMeasureSpec(EXACTLY))
    }

    private fun updateScrollDirection() {
        var direction = -1
        if (prefs.isCheckmarkSequenceReversed) direction *= -1
        if (isRTL()) direction *= -1
        setScrollDirection(direction)
    }

    private inner class Drawer {
        private val rect = RectF()
        private val paint = TextPaint().apply {
            color = Color.BLACK
            isAntiAlias = true
            textSize = dim(R.dimen.tinyTextSize)
            textAlign = Paint.Align.CENTER
            typeface = Typeface.DEFAULT_BOLD
            color = sres.getColor(R.attr.mediumContrastTextColor)
        }

        fun draw(canvas: Canvas) {
            val day = getStartOfTodayCalendar()
            val width = dim(R.dimen.checkmarkWidth)
            val height = dim(R.dimen.checkmarkHeight)
            val isReversed = prefs.isCheckmarkSequenceReversed

            day.add(GregorianCalendar.DAY_OF_MONTH, -dataOffset)
            val em = paint.measureText("m")

            repeat(buttonCount) { index ->
                rect.set(0f, 0f, width, height)
                rect.offset(canvas.width.toFloat(), 0f)

                if (isReversed) rect.offset(-(index + 1) * width, 0f)
                else rect.offset((index - buttonCount) * width, 0f)

                if (isRTL()) rect.set(canvas.width - rect.right, rect.top,
                                      canvas.width - rect.left, rect.bottom)

                val y1 = rect.centerY() - 0.25 * em
                val y2 = rect.centerY() + 1.25 * em
                val lines = formatHeaderDate(day).toUpperCase().split("\n")
                canvas.drawText(lines[0], rect.centerX(), y1.toFloat(), paint)
                canvas.drawText(lines[1], rect.centerX(), y2.toFloat(), paint)
                day.add(GregorianCalendar.DAY_OF_MONTH, -1)
            }
        }
    }
}
