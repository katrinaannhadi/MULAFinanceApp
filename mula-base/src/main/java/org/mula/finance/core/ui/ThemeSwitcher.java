/* Mula */

package org.mula.finance.core.ui;

import androidx.annotation.*;

import org.mula.finance.core.preferences.Preferences;

public abstract class ThemeSwitcher
{
    public static final int THEME_DARK = 1;

    public static final int THEME_LIGHT = 2;

    public static final int THEME_AUTOMATIC = 0;

    private final Preferences preferences;

    public ThemeSwitcher(@NonNull Preferences preferences)
    {
        this.preferences = preferences;
    }

    public void apply()
    {
        if (isNightMode())
        {
            if (preferences.isPureBlackEnabled()) applyPureBlackTheme();
            else applyDarkTheme();
        }
        else
        {
            applyLightTheme();
        }
    }

    public abstract void applyDarkTheme();

    public abstract void applyLightTheme();

    public abstract void applyPureBlackTheme();

    public abstract int getSystemTheme();

    public boolean isNightMode()
    {
        int systemTheme = getSystemTheme();
        int userTheme = preferences.getTheme();

        return (userTheme == THEME_DARK ||
                (systemTheme == THEME_DARK && userTheme == THEME_AUTOMATIC));
    }

    public void toggleNightMode()
    {
        int systemTheme = getSystemTheme();
        int userTheme = preferences.getTheme();

        if(userTheme == THEME_AUTOMATIC)
        {
            if(systemTheme == THEME_LIGHT) preferences.setTheme(THEME_DARK);
            if(systemTheme == THEME_DARK) preferences.setTheme(THEME_LIGHT);
        }
        else if(userTheme == THEME_LIGHT)
        {
            if (systemTheme == THEME_LIGHT) preferences.setTheme(THEME_DARK);
            if (systemTheme == THEME_DARK) preferences.setTheme(THEME_AUTOMATIC);
        }
        else if(userTheme == THEME_DARK)
        {
            if (systemTheme == THEME_LIGHT) preferences.setTheme(THEME_AUTOMATIC);
            if (systemTheme == THEME_DARK) preferences.setTheme(THEME_LIGHT);
        }
    }
}
