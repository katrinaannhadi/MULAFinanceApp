/* Mula */

package org.mula.finance.core.ui.screens.habits.list;

import org.mula.finance.core.*;
import org.junit.*;
import org.mockito.*;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.utils.DateUtils;

import java.io.*;

import static java.nio.file.Files.createTempDirectory;
import static org.apache.commons.io.FileUtils.deleteDirectory;
import static org.apache.commons.io.FileUtils.listFiles;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior.Message.COULD_NOT_EXPORT;
import static org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior.Message.COULD_NOT_GENERATE_BUG_REPORT;
import static org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior.Message.DATABASE_REPAIRED;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ListHabitsBehaviorTest extends BaseUnitTest
{
    @Mock
    private ListHabitsBehavior.DirFinder dirFinder;

    @Mock
    private Preferences prefs;

    private ListHabitsBehavior behavior;

    @Mock
    private ListHabitsBehavior.Screen screen;

    private Habit habit1, habit2;

    @Captor
    ArgumentCaptor<ListHabitsBehavior.NumberPickerCallback> picker;

    @Mock
    private ListHabitsBehavior.BugReporter bugReporter;

    @Override
    @Before
    public void setUp() throws Exception
    {
        super.setUp();
        habit1 = fixtures.createShortHabit();
        habit2 = fixtures.createNumericalHabit();
        habitList.add(habit1);
        habitList.add(habit2);
        clearInvocations(habitList);

        behavior = new ListHabitsBehavior(habitList, dirFinder, taskRunner, screen,
            commandRunner, prefs, bugReporter);
    }

    @Test
    public void testOnEdit()
    {
        behavior.onEdit(habit2, DateUtils.getToday());
        verify(screen).showNumberPicker(eq(0.1), eq("miles"), picker.capture());
        picker.getValue().onNumberPicked(100);
        assertThat(habit2.getCheckmarks().getTodayValue(), equalTo(100000));
    }

    @Test
    public void testOnExportCSV() throws Exception
    {
        File outputDir = createTempDirectory("CSV").toFile();
        when(dirFinder.getCSVOutputDir()).thenReturn(outputDir);
        behavior.onExportCSV();
        verify(screen).showSendFileScreen(any());
        assertThat(listFiles(outputDir, null, false).size(), equalTo(1));
        deleteDirectory(outputDir);
    }

    @Test
    public void testOnExportCSV_fail() throws Exception
    {
        File outputDir = createTempDirectory("CSV").toFile();
        outputDir.setWritable(false);
        when(dirFinder.getCSVOutputDir()).thenReturn(outputDir);
        behavior.onExportCSV();
        verify(screen).showMessage(COULD_NOT_EXPORT);
        assertTrue(outputDir.delete());
    }

    @Test
    public void testOnHabitClick()
    {
        behavior.onClickHabit(habit1);
        verify(screen).showHabitScreen(habit1);
    }

    @Test
    public void testOnHabitReorder()
    {
        Habit from = habit1;
        Habit to = habit2;
        behavior.onReorderHabit(from, to);
        verify(habitList).reorder(from, to);
    }

    @Test
    public void testOnRepairDB()
    {
        behavior.onRepairDB();
        verify(habitList).repair();
        verify(screen).showMessage(DATABASE_REPAIRED);
    }

    @Test
    public void testOnSendBugReport() throws IOException
    {
        when(bugReporter.getBugReport()).thenReturn("hello");
        behavior.onSendBugReport();
        verify(bugReporter).dumpBugReportToFile();
        verify(screen).showSendBugReportToDeveloperScreen("hello");

        when(bugReporter.getBugReport()).thenThrow(new IOException());
        behavior.onSendBugReport();
        verify(screen).showMessage(COULD_NOT_GENERATE_BUG_REPORT);

    }

    @Test
    public void testOnStartup_firstLaunch()
    {
        Timestamp today = DateUtils.getToday();

        when(prefs.isFirstRun()).thenReturn(true);
        behavior.onStartup();
        verify(prefs).setFirstRun(false);
        verify(prefs).updateLastHint(-1, today);
        verify(screen).showIntroScreen();
    }

    @Test
    public void testOnStartup_notFirstLaunch()
    {
        when(prefs.isFirstRun()).thenReturn(false);
        behavior.onStartup();
        verify(prefs).incrementLaunchCount();
    }

    @Test
    public void testOnToggle()
    {
        assertTrue(habit1.isCompletedToday());
        behavior.onToggle(habit1, DateUtils.getToday());
        assertFalse(habit1.isCompletedToday());
    }

}