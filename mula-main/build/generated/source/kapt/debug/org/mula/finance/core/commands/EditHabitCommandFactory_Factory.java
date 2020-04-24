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
public final class EditHabitCommandFactory_Factory implements Factory<EditHabitCommandFactory> {
  private final Provider<ModelFactory> modelFactoryProvider;

  public EditHabitCommandFactory_Factory(Provider<ModelFactory> modelFactoryProvider) {
    this.modelFactoryProvider = modelFactoryProvider;
  }

  @Override
  public EditHabitCommandFactory get() {
    return newInstance(modelFactoryProvider);
  }

  public static EditHabitCommandFactory_Factory create(
      Provider<ModelFactory> modelFactoryProvider) {
    return new EditHabitCommandFactory_Factory(modelFactoryProvider);
  }

  public static EditHabitCommandFactory newInstance(Provider<ModelFactory> modelFactoryProvider) {
    return new EditHabitCommandFactory(modelFactoryProvider);
  }
}
