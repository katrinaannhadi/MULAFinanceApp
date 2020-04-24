/* Mula */

package org.mula.finance.utils;

import android.content.*;
import android.text.format.*;

import org.mula.finance.*;
import org.mula.finance.core.utils.DateUtils;

import java.util.*;

public class AndroidDateUtils
{
    public static String formatTime(Context context, int hours, int minutes)
    {
        int reminderMilliseconds = (hours * 60 + minutes) * 60 * 1000;

        Date date = new Date(reminderMilliseconds);
        java.text.DateFormat df = DateFormat.getTimeFormat(context);
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        return df.format(date);
    }

    public static String formatWeekdayList(Context context, boolean weekday[])
    {
        String shortDayNames[] = DateUtils.getShortWeekdayNames(Calendar.SATURDAY);
        String longDayNames[] = DateUtils.getLongWeekdayNames(Calendar.SATURDAY);
        StringBuilder buffer = new StringBuilder();

        int count = 0;
        int first = 0;
        boolean isFirst = true;
        for (int i = 0; i < 7; i++)
        {
            if (weekday[i])
            {
                if (isFirst) first = i;
                else buffer.append(", ");

                buffer.append(shortDayNames[i]);
                isFirst = false;
                count++;
            }
        }

        if (count == 1) return longDayNames[first];
        if (count == 2 && weekday[0] && weekday[1])
            return context.getString(R.string.weekends);
        if (count == 5 && !weekday[0] && !weekday[1])
            return context.getString(R.string.any_weekday);
        if (count == 7) return context.getString(R.string.any_day);
        return buffer.toString();
    }
}
