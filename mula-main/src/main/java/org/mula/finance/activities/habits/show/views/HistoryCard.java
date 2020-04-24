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
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.tasks.CancelableTask;
import org.mula.finance.core.tasks.Task;

import butterknife.*;

public class HistoryCard extends HabitCard
{
    @BindView(R.id.historyChart)
    HistoryChart chart;

    @BindView(R.id.title)
    TextView title;

    @Nullable
    private Controller controller;

    @Nullable
    private Preferences prefs;

    public HistoryCard(Context context)
    {
        super(context);
        init();
    }

    public HistoryCard(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    @OnClick(R.id.edit)
    public void onClickEditButton()
    {
        if(controller != null) controller.onEditHistoryButtonClick();
    }

    public void setController(@Nullable Controller controller)
    {
        this.controller = controller;
    }

    private void init()
    {
        Context appContext = getContext().getApplicationContext();
        if (appContext instanceof HabitsApplication)
        {
            HabitsApplication app = (HabitsApplication) appContext;
            prefs = app.getComponent().getPreferences();
        }

        inflate(getContext(), R.layout.show_habit_history, this);
        ButterKnife.bind(this);
        controller = new Controller() {};
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

    public interface Controller
    {
        default void onEditHistoryButtonClick() {}
    }

    private class RefreshTask  extends CancelableTask
    {
        private final Habit habit;

        private RefreshTask(Habit habit)
        {
            this.habit = habit;
        }

        @Override
        public void doInBackground()
        {
            if (isCanceled()) return;
            int[] checkmarks = habit.getCheckmarks().getAllValues();
            if(prefs != null) chart.setFirstWeekday(prefs.getFirstWeekday());
            chart.setCheckmarks(checkmarks);
        }

        @Override
        public void onPreExecute()
        {
            int color = PaletteUtils.getColor(getContext(), habit.getColor());
            title.setTextColor(color);
            chart.setColor(color);
            if(habit.isNumerical())
            {
                chart.setTarget((int) (habit.getTargetValue() * 1000));
                chart.setNumerical(true);
            }
        }
    }
}
