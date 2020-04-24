/* Mula */

package org.mula.androidbase.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ActionMode;
import android.view.*;

/**
 * Base class for all the selection menus in the application.
 * <p>
 * A selection menu is a menu that appears when the screen starts a selection
 * operation. It contains actions that modify the selected items, such as delete
 * or archive. Since it replaces the toolbar, it also has a title.
 * <p>
 * This class hides many implementation details of creating such menus in
 * Android. The interface is supposed to look very similar to {@link BaseMenu},
 * with a few additional methods, such as finishing the selection operation.
 * Internally, it uses an {@link ActionMode}.
 */
public abstract class BaseSelectionMenu
{
    @Nullable
    private ActionMode actionMode;

    /**
     * Finishes the selection operation.
     */
    public void finish()
    {
        if (actionMode != null) actionMode.finish();
    }

    /**
     * Declare that the menu has changed, and should be recreated.
     */
    public void invalidate()
    {
        if (actionMode != null) actionMode.invalidate();
    }

    /**
     * Called when the menu is first displayed.
     * <p>
     * This method should not be overridden. The application should override
     * the methods onCreate(Menu) and getMenuResourceId instead.
     *
     * @param inflater a menu inflater, for creating the menu
     * @param mode     the action mode associated with this menu.
     * @param menu     the menu that is being created.
     */
    public void onCreate(@NonNull MenuInflater inflater,
                         @NonNull ActionMode mode,
                         @NonNull Menu menu)
    {
        this.actionMode = mode;
        inflater.inflate(getResourceId(), menu);
        onCreate(menu);
    }

    /**
     * Called when the selection operation is about to finish.
     */
    public void onFinish()
    {

    }

    /**
     * Called whenever an item on the menu is selected.
     *
     * @param item the item that was selected.
     * @return true if the event was consumed, or false otherwise
     */
    public boolean onItemClicked(@NonNull MenuItem item)
    {
        return false;
    }


    /**
     * Called whenever the menu is invalidated.
     *
     * @param menu the menu to be refreshed
     * @return true if the menu has changes, false otherwise
     */
    public boolean onPrepare(@NonNull Menu menu)
    {
        return false;
    }

    /**
     * Sets the title of the selection menu.
     *
     * @param title the new title.
     */
    public void setTitle(String title)
    {
        if (actionMode != null) actionMode.setTitle(title);
    }

    protected abstract int getResourceId();

    /**
     * Called when the menu is first created.
     *
     * @param menu the menu being created
     */
    protected void onCreate(@NonNull Menu menu)
    {
    }
}
