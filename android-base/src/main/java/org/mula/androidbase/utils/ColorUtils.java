/* Mula */

package org.mula.androidbase.utils;

import android.graphics.*;

public abstract class ColorUtils
{
    public static int mixColors(int color1, int color2, float amount)
    {
        final byte ALPHA_CHANNEL = 24;
        final byte RED_CHANNEL = 16;
        final byte GREEN_CHANNEL = 8;
        final byte BLUE_CHANNEL = 0;

        final float inverseAmount = 1.0f - amount;

        int a = ((int) (((float) (color1 >> ALPHA_CHANNEL & 0xff) * amount) +
                        ((float) (color2 >> ALPHA_CHANNEL & 0xff) *
                         inverseAmount))) & 0xff;
        int r = ((int) (((float) (color1 >> RED_CHANNEL & 0xff) * amount) +
                        ((float) (color2 >> RED_CHANNEL & 0xff) *
                         inverseAmount))) & 0xff;
        int g = ((int) (((float) (color1 >> GREEN_CHANNEL & 0xff) * amount) +
                        ((float) (color2 >> GREEN_CHANNEL & 0xff) *
                         inverseAmount))) & 0xff;
        int b = ((int) (((float) (color1 & 0xff) * amount) +
                        ((float) (color2 & 0xff) * inverseAmount))) & 0xff;

        return a << ALPHA_CHANNEL | r << RED_CHANNEL | g << GREEN_CHANNEL |
               b << BLUE_CHANNEL;
    }

    public static int setAlpha(int color, float newAlpha)
    {
        int intAlpha = (int) (newAlpha * 255);
        return Color.argb(intAlpha, Color.red(color), Color.green(color),
            Color.blue(color));
    }

    public static int setMinValue(int color, float newValue)
    {
        float hsv[] = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] = Math.max(hsv[2], newValue);
        return Color.HSVToColor(hsv);
    }

}