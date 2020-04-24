package org.mula.finance;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.preferences.SharedPreferencesStorage;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HabitsModule_GetPreferencesFactory implements Factory<Preferences> {
  private final HabitsModule module;

  private final Provider<SharedPreferencesStorage> storageProvider;

  public HabitsModule_GetPreferencesFactory(HabitsModule module,
      Provider<SharedPreferencesStorage> storageProvider) {
    this.module = module;
    this.storageProvider = storageProvider;
  }

  @Override
  public Preferences get() {
    return getPreferences(module, storageProvider.get());
  }

  public static HabitsModule_GetPreferencesFactory create(HabitsModule module,
      Provider<SharedPreferencesStorage> storageProvider) {
    return new HabitsModule_GetPreferencesFactory(module, storageProvider);
  }

  public static Preferences getPreferences(HabitsModule instance,
      SharedPreferencesStorage storage) {
    return Preconditions.checkNotNull(instance.getPreferences(storage), "Cannot return null from a non-@Nullable @Provides method");
  }
}
