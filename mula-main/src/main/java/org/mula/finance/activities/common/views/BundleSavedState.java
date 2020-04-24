/* Mula */

package org.mula.finance.activities.common.views;

import android.os.*;
import androidx.core.os.*;
import androidx.customview.view.AbsSavedState;

public class BundleSavedState extends AbsSavedState
{
    public static final Parcelable.Creator<BundleSavedState> CREATOR =
        ParcelableCompat.newCreator(
            new ParcelableCompatCreatorCallbacks<BundleSavedState>()
            {
                @Override
                public BundleSavedState createFromParcel(Parcel source,
                                                         ClassLoader loader)
                {
                    return new BundleSavedState(source, loader);
                }

                @Override
                public BundleSavedState[] newArray(int size)
                {
                    return new BundleSavedState[size];
                }
            });

    public final Bundle bundle;

    public BundleSavedState(Parcelable superState, Bundle bundle)
    {
        super(superState);
        this.bundle = bundle;
    }

    public BundleSavedState(Parcel source, ClassLoader loader)
    {
        super(source, loader);
        this.bundle = source.readBundle(loader);
    }

    @Override
    public void writeToParcel(Parcel out, int flags)
    {
        super.writeToParcel(out, flags);
        out.writeBundle(bundle);
    }
}