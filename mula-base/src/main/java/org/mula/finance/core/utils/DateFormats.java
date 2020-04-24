/* Mula */

package org.mula.finance.core.utils;

import androidx.annotation.*;

import java.text.*;
import java.util.*;

public class DateFormats
{
    @NonNull
    public static SimpleDateFormat fromSkeleton(@NonNull String skeleton,
                                                @NonNull Locale locale)
    {
        SimpleDateFormat df = new SimpleDateFormat(skeleton, locale);
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        return df;
    }

    public static SimpleDateFormat getBackupDateFormat()
    {
        return fromSkeleton("yyyy-MM-dd HHmmss", Locale.US);
    }

    public static SimpleDateFormat getCSVDateFormat()
    {
        return fromSkeleton("yyyy-MM-dd", Locale.US);
    }
}
