package org.mula.finance.intents;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.models.HabitList;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class IntentParser_Factory implements Factory<IntentParser> {
  private final Provider<HabitList> habitsProvider;

  public IntentParser_Factory(Provider<HabitList> habitsProvider) {
    this.habitsProvider = habitsProvider;
  }

  @Override
  public IntentParser get() {
    return newInstance(habitsProvider.get());
  }

  public static IntentParser_Factory create(Provider<HabitList> habitsProvider) {
    return new IntentParser_Factory(habitsProvider);
  }

  public static IntentParser newInstance(HabitList habits) {
    return new IntentParser(habits);
  }
}
