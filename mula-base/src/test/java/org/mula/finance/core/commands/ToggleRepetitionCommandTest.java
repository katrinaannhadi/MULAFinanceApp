/* Mula */

package org.mula.finance.core.commands;

import org.mula.finance.core.*;
import org.junit.*;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.utils.DateUtils;

import static junit.framework.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ToggleRepetitionCommandTest extends BaseUnitTest
{

    private ToggleRepetitionCommand command;
    private Habit habit;
    private Timestamp today;

    @Override
    @Before
    public void setUp() throws Exception
    {
        super.setUp();

        habit = fixtures.createShortHabit();
        habitList.add(habit);

        today = DateUtils.getToday();
        command = new ToggleRepetitionCommand(habitList, habit, today);
    }

    @Test
    public void testExecuteUndoRedo()
    {
        assertTrue(habit.getRepetitions().containsTimestamp(today));

        command.execute();
        assertFalse(habit.getRepetitions().containsTimestamp(today));

        command.undo();
        assertTrue(habit.getRepetitions().containsTimestamp(today));

        command.execute();
        assertFalse(habit.getRepetitions().containsTimestamp(today));
    }

    @Test
    public void testRecord()
    {
        ToggleRepetitionCommand.Record rec = command.toRecord();
        ToggleRepetitionCommand other = rec.toCommand(habitList);

        assertThat(command.getId(), equalTo(other.getId()));
        assertThat(command.timestamp, equalTo(other.timestamp));
        assertThat(command.habit, equalTo(other.habit));
    }
}
