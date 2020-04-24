package org.mula.finance.activities.habits.list;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.androidbase.activities.BaseActivity;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.ui.ThemeSwitcher;
import org.mula.finance.core.ui.screens.habits.list.ListHabitsMenuBehavior;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ListHabitsMenu_Factory implements Factory<ListHabitsMenu> {
  private final Provider<BaseActivity> activityProvider;

  private final Provider<Preferences> preferencesProvider;

  private final Provider<ThemeSwitcher> themeSwitcherProvider;

  private final Provider<ListHabitsMenuBehavior> behaviorProvider;

  public ListHabitsMenu_Factory(Provider<BaseActivity> activityProvider,
      Provider<Preferences> preferencesProvider, Provider<ThemeSwitcher> themeSwitcherProvider,
      Provider<ListHabitsMenuBehavior> behaviorProvider) {
    this.activityProvider = activityProvider;
    this.preferencesProvider = preferencesProvider;
    this.themeSwitcherProvider = themeSwitcherProvider;
    this.behaviorProvider = behaviorProvider;
  }

  @Override
  public ListHabitsMenu get() {
    return newInstance(activityProvider.get(), preferencesProvider.get(), themeSwitcherProvider.get(), behaviorProvider.get());
  }

  public static ListHabitsMenu_Factory create(Provider<BaseActivity> activityProvider,
      Provider<Preferences> preferencesProvider, Provider<ThemeSwitcher> themeSwitcherProvider,
      Provider<ListHabitsMenuBehavior> behaviorProvider) {
    return new ListHabitsMenu_Factory(activityProvider, preferencesProvider, themeSwitcherProvider, behaviorProvider);
  }

  public static ListHabitsMenu newInstance(BaseActivity activity, Preferences preferences,
      ThemeSwitcher themeSwitcher, ListHabitsMenuBehavior behavior) {
    return new ListHabitsMenu(activity, preferences, themeSwitcher, behavior);
  }
}
