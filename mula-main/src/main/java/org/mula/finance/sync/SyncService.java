/* Mula */

package org.mula.finance.sync;

import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import androidx.core.app.*;

import org.mula.finance.*;
import org.mula.finance.receivers.*;
import org.mula.finance.core.preferences.Preferences;

public class SyncService extends Service implements Preferences.Listener
{
    private SyncManager syncManager;

    private Preferences prefs;

    private ConnectivityReceiver connectivityReceiver;

    public SyncService()
    {
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    public void onCreate()
    {
        Intent notificationIntent = new Intent(this, SyncService.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        Notification notification = new NotificationCompat.Builder(this)
            .setContentTitle("Loop Habit Tracker")
            .setContentText("Sync service running")
            .setSmallIcon(R.drawable.ic_notification)
            .setPriority(NotificationCompat.PRIORITY_MIN)
            .setContentIntent(pendingIntent)
            .build();

        startForeground(99999, notification);

        connectivityReceiver = new ConnectivityReceiver();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        this.registerReceiver(connectivityReceiver, filter);

        HabitsApplication app = (HabitsApplication) getApplicationContext();
        syncManager = app.getComponent().getSyncManager();
        syncManager.startListening();

        prefs = app.getComponent().getPreferences();
        prefs.addListener(this);
    }

    @Override
    public void onSyncFeatureChanged()
    {
        if(!prefs.isSyncEnabled()) stopSelf();
    }

    @Override
    public void onDestroy()
    {
        unregisterReceiver(connectivityReceiver);
        syncManager.stopListening();
    }
}
