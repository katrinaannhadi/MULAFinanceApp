/* Mula */

package org.mula.finance.activities.habits.edit.views;

import android.content.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.datetimepicker.time.*;

import org.mula.finance.R;
import org.mula.finance.activities.common.dialogs.*;
import org.mula.finance.activities.common.views.*;
import org.mula.finance.utils.*;
import org.mula.finance.core.models.Reminder;
import org.mula.finance.core.models.WeekdayList;

import butterknife.*;

public class ReminderPanel extends FrameLayout
    implements TimePickerDialog.OnTimeSetListener,
               WeekdayPickerDialog.OnWeekdaysPickedListener
{
    @BindView(R.id.tvReminderTime)
    TextView tvReminderTime;

    @BindView(R.id.llReminderDays)
    ViewGroup llReminderDays;

    @BindView(R.id.tvReminderDays)
    TextView tvReminderDays;

    @Nullable
    private Reminder reminder;

    @NonNull
    private Controller controller;

    public ReminderPanel(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);

        View view = inflate(context, R.layout.edit_habit_reminder, null);
        ButterKnife.bind(this, view);
        addView(view);

        controller = new Controller() {};
        setReminder(null);
    }

    @Nullable
    public Reminder getReminder()
    {
        return reminder;
    }

    public void setReminder(@Nullable Reminder reminder)
    {
        this.reminder = reminder;

        if (reminder == null)
        {
            tvReminderTime.setText(R.string.reminder_off);
            llReminderDays.setVisibility(View.GONE);
            return;
        }

        Context ctx = getContext();
        String time = AndroidDateUtils.formatTime(ctx, reminder.getHour(), reminder.getMinute());
        tvReminderTime.setText(time);
        llReminderDays.setVisibility(View.VISIBLE);

        boolean weekdays[] = reminder.getDays().toArray();
        tvReminderDays.setText(AndroidDateUtils.formatWeekdayList(ctx, weekdays));
    }

    @Override
    public void onTimeCleared(RadialPickerLayout view)
    {
        setReminder(null);
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hour, int minute)
    {
        WeekdayList days = WeekdayList.EVERY_DAY;
        if (reminder != null) days = reminder.getDays();
        setReminder(new Reminder(hour, minute, days));
    }

    @Override
    public void onWeekdaysSet(WeekdayList selectedDays)
    {
        if (reminder == null) return;
        if (selectedDays.isEmpty()) selectedDays = WeekdayList.EVERY_DAY;

        setReminder(new Reminder(reminder.getHour(), reminder.getMinute(),
            selectedDays));
    }

    public void setController(@NonNull Controller controller)
    {
        this.controller = controller;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state)
    {
        BundleSavedState bss = (BundleSavedState) state;
        if (!bss.bundle.isEmpty())
        {
            int days = bss.bundle.getInt("days");
            int hour = bss.bundle.getInt("hour");
            int minute = bss.bundle.getInt("minute");
            reminder = new Reminder(hour, minute, new WeekdayList(days));
            setReminder(reminder);
        }
        super.onRestoreInstanceState(bss.getSuperState());
    }

    @Override
    protected Parcelable onSaveInstanceState()
    {
        Parcelable superState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        if (reminder != null)
        {
            bundle.putInt("days", reminder.getDays().toInteger());
            bundle.putInt("hour", reminder.getHour());
            bundle.putInt("minute", reminder.getMinute());
        }
        return new BundleSavedState(superState, bundle);
    }

    @OnClick(R.id.tvReminderTime)
    void onDateSpinnerClick()
    {
        int hour = 8;
        int min = 0;

        if (reminder != null)
        {
            hour = reminder.getHour();
            min = reminder.getMinute();
        }

        controller.onTimeClicked(hour, min);
    }

    @OnClick(R.id.tvReminderDays)
    void onWeekdayClicked()
    {
        if (reminder == null) return;
        controller.onWeekdayClicked(reminder.getDays());
    }

    public interface Controller
    {
        /**
         * Called when the user has clicked the widget to change the time of
         * the reminder.
         *
         * @param currentHour hour previously picked by the user
         * @param currentMin  minute previously picked by the user
         */
        default void onTimeClicked(int currentHour, int currentMin) {}

        /**
         * Called when the used has clicked the widget to change the days
         * of the reminder.
         *
         * @param currentDays days previously selected by the user.
         */
        default void onWeekdayClicked(WeekdayList currentDays) {}
    }
}
