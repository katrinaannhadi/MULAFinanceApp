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
public final class CheckmarkButtonViewFactory_Factory implements Factory<CheckmarkButtonViewFactory> {
  private final Provider<Context> contextProvider;

  private final Provider<Preferences> preferencesProvider;

  public CheckmarkButtonViewFactory_Factory(Provider<Context> contextProvider,
      Provider<Preferences> preferencesProvider) {
    this.contextProvider = contextProvider;
    this.preferencesProvider = preferencesProvider;
  }

  @Override
  public CheckmarkButtonViewFactory get() {
    return newInstance(contextProvider, preferencesProvider);
  }

  public static CheckmarkButtonViewFactory_Factory create(Provider<Context> contextProvider,
      Provider<Preferences> preferencesProvider) {
    return new CheckmarkButtonViewFactory_Factory(contextProvider, preferencesProvider);
  }

  public static CheckmarkButtonViewFactory newInstance(Provider<Context> contextProvider,
      Provider<Preferences> preferencesProvider) {
    return new CheckmarkButtonViewFactory(contextProvider, preferencesProvider);
  }
}
