package org.mula.finance;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.database.DatabaseOpener;
import org.mula.finance.database.AndroidDatabaseOpener;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HabitsModule_GetDatabaseOpenerFactory implements Factory<DatabaseOpener> {
  private final HabitsModule module;

  private final Provider<AndroidDatabaseOpener> openerProvider;

  public HabitsModule_GetDatabaseOpenerFactory(HabitsModule module,
      Provider<AndroidDatabaseOpener> openerProvider) {
    this.module = module;
    this.openerProvider = openerProvider;
  }

  @Override
  public DatabaseOpener get() {
    return getDatabaseOpener(module, openerProvider.get());
  }

  public static HabitsModule_GetDatabaseOpenerFactory create(HabitsModule module,
      Provider<AndroidDatabaseOpener> openerProvider) {
    return new HabitsModule_GetDatabaseOpenerFactory(module, openerProvider);
  }

  public static DatabaseOpener getDatabaseOpener(HabitsModule instance,
      AndroidDatabaseOpener opener) {
    return Preconditions.checkNotNull(instance.getDatabaseOpener(opener), "Cannot return null from a non-@Nullable @Provides method");
  }
}
