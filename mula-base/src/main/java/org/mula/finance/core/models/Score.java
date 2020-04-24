/* Mula */

package org.mula.finance.core.models;

import org.apache.commons.lang3.builder.*;
import org.mula.finance.core.utils.StringUtils;

import static java.lang.Math.*;

/**
 * Represents how strong a habit is at a certain date.
 */
public final class Score
{
    /**
     * Timestamp of the day to which this score applies. Time of day should be
     * midnight (UTC).
     */
    private final Timestamp timestamp;

    /**
     * Value of the score.
     */
    private final double value;

    public Score(Timestamp timestamp, double value)
    {
        this.timestamp = timestamp;
        this.value = value;
    }

    /**
     * Given the frequency of the habit, the previous score, and the value of
     * the current checkmark, computes the current score for the habit.
     * <p>
     * The frequency of the habit is the number of repetitions divided by the
     * length of the interval. For example, a habit that should be repeated 3
     * times in 8 days has frequency 3.0 / 8.0 = 0.375.
     *
     * @param frequency      the frequency of the habit
     * @param previousScore  the previous score of the habit
     * @param checkmarkValue the value of the current checkmark
     * @return the current score
     */
    public static double compute(double frequency,
                                 double previousScore,
                                 double checkmarkValue)
    {
        double multiplier = pow(0.5, frequency / 13.0);

        double score = previousScore * multiplier;
        score += checkmarkValue * (1 - multiplier);

        return score;
    }

    public int compareNewer(Score other)
    {
        return getTimestamp().compare(other.getTimestamp());
    }

    public Timestamp getTimestamp()
    {
        return timestamp;
    }

    public double getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, StringUtils.defaultToStringStyle())
            .append("timestamp", timestamp)
            .append("value", value)
            .toString();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Score score = (Score) o;

        return new EqualsBuilder()
            .append(value, score.value)
            .append(timestamp, score.timestamp)
            .isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37)
            .append(timestamp)
            .append(value)
            .toHashCode();
    }
}
