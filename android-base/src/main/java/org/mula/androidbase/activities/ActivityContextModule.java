/* Mula */

package org.mula.androidbase.activities;

import android.content.*;

import dagger.*;

@Module
public class ActivityContextModule
{
    private Context context;

    public ActivityContextModule(Context context)
    {
        this.context = context;
    }

    @Provides
    @ActivityContext
    public Context getContext()
    {
        return context;
    }
}
