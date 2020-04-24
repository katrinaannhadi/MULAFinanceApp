package org.mula.finance.core.commands;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.tasks.TaskRunner;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CommandRunner_Factory implements Factory<CommandRunner> {
  private final Provider<TaskRunner> taskRunnerProvider;

  public CommandRunner_Factory(Provider<TaskRunner> taskRunnerProvider) {
    this.taskRunnerProvider = taskRunnerProvider;
  }

  @Override
  public CommandRunner get() {
    return newInstance(taskRunnerProvider.get());
  }

  public static CommandRunner_Factory create(Provider<TaskRunner> taskRunnerProvider) {
    return new CommandRunner_Factory(taskRunnerProvider);
  }

  public static CommandRunner newInstance(TaskRunner taskRunner) {
    return new CommandRunner(taskRunner);
  }
}
