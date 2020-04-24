/* Mula */

package org.mula.finance.core.io;

import androidx.annotation.*;

import org.mula.finance.core.models.HabitList;

import java.io.*;
import java.util.*;

/**
 * AbstractImporter is the base class for all classes that import data from
 * files into the app.
 */
public abstract class AbstractImporter
{
    protected final HabitList habitList;

    public AbstractImporter(HabitList habitList)
    {
        this.habitList = habitList;
    }

    public abstract boolean canHandle(@NonNull File file) throws IOException;

    public abstract void importHabitsFromFile(@NonNull File file) throws IOException;

    public static boolean isSQLite3File(@NonNull File file) throws IOException
    {
        FileInputStream fis = new FileInputStream(file);

        byte[] sqliteHeader = "SQLite format 3".getBytes();
        byte[] buffer = new byte[sqliteHeader.length];

        int count = fis.read(buffer);
        if(count < sqliteHeader.length) return false;

        return Arrays.equals(buffer, sqliteHeader);
    }
}