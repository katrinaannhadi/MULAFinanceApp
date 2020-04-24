package org.mula.finance.core.ui.screens.habits.list;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.models.HabitList;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ListHabitsSelectionMenuBehavior_Factory implements Factory<ListHabitsSelectionMenuBehavior> {
  private final Provider<HabitList> habitListProvider;

  private final Provider<ListHabitsSelectionMenuBehavior.Screen> screenProvider;

  private final Provider<ListHabitsSelectionMenuBehavior.Adapter> adapterProvider;

  private final Provider<CommandRunner> commandRunnerProvider;

  public ListHabitsSelectionMenuBehavior_Factory(Provider<HabitList> habitListProvider,
      Provider<ListHabitsSelectionMenuBehavior.Screen> screenProvider,
      Provider<ListHabitsSelectionMenuBehavior.Adapter> adapterProvider,
      Provider<CommandRunner> commandRunnerProvider) {
    this.habitListProvider = habitListProvider;
    this.screenProvider = screenProvider;
    this.adapterProvider = adapterProvider;
    this.commandRunnerProvider = commandRunnerProvider;
  }

  @Override
  public ListHabitsSelectionMenuBehavior get() {
    return newInstance(habitListProvider.get(), screenProvider.get(), adapterProvider.get(), commandRunnerProvider.get());
  }

  public static ListHabitsSelectionMenuBehavior_Factory create(
      Provider<HabitList> habitListProvider,
      Provider<ListHabitsSelectionMenuBehavior.Screen> screenProvider,
      Provider<ListHabitsSelectionMenuBehavior.Adapter> adapterProvider,
      Provider<CommandRunner> commandRunnerProvider) {
    return new ListHabitsSelectionMenuBehavior_Factory(habitListProvider, screenProvider, adapterProvider, commandRunnerProvider);
  }

  public static ListHabitsSelectionMenuBehavior newInstance(HabitList habitList,
      ListHabitsSelectionMenuBehavior.Screen screen,
      ListHabitsSelectionMenuBehavior.Adapter adapter, CommandRunner commandRunner) {
    return new ListHabitsSelectionMenuBehavior(habitList, screen, adapter, commandRunner);
  }
}
