/* Mula */

package org.mula.finance.activities.habits.list

import android.os.*
import org.mula.finance.*
import org.mula.finance.activities.*
import org.mula.finance.activities.habits.list.views.*
import org.mula.finance.core.ui.ThemeSwitcher.*
import org.mula.finance.core.preferences.Preferences
import org.mula.finance.core.utils.MidnightTimer

class ListHabitsActivity : HabitsActivity() {

    var pureBlack: Boolean = false
    lateinit var adapter: HabitCardListAdapter
    lateinit var rootView: ListHabitsRootView
    lateinit var screen: ListHabitsScreen
    lateinit var prefs: Preferences
    lateinit var midnightTimer: MidnightTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefs = appComponent.preferences
        pureBlack = prefs.isPureBlackEnabled
        midnightTimer = appComponent.midnightTimer
        rootView = component.listHabitsRootView
        screen = component.listHabitsScreen
        adapter = component.habitCardListAdapter

        setScreen(screen)
        component.listHabitsBehavior.onStartup()
        setTitle(R.string.main_activity_title)
    }

    override fun onPause() {
        midnightTimer.onPause()
        screen.onDettached()
        adapter.cancelRefresh()
        super.onPause()
    }

    override fun onResume() {
        adapter.refresh()
        screen.onAttached()
        rootView.postInvalidate()
        midnightTimer.onResume()

        if (prefs.theme == THEME_DARK && prefs.isPureBlackEnabled != pureBlack) {
            restartWithFade(ListHabitsActivity::class.java)
        }

        super.onResume()
    }
}
