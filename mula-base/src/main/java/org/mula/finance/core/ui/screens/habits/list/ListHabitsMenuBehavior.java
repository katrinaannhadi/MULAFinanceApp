/* Mula */

package org.mula.finance.core.ui.screens.habits.list;

import androidx.annotation.*;

import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.HabitMatcher;
import org.mula.finance.core.models.HabitMatcherBuilder;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.ui.ThemeSwitcher;

import javax.inject.*;

public class ListHabitsMenuBehavior
{
    @NonNull
    private final Screen screen;

    @NonNull
    private final Adapter adapter;

    @NonNull
    private final Preferences preferences;

    @NonNull
    private final ThemeSwitcher themeSwitcher;

    private boolean showCompleted;

    private boolean showArchived;

    @Inject
    public ListHabitsMenuBehavior(@NonNull Screen screen,
                                  @NonNull Adapter adapter,
                                  @NonNull Preferences preferences,
                                  @NonNull ThemeSwitcher themeSwitcher)
    {
        this.screen = screen;
        this.adapter = adapter;
        this.preferences = preferences;
        this.themeSwitcher = themeSwitcher;

        showCompleted = preferences.getShowCompleted();
        showArchived = preferences.getShowArchived();
        updateAdapterFilter();
    }

    public void onCreateBooleanHabit()
    {
        screen.showCreateBooleanHabitScreen();
    }

    public void onCreateNumericalHabit()
    {
        screen.showCreateNumericalHabitScreen();
    }


    public void onViewSettings()
    {
        screen.showSettingsScreen();
    }

    public void onToggleShowArchived()
    {
        showArchived = !showArchived;
        preferences.setShowArchived(showArchived);
        updateAdapterFilter();
    }

    public void onToggleShowCompleted()
    {
        showCompleted = !showCompleted;
        preferences.setShowCompleted(showCompleted);
        updateAdapterFilter();
    }

    public void onSortByColor()
    {
        adapter.setOrder(HabitList.Order.BY_COLOR);
    }

    public void onSortByManually()
    {
        adapter.setOrder(HabitList.Order.BY_POSITION);
    }

    public void onSortByScore()
    {
        adapter.setOrder(HabitList.Order.BY_SCORE);
    }

    public void onSortByName()
    {
        adapter.setOrder(HabitList.Order.BY_NAME);
    }


    private void updateAdapterFilter()
    {
        adapter.setFilter(new HabitMatcherBuilder()
            .setArchivedAllowed(showArchived)
            .setCompletedAllowed(showCompleted)
            .build());
        adapter.refresh();
    }

    public interface Adapter
    {
        void refresh();

        void setFilter(HabitMatcher build);

        void setOrder(HabitList.Order order);
    }

    public interface Screen
    {
        void applyTheme();

        void showCreateBooleanHabitScreen();

        void showCreateNumericalHabitScreen();

        void showSettingsScreen();
    }
}
