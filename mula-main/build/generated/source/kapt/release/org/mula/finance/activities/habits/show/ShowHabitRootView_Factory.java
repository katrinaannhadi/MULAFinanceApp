package org.mula.finance.activities.habits.show;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.models.Habit;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ShowHabitRootView_Factory implements Factory<ShowHabitRootView> {
  private final Provider<Context> contextProvider;

  private final Provider<Habit> habitProvider;

  public ShowHabitRootView_Factory(Provider<Context> contextProvider,
      Provider<Habit> habitProvider) {
    this.contextProvider = contextProvider;
    this.habitProvider = habitProvider;
  }

  @Override
  public ShowHabitRootView get() {
    return newInstance(contextProvider.get(), habitProvider.get());
  }

  public static ShowHabitRootView_Factory create(Provider<Context> contextProvider,
      Provider<Habit> habitProvider) {
    return new ShowHabitRootView_Factory(contextProvider, habitProvider);
  }

  public static ShowHabitRootView newInstance(Context context, Habit habit) {
    return new ShowHabitRootView(context, habit);
  }
}
