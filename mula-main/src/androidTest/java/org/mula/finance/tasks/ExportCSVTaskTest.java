/* Mula */

package org.mula.finance.tasks;

import androidx.test.filters.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.mula.finance.*;
import org.junit.*;
import org.junit.runner.*;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class ExportCSVTaskTest extends BaseAndroidTest
{
    @Before
    @Override
    public void setUp()
    {
        super.setUp();
    }

//    @Test
//    public void testExportCSV() throws Throwable
//    {
//        fixtures.purgeHabits(habitList);
//        fixtures.createShortHabit();
//
//        List<Habit> selected = new LinkedList<>();
//        for (Habit h : habitList) selected.add(h);
//        File outputDir = new AndroidDirFinder(targetContext).getFilesDir("CSV");
//        assertNotNull(outputDir);
//
//        taskRunner.execute(
//            new ExportCSVTask(habitList, selected, outputDir, archiveFilename -> {
//                assertThat(archiveFilename, is(not(nullValue())));
//                File f = new File(archiveFilename);
//                assertTrue(f.exists());
//                assertTrue(f.canRead());
//            }));
//    }
}
