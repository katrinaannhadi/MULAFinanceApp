/* Mula */

package org.mula.finance.activities.settings;

import android.os.*;

import org.mula.finance.R;
import org.mula.androidbase.activities.BaseActivity;
import org.mula.androidbase.activities.BaseScreen;
import org.mula.androidbase.utils.StyledResources;

/**
 * Activity that allows the user to view and modify the app settings.
 */
public class SettingsActivity extends BaseActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        setupActionBarColor();
    }

    private void setupActionBarColor()
    {
        StyledResources res = new StyledResources(this);
        int color = BaseScreen.getDefaultActionBarColor(this);

        if (res.getBoolean(R.attr.useGoalColorAsPrimary))
            color = res.getColor(R.attr.aboutScreenColor);

        BaseScreen.setupActionBarColor(this, color);
    }
}
