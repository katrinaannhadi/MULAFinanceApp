/* Mula */

package org.mula.finance.core.models;

import androidx.annotation.*;

import org.apache.commons.lang3.builder.*;
import org.mula.finance.core.utils.DateUtils;
import org.mula.finance.core.utils.StringUtils;

public final class Reminder
{
    private final int hour;

    private final int minute;

    private final WeekdayList days;

    public Reminder(int hour, int minute, @NonNull WeekdayList days)
    {
        this.hour = hour;
        this.minute = minute;
        this.days = days;
    }

    @NonNull
    public WeekdayList getDays()
    {
        return days;
    }

    public int getHour()
    {
        return hour;
    }

    public int getMinute()
    {
        return minute;
    }

    public long getTimeInMillis()
    {
        return DateUtils.getUpcomingTimeInMillis(hour, minute);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Reminder reminder = (Reminder) o;

        return new EqualsBuilder()
                .append(hour, reminder.hour)
                .append(minute, reminder.minute)
                .append(days, reminder.days)
                .isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37)
                .append(hour)
                .append(minute)
                .append(days)
                .toHashCode();
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, StringUtils.defaultToStringStyle())
                .append("hour", hour)
                .append("minute", minute)
                .append("days", days)
                .toString();
    }
}
