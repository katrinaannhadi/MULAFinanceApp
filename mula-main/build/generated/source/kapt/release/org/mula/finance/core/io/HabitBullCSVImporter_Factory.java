package org.mula.finance.core.io;

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
public final class HabitBullCSVImporter_Factory implements Factory<HabitBullCSVImporter> {
  private final Provider<HabitList> habitsProvider;

  private final Provider<ModelFactory> modelFactoryProvider;

  public HabitBullCSVImporter_Factory(Provider<HabitList> habitsProvider,
      Provider<ModelFactory> modelFactoryProvider) {
    this.habitsProvider = habitsProvider;
    this.modelFactoryProvider = modelFactoryProvider;
  }

  @Override
  public HabitBullCSVImporter get() {
    return newInstance(habitsProvider.get(), modelFactoryProvider.get());
  }

  public static HabitBullCSVImporter_Factory create(Provider<HabitList> habitsProvider,
      Provider<ModelFactory> modelFactoryProvider) {
    return new HabitBullCSVImporter_Factory(habitsProvider, modelFactoryProvider);
  }

  public static HabitBullCSVImporter newInstance(HabitList habits, ModelFactory modelFactory) {
    return new HabitBullCSVImporter(habits, modelFactory);
  }
}
