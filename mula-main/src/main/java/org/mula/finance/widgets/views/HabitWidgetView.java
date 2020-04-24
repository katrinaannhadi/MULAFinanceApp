/* Mula */

package org.mula.finance.widgets.views;

import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.graphics.drawable.shapes.*;
import android.util.*;
import android.view.*;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.mula.androidbase.utils.*;
import org.mula.finance.*;

import java.util.*;

import static org.mula.androidbase.utils.InterfaceUtils.*;
public abstract class HabitWidgetView extends FrameLayout
{
    @Nullable
    protected InsetDrawable background;

    @Nullable
    protected Paint backgroundPaint;

    protected ViewGroup frame;

    private int shadowAlpha;

    private StyledResources res;

    private int backgroundAlpha;

    public HabitWidgetView(Context context)
    {
        super(context);
        init();
    }

    public HabitWidgetView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public void setShadowAlpha(int shadowAlpha)
    {
        this.shadowAlpha = shadowAlpha;
        rebuildBackground();
    }

    public void setBackgroundAlpha(int backgroundAlpha)
    {
        this.backgroundAlpha = backgroundAlpha;
        rebuildBackground();
    }

    protected abstract
    @NonNull
    Integer getInnerLayoutId();

    public void rebuildBackground()
    {
        Context context = getContext();

        int shadowRadius = (int) dpToPixels(context, 2);
        int shadowOffset = (int) dpToPixels(context, 1);
        int shadowColor = Color.argb(shadowAlpha, 0, 0, 0);

        float cornerRadius = dpToPixels(context, 5);
        float[] radii = new float[8];
        Arrays.fill(radii, cornerRadius);

        RoundRectShape shape = new RoundRectShape(radii, null, null);
        ShapeDrawable innerDrawable = new ShapeDrawable(shape);

        int insetLeftTop = Math.max(shadowRadius - shadowOffset, 0);
        int insetRightBottom = shadowRadius + shadowOffset;

        background =
            new InsetDrawable(innerDrawable, insetLeftTop, insetLeftTop,
                insetRightBottom, insetRightBottom);
        backgroundPaint = innerDrawable.getPaint();
        backgroundPaint.setShadowLayer(shadowRadius, shadowOffset, shadowOffset,
            shadowColor);
        backgroundPaint.setColor(res.getColor(R.attr.cardBgColor));
        backgroundPaint.setAlpha(backgroundAlpha);

        frame = (ViewGroup) findViewById(R.id.frame);
        if (frame != null) frame.setBackgroundDrawable(background);
    }

    private void init()
    {
        inflate(getContext(), getInnerLayoutId(), this);
        res = new StyledResources(getContext());
        shadowAlpha = (int) (255 * res.getFloat(R.attr.widgetShadowAlpha));
        rebuildBackground();
    }
}
