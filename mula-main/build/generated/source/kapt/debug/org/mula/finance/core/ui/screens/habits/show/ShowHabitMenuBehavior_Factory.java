package org.mula.finance.core.ui.screens.habits.show;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.tasks.TaskRunner;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ShowHabitMenuBehavior_Factory implements Factory<ShowHabitMenuBehavior> {
  private final Provider<HabitList> habitListProvider;

  private final Provider<Habit> habitProvider;

  private final Provider<TaskRunner> taskRunnerProvider;

  private final Provider<ShowHabitMenuBehavior.Screen> screenProvider;

  private final Provider<ShowHabitMenuBehavior.System> systemProvider;

  private final Provider<CommandRunner> commandRunnerProvider;

  public ShowHabitMenuBehavior_Factory(Provider<HabitList> habitListProvider,
      Provider<Habit> habitProvider, Provider<TaskRunner> taskRunnerProvider,
      Provider<ShowHabitMenuBehavior.Screen> screenProvider,
      Provider<ShowHabitMenuBehavior.System> systemProvider,
      Provider<CommandRunner> commandRunnerProvider) {
    this.habitListProvider = habitListProvider;
    this.habitProvider = habitProvider;
    this.taskRunnerProvider = taskRunnerProvider;
    this.screenProvider = screenProvider;
    this.systemProvider = systemProvider;
    this.commandRunnerProvider = commandRunnerProvider;
  }

  @Override
  public ShowHabitMenuBehavior get() {
    return newInstance(habitListProvider.get(), habitProvider.get(), taskRunnerProvider.get(), screenProvider.get(), systemProvider.get(), commandRunnerProvider.get());
  }

  public static ShowHabitMenuBehavior_Factory create(Provider<HabitList> habitListProvider,
      Provider<Habit> habitProvider, Provider<TaskRunner> taskRunnerProvider,
      Provider<ShowHabitMenuBehavior.Screen> screenProvider,
      Provider<ShowHabitMenuBehavior.System> systemProvider,
      Provider<CommandRunner> commandRunnerProvider) {
    return new ShowHabitMenuBehavior_Factory(habitListProvider, habitProvider, taskRunnerProvider, screenProvider, systemProvider, commandRunnerProvider);
  }

  public static ShowHabitMenuBehavior newInstance(HabitList habitList, Habit habit,
      TaskRunner taskRunner, ShowHabitMenuBehavior.Screen screen,
      ShowHabitMenuBehavior.System system, CommandRunner commandRunner) {
    return new ShowHabitMenuBehavior(habitList, habit, taskRunner, screen, system, commandRunner);
  }
}
