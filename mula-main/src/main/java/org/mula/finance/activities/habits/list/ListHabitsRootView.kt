/* Mula */

package org.mula.finance.activities.habits.list

import android.content.*
import android.os.Build.VERSION.*
import android.os.Build.VERSION_CODES.*
import androidx.appcompat.widget.Toolbar
import android.view.ViewGroup.LayoutParams.*
import android.widget.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.mula.androidbase.activities.*
import org.mula.finance.*
import org.mula.finance.activities.common.views.*
import org.mula.finance.activities.habits.list.views.*
import org.mula.finance.core.models.*
import org.mula.finance.core.preferences.*
import org.mula.finance.core.tasks.*
import org.mula.finance.core.ui.screens.habits.list.*
import org.mula.finance.core.utils.*
import org.mula.finance.utils.*
import java.lang.Math.*
import javax.inject.*

const val MAX_CHECKMARK_COUNT = 60

@ActivityScope
class ListHabitsRootView @Inject constructor(
        @ActivityContext context: Context,
        hintListFactory: HintListFactory,
        preferences: Preferences,
        midnightTimer: MidnightTimer,
        runner: TaskRunner,
        private val listAdapter: HabitCardListAdapter,
        habitCardListViewFactory: HabitCardListViewFactory
) : BaseRootView(context), ModelObservable.Listener {

    val listView: HabitCardListView = habitCardListViewFactory.create()
    val llEmpty = EmptyListView(context)
    val tbar = buildToolbar()
    //Decided to take bottom nav out of goals tracker
//    val bmenu = buildBottomNav()
    val progressBar = TaskProgressBar(context, runner)
    val hintView: HintView
    val header = HeaderView(context, preferences, midnightTimer)

    init {
        val hints = resources.getStringArray(R.array.hints)
        val hintList = hintListFactory.create(hints)
        hintView = HintView(context, hintList)

        addView(RelativeLayout(context).apply {
//            background = sres.getDrawable(R.attr.windowBackgroundColor)
            background = sres.getDrawable(R.attr.colorAccent)
//            addAtTop(tbar)
            addAtTop(header)
            addBelow(listView, header, height = MATCH_PARENT)
            addBelow(llEmpty, header, height = MATCH_PARENT)
            addBelow(progressBar, header) {
                it.topMargin = dp(-10.0f).toInt()
            }
            // take bottom nav out
//            addAtBottom(bmenu)

            addAtBottom(tbar)

//            addAtBottom(hintView)
//            if (SDK_INT < LOLLIPOP) {
//                addBelow(ShadowView(context), tbar)
//                addBelow(ShadowView(context), header)
//            }
        }, MATCH_PARENT, MATCH_PARENT)

        listAdapter.setListView(listView)
        initToolbar()
    }

    override fun getToolbar(): Toolbar {
        return tbar
    }
// take bottom nav out
//    override fun getBottomNav(): BottomNavigationView {
//        return bmenu;
//    }

    override fun onModelChange() {
        updateEmptyView()
    }

    private fun setupControllers() {
        header.setScrollController(object : ScrollableChart.ScrollController {
            override fun onDataOffsetChanged(newDataOffset: Int) {
                listView.dataOffset = newDataOffset
            }
        })
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        setupControllers()
        listAdapter.observable.addListener(this)
    }

    override fun onDetachedFromWindow() {
        listAdapter.observable.removeListener(this)
        super.onDetachedFromWindow()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        val count = getCheckmarkCount()
        header.buttonCount = count
        header.setMaxDataOffset(max(MAX_CHECKMARK_COUNT - count, 0))
        listView.checkmarkCount = count
        super.onSizeChanged(w, h, oldw, oldh)
    }

    private fun getCheckmarkCount(): Int {
        val nameWidth = dim(R.dimen.habitNameWidth)
        val buttonWidth = dim(R.dimen.checkmarkWidth)
        val labelWidth = max((measuredWidth / 3).toFloat(), nameWidth)
        val buttonCount = ((measuredWidth - labelWidth) / buttonWidth).toInt()
        return min(MAX_CHECKMARK_COUNT, max(0, buttonCount))
    }

    private fun updateEmptyView() {
        llEmpty.visibility = when (listAdapter.itemCount) {
            0 -> VISIBLE
            else -> GONE
        }
    }
}
