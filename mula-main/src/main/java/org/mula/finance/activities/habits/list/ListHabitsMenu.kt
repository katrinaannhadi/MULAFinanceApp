/* Mula */

package org.mula.finance.activities.habits.list

import android.view.*
import org.mula.finance.*
import org.mula.androidbase.activities.ActivityScope
import org.mula.androidbase.activities.BaseActivity
import org.mula.androidbase.activities.BaseMenu
import org.mula.finance.core.preferences.Preferences
import org.mula.finance.core.ui.ThemeSwitcher
import org.mula.finance.core.ui.screens.habits.list.ListHabitsMenuBehavior
import javax.inject.*

@ActivityScope
class ListHabitsMenu @Inject constructor(
        activity: BaseActivity,
        private val preferences: Preferences,
        private val themeSwitcher: ThemeSwitcher,
        private val behavior: ListHabitsMenuBehavior
) : BaseMenu(activity){

    override fun onCreate(menu: Menu) {
        val hideArchivedItem = menu.findItem(R.id.actionHideArchived)
        val hideCompletedItem = menu.findItem(R.id.actionHideCompleted)
        val addNumericalHabit = menu.findItem(R.id.actionCreateNumeralHabit)

        addNumericalHabit.isVisible = preferences.isDeveloper
        hideArchivedItem.isChecked = !preferences.showArchived
        hideCompletedItem.isChecked = !preferences.showCompleted
    }

    override fun onItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.actionCreateBooleanHabit -> {
                behavior.onCreateBooleanHabit()
                return true
            }

            R.id.actionCreateNumeralHabit -> {
                behavior.onCreateNumericalHabit()
                return true
            }

            R.id.actionHideArchived -> {
                behavior.onToggleShowArchived()
                invalidate()
                return true
            }

            R.id.actionHideCompleted -> {
                behavior.onToggleShowCompleted()
                invalidate()
                return true
            }

            R.id.actionSortColor -> {
                behavior.onSortByColor()
                return true
            }

            R.id.actionSortManual -> {
                behavior.onSortByManually()
                return true
            }

            R.id.actionSortName -> {
                behavior.onSortByName()
                return true
            }

            R.id.actionSortScore -> {
                behavior.onSortByScore()
                return true
            }

            else -> return false
        }
    }

    override fun getMenuResourceId() = R.menu.list_habits
}
