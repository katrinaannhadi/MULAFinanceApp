/* Mula */
package org.mula.finance.activities

import org.mula.androidbase.AndroidDirFinder
import org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior
import org.mula.finance.core.ui.screens.habits.show.ShowHabitMenuBehavior
import java.io.*
import javax.inject.*

class HabitsDirFinder @Inject
constructor(
        private val androidDirFinder: AndroidDirFinder
) : ShowHabitMenuBehavior.System, ListHabitsBehavior.DirFinder {

    override fun getCSVOutputDir(): File {
        return androidDirFinder.getFilesDir("CSV")!!
    }
}
