/* Mula */

package org.mula.finance.activities.habits.show.views;

import android.view.LayoutInflater;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.MediumTest;

import org.mula.finance.BaseViewTest;
import org.mula.finance.R;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.Reminder;
import org.mula.finance.core.models.WeekdayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class NotesCardTest extends BaseViewTest
{
    public static final String PATH = "habits/show/NotesCard/";

    private NotesCard view;

    private Habit habit;

    @Before
    @Override
    public void setUp()
    {
        super.setUp();

        habit = fixtures.createLongHabit();
        habit.setReminder(new Reminder(8, 30, WeekdayList.EVERY_DAY));

        view = LayoutInflater
            .from(targetContext)
            .inflate(R.layout.show_habit, null)
            .findViewById(R.id.notesCard);

        view.setHabit(habit);
        view.refreshData();

        measureView(view, 800, 200);
    }

    @Test
    public void testRender() throws Exception
    {
        assertRenders(view, PATH + "render.png");
    }

    @Test
    public void testRenderEmptyDescription() throws Exception
    {
        habit.setDescription("");
        view.refreshData();
        assertRenders(view, PATH + "render-empty-description.png");
    }
}
