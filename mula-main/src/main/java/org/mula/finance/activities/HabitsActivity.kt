/* Mula */

package org.mula.finance.activities

import android.content.*
import android.os.*
import org.mula.finance.*
import org.mula.androidbase.activities.ActivityContextModule
import org.mula.androidbase.activities.BaseActivity
import org.mula.androidbase.activities.BaseActivityModule
import org.mula.finance.core.models.Habit
import org.mula.finance.core.models.HabitList

abstract class HabitsActivity : BaseActivity() {
    lateinit var component: HabitsActivityComponent
    lateinit var appComponent: HabitsApplicationComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appComponent = (applicationContext as HabitsApplication).component

        val habit = getHabitFromIntent(appComponent.habitList)
                    ?: appComponent.modelFactory.buildHabit()

        component = DaggerHabitsActivityComponent
                .builder()
                .activityContextModule(ActivityContextModule(this))
                .baseActivityModule(BaseActivityModule(this))
                .habitModule(HabitModule(habit))
                .habitsApplicationComponent(appComponent)
                .build()

        component.themeSwitcher.apply()
    }

    private fun getHabitFromIntent(habitList: HabitList): Habit? {
        val data = intent.data ?: return null
        val habit = habitList.getById(ContentUris.parseId(data))
                    ?: throw RuntimeException("habit not found")
        return habit
    }
}
