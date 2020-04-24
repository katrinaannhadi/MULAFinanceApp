/* Mula */

package org.mula.finance.activities.settings;

import android.app.backup.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.provider.*;
import android.util.*;

import androidx.annotation.Nullable;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragmentCompat;

import org.mula.finance.R;
import org.mula.finance.*;
import org.mula.finance.notifications.*;
import org.mula.finance.widgets.*;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.ui.NotificationTray;
import org.mula.finance.core.utils.DateUtils;

import java.util.*;

import static android.media.RingtoneManager.*;
import static android.os.Build.VERSION.*;
import static org.mula.finance.activities.habits.list.ListHabitsScreenKt.*;

public class SettingsFragment extends PreferenceFragmentCompat
    implements SharedPreferences.OnSharedPreferenceChangeListener
{
    private static int RINGTONE_REQUEST_CODE = 1;

    private SharedPreferences sharedPrefs;

    private RingtoneManager ringtoneManager;

    @Nullable
    private Preferences prefs;

    @Nullable
    private WidgetUpdater widgetUpdater;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == RINGTONE_REQUEST_CODE)
        {
            ringtoneManager.update(data);
            updateRingtoneDescription();
            return;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        Context appContext = getContext().getApplicationContext();
        if (appContext instanceof HabitsApplication)
        {
            HabitsApplication app = (HabitsApplication) appContext;
            prefs = app.getComponent().getPreferences();
            widgetUpdater = app.getComponent().getWidgetUpdater();
        }

        setResultOnPreferenceClick("importData", RESULT_IMPORT_DATA);
        setResultOnPreferenceClick("exportCSV", RESULT_EXPORT_CSV);
        setResultOnPreferenceClick("exportDB", RESULT_EXPORT_DB);
        setResultOnPreferenceClick("repairDB", RESULT_REPAIR_DB);
        setResultOnPreferenceClick("bugReport", RESULT_BUG_REPORT);
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String s)
    {
        // NOP
    }

    @Override
    public void onPause()
    {
        sharedPrefs.unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    @Override
    public boolean onPreferenceTreeClick(Preference preference)
    {
        String key = preference.getKey();
        if (key == null) return false;

        if (key.equals("reminderSound"))
        {
            showRingtonePicker();
            return true;
        }
        else if (key.equals("reminderCustomize"))
        {
            if (SDK_INT < Build.VERSION_CODES.O) return true;
            AndroidNotificationTray.Companion.createAndroidNotificationChannel(getContext());
            Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
            intent.putExtra(Settings.EXTRA_APP_PACKAGE, getContext().getPackageName());
            intent.putExtra(Settings.EXTRA_CHANNEL_ID, NotificationTray.REMINDERS_CHANNEL_ID);
            startActivity(intent);
            return true;
        }

        return super.onPreferenceTreeClick(preference);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        this.ringtoneManager = new RingtoneManager(getActivity());

        sharedPrefs = getPreferenceManager().getSharedPreferences();
        sharedPrefs.registerOnSharedPreferenceChangeListener(this);

        if (prefs != null && !prefs.isDeveloper())
        {
            PreferenceCategory devCategory =
                (PreferenceCategory) findPreference("devCategory");
            devCategory.removeAll();
            devCategory.setVisible(false);
        }

        updateWeekdayPreference();

        // Temporarily disable this; we now always ask
        findPreference("reminderSound").setVisible(false);
        findPreference("pref_snooze_interval").setVisible(false);

        updateSync();
    }

    private void updateWeekdayPreference()
    {
        if (prefs == null) return;
        ListPreference weekdayPref = (ListPreference) findPreference("pref_first_weekday");
        int currentFirstWeekday = prefs.getFirstWeekday();
        String[] dayNames = DateUtils.getLongWeekdayNames(Calendar.SATURDAY);
        String[] dayValues = {"7", "1", "2", "3", "4", "5", "6"};
        weekdayPref.setEntries(dayNames);
        weekdayPref.setEntryValues(dayValues);
        weekdayPref.setDefaultValue(Integer.toString(currentFirstWeekday));
        weekdayPref.setSummary(dayNames[currentFirstWeekday % 7]);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
                                          String key)
    {
        if (key.equals("pref_widget_opacity") && widgetUpdater != null)
        {
            Log.d("SettingsFragment", "updating widgets");
            widgetUpdater.updateWidgets();
        }
        if (key.equals("pref_first_weekday")) updateWeekdayPreference();
        BackupManager.dataChanged("org.mula.finance");
        updateSync();
    }

    private void setResultOnPreferenceClick(String key, final int result)
    {
        Preference pref = findPreference(key);
        pref.setOnPreferenceClickListener(preference ->
        {
            getActivity().setResult(result);
            getActivity().finish();
            return true;
        });
    }

    private void showRingtonePicker()
    {
        Uri existingRingtoneUri = ringtoneManager.getURI();
        Uri defaultRingtoneUri = Settings.System.DEFAULT_NOTIFICATION_URI;

        Intent intent = new Intent(ACTION_RINGTONE_PICKER);
        intent.putExtra(EXTRA_RINGTONE_TYPE, TYPE_NOTIFICATION);
        intent.putExtra(EXTRA_RINGTONE_SHOW_DEFAULT, true);
        intent.putExtra(EXTRA_RINGTONE_SHOW_SILENT, true);
        intent.putExtra(EXTRA_RINGTONE_DEFAULT_URI, defaultRingtoneUri);
        intent.putExtra(EXTRA_RINGTONE_EXISTING_URI, existingRingtoneUri);
        startActivityForResult(intent, RINGTONE_REQUEST_CODE);
    }

    private void updateRingtoneDescription()
    {
        String ringtoneName = ringtoneManager.getName();
        if (ringtoneName == null) return;
        Preference ringtonePreference = findPreference("reminderSound");
        ringtonePreference.setSummary(ringtoneName);
    }

    private void updateSync()
    {
        if (prefs == null) return;
        boolean enabled = prefs.isSyncEnabled();

        Preference syncKey = findPreference("pref_sync_key");
        if (syncKey != null)
        {
            syncKey.setSummary(prefs.getSyncKey());
            syncKey.setVisible(enabled);
        }

        Preference syncAddress = findPreference("pref_sync_address");
        if (syncAddress != null)
        {
            syncAddress.setSummary(prefs.getSyncAddress());
            syncAddress.setVisible(enabled);
        }
    }
}