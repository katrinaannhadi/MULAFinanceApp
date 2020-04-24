/* Mula */

package org.mula.finance.activities

import com.google.android.material.bottomnavigation.BottomNavigationMenu
import dagger.*
import org.mula.finance.*
import org.mula.finance.activities.common.dialogs.*
import org.mula.finance.activities.habits.list.*
import org.mula.finance.activities.habits.list.views.*
import org.mula.finance.activities.habits.show.*
import org.mula.androidbase.activities.ActivityContextModule
import org.mula.androidbase.activities.ActivityScope
import org.mula.androidbase.activities.BaseActivityModule
import org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior

@ActivityScope
@Component(modules = arrayOf(
        ActivityContextModule::class,
        BaseActivityModule::class,
        HabitsActivityModule::class,
        ListHabitsModule::class,
        ShowHabitModule::class,
        HabitModule::class
), dependencies = arrayOf(HabitsApplicationComponent::class))
interface HabitsActivityComponent {
    val colorPickerDialogFactory: ColorPickerDialogFactory
    val habitCardListAdapter: HabitCardListAdapter
    val listHabitsBehavior: ListHabitsBehavior
    val listHabitsMenu: ListHabitsMenu
    val listHabitsRootView: ListHabitsRootView
    val listHabitsScreen: ListHabitsScreen
    val listHabitsSelectionMenu: ListHabitsSelectionMenu
    val showHabitScreen: ShowHabitScreen
    val themeSwitcher: AndroidThemeSwitcher
}
