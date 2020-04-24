/* Mula */

package org.mula.finance.intents

import android.content.*
import android.net.*
import org.mula.finance.activities.habits.show.*
import org.mula.finance.activities.intro.*
import org.mula.finance.activities.settings.*
import org.mula.finance.core.models.Habit
import javax.inject.*

class IntentFactory
@Inject constructor() {


    fun openDocument() = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
        addCategory(Intent.CATEGORY_OPENABLE)
        type = "*/*"
    }


    fun startIntroActivity(context: Context) =
            Intent(context, IntroActivity::class.java)

    fun startSettingsActivity(context: Context) =
            Intent(context, SettingsActivity::class.java)

    fun startShowHabitActivity(context: Context, habit: Habit) =
            Intent(context, ShowHabitActivity::class.java).apply {
                data = Uri.parse(habit.uriString)
            }


    private fun buildSendToIntent(url: String) = Intent().apply {
        action = Intent.ACTION_SENDTO
        data = Uri.parse(url)
    }

    private fun buildViewIntent(url: String) = Intent().apply {
        action = Intent.ACTION_VIEW
        data = Uri.parse(url)
    }
}
