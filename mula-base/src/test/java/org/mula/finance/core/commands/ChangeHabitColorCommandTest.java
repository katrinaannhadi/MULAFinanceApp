/* Mula */

package org.mula.finance.core.commands;

import org.mula.finance.core.*;
import org.junit.*;
import org.mula.finance.core.models.Habit;

import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ChangeHabitColorCommandTest extends BaseUnitTest
{
    private ChangeHabitColorCommand command;

    private LinkedList<Habit> selected;

    @Override
    @Before
    public void setUp() throws Exception
    {
        super.setUp();

        selected = new LinkedList<>();

        for (int i = 0; i < 3; i++)
        {
            Habit habit = fixtures.createShortHabit();
            habit.setColor(i + 1);
            selected.add(habit);
            habitList.add(habit);
        }

        command = new ChangeHabitColorCommand(habitList, selected, 0);
    }

    @Test
    public void testExecuteUndoRedo()
    {
        checkOriginalColors();

        command.execute();
        checkNewColors();

        command.undo();
        checkOriginalColors();

        command.execute();
        checkNewColors();
    }

    @Test
    public void testRecord()
    {
        ChangeHabitColorCommand.Record rec = command.toRecord();
        ChangeHabitColorCommand other = rec.toCommand(habitList);
        assertThat(other.getId(), equalTo(command.getId()));
        assertThat(other.newColor, equalTo(command.newColor));
        assertThat(other.selected, equalTo(command.selected));
    }

    private void checkNewColors()
    {
        for (Habit h : selected)
            assertThat(h.getColor(), equalTo(0));
    }

    private void checkOriginalColors()
    {
        int k = 0;
        for (Habit h : selected)
            assertThat(h.getColor(), equalTo(++k));
    }
}
