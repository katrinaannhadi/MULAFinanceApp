/* Mula */

package org.mula.finance.core;

import androidx.annotation.*;

import org.apache.commons.io.*;
import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.database.Database;
import org.mula.finance.core.database.DatabaseOpener;
import org.mula.finance.core.database.JdbcDatabase;
import org.mula.finance.core.database.MigrationHelper;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.ModelFactory;
import org.mula.finance.core.models.Timestamp;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.junit.*;
import org.mula.finance.core.models.memory.MemoryModelFactory;
import org.mula.finance.core.tasks.SingleThreadTaskRunner;
import org.mula.finance.core.test.HabitFixtures;
import org.mula.finance.core.utils.DateUtils;

import java.io.*;
import java.sql.*;
import java.util.*;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BaseUnitTest
{

    // 8:00am, January 25th, 2015 (UTC)
    protected static final long FIXED_LOCAL_TIME = 1422172800000L;

    protected HabitList habitList;

    protected HabitFixtures fixtures;

    protected ModelFactory modelFactory;

    protected SingleThreadTaskRunner taskRunner;

    protected CommandRunner commandRunner;

    protected DatabaseOpener databaseOpener = new DatabaseOpener()
    {
        @Override
        public Database open(@NonNull File file)
        {
            try
            {
                return new JdbcDatabase(DriverManager.getConnection(
                    String.format("jdbc:sqlite:%s", file.getAbsolutePath())));
            }
            catch (SQLException e)
            {
                throw new RuntimeException(e);
            }
        }
    };

    @Before
    public void setUp() throws Exception
    {
        DateUtils.setFixedLocalTime(FIXED_LOCAL_TIME);

        modelFactory = new MemoryModelFactory();
        habitList = spy(modelFactory.buildHabitList());
        fixtures = new HabitFixtures(modelFactory, habitList);
        taskRunner = new SingleThreadTaskRunner();
        commandRunner = new CommandRunner(taskRunner);
    }

    @After
    public void tearDown() throws Exception
    {
        validateMockitoUsage();
        DateUtils.setFixedLocalTime(null);
    }

    public long unixTime(int year, int month, int day)
    {
        GregorianCalendar cal = DateUtils.getStartOfTodayCalendar();
        cal.set(year, month, day, 0, 0, 0);
        return cal.getTimeInMillis();
    }

    public long unixTime(int year, int month, int day, int hour, int minute)
    {
        GregorianCalendar cal = DateUtils.getStartOfTodayCalendar();
        cal.set(year, month, day, hour, minute);
        return cal.getTimeInMillis();
    }

    public Timestamp timestamp(int year, int month, int day) {
        return new Timestamp(unixTime(year, month, day));
    }

    @Test
    public void nothing()
    {

    }

    protected Database buildMemoryDatabase()
    {
        try
        {
            Database db = new JdbcDatabase(
                DriverManager.getConnection("jdbc:sqlite::memory:"));
            db.execute("pragma user_version=8;");
            MigrationHelper helper = new MigrationHelper(db);
            helper.migrateTo(23);
            return db;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    protected void copyAssetToFile(String assetPath, File dst)
        throws IOException
    {
        IOUtils.copy(openAsset(assetPath), new FileOutputStream(dst));
    }

    @NonNull
    protected InputStream openAsset(String assetPath) throws IOException
    {
        InputStream in = getClass().getResourceAsStream(assetPath);
        if (in != null) return in;

        String basePath = "finance-core/src/test/resources/";
        File file = new File(basePath + assetPath);
        if (file.exists() && file.canRead()) in = new FileInputStream(file);
        if (in != null) return in;

        basePath = "src/test/resources/";
        file = new File(basePath + assetPath);
        if (file.exists() && file.canRead()) in = new FileInputStream(file);
        if (in != null) return in;

        throw new IllegalStateException("asset not found: " + assetPath);
    }

    protected Database openDatabaseResource(String path) throws IOException
    {
        InputStream original = openAsset(path);
        File tmpDbFile = File.createTempFile("database", ".db");
        tmpDbFile.deleteOnExit();
        IOUtils.copy(original, new FileOutputStream(tmpDbFile));
        return databaseOpener.open(tmpDbFile);
    }
}
