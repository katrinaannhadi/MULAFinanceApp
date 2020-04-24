/* Mula */

package org.mula.finance.acceptance;

import androidx.test.filters.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.mula.finance.*;
import org.junit.*;
import org.junit.runner.*;

import static org.mula.finance.acceptance.steps.CommonSteps.Screen.*;
import static org.mula.finance.acceptance.steps.CommonSteps.*;
import static org.mula.finance.acceptance.steps.EditHabitSteps.*;
import static org.mula.finance.acceptance.steps.ListHabitsSteps.MenuItem.*;
import static org.mula.finance.acceptance.steps.ListHabitsSteps.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class HabitsTest extends BaseUserInterfaceTest
{
    @Test
    public void shouldCreateHabit() throws Exception {
        shouldCreateHabit("this is a test description");
    }

    @Test
    public void shouldCreateHabitBlankDescription() throws Exception {
        shouldCreateHabit("");
    }

    private void shouldCreateHabit(String description) throws Exception
    {
        launchApp();

        verifyShowsScreen(LIST_HABITS);
        clickMenu(ADD);

        verifyShowsScreen(EDIT_HABIT);
        String testName = "Hello world";
        typeName(testName);
        typeQuestion("Did you say hello to the world today?");
        typeDescription(description);
        pickFrequency("Every week");
        pickColor(5);
        clickSave();

        verifyShowsScreen(LIST_HABITS);
        verifyDisplaysText(testName);
    }

    @Test
    public void shouldShowHabitStatistics() throws Exception
    {
        launchApp();
        verifyShowsScreen(LIST_HABITS);
        clickText("Track time");

        verifyShowsScreen(SHOW_HABIT);
        verifyDisplayGraphs();
    }

    @Test
    public void shouldDeleteHabit() throws Exception
    {
        launchApp();

        verifyShowsScreen(LIST_HABITS);
        longClickText("Track time");
        clickMenu(DELETE);
        clickOK();
        verifyDoesNotDisplayText("Track time");
    }

    @Test
    public void shouldEditHabit() throws Exception {
        shouldEditHabit("this is a test description");
    }

    @Test
    public void shouldEditHabitBlankDescription() throws Exception {
        shouldEditHabit("");
    }

    private void shouldEditHabit(String description) throws Exception
    {
        launchApp();

        verifyShowsScreen(LIST_HABITS);
        longClickText("Track time");
        clickMenu(EDIT);

        verifyShowsScreen(EDIT_HABIT);
        typeName("Take a walk");
        typeQuestion("Did you take a walk today?");
        typeDescription(description);
        clickSave();

        verifyShowsScreen(LIST_HABITS);
        verifyDisplaysTextInSequence("Wake up early", "Take a walk", "Meditate");
        verifyDoesNotDisplayText("Track time");
    }

    @Test
    public void shouldEditHabit_fromStatisticsScreen() throws Exception
    {
        launchApp();

        verifyShowsScreen(LIST_HABITS);
        clickText("Track time");

        verifyShowsScreen(SHOW_HABIT);
        clickMenu(EDIT);

        verifyShowsScreen(EDIT_HABIT);
        typeName("Take a walk");
        typeQuestion("Did you take a walk today?");
        pickColor(10);
        clickSave();

        verifyShowsScreen(SHOW_HABIT);
        verifyDisplaysText("Take a walk");
        pressBack();

        verifyShowsScreen(LIST_HABITS);
        verifyDisplaysText("Take a walk");
        verifyDoesNotDisplayText("Track time");
    }

    @Test
    public void shouldArchiveAndUnarchiveHabits() throws Exception
    {
        launchApp();

        verifyShowsScreen(LIST_HABITS);
        longClickText("Track time");
        clickMenu(ARCHIVE);
        verifyDoesNotDisplayText("Track time");
        clickMenu(TOGGLE_ARCHIVED);
        verifyDisplaysText("Track time");

        longClickText("Track time");
        clickMenu(UNARCHIVE);
        clickMenu(TOGGLE_ARCHIVED);
        verifyDisplaysText("Track time");
    }

    @Test
    public void shouldToggleCheckmarksAndUpdateScore() throws Exception
    {
        launchApp();
        verifyShowsScreen(LIST_HABITS);
        longPressCheckmarks("Wake up early", 2);
        clickText("Wake up early");

        verifyShowsScreen(SHOW_HABIT);
        verifyDisplaysText("10%");
    }

    @Test
    public void shouldHideCompleted() throws Exception
    {
        launchApp();
        verifyShowsScreen(LIST_HABITS);
        verifyDisplaysText("Track time");
        verifyDisplaysText("Wake up early");

        clickMenu(TOGGLE_COMPLETED);
        verifyDoesNotDisplayText("Track time");
        verifyDisplaysText("Wake up early");

        longPressCheckmarks("Wake up early", 1);
        verifyDoesNotDisplayText("Wake up early");

        clickMenu(TOGGLE_COMPLETED);
        verifyDisplaysText("Track time");
        verifyDisplaysText("Wake up early");
    }

    @Test
    public void shouldHideNotesCard() throws Exception
    {
        launchApp();
        clickText(EMPTY_DESCRIPTION_HABIT_NAME);
        verifyShowsScreen(SHOW_HABIT, false);
    }
}
