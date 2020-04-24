/* Mula */

package org.mula.finance.utils;

import android.content.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.*;

import org.jetbrains.annotations.*;

public class AttributeSetUtils
{
    public static final String ISORON_NAMESPACE = "http://isoron.org/android";

    @Nullable
    public static String getAttribute(@NonNull Context context,
                                      @NonNull AttributeSet attrs,
                                      @NonNull String name,
                                      @Nullable String defaultValue)
    {
        int resId = attrs.getAttributeResourceValue(ISORON_NAMESPACE, name, 0);
        if (resId != 0) return context.getResources().getString(resId);

        String value = attrs.getAttributeValue(ISORON_NAMESPACE, name);
        if (value != null) return value;
        else return defaultValue;
    }

    public static boolean getBooleanAttribute(@NonNull Context context,
                                              @NonNull AttributeSet attrs,
                                              @NonNull String name,
                                              boolean defaultValue)
    {
        String boolText = getAttribute(context, attrs, name, null);
        if (boolText != null) return Boolean.parseBoolean(boolText);
        else return defaultValue;
    }

    @Contract("_,_,_,!null -> !null")
    public static Integer getColorAttribute(@NonNull Context context,
                                            @NonNull AttributeSet attrs,
                                            @NonNull String name,
                                            @Nullable Integer defaultValue)
    {
        int resId = attrs.getAttributeResourceValue(ISORON_NAMESPACE, name, 0);
        if (resId != 0) return context.getResources().getColor(resId);
        else return defaultValue;
    }

    public static float getFloatAttribute(@NonNull Context context,
                                          @NonNull AttributeSet attrs,
                                          @NonNull String name,
                                          float defaultValue)
    {
        String number = getAttribute(context, attrs, name, null);
        if (number != null) return Float.parseFloat(number);
        else return defaultValue;
    }

    public static int getIntAttribute(@NonNull Context context,
                                      @NonNull AttributeSet attrs,
                                      @NonNull String name,
                                      int defaultValue)
    {
        String number = getAttribute(context, attrs, name, null);
        if (number != null) return Integer.parseInt(number);
        else return defaultValue;
    }
}
