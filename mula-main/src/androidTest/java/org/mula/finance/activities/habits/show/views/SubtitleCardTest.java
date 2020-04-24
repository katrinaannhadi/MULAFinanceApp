/* Mula */

package org.mula.finance.activities.habits.show.views;

import androidx.test.filters.*;

import android.view.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.mula.finance.*;
import org.junit.*;
import org.junit.runner.*;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.Reminder;
import org.mula.finance.core.models.WeekdayList;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class SubtitleCardTest extends BaseViewTest
{
    public static final String PATH = "habits/show/SubtitleCard/";

    private SubtitleCard view;

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
            .findViewById(R.id.subtitleCard);

        view.setHabit(habit);
        view.refreshData();

        measureView(view, 800, 200);
    }

    @Test
    public void testRender() throws Exception
    {
        assertRenders(view, PATH + "render.png");
    }
}
