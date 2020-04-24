package org.mula.finance.core.io;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.database.DatabaseOpener;
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
public final class TickmateDBImporter_Factory implements Factory<TickmateDBImporter> {
  private final Provider<HabitList> habitsProvider;

  private final Provider<ModelFactory> modelFactoryProvider;

  private final Provider<DatabaseOpener> openerProvider;

  public TickmateDBImporter_Factory(Provider<HabitList> habitsProvider,
      Provider<ModelFactory> modelFactoryProvider, Provider<DatabaseOpener> openerProvider) {
    this.habitsProvider = habitsProvider;
    this.modelFactoryProvider = modelFactoryProvider;
    this.openerProvider = openerProvider;
  }

  @Override
  public TickmateDBImporter get() {
    return newInstance(habitsProvider.get(), modelFactoryProvider.get(), openerProvider.get());
  }

  public static TickmateDBImporter_Factory create(Provider<HabitList> habitsProvider,
      Provider<ModelFactory> modelFactoryProvider, Provider<DatabaseOpener> openerProvider) {
    return new TickmateDBImporter_Factory(habitsProvider, modelFactoryProvider, openerProvider);
  }

  public static TickmateDBImporter newInstance(HabitList habits, ModelFactory modelFactory,
      DatabaseOpener opener) {
    return new TickmateDBImporter(habits, modelFactory, opener);
  }
}
