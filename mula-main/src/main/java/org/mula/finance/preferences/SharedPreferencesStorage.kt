/* Mula */

package org.mula.finance.preferences

import android.content.*
import android.preference.*
import org.mula.finance.R
import org.mula.androidbase.AppContext
import org.mula.finance.core.AppScope
import org.mula.finance.core.preferences.Preferences
import javax.inject.*

@AppScope
class SharedPreferencesStorage
@Inject constructor(
        @AppContext context: Context
) : SharedPreferences.OnSharedPreferenceChangeListener, Preferences.Storage {

    private val sharedPrefs: SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

    private var preferences: Preferences? = null

    init {
        sharedPrefs.registerOnSharedPreferenceChangeListener(this)
        PreferenceManager.setDefaultValues(context, R.xml.preferences, false)
    }

    override fun clear() = sharedPrefs.edit().clear().apply()

    override fun getBoolean(key: String, defValue: Boolean) =
            sharedPrefs.getBoolean(key, defValue)

    override fun getInt(key: String, defValue: Int) =
            sharedPrefs.getInt(key, defValue)

    override fun getLong(key: String, defValue: Long) =
            sharedPrefs.getLong(key, defValue)

    override fun getString(key: String, defValue: String): String =
            sharedPrefs.getString(key, defValue)!!

    override fun onAttached(preferences: Preferences) {
        this.preferences = preferences
    }

    override fun putBoolean(key: String, value: Boolean) =
            sharedPrefs.edit().putBoolean(key, value).apply()

    override fun putInt(key: String, value: Int) =
            sharedPrefs.edit().putInt(key, value).apply()

    override fun putLong(key: String, value: Long) =
            sharedPrefs.edit().putLong(key, value).apply()

    override fun putString(key: String, value: String) =
            sharedPrefs.edit().putString(key, value).apply()

    override fun remove(key: String) =
            sharedPrefs.edit().remove(key).apply()

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences,
                                           key: String) {
        val preferences = this.preferences ?: return
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
        when (key) {
            "pref_checkmark_reverse_order" ->
                preferences.isCheckmarkSequenceReversed = getBoolean(key, false)
            "pref_sticky_notifications" ->
                preferences.setNotificationsSticky(getBoolean(key, false))
            "pref_led_notifications" ->
                preferences.setNotificationsLed(getBoolean(key, false))
            "pref_feature_sync" ->
                preferences.isSyncEnabled = getBoolean(key, false)
        }
        sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }
}
