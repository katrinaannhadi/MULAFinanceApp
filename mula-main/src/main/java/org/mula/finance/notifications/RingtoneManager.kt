/* Mula */

package org.mula.finance.notifications

import android.content.*
import android.media.RingtoneManager.*
import android.net.*
import android.preference.*
import android.provider.*
import org.mula.finance.R
import org.mula.androidbase.AppContext
import org.mula.finance.core.AppScope
import javax.inject.*

@AppScope
class RingtoneManager
@Inject constructor(@AppContext private val context: Context) {

    val prefs: SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

    fun getName(): String? {
        try {
            var ringtoneName = context.resources.getString(R.string.none)
            val ringtoneUri = getURI()
            if (ringtoneUri != null) {
                val ringtone = getRingtone(context, ringtoneUri)
                if (ringtone != null) ringtoneName = ringtone.getTitle(context)
            }
            return ringtoneName
        } catch (e: RuntimeException) {
            e.printStackTrace()
            return null
        }
    }

    fun getURI(): Uri? {
        var ringtoneUri: Uri? = null
        val defaultRingtoneUri = Settings.System.DEFAULT_NOTIFICATION_URI
        val prefRingtoneUri = prefs.getString("pref_ringtone_uri",
                                              defaultRingtoneUri.toString())!!
        if (prefRingtoneUri.isNotEmpty())
            ringtoneUri = Uri.parse(prefRingtoneUri)

        return ringtoneUri
    }

    fun update(data: Intent?) {
        if (data == null) return
        val ringtoneUri = data.getParcelableExtra<Uri>(EXTRA_RINGTONE_PICKED_URI)
        if (ringtoneUri != null) {
            prefs.edit().putString("pref_ringtone_uri", ringtoneUri.toString()).apply()
        } else {
            prefs.edit().putString("pref_ringtone_uri", "").apply()
        }
    }
}
