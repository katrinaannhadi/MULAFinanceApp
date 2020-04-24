package org.mula.finance.core.ui.widgets;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.ui.NotificationTray;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class WidgetBehavior_Factory implements Factory<WidgetBehavior> {
  private final Provider<HabitList> habitListProvider;

  private final Provider<CommandRunner> commandRunnerProvider;

  private final Provider<NotificationTray> notificationTrayProvider;

  public WidgetBehavior_Factory(Provider<HabitList> habitListProvider,
      Provider<CommandRunner> commandRunnerProvider,
      Provider<NotificationTray> notificationTrayProvider) {
    this.habitListProvider = habitListProvider;
    this.commandRunnerProvider = commandRunnerProvider;
    this.notificationTrayProvider = notificationTrayProvider;
  }

  @Override
  public WidgetBehavior get() {
    return newInstance(habitListProvider.get(), commandRunnerProvider.get(), notificationTrayProvider.get());
  }

  public static WidgetBehavior_Factory create(Provider<HabitList> habitListProvider,
      Provider<CommandRunner> commandRunnerProvider,
      Provider<NotificationTray> notificationTrayProvider) {
    return new WidgetBehavior_Factory(habitListProvider, commandRunnerProvider, notificationTrayProvider);
  }

  public static WidgetBehavior newInstance(HabitList habitList, CommandRunner commandRunner,
      NotificationTray notificationTray) {
    return new WidgetBehavior(habitList, commandRunner, notificationTray);
  }
}
