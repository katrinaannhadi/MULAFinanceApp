/* Mula */

package org.mula.finance.core.models;

import org.apache.commons.lang3.builder.*;
import org.mula.finance.core.utils.StringUtils;

import javax.annotation.concurrent.*;

/**
 * Represents how often is the habit repeated.
 */
@ThreadSafe
public class Frequency
{
    public static final Frequency DAILY = new Frequency(1, 1);

    public static final Frequency FIVE_TIMES_PER_WEEK = new Frequency(5, 7);

    public static final Frequency THREE_TIMES_PER_WEEK = new Frequency(3, 7);

    public static final Frequency TWO_TIMES_PER_WEEK = new Frequency(2, 7);

    public static final Frequency WEEKLY = new Frequency(1, 7);

    private final int numerator;

    private final int denominator;

    public Frequency(int numerator, int denominator)
    {
        if (numerator == denominator) numerator = denominator = 1;

        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Frequency frequency = (Frequency) o;

        return new EqualsBuilder()
            .append(numerator, frequency.numerator)
            .append(denominator, frequency.denominator)
            .isEquals();
    }

    public int getDenominator()
    {
        return denominator;
    }

    public int getNumerator()
    {
        return numerator;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37)
            .append(numerator)
            .append(denominator)
            .toHashCode();
    }

    public double toDouble()
    {
        return (double) numerator / denominator;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, StringUtils.defaultToStringStyle())
            .append("numerator", numerator)
            .append("denominator", denominator)
            .toString();
    }
}
