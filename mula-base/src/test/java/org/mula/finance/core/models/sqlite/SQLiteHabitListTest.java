/* Mula */

package org.mula.finance.core.models.sqlite;

import org.mula.finance.core.*;
import org.junit.*;
import org.junit.rules.*;
import org.mula.finance.core.database.Database;
import org.mula.finance.core.database.Repository;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.HabitMatcherBuilder;
import org.mula.finance.core.models.ModelObservable;
import org.mula.finance.core.models.Reminder;
import org.mula.finance.core.models.WeekdayList;
import org.mula.finance.core.models.sqlite.records.HabitRecord;
import org.mula.finance.core.test.HabitFixtures;

import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SQLiteHabitListTest extends BaseUnitTest
{
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private SQLiteHabitList habitList;

    private Repository<HabitRecord> repository;

    private ModelObservable.Listener listener;

    private ArrayList<Habit> habitsArray;

    private HabitList activeHabits;

    private HabitList reminderHabits;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        Database db = buildMemoryDatabase();
        modelFactory = new SQLModelFactory(db);
        habitList = new SQLiteHabitList(modelFactory);
        fixtures = new HabitFixtures(modelFactory, habitList);
        repository = new Repository<>(HabitRecord.class, db);
        habitsArray = new ArrayList<>();

        for (int i = 0; i < 10; i++)
        {
            Habit habit = fixtures.createEmptyHabit();
            habit.setName("habit " + (i+1));
            habitList.update(habit);
            habitsArray.add(habit);

            if (i % 3 == 0)
                habit.setReminder(new Reminder(8, 30, WeekdayList.EVERY_DAY));
        }

        habitsArray.get(0).setArchived(true);
        habitsArray.get(1).setArchived(true);
        habitsArray.get(4).setArchived(true);
        habitsArray.get(7).setArchived(true);
        habitList.update(habitsArray);

        activeHabits = habitList.getFiltered(new HabitMatcherBuilder().build());

        reminderHabits = habitList.getFiltered(new HabitMatcherBuilder()
            .setArchivedAllowed(true)
            .setReminderRequired(true)
            .build());

        listener = mock(ModelObservable.Listener.class);
        habitList.getObservable().addListener(listener);
    }

    @Override
    public void tearDown() throws Exception
    {
        habitList.getObservable().removeListener(listener);
        super.tearDown();
    }

    @Test
    public void testAdd_withDuplicate()
    {
        Habit habit = modelFactory.buildHabit();
        habitList.add(habit);
        verify(listener).onModelChange();

        exception.expect(IllegalArgumentException.class);
        habitList.add(habit);
    }

    @Test
    public void testAdd_withId()
    {
        Habit habit = modelFactory.buildHabit();
        habit.setName("Hello world with id");
        habit.setId(12300L);

        habitList.add(habit);
        assertThat(habit.getId(), equalTo(12300L));

        HabitRecord record = repository.find(12300L);
        assertNotNull(record);
        assertThat(record.name, equalTo(habit.getName()));
    }

    @Test
    public void testAdd_withoutId()
    {
        Habit habit = modelFactory.buildHabit();
        habit.setName("Hello world");
        assertNull(habit.getId());

        habitList.add(habit);
        assertNotNull(habit.getId());

        HabitRecord record = repository.find(habit.getId());
        assertNotNull(record);
        assertThat(record.name, equalTo(habit.getName()));
    }

    @Test
    public void testSize()
    {
        assertThat(habitList.size(), equalTo(10));
    }

    @Test
    public void testGetById()
    {
        Habit h1 = habitList.getById(1);
        assertNotNull(h1);
        assertThat(h1.getName(), equalTo("habit 1"));

        Habit h2 = habitList.getById(2);
        assertNotNull(h2);
        assertThat(h2, equalTo(h2));
    }

    @Test
    public void testGetById_withInvalid()
    {
        long invalidId = 9183792001L;
        Habit h1 = habitList.getById(invalidId);
        assertNull(h1);
    }

    @Test
    public void testGetByPosition()
    {
        Habit h = habitList.getByPosition(4);
        assertNotNull(h);
        assertThat(h.getName(), equalTo("habit 5"));
    }

    @Test
    public void testIndexOf()
    {
        Habit h1 = habitList.getByPosition(5);
        assertNotNull(h1);
        assertThat(habitList.indexOf(h1), equalTo(5));

        Habit h2 = modelFactory.buildHabit();
        assertThat(habitList.indexOf(h2), equalTo(-1));

        h2.setId(1000L);
        assertThat(habitList.indexOf(h2), equalTo(-1));
    }

    @Test
    public void testRemove() throws Exception
    {
        Habit h = habitList.getById(2);
        habitList.remove(h);
        assertThat(habitList.indexOf(h), equalTo(-1));

        HabitRecord rec = repository.find(2L);
        assertNull(rec);

        rec = repository.find(3L);
        assertNotNull(rec);
        assertThat(rec.position, equalTo(1));
    }

    @Test
    public void testReorder()
    {
        Habit habit3 = habitList.getById(3);
        Habit habit4 = habitList.getById(4);
        assertNotNull(habit3);
        assertNotNull(habit4);
        habitList.reorder(habit4, habit3);

        HabitRecord record3 = repository.find(3L);
        assertNotNull(record3);
        assertThat(record3.position, equalTo(3));

        HabitRecord record4 = repository.find(4L);
        assertNotNull(record4);
        assertThat(record4.position, equalTo(2));
    }


}