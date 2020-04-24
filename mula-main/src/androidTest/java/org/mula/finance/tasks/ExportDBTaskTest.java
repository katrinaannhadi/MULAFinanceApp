/* Mula */

package org.mula.finance.tasks;

import androidx.test.filters.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.mula.finance.*;
import org.junit.*;
import org.junit.runner.*;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class ExportDBTaskTest extends BaseAndroidTest
{
    @Override
    @Before
    public void setUp()
    {
        super.setUp();
    }

//    @Test
//    public void testExportCSV() throws Throwable
//    {
//        ExportDBTask task =
//            new ExportDBTask(targetContext, new AndroidDirFinder(targetContext),
//                filename ->
//                {
//                    assertNotNull(filename);
//                    File f = new File(filename);
//                    assertTrue(f.exists());
//                    assertTrue(f.canRead());
//                });
//
//        taskRunner.execute(task);
//    }
}
