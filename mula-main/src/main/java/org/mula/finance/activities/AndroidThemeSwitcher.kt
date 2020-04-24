/* Mula */

package org.mula.finance.activities

import android.content.res.Configuration.*
import android.os.Build.VERSION.*
import androidx.core.content.*
import org.mula.finance.*
import org.mula.androidbase.activities.ActivityScope
import org.mula.androidbase.activities.BaseActivity
import org.mula.finance.core.preferences.Preferences
import org.mula.finance.core.ui.ThemeSwitcher
import javax.inject.*

@ActivityScope
class AndroidThemeSwitcher
@Inject constructor(
        private val activity: BaseActivity,
        preferences: Preferences
) : ThemeSwitcher(preferences) {

    override fun getSystemTheme(): Int {
        if(SDK_INT < 29) return THEME_LIGHT;
        val uiMode = activity.resources.configuration.uiMode
        return if ((uiMode and UI_MODE_NIGHT_MASK) == UI_MODE_NIGHT_YES) {
            THEME_DARK;
        } else {
            THEME_LIGHT;
        }
    }

    override fun applyDarkTheme() {
        activity.setTheme(R.style.AppBaseThemeDark)
        activity.window.navigationBarColor =
                ContextCompat.getColor(activity, R.color.grey_900)
    }

    override fun applyLightTheme() {
        activity.setTheme(R.style.AppBaseTheme)
    }

    override fun applyPureBlackTheme() {
        activity.setTheme(R.style.AppBaseThemeDark_PureBlack)
        activity.window.navigationBarColor =
                ContextCompat.getColor(activity, R.color.black)
    }

    fun getDialogTheme(): Int {
        return when {
            isNightMode -> R.style.DarkDialogWithTitle
            else -> R.style.DialogWithTitle
        }
    }
}
