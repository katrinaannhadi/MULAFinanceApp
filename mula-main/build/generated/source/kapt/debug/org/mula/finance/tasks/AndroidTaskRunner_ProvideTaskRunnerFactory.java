package org.mula.finance.tasks;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import org.mula.finance.core.tasks.TaskRunner;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AndroidTaskRunner_ProvideTaskRunnerFactory implements Factory<TaskRunner> {
  @Override
  public TaskRunner get() {
    return provideTaskRunner();
  }

  public static AndroidTaskRunner_ProvideTaskRunnerFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static TaskRunner provideTaskRunner() {
    return Preconditions.checkNotNull(AndroidTaskRunner.provideTaskRunner(), "Cannot return null from a non-@Nullable @Provides method");
  }

  private static final class InstanceHolder {
    private static final AndroidTaskRunner_ProvideTaskRunnerFactory INSTANCE = new AndroidTaskRunner_ProvideTaskRunnerFactory();
  }
}
