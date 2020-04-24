package org.mula.finance.activities.habits.list.views;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.ui.screens.habits.list.HabitCardListCache;
import org.mula.finance.core.utils.MidnightTimer;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HabitCardListAdapter_Factory implements Factory<HabitCardListAdapter> {
  private final Provider<HabitCardListCache> cacheProvider;

  private final Provider<Preferences> preferencesProvider;

  private final Provider<MidnightTimer> midnightTimerProvider;

  public HabitCardListAdapter_Factory(Provider<HabitCardListCache> cacheProvider,
      Provider<Preferences> preferencesProvider, Provider<MidnightTimer> midnightTimerProvider) {
    this.cacheProvider = cacheProvider;
    this.preferencesProvider = preferencesProvider;
    this.midnightTimerProvider = midnightTimerProvider;
  }

  @Override
  public HabitCardListAdapter get() {
    return newInstance(cacheProvider.get(), preferencesProvider.get(), midnightTimerProvider.get());
  }

  public static HabitCardListAdapter_Factory create(Provider<HabitCardListCache> cacheProvider,
      Provider<Preferences> preferencesProvider, Provider<MidnightTimer> midnightTimerProvider) {
    return new HabitCardListAdapter_Factory(cacheProvider, preferencesProvider, midnightTimerProvider);
  }

  public static HabitCardListAdapter newInstance(HabitCardListCache cache, Preferences preferences,
      MidnightTimer midnightTimer) {
    return new HabitCardListAdapter(cache, preferences, midnightTimer);
  }
}
