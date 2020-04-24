/* Mula */

package org.mula.finance.activities.habits.show.views;

import android.content.*;
import android.util.*;
import android.widget.*;

import org.mula.finance.R;
import org.mula.finance.activities.common.views.*;
import org.mula.finance.utils.*;
import org.mula.finance.core.models.Streak;
import org.mula.finance.core.models.StreakList;
import org.mula.finance.core.tasks.CancelableTask;
import org.mula.finance.core.tasks.Task;

import java.util.*;

import butterknife.*;

public class StreakCard extends HabitCard
{
    public static final int NUM_STREAKS = 10;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.streakChart)
    StreakChart streakChart;

    public StreakCard(Context context)
    {
        super(context);
        init();
    }

    public StreakCard(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    private void init()
    {
        inflate(getContext(), R.layout.show_habit_streak, this);
        ButterKnife.bind(this);
        setOrientation(VERTICAL);
        if (isInEditMode()) initEditMode();
    }

    private void initEditMode()
    {
        int color = PaletteUtils.getAndroidTestColor(1);
        title.setTextColor(color);
        streakChart.setColor(color);
        streakChart.populateWithRandomData();
    }

    @Override
    protected Task createRefreshTask()
    {
        return new RefreshTask();
    }

    private class RefreshTask extends CancelableTask
    {
        List<Streak> bestStreaks;

        @Override
        public void doInBackground()
        {
            if (isCanceled()) return;
            StreakList streaks = getHabit().getStreaks();
            bestStreaks = streaks.getBest(NUM_STREAKS);
        }

        @Override
        public void onPostExecute()
        {
            if (isCanceled()) return;
            streakChart.setStreaks(bestStreaks);
        }

        @Override
        public void onPreExecute()
        {
            int color =
                PaletteUtils.getColor(getContext(), getHabit().getColor());
            title.setTextColor(color);
            streakChart.setColor(color);
        }
    }
}
