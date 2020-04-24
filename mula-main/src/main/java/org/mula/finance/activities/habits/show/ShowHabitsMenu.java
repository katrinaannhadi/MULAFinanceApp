/* Mula */

package org.mula.finance.activities.habits.show;

import android.view.*;

import androidx.annotation.NonNull;

import org.mula.finance.*;
import org.mula.finance.core.preferences.Preferences;
import org.mula.androidbase.activities.ActivityScope;
import org.mula.androidbase.activities.BaseActivity;
import org.mula.androidbase.activities.BaseMenu;
import org.mula.finance.core.ui.screens.habits.show.ShowHabitMenuBehavior;

import javax.inject.*;

import dagger.*;

@ActivityScope
public class ShowHabitsMenu extends BaseMenu
{
    @NonNull
    private Lazy<ShowHabitMenuBehavior> behavior;
    @NonNull
    private final Preferences prefs;

    @Inject
    public ShowHabitsMenu(@NonNull BaseActivity activity,
                          @NonNull Lazy<ShowHabitMenuBehavior> behavior,
                          @NonNull Preferences prefs)
    {
        super(activity);
        this.behavior = behavior;
        this.prefs = prefs;
    }

    @Override
    public void onCreate(@NonNull Menu menu)
    {
        super.onCreate(menu);

        if (prefs.isDeveloper())
            menu.findItem(R.id.action_randomize).setVisible(true);
    }

    @Override
    public boolean onItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_edit_habit:
                behavior.get().onEditHabit();
                return true;

            case R.id.export:
                behavior.get().onExportCSV();
                return true;

            case R.id.action_delete:
                behavior.get().onDeleteHabit();
                return true;

            case R.id.action_randomize:
                behavior.get().onRandomize();
                return true;

            default:
                return false;
        }
    }

    @Override
    protected int getMenuResourceId()
    {
        return R.menu.show_habit;
    }
}
