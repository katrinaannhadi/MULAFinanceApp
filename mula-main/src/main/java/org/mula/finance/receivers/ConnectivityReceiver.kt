/* Mula */

package org.mula.finance.receivers

import android.content.*
import android.content.Context.*
import android.net.*
import org.mula.finance.*

class ConnectivityReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (context == null || intent == null) return
        val app = context.applicationContext as HabitsApplication
        val networkInfo = (context.getSystemService(CONNECTIVITY_SERVICE)
                as ConnectivityManager).activeNetworkInfo
        val isConnected = (networkInfo != null) &&
                          networkInfo.isConnectedOrConnecting
        val syncManager = app.component.syncManager
        syncManager.onNetworkStatusChanged(isConnected)
    }
}
