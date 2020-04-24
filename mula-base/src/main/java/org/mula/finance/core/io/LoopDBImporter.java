/* Mula */

package org.mula.finance.core.io;

import androidx.annotation.*;

import org.mula.finance.core.Config;
import org.mula.finance.core.database.Cursor;
import org.mula.finance.core.database.Database;
import org.mula.finance.core.database.DatabaseOpener;
import org.mula.finance.core.database.MigrationHelper;
import org.mula.finance.core.database.Repository;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.ModelFactory;
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.models.sqlite.records.HabitRecord;
import org.mula.finance.core.models.sqlite.records.RepetitionRecord;

import java.io.*;
import java.util.*;

import javax.inject.*;

/**
 * Class that imports data from database files exported by Loop Habit Tracker.
 */
public class LoopDBImporter extends AbstractImporter
{
    @NonNull
    private final ModelFactory modelFactory;

    @NonNull
    private final DatabaseOpener opener;

    @Inject
    public LoopDBImporter(@NonNull HabitList habitList,
                          @NonNull ModelFactory modelFactory,
                          @NonNull DatabaseOpener opener)
    {
        super(habitList);
        this.modelFactory = modelFactory;
        this.opener = opener;
    }

    @Override
    public boolean canHandle(@NonNull File file) throws IOException
    {
        if (!isSQLite3File(file)) return false;

        Database db = opener.open(file);
        boolean canHandle = true;

        Cursor c = db.query("select count(*) from SQLITE_MASTER " +
                            "where name='Habits' or name='Repetitions'");

        if (!c.moveToNext() || c.getInt(0) != 2)
        {
//            Log.w("LoopDBImporter", "Cannot handle file: tables not found");
            canHandle = false;
        }

        if (db.getVersion() > Config.DATABASE_VERSION)
        {
//            Log.w("LoopDBImporter", String.format(
//                "Cannot handle file: incompatible version: %d > %d",
//                db.getVersion(), DATABASE_VERSION));
            canHandle = false;
        }

        c.close();
        db.close();
        return canHandle;
    }

    @Override
    public synchronized void importHabitsFromFile(@NonNull File file)
        throws IOException
    {
        Database db = opener.open(file);
        MigrationHelper helper = new MigrationHelper(db);
        helper.migrateTo(Config.DATABASE_VERSION);

        Repository<HabitRecord> habitsRepository;
        Repository<RepetitionRecord> repsRepository;
        habitsRepository = new Repository<>(HabitRecord.class, db);
        repsRepository = new Repository<>(RepetitionRecord.class, db);

        for (HabitRecord habitRecord : habitsRepository.findAll(
            "order by position"))
        {
            Habit h = modelFactory.buildHabit();
            habitRecord.copyTo(h);
            h.setId(null);
            habitList.add(h);

            List<RepetitionRecord> reps =
                repsRepository.findAll("where habit = ?",
                    habitRecord.id.toString());

            for (RepetitionRecord r : reps)
                h.getRepetitions().toggle(new Timestamp(r.timestamp), r.value);
        }
    }
}
