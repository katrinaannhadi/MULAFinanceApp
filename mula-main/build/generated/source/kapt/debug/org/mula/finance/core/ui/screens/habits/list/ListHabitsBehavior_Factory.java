package org.mula.finance.core.ui.screens.habits.list;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.tasks.TaskRunner;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ListHabitsBehavior_Factory implements Factory<ListHabitsBehavior> {
  private final Provider<HabitList> habitListProvider;

  private final Provider<ListHabitsBehavior.DirFinder> dirFinderProvider;

  private final Provider<TaskRunner> taskRunnerProvider;

  private final Provider<ListHabitsBehavior.Screen> screenProvider;

  private final Provider<CommandRunner> commandRunnerProvider;

  private final Provider<Preferences> prefsProvider;

  private final Provider<ListHabitsBehavior.BugReporter> bugReporterProvider;

  public ListHabitsBehavior_Factory(Provider<HabitList> habitListProvider,
      Provider<ListHabitsBehavior.DirFinder> dirFinderProvider,
      Provider<TaskRunner> taskRunnerProvider, Provider<ListHabitsBehavior.Screen> screenProvider,
      Provider<CommandRunner> commandRunnerProvider, Provider<Preferences> prefsProvider,
      Provider<ListHabitsBehavior.BugReporter> bugReporterProvider) {
    this.habitListProvider = habitListProvider;
    this.dirFinderProvider = dirFinderProvider;
    this.taskRunnerProvider = taskRunnerProvider;
    this.screenProvider = screenProvider;
    this.commandRunnerProvider = commandRunnerProvider;
    this.prefsProvider = prefsProvider;
    this.bugReporterProvider = bugReporterProvider;
  }

  @Override
  public ListHabitsBehavior get() {
    return newInstance(habitListProvider.get(), dirFinderProvider.get(), taskRunnerProvider.get(), screenProvider.get(), commandRunnerProvider.get(), prefsProvider.get(), bugReporterProvider.get());
  }

  public static ListHabitsBehavior_Factory create(Provider<HabitList> habitListProvider,
      Provider<ListHabitsBehavior.DirFinder> dirFinderProvider,
      Provider<TaskRunner> taskRunnerProvider, Provider<ListHabitsBehavior.Screen> screenProvider,
      Provider<CommandRunner> commandRunnerProvider, Provider<Preferences> prefsProvider,
      Provider<ListHabitsBehavior.BugReporter> bugReporterProvider) {
    return new ListHabitsBehavior_Factory(habitListProvider, dirFinderProvider, taskRunnerProvider, screenProvider, commandRunnerProvider, prefsProvider, bugReporterProvider);
  }

  public static ListHabitsBehavior newInstance(HabitList habitList,
      ListHabitsBehavior.DirFinder dirFinder, TaskRunner taskRunner,
      ListHabitsBehavior.Screen screen, CommandRunner commandRunner, Preferences prefs,
      ListHabitsBehavior.BugReporter bugReporter) {
    return new ListHabitsBehavior(habitList, dirFinder, taskRunner, screen, commandRunner, prefs, bugReporter);
  }
}
