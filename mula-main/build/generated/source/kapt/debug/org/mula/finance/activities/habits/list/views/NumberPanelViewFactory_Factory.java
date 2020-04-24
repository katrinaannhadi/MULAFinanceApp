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
public final class NumberPanelViewFactory_Factory implements Factory<NumberPanelViewFactory> {
  private final Provider<Context> contextProvider;

  private final Provider<Preferences> preferencesProvider;

  private final Provider<NumberButtonViewFactory> buttonFactoryProvider;

  public NumberPanelViewFactory_Factory(Provider<Context> contextProvider,
      Provider<Preferences> preferencesProvider,
      Provider<NumberButtonViewFactory> buttonFactoryProvider) {
    this.contextProvider = contextProvider;
    this.preferencesProvider = preferencesProvider;
    this.buttonFactoryProvider = buttonFactoryProvider;
  }

  @Override
  public NumberPanelViewFactory get() {
    return newInstance(contextProvider, preferencesProvider, buttonFactoryProvider);
  }

  public static NumberPanelViewFactory_Factory create(Provider<Context> contextProvider,
      Provider<Preferences> preferencesProvider,
      Provider<NumberButtonViewFactory> buttonFactoryProvider) {
    return new NumberPanelViewFactory_Factory(contextProvider, preferencesProvider, buttonFactoryProvider);
  }

  public static NumberPanelViewFactory newInstance(Provider<Context> contextProvider,
      Provider<Preferences> preferencesProvider,
      Provider<NumberButtonViewFactory> buttonFactoryProvider) {
    return new NumberPanelViewFactory(contextProvider, preferencesProvider, buttonFactoryProvider);
  }
}
