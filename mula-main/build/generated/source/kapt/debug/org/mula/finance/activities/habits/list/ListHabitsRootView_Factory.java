package org.mula.finance.activities.habits.list;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.activities.habits.list.views.HabitCardListAdapter;
import org.mula.finance.activities.habits.list.views.HabitCardListViewFactory;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.tasks.TaskRunner;
import org.mula.finance.core.ui.screens.habits.list.HintListFactory;
import org.mula.finance.core.utils.MidnightTimer;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ListHabitsRootView_Factory implements Factory<ListHabitsRootView> {
  private final Provider<Context> contextProvider;

  private final Provider<HintListFactory> hintListFactoryProvider;

  private final Provider<Preferences> preferencesProvider;

  private final Provider<MidnightTimer> midnightTimerProvider;

  private final Provider<TaskRunner> runnerProvider;

  private final Provider<HabitCardListAdapter> listAdapterProvider;

  private final Provider<HabitCardListViewFactory> habitCardListViewFactoryProvider;

  public ListHabitsRootView_Factory(Provider<Context> contextProvider,
      Provider<HintListFactory> hintListFactoryProvider, Provider<Preferences> preferencesProvider,
      Provider<MidnightTimer> midnightTimerProvider, Provider<TaskRunner> runnerProvider,
      Provider<HabitCardListAdapter> listAdapterProvider,
      Provider<HabitCardListViewFactory> habitCardListViewFactoryProvider) {
    this.contextProvider = contextProvider;
    this.hintListFactoryProvider = hintListFactoryProvider;
    this.preferencesProvider = preferencesProvider;
    this.midnightTimerProvider = midnightTimerProvider;
    this.runnerProvider = runnerProvider;
    this.listAdapterProvider = listAdapterProvider;
    this.habitCardListViewFactoryProvider = habitCardListViewFactoryProvider;
  }

  @Override
  public ListHabitsRootView get() {
    return newInstance(contextProvider.get(), hintListFactoryProvider.get(), preferencesProvider.get(), midnightTimerProvider.get(), runnerProvider.get(), listAdapterProvider.get(), habitCardListViewFactoryProvider.get());
  }

  public static ListHabitsRootView_Factory create(Provider<Context> contextProvider,
      Provider<HintListFactory> hintListFactoryProvider, Provider<Preferences> preferencesProvider,
      Provider<MidnightTimer> midnightTimerProvider, Provider<TaskRunner> runnerProvider,
      Provider<HabitCardListAdapter> listAdapterProvider,
      Provider<HabitCardListViewFactory> habitCardListViewFactoryProvider) {
    return new ListHabitsRootView_Factory(contextProvider, hintListFactoryProvider, preferencesProvider, midnightTimerProvider, runnerProvider, listAdapterProvider, habitCardListViewFactoryProvider);
  }

  public static ListHabitsRootView newInstance(Context context, HintListFactory hintListFactory,
      Preferences preferences, MidnightTimer midnightTimer, TaskRunner runner,
      HabitCardListAdapter listAdapter, HabitCardListViewFactory habitCardListViewFactory) {
    return new ListHabitsRootView(context, hintListFactory, preferences, midnightTimer, runner, listAdapter, habitCardListViewFactory);
  }
}
