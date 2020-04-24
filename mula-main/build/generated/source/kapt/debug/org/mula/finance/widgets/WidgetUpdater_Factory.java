package org.mula.finance.widgets;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.preferences.WidgetPreferences;
import org.mula.finance.core.tasks.TaskRunner;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class WidgetUpdater_Factory implements Factory<WidgetUpdater> {
  private final Provider<Context> contextProvider;

  private final Provider<CommandRunner> commandRunnerProvider;

  private final Provider<TaskRunner> taskRunnerProvider;

  private final Provider<WidgetPreferences> widgetPrefsProvider;

  public WidgetUpdater_Factory(Provider<Context> contextProvider,
      Provider<CommandRunner> commandRunnerProvider, Provider<TaskRunner> taskRunnerProvider,
      Provider<WidgetPreferences> widgetPrefsProvider) {
    this.contextProvider = contextProvider;
    this.commandRunnerProvider = commandRunnerProvider;
    this.taskRunnerProvider = taskRunnerProvider;
    this.widgetPrefsProvider = widgetPrefsProvider;
  }

  @Override
  public WidgetUpdater get() {
    return newInstance(contextProvider.get(), commandRunnerProvider.get(), taskRunnerProvider.get(), widgetPrefsProvider.get());
  }

  public static WidgetUpdater_Factory create(Provider<Context> contextProvider,
      Provider<CommandRunner> commandRunnerProvider, Provider<TaskRunner> taskRunnerProvider,
      Provider<WidgetPreferences> widgetPrefsProvider) {
    return new WidgetUpdater_Factory(contextProvider, commandRunnerProvider, taskRunnerProvider, widgetPrefsProvider);
  }

  public static WidgetUpdater newInstance(Context context, CommandRunner commandRunner,
      TaskRunner taskRunner, WidgetPreferences widgetPrefs) {
    return new WidgetUpdater(context, commandRunner, taskRunner, widgetPrefs);
  }
}
