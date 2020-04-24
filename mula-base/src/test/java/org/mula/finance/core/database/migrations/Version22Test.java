/* Mula */

package org.mula.finance.core.database.migrations;

import org.mula.finance.core.*;
import org.junit.*;
import org.junit.rules.*;
import org.mula.finance.core.database.Database;
import org.mula.finance.core.database.MigrationHelper;
import org.mula.finance.core.models.sqlite.SQLModelFactory;
import org.mula.finance.core.test.HabitFixtures;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class Version22Test extends BaseUnitTest
{
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private Database db;

    private MigrationHelper helper;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        db = openDatabaseResource("/databases/021.db");
        helper = new MigrationHelper(db);
        modelFactory = new SQLModelFactory(db);
        habitList = modelFactory.buildHabitList();
        fixtures = new HabitFixtures(modelFactory, habitList);
    }

    @Test
    public void testKeepValidReps() throws Exception
    {
        db.query("select count(*) from repetitions",
            (c) -> assertThat(c.getInt(0), equalTo(3)));

        helper.migrateTo(22);

        db.query("select count(*) from repetitions",
            (c) -> assertThat(c.getInt(0), equalTo(3)));
    }

    @Test
    public void testRemoveRepsWithInvalidId() throws Exception
    {
        db.execute("insert into Repetitions(habit, timestamp, value) " +
                   "values (99999, 100, 2)");
        db.query("select count(*) from repetitions where habit = 99999",
            (c) -> assertThat(c.getInt(0), equalTo(1)));

        helper.migrateTo(22);

        db.query("select count(*) from repetitions where habit = 99999",
            (c) -> assertThat(c.getInt(0), equalTo(0)));
    }

    @Test
    public void testDisallowNewRepsWithInvalidRef() throws Exception
    {
        helper.migrateTo(22);
        exception.expectMessage(containsString("FOREIGNKEY"));
        db.execute("insert into Repetitions(habit, timestamp, value) " +
                   "values (99999, 100, 2)");
    }

    @Test
    public void testRemoveRepetitionsWithNullTimestamp() throws Exception
    {
        db.execute("insert into repetitions(habit, value) values (0, 2)");
        db.query("select count(*) from repetitions where timestamp is null",
            (c) -> assertThat(c.getInt(0), equalTo(1)));

        helper.migrateTo(22);

        db.query("select count(*) from repetitions where timestamp is null",
            (c) -> assertThat(c.getInt(0), equalTo(0)));
    }

    @Test
    public void testDisallowNullTimestamp() throws Exception
    {
        helper.migrateTo(22);
        exception.expectMessage(containsString("SQLITE_CONSTRAINT_NOTNULL"));
        db.execute("insert into Repetitions(habit, value) " + "values (0, 2)");
    }

    @Test
    public void testRemoveRepetitionsWithNullHabit() throws Exception
    {
        db.execute("insert into repetitions(timestamp, value) values (0, 2)");
        db.query("select count(*) from repetitions where habit is null",
            (c) -> assertThat(c.getInt(0), equalTo(1)));

        helper.migrateTo(22);

        db.query("select count(*) from repetitions where habit is null",
            (c) -> assertThat(c.getInt(0), equalTo(0)));
    }

    @Test
    public void testDisallowNullHabit() throws Exception
    {
        helper.migrateTo(22);
        exception.expectMessage(containsString("SQLITE_CONSTRAINT_NOTNULL"));
        db.execute(
            "insert into Repetitions(timestamp, value) " + "values (5, 2)");
    }

    @Test
    public void testRemoveDuplicateRepetitions() throws Exception
    {
        db.execute("insert into repetitions(habit, timestamp, value)" +
                   "values (0, 100, 2)");
        db.execute("insert into repetitions(habit, timestamp, value)" +
                   "values (0, 100, 5)");
        db.execute("insert into repetitions(habit, timestamp, value)" +
                   "values (0, 100, 10)");
        db.query(
            "select count(*) from repetitions where timestamp=100 and habit=0",
            (c) -> assertThat(c.getInt(0), equalTo(3)));

        helper.migrateTo(22);

        db.query(
            "select count(*) from repetitions where timestamp=100 and habit=0",
            (c) -> assertThat(c.getInt(0), equalTo(1)));
    }

    @Test
    public void testDisallowNewDuplicateTimestamps() throws Exception
    {
        helper.migrateTo(22);
        db.execute("insert into repetitions(habit, timestamp, value)" +
                   "values (0, 100, 2)");
        exception.expectMessage(containsString("SQLITE_CONSTRAINT_UNIQUE"));
        db.execute("insert into repetitions(habit, timestamp, value)" +
                   "values (0, 100, 5)");
    }
}
