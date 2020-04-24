/* Mula */

package org.mula.finance.core.models.sqlite;

import androidx.annotation.*;

import org.mula.finance.core.*;
import org.junit.*;
import org.mula.finance.core.database.Database;
import org.mula.finance.core.database.Repository;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.Repetition;
import org.mula.finance.core.models.RepetitionList;
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.models.sqlite.records.RepetitionRecord;
import org.mula.finance.core.test.HabitFixtures;
import org.mula.finance.core.utils.DateUtils;

import java.util.*;

import static junit.framework.TestCase.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsEqual.*;
import static org.mula.finance.core.models.Checkmark.*;

public class SQLiteRepetitionListTest extends BaseUnitTest
{
    private Habit habit;

    private Timestamp today;

    private RepetitionList repetitions;

    private long day;

    private Repository<RepetitionRecord> repository;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();

        Database db = buildMemoryDatabase();
        modelFactory = new SQLModelFactory(db);
        habitList = modelFactory.buildHabitList();
        fixtures = new HabitFixtures(modelFactory, habitList);
        repository = new Repository<>(RepetitionRecord.class, db);
        habit = fixtures.createLongHabit();

        repetitions = habit.getRepetitions();
        today = DateUtils.getToday();
    }

    @Test
    public void testAdd()
    {
        RepetitionRecord record = getByTimestamp(today.plus(1));
        assertNull(record);

        Repetition rep = new Repetition(today.plus(1), CHECKED_EXPLICITLY);
        habit.getRepetitions().add(rep);

        record = getByTimestamp(today.plus(1));
        assertNotNull(record);
        assertThat(record.value, equalTo(CHECKED_EXPLICITLY));
    }

    @Test
    public void testGetByInterval()
    {
        List<Repetition> reps =
            repetitions.getByInterval(today.minus(10), today);

        assertThat(reps.size(), equalTo(8));
        assertThat(reps.get(0).getTimestamp(), equalTo(today.minus(10)));
        assertThat(reps.get(4).getTimestamp(), equalTo(today.minus(5)));
        assertThat(reps.get(5).getTimestamp(), equalTo(today.minus(3)));
    }

    @Test
    public void testGetByTimestamp()
    {
        Repetition rep = repetitions.getByTimestamp(today);
        assertNotNull(rep);
        assertThat(rep.getTimestamp(), equalTo(today));

        rep = repetitions.getByTimestamp(today.minus(2));
        assertNull(rep);
    }

    @Test
    public void testGetOldest()
    {
        Repetition rep = repetitions.getOldest();
        assertNotNull(rep);
        assertThat(rep.getTimestamp(), equalTo(today.minus(120)));
    }

    @Test
    public void testGetOldest_withEmptyHabit()
    {
        Habit empty = fixtures.createEmptyHabit();
        Repetition rep = empty.getRepetitions().getOldest();
        assertNull(rep);
    }

    @Test
    public void testRemove()
    {
        RepetitionRecord record = getByTimestamp(today);
        assertNotNull(record);

        Repetition rep = record.toRepetition();
        repetitions.remove(rep);

        record = getByTimestamp(today);
        assertNull(record);
    }

    @Nullable
    private RepetitionRecord getByTimestamp(Timestamp timestamp)
    {
        String query = "where habit = ? and timestamp = ?";
        String params[] = {
            Long.toString(habit.getId()), Long.toString(timestamp.getUnixTime())
        };

        return repository.findFirst(query, params);
    }
}
