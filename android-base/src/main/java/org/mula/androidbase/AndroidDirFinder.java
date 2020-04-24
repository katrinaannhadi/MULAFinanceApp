/* Mula */

package org.mula.androidbase;

import android.content.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.*;
import android.util.*;

import org.mula.androidbase.utils.*;
import org.mula.androidbase.utils.FileUtils;

import java.io.*;

import javax.inject.*;

public class AndroidDirFinder
{
    @NonNull
    private Context context;

    @Inject
    public AndroidDirFinder(@NonNull @AppContext Context context)
    {
        this.context = context;
    }

    @Nullable
    public File getFilesDir(@Nullable String relativePath)
    {
        File externalFilesDirs[] =
            ContextCompat.getExternalFilesDirs(context, null);
        if (externalFilesDirs == null)
        {
            Log.e("BaseSystem",
                "getFilesDir: getExternalFilesDirs returned null");
            return null;
        }

        return FileUtils.getDir(externalFilesDirs, relativePath);
    }
}
