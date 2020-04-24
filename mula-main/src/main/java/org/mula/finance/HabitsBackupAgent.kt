/* Mula */

package org.mula.finance

import android.app.backup.*

/**
 * An Android BackupAgentHelper customized for this application.
 */
class HabitsBackupAgent : BackupAgentHelper() {
    override fun onCreate() {
        addHelper("preferences", SharedPreferencesBackupHelper(this, "preferences"))
        addHelper("database", FileBackupHelper(this, "../databases/finance.db"))
    }
}
