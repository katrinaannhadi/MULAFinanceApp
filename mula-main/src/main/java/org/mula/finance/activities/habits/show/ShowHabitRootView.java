/* Mula */

package org.mula.finance.activities.habits.show;

import android.content.*;
import android.os.*;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.*;

import org.mula.finance.R;
import org.mula.finance.activities.habits.show.views.*;
import org.mula.finance.utils.*;
import org.mula.androidbase.activities.ActivityContext;
import org.mula.androidbase.activities.ActivityScope;
import org.mula.androidbase.activities.BaseRootView;
import org.mula.androidbase.utils.StyledResources;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.ModelObservable;

import javax.inject.*;

import butterknife.*;

@ActivityScope
public class ShowHabitRootView extends BaseRootView
    implements ModelObservable.Listener
{
    @NonNull
    private Habit habit;

    @BindView(R.id.frequencyCard)
    FrequencyCard frequencyCard;

    @BindView(R.id.streakCard)
    StreakCard streakCard;

    @BindView(R.id.subtitleCard)
    SubtitleCard subtitleCard;

    @BindView(R.id.notesCard)
    NotesCard notesCard;

    @BindView(R.id.habitNotes)
    TextView habitNotes;

    @BindView(R.id.overviewCard)
    OverviewCard overviewCard;

    @BindView(R.id.scoreCard)
    ScoreCard scoreCard;

    @BindView(R.id.historyCard)
    HistoryCard historyCard;

    @BindView(R.id.barCard)
    BarCard barCard;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @NonNull
    private Controller controller;

    @Inject
    public ShowHabitRootView(@NonNull @ActivityContext Context context,
                             @NonNull Habit habit)
    {
        super(context);
        this.habit = habit;

        addView(inflate(getContext(), R.layout.show_habit, null));
        ButterKnife.bind(this);

        controller = new Controller() {};
        setDisplayHomeAsUp(true);
        initCards();
        initToolbar();
    }

    @Override
    public int getToolbarColor()
    {
        StyledResources res = new StyledResources(getContext());
        if (!res.getBoolean(R.attr.useGoalColorAsPrimary))
            return super.getToolbarColor();

        return PaletteUtils.getColor(getContext(), habit.getColor());
    }

    @Override
    public void onModelChange()
    {
        new Handler(Looper.getMainLooper()).post(() -> {
            toolbar.setTitle(habit.getName());
        });

        controller.onToolbarChanged();
    }

    public void setController(@NonNull Controller controller)
    {
        this.controller = controller;
        historyCard.setController(controller);
    }

    @Override
    protected void initToolbar()
    {
        super.initToolbar();
        toolbar.setTitle(habit.getName());
    }

    @Override
    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        habit.getObservable().addListener(this);
    }

    @Override
    protected void onDetachedFromWindow()
    {
        habit.getObservable().removeListener(this);
        super.onDetachedFromWindow();
    }

    private void initCards()
    {
        subtitleCard.setHabit(habit);
        notesCard.setHabit(habit);
        overviewCard.setHabit(habit);
        scoreCard.setHabit(habit);
        historyCard.setHabit(habit);
        streakCard.setHabit(habit);
        frequencyCard.setHabit(habit);
        barCard.setHabit(habit);
    }

    public interface Controller extends HistoryCard.Controller
    {
        default void onToolbarChanged() {}
    }
}
