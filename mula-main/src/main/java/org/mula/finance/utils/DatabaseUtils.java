/* Mula */

package org.mula.finance.utils;

import android.content.*;
import android.database.sqlite.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.mula.finance.*;
import org.mula.androidbase.utils.FileUtils;
import org.mula.finance.core.Config;
import org.mula.finance.core.utils.DateFormats;
import org.mula.finance.core.utils.DateUtils;

import java.io.*;
import java.text.*;

import static org.mula.finance.core.Config.DATABASE_VERSION;

public abstract class DatabaseUtils
{
    @Nullable
    private static HabitsDatabaseOpener opener = null;

    @Deprecated
    public static void executeAsTransaction(Callback callback)
    {
        try (SQLiteDatabase db = openDatabase())
        {
            db.beginTransaction();
            try
            {
                callback.execute();
                db.setTransactionSuccessful();
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }
            finally
            {
                db.endTransaction();
            }
        }
    }

    @NonNull
    public static File getDatabaseFile(Context context)
    {
        String databaseFilename = getDatabaseFilename();
        String root = context.getFilesDir().getPath();

        String format = "%s/../databases/%s";
        String filename = String.format(format, root, databaseFilename);

        return new File(filename);
    }

    @NonNull
    public static String getDatabaseFilename()
    {
        String databaseFilename = Config.DATABASE_FILENAME;
        if (HabitsApplication.Companion.isTestMode()) databaseFilename = "test.db";
        return databaseFilename;
    }

    @SuppressWarnings("unchecked")
    public static void initializeDatabase(Context context)
    {
        opener = new HabitsDatabaseOpener(context, getDatabaseFilename(),
            DATABASE_VERSION);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static String saveDatabaseCopy(Context context, File dir)
        throws IOException
    {
        SimpleDateFormat dateFormat = DateFormats.getBackupDateFormat();
        String date = dateFormat.format(DateUtils.getLocalTime());
        String format = "%s/Loop Habits Backup %s.db";
        String filename = String.format(format, dir.getAbsolutePath(), date);

        File db = getDatabaseFile(context);
        File dbCopy = new File(filename);
        FileUtils.copy(db, dbCopy);

        return dbCopy.getAbsolutePath();
    }

    @NonNull
    public static SQLiteDatabase openDatabase()
    {
        if (opener == null) throw new IllegalStateException();
        return opener.getWritableDatabase();
    }

    public static void dispose()
    {
        opener = null;
    }

    public interface Callback
    {
        void execute() throws Exception;
    }
}
