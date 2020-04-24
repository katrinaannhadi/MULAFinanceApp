/* Mula */

package org.mula.androidbase.utils;

import android.content.*;
import android.content.res.*;
import android.graphics.drawable.*;

import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;

import org.mula.androidbase.*;

public class StyledResources
{
    private static Integer fixedTheme;

    private final Context context;

    public StyledResources(@NonNull Context context)
    {
        this.context = context;
    }

    public static void setFixedTheme(Integer theme)
    {
        fixedTheme = theme;
    }

    public boolean getBoolean(@AttrRes int attrId)
    {
        TypedArray ta = getTypedArray(attrId);
        boolean bool = ta.getBoolean(0, false);
        ta.recycle();

        return bool;
    }

    public int getDimension(@AttrRes int attrId)
    {
        TypedArray ta = getTypedArray(attrId);
        int dim = ta.getDimensionPixelSize(0, 0);
        ta.recycle();

        return dim;
    }

    public int getColor(@AttrRes int attrId)
    {
        TypedArray ta = getTypedArray(attrId);
        int color = ta.getColor(0, 0);
        ta.recycle();

        return color;
    }

    public Drawable getDrawable(@AttrRes int attrId)
    {
        TypedArray ta = getTypedArray(attrId);
        Drawable drawable = ta.getDrawable(0);
        ta.recycle();

        return drawable;
    }

    public float getFloat(@AttrRes int attrId)
    {
        TypedArray ta = getTypedArray(attrId);
        float f = ta.getFloat(0, 0);
        ta.recycle();

        return f;
    }

    public int[] getPalette()
    {
        int resourceId = getResource(R.attr.palette);
        if (resourceId < 0) throw new RuntimeException("resource not found");

        return context.getResources().getIntArray(resourceId);
    }

    public int getResource(@AttrRes int attrId)
    {
        TypedArray ta = getTypedArray(attrId);
        int resourceId = ta.getResourceId(0, -1);
        ta.recycle();

        return resourceId;
    }

    private TypedArray getTypedArray(@AttrRes int attrId)
    {
        int[] attrs = new int[]{ attrId };

        if (fixedTheme != null)
            return context.getTheme().obtainStyledAttributes(fixedTheme, attrs);

        return context.obtainStyledAttributes(attrs);
    }
}