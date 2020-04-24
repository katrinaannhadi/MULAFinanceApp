/* Mula */

package org.mula.androidbase.activities;

import android.content.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import android.view.*;
import android.widget.*;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.mula.androidbase.R;
import org.mula.androidbase.utils.InterfaceUtils;
import org.mula.androidbase.utils.StyledResources;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.LOLLIPOP;

/**
 * Base class for all root views in the application.
 * <p>
 * A root view is an Android view that is directly attached to an activity. This
 * view usually includes a toolbar and a progress bar. This abstract class hides
 * some of the complexity of setting these things up, for every version of
 * Android.
 */
public abstract class BaseRootView extends FrameLayout
{
    @NonNull
    private final Context context;

    protected boolean shouldDisplayHomeAsUp = false;

    @Nullable
    private BaseScreen screen;

    public BaseRootView(@NonNull Context context)
    {
        super(context);
        this.context = context;
    }

    public boolean getDisplayHomeAsUp()
    {
        return shouldDisplayHomeAsUp;
    }

    public void setDisplayHomeAsUp(boolean b)
    {
        shouldDisplayHomeAsUp = b;
    }

    @NonNull
    public Toolbar getToolbar()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar == null) throw new RuntimeException(
            "Your BaseRootView should have a " +
            "toolbar with id R.id.toolbar");
        return toolbar;
    }

    public int getToolbarColor()
    {
        StyledResources res = new StyledResources(context);
        return res.getColor(R.attr.colorPrimaryDark);
    }

    protected void initToolbar()
    {
        if (SDK_INT >= LOLLIPOP)
        {
            getToolbar().setElevation(InterfaceUtils.dpToPixels(context, 2));

            View view = findViewById(R.id.toolbarShadow);
            if (view != null) view.setVisibility(GONE);

            view = findViewById(R.id.headerShadow);
            if (view != null) view.setVisibility(GONE);
        }
    }

    @NonNull
    public BottomNavigationView getBottomNav()
    {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);
        if (bottomNavigationView == null) throw new RuntimeException(
                "Your BaseRootView should have a " +
                        "toolbar with id R.id.toolbar");
        return bottomNavigationView;
    }

    public int getBottomNavColor()
    {
        StyledResources res = new StyledResources(context);
        return res.getColor(R.attr.colorPrimary);
    }

    public void onAttachedToScreen(BaseScreen screen)
    {
        this.screen = screen;
    }

    @Nullable
    public BaseScreen getScreen()
    {
        return screen;
    }
}
