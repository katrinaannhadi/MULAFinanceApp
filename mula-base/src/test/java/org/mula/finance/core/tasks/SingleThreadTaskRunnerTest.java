/* Mula */

package org.mula.finance.core.tasks;

import org.mula.finance.core.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import org.mockito.*;

import static org.mockito.Mockito.*;

@RunWith(JUnit4.class)
public class SingleThreadTaskRunnerTest extends BaseUnitTest
{
    private SingleThreadTaskRunner runner;

    private Task task;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        runner = new SingleThreadTaskRunner();
        task = mock(Task.class);
    }

    @Test
    public void test()
    {
        runner.execute(task);

        InOrder inOrder = inOrder(task);
        inOrder.verify(task).onAttached(runner);
        inOrder.verify(task).onPreExecute();
        inOrder.verify(task).doInBackground();
        inOrder.verify(task).onPostExecute();
    }
}
