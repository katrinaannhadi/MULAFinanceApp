/* Mula */

package org.mula.finance.activities

import dagger.*
import org.mula.finance.core.models.Habit

@Module
class HabitModule(private val habit: Habit) {
    @Provides fun getHabit() = habit
}
