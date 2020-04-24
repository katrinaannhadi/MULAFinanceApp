package org.mula.finance.core.commands;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.models.ModelFactory;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CreateHabitCommandFactory_Factory implements Factory<CreateHabitCommandFactory> {
  private final Provider<ModelFactory> modelFactoryProvider;

  public CreateHabitCommandFactory_Factory(Provider<ModelFactory> modelFactoryProvider) {
    this.modelFactoryProvider = modelFactoryProvider;
  }

  @Override
  public CreateHabitCommandFactory get() {
    return newInstance(modelFactoryProvider);
  }

  public static CreateHabitCommandFactory_Factory create(
      Provider<ModelFactory> modelFactoryProvider) {
    return new CreateHabitCommandFactory_Factory(modelFactoryProvider);
  }

  public static CreateHabitCommandFactory newInstance(Provider<ModelFactory> modelFactoryProvider) {
    return new CreateHabitCommandFactory(modelFactoryProvider);
  }
}
