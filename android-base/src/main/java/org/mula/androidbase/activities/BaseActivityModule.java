/* Mula */

package org.mula.androidbase.activities;

import dagger.*;

@Module
public class BaseActivityModule
{
    private BaseActivity activity;

    public BaseActivityModule(BaseActivity activity)
    {
        this.activity = activity;
    }

    @Provides
    public BaseActivity getBaseActivity()
    {
        return activity;
    }
}
