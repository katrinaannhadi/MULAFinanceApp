package org.mula.finance.activities.habits.list.views;

import android.content.Context;
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
public final class NumberButtonViewFactory_Factory implements Factory<NumberButtonViewFactory> {
  private final Provider<Context> contextProvider;

  private final Provider<Preferences> preferencesProvider;

  public NumberButtonViewFactory_Factory(Provider<Context> contextProvider,
      Provider<Preferences> preferencesProvider) {
    this.contextProvider = contextProvider;
    this.preferencesProvider = preferencesProvider;
  }

  @Override
  public NumberButtonViewFactory get() {
    return newInstance(contextProvider, preferencesProvider);
  }

  public static NumberButtonViewFactory_Factory create(Provider<Context> contextProvider,
      Provider<Preferences> preferencesProvider) {
    return new NumberButtonViewFactory_Factory(contextProvider, preferencesProvider);
  }

  public static NumberButtonViewFactory newInstance(Provider<Context> contextProvider,
      Provider<Preferences> preferencesProvider) {
    return new NumberButtonViewFactory(contextProvider, preferencesProvider);
  }
}
