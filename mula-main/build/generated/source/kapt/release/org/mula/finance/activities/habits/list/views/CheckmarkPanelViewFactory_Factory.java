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
public final class CheckmarkPanelViewFactory_Factory implements Factory<CheckmarkPanelViewFactory> {
  private final Provider<Context> contextProvider;

  private final Provider<Preferences> preferencesProvider;

  private final Provider<CheckmarkButtonViewFactory> buttonFactoryProvider;

  public CheckmarkPanelViewFactory_Factory(Provider<Context> contextProvider,
      Provider<Preferences> preferencesProvider,
      Provider<CheckmarkButtonViewFactory> buttonFactoryProvider) {
    this.contextProvider = contextProvider;
    this.preferencesProvider = preferencesProvider;
    this.buttonFactoryProvider = buttonFactoryProvider;
  }

  @Override
  public CheckmarkPanelViewFactory get() {
    return newInstance(contextProvider, preferencesProvider, buttonFactoryProvider);
  }

  public static CheckmarkPanelViewFactory_Factory create(Provider<Context> contextProvider,
      Provider<Preferences> preferencesProvider,
      Provider<CheckmarkButtonViewFactory> buttonFactoryProvider) {
    return new CheckmarkPanelViewFactory_Factory(contextProvider, preferencesProvider, buttonFactoryProvider);
  }

  public static CheckmarkPanelViewFactory newInstance(Provider<Context> contextProvider,
      Provider<Preferences> preferencesProvider,
      Provider<CheckmarkButtonViewFactory> buttonFactoryProvider) {
    return new CheckmarkPanelViewFactory(contextProvider, preferencesProvider, buttonFactoryProvider);
  }
}
