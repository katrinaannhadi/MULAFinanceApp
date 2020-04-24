package org.mula.finance.core.ui.screens.habits.show;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ShowHabitBehavior_Factory implements Factory<ShowHabitBehavior> {
  private final Provider<HabitList> habitListProvider;

  private final Provider<CommandRunner> commandRunnerProvider;

  private final Provider<Habit> habitProvider;

  private final Provider<ShowHabitBehavior.Screen> screenProvider;

  public ShowHabitBehavior_Factory(Provider<HabitList> habitListProvider,
      Provider<CommandRunner> commandRunnerProvider, Provider<Habit> habitProvider,
      Provider<ShowHabitBehavior.Screen> screenProvider) {
    this.habitListProvider = habitListProvider;
    this.commandRunnerProvider = commandRunnerProvider;
    this.habitProvider = habitProvider;
    this.screenProvider = screenProvider;
  }

  @Override
  public ShowHabitBehavior get() {
    return newInstance(habitListProvider.get(), commandRunnerProvider.get(), habitProvider.get(), screenProvider.get());
  }

  public static ShowHabitBehavior_Factory create(Provider<HabitList> habitListProvider,
      Provider<CommandRunner> commandRunnerProvider, Provider<Habit> habitProvider,
      Provider<ShowHabitBehavior.Screen> screenProvider) {
    return new ShowHabitBehavior_Factory(habitListProvider, commandRunnerProvider, habitProvider, screenProvider);
  }

  public static ShowHabitBehavior newInstance(HabitList habitList, CommandRunner commandRunner,
      Habit habit, ShowHabitBehavior.Screen screen) {
    return new ShowHabitBehavior(habitList, commandRunner, habit, screen);
  }
}
