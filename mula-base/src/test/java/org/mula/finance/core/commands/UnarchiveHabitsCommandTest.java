/* Mula */

package org.mula.finance.core.commands;

import org.mula.finance.core.*;
import org.junit.*;
import org.mula.finance.core.models.Habit;

import java.util.*;

import static junit.framework.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UnarchiveHabitsCommandTest extends BaseUnitTest
{
    private UnarchiveHabitsCommand command;
    private Habit habit;

    @Override
    @Before
    public void setUp() throws Exception
    {
        super.setUp();

        habit = fixtures.createShortHabit();
        habit.setArchived(true);
        habitList.add(habit);

        command = new UnarchiveHabitsCommand(habitList, Collections
            .singletonList
            (habit));
    }

    @Test
    public void testExecuteUndoRedo()
    {
        assertTrue(habit.isArchived());

        command.execute();
        assertFalse(habit.isArchived());

        command.undo();
        assertTrue(habit.isArchived());

        command.execute();
        assertFalse(habit.isArchived());
    }

    @Test
    public void testRecord()
    {
        UnarchiveHabitsCommand.Record rec = command.toRecord();
        UnarchiveHabitsCommand other = rec.toCommand(habitList);
        assertThat(other.selected, equalTo(command.selected));
        assertThat(other.getId(), equalTo(command.getId()));
    }
}
