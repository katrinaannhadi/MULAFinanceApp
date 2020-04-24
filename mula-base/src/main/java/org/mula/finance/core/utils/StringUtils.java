/* Mula */

package org.mula.finance.core.utils;

import org.apache.commons.lang3.builder.*;

import java.math.*;
import java.util.*;

public class StringUtils
{
    private static StandardToStringStyle toStringStyle = null;

    public static String getRandomId()
    {
        return new BigInteger(260, new Random()).toString(32).substring(0, 32);
    }

    public static ToStringStyle defaultToStringStyle()
    {
        if (toStringStyle == null)
        {
            toStringStyle = new StandardToStringStyle();
            toStringStyle.setFieldSeparator(", ");
            toStringStyle.setUseClassName(false);
            toStringStyle.setUseIdentityHashCode(false);
            toStringStyle.setContentStart("{");
            toStringStyle.setContentEnd("}");
            toStringStyle.setFieldNameValueSeparator(": ");
            toStringStyle.setArrayStart("[");
            toStringStyle.setArrayEnd("]");
        }

        return toStringStyle;
    }

    public static String joinLongs(long values[])
    {
        return org.apache.commons.lang3.StringUtils.join(values, ',');
    }

    public static long[] splitLongs(String str)
    {
        String parts[] = org.apache.commons.lang3.StringUtils.split(str, ',');

        long numbers[] = new long[parts.length];
        for (int i = 0; i < parts.length; i++) numbers[i] = Long.valueOf(parts[i]);
        return numbers;
    }
}
