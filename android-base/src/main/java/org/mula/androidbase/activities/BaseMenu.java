/* Mula */

package org.mula.androidbase.activities;

import android.view.*;

import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;

/**
 * Base class for all the menus in the application.
 * <p>
 * This class receives from BaseActivity all callbacks related to menus, such as
 * menu creation and click events. It also handles some implementation details
 * of creating menus in Android, such as inflating the resources.
 */
public abstract class BaseMenu
{
    @NonNull
    private final BaseActivity activity;

    public BaseMenu(@NonNull BaseActivity activity)
    {
        this.activity = activity;
    }

    @NonNull
    public BaseActivity getActivity()
    {
        return activity;
    }

    /**
     * Declare that the menu has changed, and should be recreated.
     */
    public void invalidate()
    {
        activity.invalidateOptionsMenu();
    }

    /**
     * Called when the menu is first displayed.
     * <p>
     * The given menu is already inflated and ready to receive items. The
     * application should override this method and add items to the menu here.
     *
     * @param menu the menu that is being created.
     */
    public void onCreate(@NonNull Menu menu)
    {
    }

    /**
     * Called when the menu is first displayed.
     * <p>
     * This method should not be overridden. The application should override
     * the methods onCreate(Menu) and getMenuResourceId instead.
     *
     * @param inflater a menu inflater, for creating the menu
     * @param menu     the menu that is being created.
     */
    public void onCreate(@NonNull MenuInflater inflater, @NonNull Menu menu)
    {
        menu.clear();
        inflater.inflate(getMenuResourceId(), menu);
        onCreate(menu);
    }

    /**
     * Called whenever an item on the menu is selected.
     *
     * @param item the item that was selected.
     * @return true if the event was consumed, or false otherwise
     */
    public boolean onItemSelected(@NonNull MenuItem item)
    {
        return false;
    }

    /**
     * Returns the id of the resource that should be used to inflate this menu.
     *
     * @return id of the menu resource.
     */
    @MenuRes
    protected abstract int getMenuResourceId();
}
