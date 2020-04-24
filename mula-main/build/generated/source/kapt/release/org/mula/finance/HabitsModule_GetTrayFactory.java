package org.mula.finance;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.tasks.TaskRunner;
import org.mula.finance.core.ui.NotificationTray;
import org.mula.finance.notifications.AndroidNotificationTray;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HabitsModule_GetTrayFactory implements Factory<NotificationTray> {
  private final HabitsModule module;

  private final Provider<TaskRunner> taskRunnerProvider;

  private final Provider<CommandRunner> commandRunnerProvider;

  private final Provider<Preferences> preferencesProvider;

  private final Provider<AndroidNotificationTray> screenProvider;

  public HabitsModule_GetTrayFactory(HabitsModule module, Provider<TaskRunner> taskRunnerProvider,
      Provider<CommandRunner> commandRunnerProvider, Provider<Preferences> preferencesProvider,
      Provider<AndroidNotificationTray> screenProvider) {
    this.module = module;
    this.taskRunnerProvider = taskRunnerProvider;
    this.commandRunnerProvider = commandRunnerProvider;
    this.preferencesProvider = preferencesProvider;
    this.screenProvider = screenProvider;
  }

  @Override
  public NotificationTray get() {
    return getTray(module, taskRunnerProvider.get(), commandRunnerProvider.get(), preferencesProvider.get(), screenProvider.get());
  }

  public static HabitsModule_GetTrayFactory create(HabitsModule module,
      Provider<TaskRunner> taskRunnerProvider, Provider<CommandRunner> commandRunnerProvider,
      Provider<Preferences> preferencesProvider, Provider<AndroidNotificationTray> screenProvider) {
    return new HabitsModule_GetTrayFactory(module, taskRunnerProvider, commandRunnerProvider, preferencesProvider, screenProvider);
  }

  public static NotificationTray getTray(HabitsModule instance, TaskRunner taskRunner,
      CommandRunner commandRunner, Preferences preferences, AndroidNotificationTray screen) {
    return Preconditions.checkNotNull(instance.getTray(taskRunner, commandRunner, preferences, screen), "Cannot return null from a non-@Nullable @Provides method");
  }
}
