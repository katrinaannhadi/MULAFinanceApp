/* Mula */

package org.mula.finance.activities.habits.show.views;

import android.annotation.*;
import android.content.*;
import android.content.res.*;
import android.util.*;
import android.widget.*;

import org.mula.finance.R;
import org.mula.finance.utils.*;
import org.mula.finance.core.models.Frequency;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.Reminder;
import org.mula.finance.core.tasks.Task;

import butterknife.*;

public class SubtitleCard extends HabitCard
{
    @BindView(R.id.questionLabel)
    TextView questionLabel;

    @BindView(R.id.frequencyLabel)
    TextView frequencyLabel;

    @BindView(R.id.reminderLabel)
    TextView reminderLabel;

    public SubtitleCard(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    @Override
    protected void refreshData()
    {
        Habit habit = getHabit();
        int color = PaletteUtils.getColor(getContext(), habit.getColor());

        reminderLabel.setText(getResources().getString(R.string.reminder_off));
        questionLabel.setVisibility(VISIBLE);

        questionLabel.setTextColor(color);
        questionLabel.setText(habit.getQuestion());
        frequencyLabel.setText(toText(habit.getFrequency()));

        if (habit.hasReminder()) updateReminderText(habit.getReminder());

        if (habit.getQuestion().isEmpty()) questionLabel.setVisibility(GONE);

        invalidate();
    }

    private void init()
    {
        inflate(getContext(), R.layout.show_habit_subtitle, this);
        ButterKnife.bind(this);

        if (isInEditMode()) initEditMode();
    }

    @SuppressLint("SetTextI18n")
    private void initEditMode()
    {
        questionLabel.setTextColor(PaletteUtils.getAndroidTestColor(1));
        questionLabel.setText("Have you meditated today?");
        reminderLabel.setText("08:00");
    }

    private String toText(Frequency freq)
    {
        Resources resources = getResources();
        Integer num = freq.getNumerator();
        Integer den = freq.getDenominator();

        if (num.equals(den)) return resources.getString(R.string.every_day);

        if (num == 1)
        {
            if (den == 7) return resources.getString(R.string.every_week);
            if (den % 7 == 0)
                return resources.getString(R.string.every_x_weeks, den / 7);
            return resources.getString(R.string.every_x_days, den);
        }

        String times_every = resources.getString(R.string.times_every);
        return String.format("%d %s %d %s", num, times_every, den,
            resources.getString(R.string.days));
    }

    private void updateReminderText(Reminder reminder)
    {
        reminderLabel.setText(
            AndroidDateUtils.formatTime(getContext(), reminder.getHour(),
                reminder.getMinute()));
    }

    @Override
    protected Task createRefreshTask() {
        // Never called
        throw new IllegalStateException();
    }
}
