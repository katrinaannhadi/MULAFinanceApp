/* Mula */

package org.mula.finance.tasks;

import android.content.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.auto.factory.*;

import org.mula.finance.utils.*;
import org.mula.androidbase.AndroidDirFinder;
import org.mula.androidbase.AppContext;
import org.mula.finance.core.tasks.Task;

import java.io.*;

@AutoFactory(allowSubclasses = true)
public class ExportDBTask implements Task
{
    private String filename;

    @NonNull
    private Context context;

    private AndroidDirFinder system;

    @NonNull
    private final Listener listener;

    public ExportDBTask(@Provided @AppContext @NonNull Context context,
                        @Provided @NonNull AndroidDirFinder system,
                        @NonNull Listener listener)
    {
        this.system = system;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public void doInBackground()
    {
        filename = null;

        try
        {
            File dir = system.getFilesDir("Backups");
            if (dir == null) return;

            filename = DatabaseUtils.saveDatabaseCopy(context, dir);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onPostExecute()
    {
        listener.onExportDBFinished(filename);
    }

    public interface Listener
    {
        void onExportDBFinished(@Nullable String filename);
    }
}
