/* Mula */

package org.mula.finance.widgets.views;

import android.content.*;
import android.util.*;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.mula.finance.*;
import org.mula.finance.activities.common.views.*;
import org.mula.finance.utils.*;
import org.mula.androidbase.utils.StyledResources;
import org.mula.finance.core.models.Checkmark;

import static org.mula.androidbase.utils.InterfaceUtils.getDimension;

public class CheckmarkWidgetView extends HabitWidgetView
{
    private int activeColor;

    private float percentage;

    @Nullable
    private String name;

    private RingView ring;

    private TextView label;

    private int checkmarkValue;

    public CheckmarkWidgetView(Context context)
    {
        super(context);
        init();
    }

    public CheckmarkWidgetView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public void refresh()
    {
        if (backgroundPaint == null || frame == null || ring == null) return;

        StyledResources res = new StyledResources(getContext());

        String text;
        int bgColor;
        int fgColor;

        switch (checkmarkValue)
        {
            case Checkmark.CHECKED_EXPLICITLY:
                text = getResources().getString(R.string.fa_check);
                bgColor = activeColor;
                fgColor = res.getColor(R.attr.highContrastReverseTextColor);
                setShadowAlpha(0x4f);
                backgroundPaint.setColor(bgColor);
                frame.setBackgroundDrawable(background);
                break;

            case Checkmark.CHECKED_IMPLICITLY:
                text = getResources().getString(R.string.fa_check);
                bgColor = res.getColor(R.attr.cardBgColor);
                fgColor = res.getColor(R.attr.mediumContrastTextColor);
                setShadowAlpha(0x00);
                break;

            case Checkmark.UNCHECKED:
            default:
                text = getResources().getString(R.string.fa_times);
                bgColor = res.getColor(R.attr.cardBgColor);
                fgColor = res.getColor(R.attr.mediumContrastTextColor);
                setShadowAlpha(0x00);
                break;
        }

        ring.setPercentage(percentage);
        ring.setColor(fgColor);
        ring.setBackgroundColor(bgColor);
        ring.setText(text);

        label.setText(name);
        label.setTextColor(fgColor);

        requestLayout();
        postInvalidate();
    }

    public void setActiveColor(int activeColor)
    {
        this.activeColor = activeColor;
    }

    public void setCheckmarkValue(int checkmarkValue)
    {
        this.checkmarkValue = checkmarkValue;
    }

    public void setName(@NonNull String name)
    {
        this.name = name;
    }

    public void setPercentage(float percentage)
    {
        this.percentage = percentage;
    }

    @Override
    @NonNull
    protected Integer getInnerLayoutId()
    {
        return R.layout.widget_checkmark;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        float w = width;
        float h = width * 1.25f;
        float scale = Math.min(width / w, height / h);

        w *= scale;
        h *= scale;

        if (h < getDimension(getContext(), R.dimen.checkmarkWidget_heightBreakpoint))
            ring.setVisibility(GONE);
        else
            ring.setVisibility(VISIBLE);

        widthMeasureSpec =
            MeasureSpec.makeMeasureSpec((int) w, MeasureSpec.EXACTLY);
        heightMeasureSpec =
            MeasureSpec.makeMeasureSpec((int) h, MeasureSpec.EXACTLY);

        float textSize = 0.15f * h;
        float maxTextSize = getDimension(getContext(), R.dimen.smallerTextSize);
        textSize = Math.min(textSize, maxTextSize);

        label.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        ring.setTextSize(textSize);
        ring.setThickness(0.15f * textSize);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void init()
    {
        ring = (RingView) findViewById(R.id.scoreRing);
        label = (TextView) findViewById(R.id.label);

        if (ring != null) ring.setIsTransparencyEnabled(true);

        if (isInEditMode())
        {
            percentage = 0.75f;
            name = "Wake up early";
            activeColor = PaletteUtils.getAndroidTestColor(6);
            checkmarkValue = Checkmark.CHECKED_EXPLICITLY;
            refresh();
        }
    }
}
