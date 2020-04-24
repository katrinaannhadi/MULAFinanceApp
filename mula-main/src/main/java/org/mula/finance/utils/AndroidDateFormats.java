/* Mula */
package org.mula.finance.utils;

import androidx.annotation.NonNull;

import org.mula.finance.core.utils.DateFormats;

import java.text.*;
import java.util.*;

import static android.text.format.DateFormat.getBestDateTimePattern;

public class AndroidDateFormats
{
    @NonNull
    public static SimpleDateFormat fromSkeleton(@NonNull String skeleton)
    {
        Locale locale = Locale.getDefault();
        skeleton = getBestDateTimePattern(locale, skeleton);
        return DateFormats.fromSkeleton(skeleton, locale);
    }
}
