package org.mula.finance.core.commands;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.ModelFactory;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CommandParser_Factory implements Factory<CommandParser> {
  private final Provider<HabitList> habitListProvider;

  private final Provider<ModelFactory> modelFactoryProvider;

  public CommandParser_Factory(Provider<HabitList> habitListProvider,
      Provider<ModelFactory> modelFactoryProvider) {
    this.habitListProvider = habitListProvider;
    this.modelFactoryProvider = modelFactoryProvider;
  }

  @Override
  public CommandParser get() {
    return newInstance(habitListProvider.get(), modelFactoryProvider.get());
  }

  public static CommandParser_Factory create(Provider<HabitList> habitListProvider,
      Provider<ModelFactory> modelFactoryProvider) {
    return new CommandParser_Factory(habitListProvider, modelFactoryProvider);
  }

  public static CommandParser newInstance(HabitList habitList, ModelFactory modelFactory) {
    return new CommandParser(habitList, modelFactory);
  }
}
