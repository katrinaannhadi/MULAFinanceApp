package org.mula.finance.core.models.sqlite;

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
public final class SQLiteHabitList_Factory implements Factory<SQLiteHabitList> {
  private final Provider<ModelFactory> modelFactoryProvider;

  public SQLiteHabitList_Factory(Provider<ModelFactory> modelFactoryProvider) {
    this.modelFactoryProvider = modelFactoryProvider;
  }

  @Override
  public SQLiteHabitList get() {
    return newInstance(modelFactoryProvider.get());
  }

  public static SQLiteHabitList_Factory create(Provider<ModelFactory> modelFactoryProvider) {
    return new SQLiteHabitList_Factory(modelFactoryProvider);
  }

  public static SQLiteHabitList newInstance(ModelFactory modelFactory) {
    return new SQLiteHabitList(modelFactory);
  }
}
