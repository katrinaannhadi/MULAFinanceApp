/* Mula */

package org.mula.finance.activities.habits.show.views;

import android.content.*;
import android.util.*;
import android.widget.*;

import androidx.annotation.Nullable;

import org.mula.finance.*;
import org.mula.finance.R;
import org.mula.finance.activities.common.views.*;
import org.mula.finance.utils.*;
import org.mula.finance.core.models.RepetitionList;
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.tasks.CancelableTask;
import org.mula.finance.core.tasks.Task;

import java.util.*;

import butterknife.*;

public class FrequencyCard extends HabitCard
{
    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.frequencyChart)
    FrequencyChart chart;

    @Nullable
    private Preferences prefs;

    public FrequencyCard(Context context)
    {
        super(context);
        init();
    }

    public FrequencyCard(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    @Override
    protected Task createRefreshTask()
    {
        return new RefreshTask();
    }

    private void init()
    {
        Context appContext = getContext().getApplicationContext();
        if (appContext instanceof HabitsApplication)
        {
            HabitsApplication app = (HabitsApplication) appContext;
            prefs = app.getComponent().getPreferences();
        }
        inflate(getContext(), R.layout.show_habit_frequency, this);
        ButterKnife.bind(this);
        if (isInEditMode()) initEditMode();
    }

    private void initEditMode()
    {
        int color = PaletteUtils.getAndroidTestColor(1);
        title.setTextColor(color);
        chart.setColor(color);
        chart.populateWithRandomData();
    }

    private class RefreshTask  extends CancelableTask
    {
        @Override
        public void doInBackground()
        {
            if (isCanceled()) return;
            RepetitionList reps = getHabit().getRepetitions();
            HashMap<Timestamp, Integer[]> frequency = reps.getWeekdayFrequency();
            if(prefs != null) chart.setFirstWeekday(prefs.getFirstWeekday());
            chart.setFrequency(frequency);
        }

        @Override
        public void onPreExecute()
        {
            int paletteColor = getHabit().getColor();
            int color = PaletteUtils.getColor(getContext(), paletteColor);
            title.setTextColor(color);
            chart.setColor(color);
        }
    }
}
