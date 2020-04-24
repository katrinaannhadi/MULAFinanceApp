/* Mula */

package org.mula.finance.activities.habits.show.views;

import androidx.test.filters.*;

import android.view.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.mula.finance.*;
import org.junit.*;
import org.junit.runner.*;
import org.mula.finance.core.models.Habit;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class HistoryCardTest extends BaseViewTest
{
    public static final String PATH = "habits/show/HistoryCard/";

    private HistoryCard view;

    private Habit habit;

    @Before
    @Override
    public void setUp()
    {
        super.setUp();
        habit = fixtures.createLongHabit();

        view = (HistoryCard) LayoutInflater
            .from(targetContext)
            .inflate(R.layout.show_habit, null)
            .findViewById(R.id.historyCard);

        view.setHabit(habit);
        view.refreshData();

        measureView(view, 800, 600);
    }

    @Test
    public void testRender() throws Exception
    {
        assertRenders(view, PATH + "render.png");
    }
}