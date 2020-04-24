package org.mula.finance;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import org.mula.finance.core.models.ModelFactory;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HabitsModule_GetModelFactoryFactory implements Factory<ModelFactory> {
  private final HabitsModule module;

  public HabitsModule_GetModelFactoryFactory(HabitsModule module) {
    this.module = module;
  }

  @Override
  public ModelFactory get() {
    return getModelFactory(module);
  }

  public static HabitsModule_GetModelFactoryFactory create(HabitsModule module) {
    return new HabitsModule_GetModelFactoryFactory(module);
  }

  public static ModelFactory getModelFactory(HabitsModule instance) {
    return Preconditions.checkNotNull(instance.getModelFactory(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
