/* Mula */

package org.mula.finance.core.models;

import org.apache.commons.lang3.builder.*;
import org.mula.finance.core.utils.StringUtils;

/**
 * Represents a record that the user has performed a certain habit at a certain
 * date.
 */
public final class Repetition
{

    private final Timestamp timestamp;

    /**
     * The value of the repetition.
     *
     * For boolean habits, this always equals Checkmark.CHECKED_EXPLICITLY.
     * For numerical habits, this number is stored in thousandths. That
     * is, if the user enters value 1.50 on the app, it is here stored as 1500.
     */
    private final int value;

    /**
     * Creates a new repetition with given parameters.
     * <p>
     * The timestamp corresponds to the days this repetition occurred. Time of
     * day must be midnight (UTC).
     *
     * @param timestamp the time this repetition occurred.
     */
    public Repetition(Timestamp timestamp, int value)
    {
        this.timestamp = timestamp;
        this.value = value;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Repetition that = (Repetition) o;

        return new EqualsBuilder()
                .append(timestamp, that.timestamp)
                .append(value, that.value)
                .isEquals();
    }

    public Timestamp getTimestamp()
    {
        return timestamp;
    }

    public int getValue()
    {
        return value;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37)
                .append(timestamp)
                .append(value)
                .toHashCode();
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, StringUtils.defaultToStringStyle())
                .append("timestamp", timestamp)
                .append("value", value)
                .toString();
    }
}
