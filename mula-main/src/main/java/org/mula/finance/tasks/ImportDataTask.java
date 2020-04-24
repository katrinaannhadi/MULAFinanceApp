/* Mula */

package org.mula.finance.tasks;

import androidx.annotation.NonNull;

import com.google.auto.factory.*;

import org.mula.finance.core.io.GenericImporter;
import org.mula.finance.core.models.ModelFactory;
import org.mula.finance.core.models.sqlite.SQLModelFactory;
import org.mula.finance.core.tasks.Task;

import java.io.*;

@AutoFactory(allowSubclasses = true)
public class ImportDataTask implements Task
{
    public static final int FAILED = 3;

    public static final int NOT_RECOGNIZED = 2;

    public static final int SUCCESS = 1;

    private int result;

    @NonNull
    private final File file;

    private GenericImporter importer;

    private SQLModelFactory modelFactory;

    @NonNull
    private final Listener listener;

    public ImportDataTask(@Provided @NonNull GenericImporter importer,
                          @Provided @NonNull ModelFactory modelFactory,
                          @NonNull File file,
                          @NonNull Listener listener)
    {
        this.importer = importer;
        this.modelFactory = (SQLModelFactory) modelFactory;
        this.listener = listener;
        this.file = file;
    }

    @Override
    public void doInBackground()
    {
        modelFactory.db.beginTransaction();

        try
        {
            if (importer.canHandle(file))
            {
                importer.importHabitsFromFile(file);
                result = SUCCESS;
                modelFactory.db.setTransactionSuccessful();
            }
            else
            {
                result = NOT_RECOGNIZED;
            }
        }
        catch (Exception e)
        {
            result = FAILED;
            e.printStackTrace();
        }

        modelFactory.db.endTransaction();
    }

    @Override
    public void onPostExecute()
    {
        listener.onImportDataFinished(result);
    }

    public interface Listener
    {
        void onImportDataFinished(int result);
    }
}