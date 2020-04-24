/* Mula */

package org.mula.finance.widgets

import android.appwidget.*
import android.content.*
import org.mula.androidbase.AppContext
import org.mula.finance.core.commands.Command
import org.mula.finance.core.commands.CommandRunner
import org.mula.finance.core.preferences.WidgetPreferences
import org.mula.finance.core.tasks.TaskRunner
import javax.inject.*

/**
 * A WidgetUpdater listens to the commands being executed by the application and
 * updates the home-screen widgets accordingly.
 */
class WidgetUpdater
@Inject constructor(
        @AppContext private val context: Context,
        private val commandRunner: CommandRunner,
        private val taskRunner: TaskRunner,
        private val widgetPrefs: WidgetPreferences
) : CommandRunner.Listener {

    override fun onCommandExecuted(command: Command, refreshKey: Long?) {
        updateWidgets(refreshKey)
    }

    /**
     * Instructs the updater to start listening to commands. If any relevant
     * commands are executed after this method is called, the corresponding
     * widgets will get updated.
     */
    fun startListening() {
        commandRunner.addListener(this)
    }

    /**
     * Instructs the updater to stop listening to commands. Every command
     * executed after this method is called will be ignored by the updater.
     */
    fun stopListening() {
        commandRunner.removeListener(this)
    }

    fun updateWidgets(modifiedHabitId: Long?) {
        taskRunner.execute {
            updateWidgets(modifiedHabitId, CheckmarkWidgetProvider::class.java)
            updateWidgets(modifiedHabitId, HistoryWidgetProvider::class.java)
            updateWidgets(modifiedHabitId, ScoreWidgetProvider::class.java)
            updateWidgets(modifiedHabitId, StreakWidgetProvider::class.java)
            updateWidgets(modifiedHabitId, FrequencyWidgetProvider::class.java)
        }
    }

    private fun updateWidgets(modifiedHabitId: Long?, providerClass: Class<*>) {
        val widgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(
                ComponentName(context, providerClass))

        val modifiedWidgetIds = when (modifiedHabitId) {
            null -> widgetIds.toList()
            else -> widgetIds.filter { w ->
                widgetPrefs.getHabitIdsFromWidgetId(w).contains(modifiedHabitId)
            }
        }

        context.sendBroadcast(Intent(context, providerClass).apply {
            action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
            putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, modifiedWidgetIds.toIntArray())
        })
    }

    fun updateWidgets() {
        updateWidgets(null)
    }
}
