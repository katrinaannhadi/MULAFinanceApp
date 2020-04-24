package org.mula.finance.activities.habits.show;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.androidbase.activities.BaseActivity;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.ui.screens.habits.show.ShowHabitMenuBehavior;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ShowHabitsMenu_Factory implements Factory<ShowHabitsMenu> {
  private final Provider<BaseActivity> activityProvider;

  private final Provider<ShowHabitMenuBehavior> behaviorProvider;

  private final Provider<Preferences> prefsProvider;

  public ShowHabitsMenu_Factory(Provider<BaseActivity> activityProvider,
      Provider<ShowHabitMenuBehavior> behaviorProvider, Provider<Preferences> prefsProvider) {
    this.activityProvider = activityProvider;
    this.behaviorProvider = behaviorProvider;
    this.prefsProvider = prefsProvider;
  }

  @Override
  public ShowHabitsMenu get() {
    return newInstance(activityProvider.get(), DoubleCheck.lazy(behaviorProvider), prefsProvider.get());
  }

  public static ShowHabitsMenu_Factory create(Provider<BaseActivity> activityProvider,
      Provider<ShowHabitMenuBehavior> behaviorProvider, Provider<Preferences> prefsProvider) {
    return new ShowHabitsMenu_Factory(activityProvider, behaviorProvider, prefsProvider);
  }

  public static ShowHabitsMenu newInstance(BaseActivity activity,
      Lazy<ShowHabitMenuBehavior> behavior, Preferences prefs) {
    return new ShowHabitsMenu(activity, behavior, prefs);
  }
}
