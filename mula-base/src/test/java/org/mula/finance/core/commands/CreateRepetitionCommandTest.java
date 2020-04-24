/* Mula */

package org.mula.finance.core.commands;

import org.mula.finance.core.*;
import org.junit.*;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.Repetition;
import org.mula.finance.core.models.RepetitionList;
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.utils.DateUtils;

import static junit.framework.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mula.finance.core.models.Checkmark.CHECKED_EXPLICITLY;

public class CreateRepetitionCommandTest extends BaseUnitTest
{
    private CreateRepetitionCommand command;

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
        command = new CreateRepetitionCommand(habit, today, 100);
    }

    @Test
    public void testExecuteUndoRedo()
    {
        RepetitionList reps = habit.getRepetitions();

        Repetition rep = reps.getByTimestamp(today);
        assertNotNull(rep);
        assertEquals(CHECKED_EXPLICITLY, rep.getValue());

        command.execute();
        rep = reps.getByTimestamp(today);
        assertNotNull(rep);
        assertEquals(100, rep.getValue());

        command.undo();
        rep = reps.getByTimestamp(today);
        assertNotNull(rep);
        assertEquals(CHECKED_EXPLICITLY, rep.getValue());
    }

    @Test
    public void testRecord()
    {
        CreateRepetitionCommand.Record rec = command.toRecord();
        CreateRepetitionCommand other = rec.toCommand(habitList);

        assertThat(command.getId(), equalTo(other.getId()));
        assertThat(command.timestamp, equalTo(other.timestamp));
        assertThat(command.value, equalTo(other.value));
        assertThat(command.habit, equalTo(other.habit));
    }
}
