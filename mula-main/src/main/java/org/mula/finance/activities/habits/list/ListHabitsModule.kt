/* Mula */

package org.mula.finance.activities.habits.list

import android.content.*
import dagger.*
import org.mula.finance.activities.*
import org.mula.finance.activities.habits.list.views.*
import org.mula.androidbase.AndroidBugReporter
import org.mula.androidbase.AppContext
import org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior
import org.mula.finance.core.ui.screens.habits.list.ListHabitsMenuBehavior
import org.mula.finance.core.ui.screens.habits.list.ListHabitsSelectionMenuBehavior
import javax.inject.*

class BugReporterProxy
@Inject constructor(
        @AppContext context: Context
) : AndroidBugReporter(context), ListHabitsBehavior.BugReporter

@Module
abstract class ListHabitsModule {

    @Binds
    abstract fun getAdapter(adapter: HabitCardListAdapter): ListHabitsMenuBehavior.Adapter

    @Binds
    abstract fun getBugReporter(proxy: BugReporterProxy): ListHabitsBehavior.BugReporter

    @Binds
    abstract fun getMenuScreen(screen: ListHabitsScreen): ListHabitsMenuBehavior.Screen

    @Binds
    abstract fun getScreen(screen: ListHabitsScreen): ListHabitsBehavior.Screen

    @Binds
    abstract fun getSelMenuAdapter(adapter: HabitCardListAdapter): ListHabitsSelectionMenuBehavior.Adapter

    @Binds
    abstract fun getSelMenuScreen(screen: ListHabitsScreen): ListHabitsSelectionMenuBehavior.Screen

    @Binds
    abstract fun getSystem(system: HabitsDirFinder): ListHabitsBehavior.DirFinder
}
