package org.mula.finance;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.preferences.WidgetPreferences;
import org.mula.finance.preferences.SharedPreferencesStorage;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HabitsModule_GetWidgetPreferencesFactory implements Factory<WidgetPreferences> {
  private final HabitsModule module;

  private final Provider<SharedPreferencesStorage> storageProvider;

  public HabitsModule_GetWidgetPreferencesFactory(HabitsModule module,
      Provider<SharedPreferencesStorage> storageProvider) {
    this.module = module;
    this.storageProvider = storageProvider;
  }

  @Override
  public WidgetPreferences get() {
    return getWidgetPreferences(module, storageProvider.get());
  }

  public static HabitsModule_GetWidgetPreferencesFactory create(HabitsModule module,
      Provider<SharedPreferencesStorage> storageProvider) {
    return new HabitsModule_GetWidgetPreferencesFactory(module, storageProvider);
  }

  public static WidgetPreferences getWidgetPreferences(HabitsModule instance,
      SharedPreferencesStorage storage) {
    return Preconditions.checkNotNull(instance.getWidgetPreferences(storage), "Cannot return null from a non-@Nullable @Provides method");
  }
}
