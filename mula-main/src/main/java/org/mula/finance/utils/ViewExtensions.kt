/* Mula */

package org.mula.finance.utils

import android.graphics.*
import androidx.annotation.*
import androidx.appcompat.widget.Toolbar
import android.view.*
import android.view.ViewGroup.LayoutParams.*
import android.widget.*
import android.widget.RelativeLayout.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import org.mula.finance.*
import org.mula.androidbase.utils.InterfaceUtils
import org.mula.androidbase.utils.StyledResources

fun RelativeLayout.addBelow(view: View,
                            subject: View,
                            width: Int = MATCH_PARENT,
                            height: Int = WRAP_CONTENT,
                            applyCustomRules: (params: RelativeLayout.LayoutParams) -> Unit = {}) {

    view.layoutParams = RelativeLayout.LayoutParams(width, height).apply {
        addRule(BELOW, subject.id)
        applyCustomRules(this)
    }
    view.id = View.generateViewId()
    this.addView(view)
}

fun RelativeLayout.addAtBottom(view: View,
                               width: Int = MATCH_PARENT,
                               height: Int = WRAP_CONTENT) {

    view.layoutParams = RelativeLayout.LayoutParams(width, height).apply {
        addRule(ALIGN_PARENT_BOTTOM)
    }
    view.id = View.generateViewId()
    this.addView(view)
}

fun RelativeLayout.addAtTop(view: View,
                            width: Int = MATCH_PARENT,
                            height: Int = WRAP_CONTENT) {

    view.layoutParams = RelativeLayout.LayoutParams(width, height).apply {
        addRule(ALIGN_PARENT_TOP)
    }
    view.id = View.generateViewId()
    this.addView(view)
}

fun ViewGroup.buildToolbar(): Toolbar {
    val inflater = LayoutInflater.from(context)
    return inflater.inflate(R.layout.toolbar, null) as Toolbar
}

fun ViewGroup.buildBottomNav(): BottomNavigationView {
    val inflater = LayoutInflater.from(context)
    return inflater.inflate(R.layout.bottom_nav, null) as BottomNavigationView
}



fun View.showMessage(@StringRes stringId: Int) {
    try {
        val snackbar = Snackbar.make(this, stringId, Snackbar.LENGTH_SHORT)
        val tvId = R.id.snackbar_text
        val tv = snackbar.view.findViewById<TextView>(tvId)
        tv?.setTextColor(Color.WHITE)
        snackbar.show()
    } catch (e: IllegalArgumentException) {
        return
    }
}

fun Int.toMeasureSpec(mode: Int) =
        View.MeasureSpec.makeMeasureSpec(this, mode)

fun Float.toMeasureSpec(mode: Int) =
        View.MeasureSpec.makeMeasureSpec(toInt(), mode)

fun View.isRTL() = InterfaceUtils.isLayoutRtl(this)
fun View.getFontAwesome() = InterfaceUtils.getFontAwesome(context)!!
fun View.dim(id: Int) = InterfaceUtils.getDimension(context, id)
fun View.sp(value: Float) = InterfaceUtils.spToPixels(context, value)
fun View.dp(value: Float) = InterfaceUtils.dpToPixels(context, value)
fun View.str(id: Int) = resources.getString(id)
val View.sres: StyledResources
    get() = StyledResources(context)
