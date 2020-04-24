/* Mula */

package org.mula.finance.core.models;

import org.apache.commons.lang3.builder.*;
import org.mula.finance.core.utils.StringUtils;

import java.util.*;

public final class WeekdayList
{
    public static final WeekdayList EVERY_DAY = new WeekdayList(127);

    private final boolean[] weekdays;

    public WeekdayList(int packedList)
    {
        weekdays = new boolean[7];

        int current = 1;
        for (int i = 0; i < 7; i++)
        {
            if ((packedList & current) != 0) weekdays[i] = true;
            current = current << 1;
        }
    }

    public WeekdayList(boolean weekdays[])
    {
        this.weekdays = Arrays.copyOf(weekdays, 7);
    }

    public boolean isEmpty()
    {
        for (boolean d : weekdays) if (d) return false;
        return true;
    }

    public boolean[] toArray()
    {
        return Arrays.copyOf(weekdays, 7);
    }

    public int toInteger()
    {
        int packedList = 0;
        int current = 1;

        for (int i = 0; i < 7; i++)
        {
            if (weekdays[i]) packedList |= current;
            current = current << 1;
        }

        return packedList;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        WeekdayList that = (WeekdayList) o;

        return new EqualsBuilder().append(weekdays, that.weekdays).isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37).append(weekdays).toHashCode();
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, StringUtils.defaultToStringStyle())
            .append("weekdays", weekdays)
            .toString();
    }
}
