package org.mula.finance.core.ui.screens.habits.list;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.ui.ThemeSwitcher;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ListHabitsMenuBehavior_Factory implements Factory<ListHabitsMenuBehavior> {
  private final Provider<ListHabitsMenuBehavior.Screen> screenProvider;

  private final Provider<ListHabitsMenuBehavior.Adapter> adapterProvider;

  private final Provider<Preferences> preferencesProvider;

  private final Provider<ThemeSwitcher> themeSwitcherProvider;

  public ListHabitsMenuBehavior_Factory(Provider<ListHabitsMenuBehavior.Screen> screenProvider,
      Provider<ListHabitsMenuBehavior.Adapter> adapterProvider,
      Provider<Preferences> preferencesProvider, Provider<ThemeSwitcher> themeSwitcherProvider) {
    this.screenProvider = screenProvider;
    this.adapterProvider = adapterProvider;
    this.preferencesProvider = preferencesProvider;
    this.themeSwitcherProvider = themeSwitcherProvider;
  }

  @Override
  public ListHabitsMenuBehavior get() {
    return newInstance(screenProvider.get(), adapterProvider.get(), preferencesProvider.get(), themeSwitcherProvider.get());
  }

  public static ListHabitsMenuBehavior_Factory create(
      Provider<ListHabitsMenuBehavior.Screen> screenProvider,
      Provider<ListHabitsMenuBehavior.Adapter> adapterProvider,
      Provider<Preferences> preferencesProvider, Provider<ThemeSwitcher> themeSwitcherProvider) {
    return new ListHabitsMenuBehavior_Factory(screenProvider, adapterProvider, preferencesProvider, themeSwitcherProvider);
  }

  public static ListHabitsMenuBehavior newInstance(ListHabitsMenuBehavior.Screen screen,
      ListHabitsMenuBehavior.Adapter adapter, Preferences preferences,
      ThemeSwitcher themeSwitcher) {
    return new ListHabitsMenuBehavior(screen, adapter, preferences, themeSwitcher);
  }
}
