/* Mula */

package org.mula.androidbase;

import android.content.*;

import dagger.*;

@Module
public class AppContextModule
{
    private final Context context;

    public AppContextModule(@AppContext Context context)
    {
        this.context = context;
    }

    @Provides
    @AppContext
    Context getContext()
    {
        return context;
    }
}
