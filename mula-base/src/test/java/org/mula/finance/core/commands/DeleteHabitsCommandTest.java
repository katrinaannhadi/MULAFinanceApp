/* Mula */

package org.mula.finance.core.commands;

import org.mula.finance.core.*;
import org.junit.*;
import org.junit.rules.*;
import org.mula.finance.core.models.Habit;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteHabitsCommandTest extends BaseUnitTest
{
    private DeleteHabitsCommand command;

    private LinkedList<Habit> selected;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Override
    @Before
    public void setUp() throws Exception
    {
        super.setUp();
        selected = new LinkedList<>();

        // Habits that should be deleted
        for (int i = 0; i < 3; i++)
        {
            Habit habit = fixtures.createShortHabit();
            habitList.add(habit);
            selected.add(habit);
        }

        // Extra habit that should not be deleted
        Habit extraHabit = fixtures.createShortHabit();
        extraHabit.setName("extra");
        habitList.add(extraHabit);

        command = new DeleteHabitsCommand(habitList, selected);
    }

    @Test
    public void testExecuteUndoRedo()
    {
        assertThat(habitList.size(), equalTo(4));

        command.execute();
        assertThat(habitList.size(), equalTo(1));
        assertThat(habitList.getByPosition(0).getName(), equalTo("extra"));

        thrown.expect(UnsupportedOperationException.class);
        command.undo();
    }

    @Test
    public void testRecord()
    {
        DeleteHabitsCommand.Record rec = command.toRecord();
        DeleteHabitsCommand other = rec.toCommand(habitList);
        assertThat(other.getId(), equalTo(command.getId()));
        assertThat(other.selected, equalTo(command.selected));
    }
}
