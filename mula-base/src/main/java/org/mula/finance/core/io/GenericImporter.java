/* Mula */

package org.mula.finance.core.io;

import androidx.annotation.*;

import org.mula.finance.core.models.HabitList;

import java.io.*;
import java.util.*;

import javax.inject.*;

/**
 * A GenericImporter decides which implementation of AbstractImporter is able to
 * handle a given file and delegates to it the task of importing the data.
 */
public class GenericImporter extends AbstractImporter
{
    List<AbstractImporter> importers;

    @Inject
    public GenericImporter(@NonNull HabitList habits,
                           @NonNull LoopDBImporter loopDBImporter,
                           @NonNull RewireDBImporter rewireDBImporter,
                           @NonNull TickmateDBImporter tickmateDBImporter,
                           @NonNull HabitBullCSVImporter habitBullCSVImporter)
    {
        super(habits);
        importers = new LinkedList<>();
        importers.add(loopDBImporter);
        importers.add(rewireDBImporter);
        importers.add(tickmateDBImporter);
        importers.add(habitBullCSVImporter);
    }

    @Override
    public boolean canHandle(@NonNull File file) throws IOException
    {
        for (AbstractImporter importer : importers)
            if (importer.canHandle(file)) return true;

        return false;
    }

    @Override
    public void importHabitsFromFile(@NonNull File file) throws IOException
    {
        for (AbstractImporter importer : importers)
            if (importer.canHandle(file)) importer.importHabitsFromFile(file);
    }
}
