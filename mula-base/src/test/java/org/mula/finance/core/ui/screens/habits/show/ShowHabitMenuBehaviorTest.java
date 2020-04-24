/* Mula */

package org.mula.finance.core.ui.screens.habits.show;

import org.mula.finance.core.*;
import org.junit.*;
import org.mula.finance.core.models.Habit;

import java.io.*;

import static java.nio.file.Files.*;
import static org.apache.commons.io.FileUtils.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class ShowHabitMenuBehaviorTest extends BaseUnitTest
{
    private ShowHabitMenuBehavior.System system;

    private ShowHabitMenuBehavior.Screen screen;

    private Habit habit;

    private ShowHabitMenuBehavior menu;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        system = mock(ShowHabitMenuBehavior.System.class);
        screen = mock(ShowHabitMenuBehavior.Screen.class);

        habit = fixtures.createShortHabit();
        menu = new ShowHabitMenuBehavior(habitList, habit, taskRunner, screen,
            system, commandRunner);
    }

    @Test
    public void testOnEditHabit()
    {
        menu.onEditHabit();
        verify(screen).showEditHabitScreen(habit);
    }

    @Test
    public void testOnExport() throws Exception
    {
        File outputDir = createTempDirectory("CSV").toFile();
        when(system.getCSVOutputDir()).thenReturn(outputDir);
        menu.onExportCSV();
        assertThat(listFiles(outputDir, null, false).size(), equalTo(1));
        deleteDirectory(outputDir);
    }
}