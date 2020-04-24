/* Mula */

package org.mula.finance.core.database;

import androidx.annotation.*;

import java.io.*;
import java.util.*;
import java.util.logging.*;

public class MigrationHelper
{
    private static final Logger LOGGER =
        Logger.getLogger(MigrationHelper.class.getName());

    private final Database db;

    public MigrationHelper(@NonNull Database db)
    {
        this.db = db;
    }

    public void migrateTo(int newVersion)
    {
        try
        {
            for (int v = db.getVersion() + 1; v <= newVersion; v++)
            {
                String fname = String.format(Locale.US, "/migrations/%02d.sql", v);
                for (String command : SQLParser.parse(open(fname)))
                    db.execute(command);
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    private InputStream open(String fname) throws IOException
    {
        InputStream resource = getClass().getResourceAsStream(fname);
        if(resource != null) return resource;

        // Workaround for bug in Android Studio / IntelliJ. Removing this
        // causes unit tests to fail when run from within the IDE, although
        // everything works fine from the command line.
        File file = new File("finance-core/src/main/resources/" + fname);
        if(file.exists()) return new FileInputStream(file);

        throw new RuntimeException("resource not found: " + fname);
    }
}
