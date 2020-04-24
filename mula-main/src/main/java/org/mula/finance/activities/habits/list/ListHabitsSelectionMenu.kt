/* Mula */

package org.mula.finance.activities.habits.list

import android.view.*
import dagger.*
import org.mula.finance.*
import org.mula.finance.activities.habits.list.views.*
import org.mula.androidbase.activities.ActivityScope
import org.mula.androidbase.activities.BaseSelectionMenu
import org.mula.finance.core.commands.CommandRunner
import org.mula.finance.core.preferences.Preferences
import org.mula.finance.core.ui.NotificationTray
import org.mula.finance.core.ui.screens.habits.list.ListHabitsSelectionMenuBehavior
import org.mula.finance.core.utils.DateUtils
import javax.inject.*

@ActivityScope
class ListHabitsSelectionMenu @Inject constructor(
        private val screen: ListHabitsScreen,
        private val listAdapter: HabitCardListAdapter,
        var commandRunner: CommandRunner,
        private val prefs: Preferences,
        private val behavior: ListHabitsSelectionMenuBehavior,
        private val listController: Lazy<HabitCardListController>,
        private val notificationTray: NotificationTray
) : BaseSelectionMenu() {

    override fun onFinish() {
        listController.get().onSelectionFinished()
        super.onFinish()
    }

    override fun onItemClicked(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_edit_habit -> {
                behavior.onEditHabits()
                return true
            }

            R.id.action_archive_habit -> {
                behavior.onArchiveHabits()
                return true
            }

            R.id.action_unarchive_habit -> {
                behavior.onUnarchiveHabits()
                return true
            }

            R.id.action_delete -> {
                behavior.onDeleteHabits()
                return true
            }

            R.id.action_color -> {
                behavior.onChangeColor()
                return true
            }

            R.id.action_notify -> {
                for(h in listAdapter.selected)
                    notificationTray.show(h, DateUtils.getToday(), 0)
                return true
            }

            else -> return false
        }
    }

    override fun onPrepare(menu: Menu): Boolean {
        val itemEdit = menu.findItem(R.id.action_edit_habit)
        val itemColor = menu.findItem(R.id.action_color)
        val itemArchive = menu.findItem(R.id.action_archive_habit)
        val itemUnarchive = menu.findItem(R.id.action_unarchive_habit)
        val itemNotify = menu.findItem(R.id.action_notify)

        itemColor.isVisible = true
        itemEdit.isVisible = behavior.canEdit()
        itemArchive.isVisible = behavior.canArchive()
        itemUnarchive.isVisible = behavior.canUnarchive()
        setTitle(Integer.toString(listAdapter.selected.size))
        itemNotify.isVisible = prefs.isDeveloper

        return true
    }

    fun onSelectionStart() = screen.startSelection()
    fun onSelectionChange() = invalidate()
    fun onSelectionFinish() = finish()
    override fun getResourceId() = R.menu.list_habits_selection
}
