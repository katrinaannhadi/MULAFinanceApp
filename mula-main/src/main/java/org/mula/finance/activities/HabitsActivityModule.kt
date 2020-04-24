/* Mula */

package org.mula.finance.activities

import dagger.*
import org.mula.androidbase.activities.ActivityScope
import org.mula.finance.core.ui.ThemeSwitcher

@Module
abstract class HabitsActivityModule {
    @Binds @ActivityScope
    internal abstract fun getThemeSwitcher(t: AndroidThemeSwitcher): ThemeSwitcher
}
