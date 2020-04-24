/* Mula */

package org.mula.finance.core.commands;

import org.mula.finance.core.*;
import org.junit.*;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.Reminder;
import org.mula.finance.core.models.WeekdayList;

import static junit.framework.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class CreateHabitCommandTest extends BaseUnitTest
{
    private CreateHabitCommand command;

    private Habit model;

    @Override
    @Before
    public void setUp() throws Exception
    {
        super.setUp();

        model = fixtures.createEmptyHabit();
        model.setName("New habit");
        model.setReminder(new Reminder(8, 30, WeekdayList.EVERY_DAY));

        command = new CreateHabitCommand(modelFactory, habitList, model);
    }

    @Test
    public void testExecuteUndoRedo()
    {
        assertTrue(habitList.isEmpty());

        command.execute();

        assertThat(habitList.size(), equalTo(1));

        Habit habit = habitList.getByPosition(0);
        Long id = habit.getId();
        assertThat(habit.getName(), equalTo(model.getName()));

        command.undo();
        assertTrue(habitList.isEmpty());

        command.execute();
        assertThat(habitList.size(), equalTo(1));

        habit = habitList.getByPosition(0);
        Long newId = habit.getId();
        assertThat(id, equalTo(newId));
        assertThat(habit.getName(), equalTo(model.getName()));
    }

    @Test
    public void testRecord()
    {
        command.execute();

        CreateHabitCommand.Record rec = command.toRecord();
        CreateHabitCommand other = rec.toCommand(modelFactory, habitList);

        assertThat(other.getId(), equalTo(command.getId()));
        assertThat(other.savedId, equalTo(command.savedId));
        assertThat(other.model.getData(), equalTo(command.model.getData()));
    }
}
