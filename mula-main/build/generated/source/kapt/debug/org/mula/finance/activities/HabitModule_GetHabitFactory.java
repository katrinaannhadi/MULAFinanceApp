package org.mula.finance.activities;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import org.mula.finance.core.models.Habit;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HabitModule_GetHabitFactory implements Factory<Habit> {
  private final HabitModule module;

  public HabitModule_GetHabitFactory(HabitModule module) {
    this.module = module;
  }

  @Override
  public Habit get() {
    return getHabit(module);
  }

  public static HabitModule_GetHabitFactory create(HabitModule module) {
    return new HabitModule_GetHabitFactory(module);
  }

  public static Habit getHabit(HabitModule instance) {
    return Preconditions.checkNotNull(instance.getHabit(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
