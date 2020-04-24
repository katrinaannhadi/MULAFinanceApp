/* Mula */

package org.mula.finance;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.junit.*;
import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.memory.MemoryModelFactory;
import org.mula.finance.core.tasks.SingleThreadTaskRunner;
import org.mula.finance.core.test.HabitFixtures;
import org.mula.finance.core.utils.DateUtils;

import java.util.*;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BaseAndroidJVMTest
{
    protected HabitList habitList;
    protected HabitFixtures fixtures;
    protected MemoryModelFactory modelFactory;
    protected SingleThreadTaskRunner taskRunner;
    protected CommandRunner commandRunner;

    @Before
    public void setUp()
    {
        long fixed_local_time = 1422172800000L;
        DateUtils.setFixedLocalTime(fixed_local_time);

        modelFactory = new MemoryModelFactory();
        habitList = spy(modelFactory.buildHabitList());
        fixtures = new HabitFixtures(modelFactory, habitList);
        taskRunner = new SingleThreadTaskRunner();
        commandRunner = new CommandRunner(taskRunner);
    }

    @After
    public void tearDown()
    {
        DateUtils.setFixedLocalTime(null);
    }

    public long timestamp(int year, int month, int day)
    {
        GregorianCalendar cal = DateUtils.getStartOfTodayCalendar();
        cal.set(year, month, day);
        return cal.getTimeInMillis();
    }

    @Test
    public void nothing()
    {

    }
}
