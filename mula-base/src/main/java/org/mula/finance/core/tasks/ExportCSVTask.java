/* Mula */

package org.mula.finance.core.tasks;

import androidx.annotation.*;

import com.google.auto.factory.*;

import org.mula.finance.core.io.HabitsCSVExporter;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;

import java.io.*;
import java.util.*;

@AutoFactory(allowSubclasses = true)
public class ExportCSVTask implements Task
{
    private String archiveFilename;

    @NonNull
    private final List<Habit> selectedHabits;

    private File outputDir;

    @NonNull
    private final ExportCSVTask.Listener listener;

    @NonNull
    private final HabitList habitList;

    public ExportCSVTask(@Provided @NonNull HabitList habitList,
                         @NonNull List<Habit> selectedHabits,
                         @NonNull File outputDir,
                         @NonNull Listener listener)
    {
        this.listener = listener;
        this.habitList = habitList;
        this.selectedHabits = selectedHabits;
        this.outputDir = outputDir;
    }

    @Override
    public void doInBackground()
    {
        try
        {
            HabitsCSVExporter exporter;
            exporter = new HabitsCSVExporter(habitList, selectedHabits, outputDir);
            archiveFilename = exporter.writeArchive();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onPostExecute()
    {
        listener.onExportCSVFinished(archiveFilename);
    }

    public interface Listener
    {
        void onExportCSVFinished(@Nullable String archiveFilename);
    }
}
