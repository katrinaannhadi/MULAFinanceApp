/* Mula */

package org.mula.finance.activities.habits.show;

import android.os.*;

import org.mula.finance.activities.*;

/**
 * Activity that allows the user to see more information about a single habit.
 * <p>
 * Shows all the metadata for the habit, in addition to several charts.
 */
public class ShowHabitActivity extends HabitsActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setScreen(getComponent().getShowHabitScreen());
    }
}
