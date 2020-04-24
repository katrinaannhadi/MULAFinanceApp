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
import org.mula.finance.core.models.Checkmark;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.tasks.CancelableTask;
import org.mula.finance.core.tasks.Task;

import java.util.*;

import butterknife.*;

import static org.mula.finance.activities.habits.show.views.ScoreCard.getTruncateField;

public class BarCard extends HabitCard
{
    public static final int[] NUMERICAL_BUCKET_SIZES = {1, 7, 31, 92, 365};
    public static final int[] BOOLEAN_BUCKET_SIZES = {7, 31, 92, 365};

    @BindView(R.id.numericalSpinner)
    Spinner numericalSpinner;

    @BindView(R.id.boolSpinner)
    Spinner boolSpinner;

    @BindView(R.id.barChart)
    BarChart chart;

    @BindView(R.id.title)
    TextView title;

    private int bucketSize;

    @Nullable
    private Preferences prefs;

    public BarCard(Context context)
    {
        super(context);
        init();
    }

    public BarCard(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    @OnItemSelected(R.id.numericalSpinner)
    public void onNumericalItemSelected(int position)
    {
        bucketSize = NUMERICAL_BUCKET_SIZES[position];
        refreshData();
    }

    @OnItemSelected(R.id.boolSpinner)
    public void onBoolItemSelected(int position)
    {
        bucketSize = BOOLEAN_BUCKET_SIZES[position];
        refreshData();
    }

    private void init()
    {
        Context appContext = getContext().getApplicationContext();
        if (appContext instanceof HabitsApplication)
        {
            HabitsApplication app = (HabitsApplication) appContext;
            prefs = app.getComponent().getPreferences();
        }
        inflate(getContext(), R.layout.show_habit_bar, this);
        ButterKnife.bind(this);
        boolSpinner.setSelection(1);
        numericalSpinner.setSelection(2);
        bucketSize = 7;
        if (isInEditMode()) initEditMode();
    }

    private void initEditMode()
    {
        int color = PaletteUtils.getAndroidTestColor(1);
        title.setTextColor(color);
        chart.setColor(color);
        chart.populateWithRandomData();
    }

    @Override
    protected Task createRefreshTask()
    {
        return new RefreshTask(getHabit());
    }

    private class RefreshTask extends CancelableTask
    {
        private final Habit habit;

        RefreshTask(Habit habit)
        {
            this.habit = habit;
        }

        @Override
        public void doInBackground()
        {
            if (isCanceled()) return;
            List<Checkmark> checkmarks;
            int firstWeekday = Calendar.SATURDAY;
            if (prefs != null) firstWeekday = prefs.getFirstWeekday();
            if (bucketSize == 1) checkmarks = habit.getCheckmarks().getAll();
            else checkmarks = habit.getCheckmarks().groupBy(getTruncateField(bucketSize),
                                                            firstWeekday);
            chart.setCheckmarks(checkmarks);
            chart.setBucketSize(bucketSize);
        }

        @Override
        public void onPreExecute()
        {
            int color = PaletteUtils.getColor(getContext(), habit.getColor());
            title.setTextColor(color);
            chart.setColor(color);
            if (habit.isNumerical())
            {
                boolSpinner.setVisibility(GONE);
                chart.setTarget(habit.getTargetValue() * bucketSize);
            }
            else
            {
                numericalSpinner.setVisibility(GONE);
                chart.setTarget(0);
            }
        }
    }
}
