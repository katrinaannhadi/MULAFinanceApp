/* Mula */

package org.mula.finance.core.models;

import org.apache.commons.lang3.builder.*;
import org.mula.finance.core.utils.StringUtils;

public final class Streak
{
    private final Timestamp start;

    private final Timestamp end;

    public Streak(Timestamp start, Timestamp end)
    {
        this.start = start;
        this.end = end;
    }

    public int compareLonger(Streak other)
    {
        if (this.getLength() != other.getLength())
            return Long.signum(this.getLength() - other.getLength());

        return compareNewer(other);
    }

    public int compareNewer(Streak other)
    {
        return end.compare(other.end);
    }

    public Timestamp getEnd()
    {
        return end;
    }

    public int getLength()
    {
        return start.daysUntil(end) + 1;
    }

    public Timestamp getStart()
    {
        return start;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, StringUtils.defaultToStringStyle())
            .append("start", start)
            .append("end", end)
            .toString();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Streak streak = (Streak) o;

        return new EqualsBuilder()
            .append(start, streak.start)
            .append(end, streak.end)
            .isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37)
            .append(start)
            .append(end)
            .toHashCode();
    }
}
