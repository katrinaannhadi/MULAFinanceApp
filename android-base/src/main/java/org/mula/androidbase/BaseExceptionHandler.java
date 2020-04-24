/* Mula */

package org.mula.androidbase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.mula.androidbase.activities.*;
import org.mula.androidbase.activities.BaseActivity;

public class BaseExceptionHandler implements Thread.UncaughtExceptionHandler
{
    @Nullable
    private Thread.UncaughtExceptionHandler originalHandler;

    @NonNull
    private BaseActivity activity;

    public BaseExceptionHandler(@NonNull BaseActivity activity)
    {
        this.activity = activity;
        originalHandler = Thread.getDefaultUncaughtExceptionHandler();
    }

    @Override
    public void uncaughtException(@Nullable Thread thread,
                                  @Nullable Throwable ex)
    {
        if (ex == null) return;

        try
        {
            ex.printStackTrace();
            new AndroidBugReporter(activity).dumpBugReportToFile();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

//        if (ex.getCause() instanceof InconsistentDatabaseException)
//        {
//            HabitsApplication app = (HabitsApplication) activity.getApplication();
//            HabitList habits = app.getComponent().getHabitList();
//            habits.repair();
//            System.exit(0);
//        }

        if (originalHandler != null)
            originalHandler.uncaughtException(thread, ex);
    }
}
