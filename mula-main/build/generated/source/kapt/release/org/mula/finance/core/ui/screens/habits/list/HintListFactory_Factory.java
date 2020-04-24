package org.mula.finance.core.ui.screens.habits.list;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.preferences.Preferences;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HintListFactory_Factory implements Factory<HintListFactory> {
  private final Provider<Preferences> prefsProvider;

  public HintListFactory_Factory(Provider<Preferences> prefsProvider) {
    this.prefsProvider = prefsProvider;
  }

  @Override
  public HintListFactory get() {
    return newInstance(prefsProvider);
  }

  public static HintListFactory_Factory create(Provider<Preferences> prefsProvider) {
    return new HintListFactory_Factory(prefsProvider);
  }

  public static HintListFactory newInstance(Provider<Preferences> prefsProvider) {
    return new HintListFactory(prefsProvider);
  }
}
