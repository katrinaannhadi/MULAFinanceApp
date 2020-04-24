/* Mula */

package org.mula.finance.core.commands;

import org.mula.finance.core.*;
import org.junit.*;
import org.mula.finance.core.models.Habit;

import java.util.*;

import static junit.framework.Assert.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ArchiveHabitsCommandTest extends BaseUnitTest
{
    private ArchiveHabitsCommand command;

    private Habit habit;

    @Override
    @Before
    public void setUp() throws Exception
    {
        super.setUp();

        habit = fixtures.createShortHabit();
        habitList.add(habit);

        command = new ArchiveHabitsCommand(habitList,
            Collections.singletonList(habit));
    }

    @Test
    public void testExecuteUndoRedo()
    {
        assertFalse(habit.isArchived());

        command.execute();
        assertTrue(habit.isArchived());

        command.undo();
        assertFalse(habit.isArchived());

        command.execute();
        assertTrue(habit.isArchived());
    }

    @Test
    public void testRecord()
    {
        ArchiveHabitsCommand.Record rec = command.toRecord();
        ArchiveHabitsCommand other = rec.toCommand(habitList);
        assertThat(other.selected, equalTo(command.selected));
        assertThat(other.getId(), equalTo(command.getId()));
    }
}
