package org.mula.finance;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.sqlite.SQLiteHabitList;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HabitsModule_GetHabitListFactory implements Factory<HabitList> {
  private final HabitsModule module;

  private final Provider<SQLiteHabitList> listProvider;

  public HabitsModule_GetHabitListFactory(HabitsModule module,
      Provider<SQLiteHabitList> listProvider) {
    this.module = module;
    this.listProvider = listProvider;
  }

  @Override
  public HabitList get() {
    return getHabitList(module, listProvider.get());
  }

  public static HabitsModule_GetHabitListFactory create(HabitsModule module,
      Provider<SQLiteHabitList> listProvider) {
    return new HabitsModule_GetHabitListFactory(module, listProvider);
  }

  public static HabitList getHabitList(HabitsModule instance, SQLiteHabitList list) {
    return Preconditions.checkNotNull(instance.getHabitList(list), "Cannot return null from a non-@Nullable @Provides method");
  }
}
