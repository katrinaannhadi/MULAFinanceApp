/* Mula */

package org.mula.finance

import android.app.*
import android.content.*
import org.mula.finance.utils.*
import org.mula.finance.widgets.*
import org.mula.androidbase.AppContextModule
import org.mula.finance.core.database.UnsupportedDatabaseVersionException
import org.mula.finance.core.reminders.ReminderScheduler
import org.mula.finance.core.ui.NotificationTray
import java.io.*

/**
 * The Android application for Loop Habit Tracker.
 */
class HabitsApplication : Application() {

    private lateinit var context: Context
    private lateinit var widgetUpdater: WidgetUpdater
    private lateinit var reminderScheduler: ReminderScheduler
    private lateinit var notificationTray: NotificationTray

    override fun onCreate() {
        super.onCreate()
        context = this
        HabitsApplication.component = DaggerHabitsApplicationComponent
                .builder()
                .appContextModule(AppContextModule(context))
                .build()

        if (isTestMode()) {
            val db = DatabaseUtils.getDatabaseFile(context)
            if (db.exists()) db.delete()
        }

        try {
            DatabaseUtils.initializeDatabase(context)
        } catch (e: UnsupportedDatabaseVersionException) {
            val db = DatabaseUtils.getDatabaseFile(context)
            db.renameTo(File(db.absolutePath + ".invalid"))
            DatabaseUtils.initializeDatabase(context)
        }

        widgetUpdater = component.widgetUpdater
        widgetUpdater.startListening()

        reminderScheduler = component.reminderScheduler
        reminderScheduler.startListening()

        notificationTray = component.notificationTray
        notificationTray.startListening()

        val prefs = component.preferences
        prefs.setLastAppVersion(BuildConfig.VERSION_CODE)

        val taskRunner = component.taskRunner
        taskRunner.execute {
            reminderScheduler.scheduleAll()
            widgetUpdater.updateWidgets()
        }
    }

    override fun onTerminate() {
        reminderScheduler.stopListening()
        widgetUpdater.stopListening()
        notificationTray.stopListening()
        super.onTerminate()
    }

    val component: HabitsApplicationComponent
        get() = HabitsApplication.component

    companion object {
        lateinit var component: HabitsApplicationComponent

        fun isTestMode(): Boolean {
            try {
                Class.forName("org.mula.finance.BaseAndroidTest")
                return true
            } catch (e: ClassNotFoundException) {
                return false
            }
        }
    }
}
