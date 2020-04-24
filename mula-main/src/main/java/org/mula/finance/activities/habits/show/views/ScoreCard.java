/* Mula */

package org.mula.finance.activities.habits.show.views;

import android.content.*;
import android.util.*;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.mula.finance.*;
import org.mula.finance.R;
import org.mula.finance.activities.common.views.*;
import org.mula.finance.utils.*;
import org.mula.finance.core.models.Score;
import org.mula.finance.core.models.ScoreList;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.tasks.CancelableTask;
import org.mula.finance.core.tasks.Task;
import org.mula.finance.core.utils.DateUtils;

import java.util.*;

import butterknife.*;

public class ScoreCard extends HabitCard
{
    public static final int[] BUCKET_SIZES = { 1, 7, 31, 92, 365 };

    @BindView(R.id.spinner)
    Spinner spinner;

    @BindView(R.id.scoreView)
    ScoreChart chart;

    @BindView(R.id.title)
    TextView title;

    private int bucketSize;

    @Nullable
    private Preferences prefs;

    public ScoreCard(Context context)
    {
        super(context);
        init();
    }

    public ScoreCard(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    @NonNull
    public static DateUtils.TruncateField getTruncateField(int bucketSize)
    {
        if (bucketSize == 7) return DateUtils.TruncateField.WEEK_NUMBER;
        if (bucketSize == 31) return DateUtils.TruncateField.MONTH;
        if (bucketSize == 92) return DateUtils.TruncateField.QUARTER;
        if (bucketSize == 365) return DateUtils.TruncateField.YEAR;

        Log.e("ScoreCard",
            String.format("Unknown bucket size: %d", bucketSize));

        return DateUtils.TruncateField.MONTH;
    }

    @OnItemSelected(R.id.spinner)
    public void onItemSelected(int position)
    {
        setBucketSizeFromPosition(position);
        HabitsApplication app =
            (HabitsApplication) getContext().getApplicationContext();
        app.getComponent().getWidgetUpdater().updateWidgets();
        refreshData();
    }

    private int getDefaultSpinnerPosition()
    {
        if(prefs == null) return 0;
        return prefs.getDefaultScoreSpinnerPosition();
    }

    private void init()
    {
        Context appContext = getContext().getApplicationContext();
        if (appContext instanceof HabitsApplication)
        {
            HabitsApplication app = (HabitsApplication) appContext;
            prefs = app.getComponent().getPreferences();
        }

        inflate(getContext(), R.layout.show_habit_score, this);
        ButterKnife.bind(this);

        int defaultPosition = getDefaultSpinnerPosition();
        setBucketSizeFromPosition(defaultPosition);
        spinner.setSelection(defaultPosition);

        if (isInEditMode())
        {
            spinner.setVisibility(GONE);
            title.setTextColor(PaletteUtils.getAndroidTestColor(1));
            chart.setColor(PaletteUtils.getAndroidTestColor(1));
            chart.populateWithRandomData();
        }
    }

    private void setBucketSizeFromPosition(int position)
    {
        if(prefs == null) return;
        prefs.setDefaultScoreSpinnerPosition(position);
        bucketSize = BUCKET_SIZES[position];
    }

    @Override
    protected Task createRefreshTask()
    {
        return new RefreshTask();
    }

    private class RefreshTask  extends CancelableTask
    {
        @Override
        public void doInBackground()
        {
            if (isCanceled()) return;
            List<Score> scores;
            ScoreList scoreList = getHabit().getScores();
            int firstWeekday = Calendar.SATURDAY;
            if (prefs != null) firstWeekday = prefs.getFirstWeekday();
            Log.d("ScoreCard", "firstWeekday="+firstWeekday);

            if (bucketSize == 1) scores = scoreList.toList();
            else scores = scoreList.groupBy(getTruncateField(bucketSize), firstWeekday);

            chart.setScores(scores);
            chart.setBucketSize(bucketSize);
        }

        @Override
        public void onPreExecute()
        {
            int color =
                PaletteUtils.getColor(getContext(), getHabit().getColor());
            title.setTextColor(color);
            chart.setColor(color);
        }
    }
}
