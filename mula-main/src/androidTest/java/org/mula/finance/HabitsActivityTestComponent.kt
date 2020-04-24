/* Mula */

package org.mula.finance

import dagger.*
import org.mula.finance.activities.*
import org.mula.finance.activities.habits.list.*
import org.mula.finance.activities.habits.list.views.*
import org.mula.finance.activities.habits.show.*
import org.mockito.Mockito.*
import org.mula.androidbase.activities.ActivityContextModule
import org.mula.androidbase.activities.ActivityScope

@Module
class TestModule {
    @Provides fun ListHabitsBehavior() = mock(org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior::class.java)
}

@ActivityScope
@Component(modules = arrayOf(
        ActivityContextModule::class,
        HabitsActivityModule::class,
        ListHabitsModule::class,
        ShowHabitModule::class,
        HabitModule::class,
        TestModule::class
), dependencies = arrayOf(HabitsApplicationComponent::class))
interface HabitsActivityTestComponent {
    fun getCheckmarkPanelViewFactory(): CheckmarkPanelViewFactory
    fun getHabitCardViewFactory(): HabitCardViewFactory
    fun getCheckmarkButtonViewFactory(): CheckmarkButtonViewFactory
    fun getNumberButtonViewFactory(): NumberButtonViewFactory
    fun getNumberPanelViewFactory(): NumberPanelViewFactory
}