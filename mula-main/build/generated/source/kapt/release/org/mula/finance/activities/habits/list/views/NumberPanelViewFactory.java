package org.mula.finance.activities.habits.list.views;

import android.content.Context;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;
import org.mula.androidbase.activities.ActivityContext;
import org.mula.finance.core.preferences.Preferences;

@Generated(
  value = "com.google.auto.factory.processor.AutoFactoryProcessor",
  comments = "https://github.com/google/auto/tree/master/factory"
)
public final class NumberPanelViewFactory {
  private final Provider<Context> contextProvider;

  private final Provider<Preferences> preferencesProvider;

  private final Provider<NumberButtonViewFactory> buttonFactoryProvider;

  @Inject
  public NumberPanelViewFactory(
      @ActivityContext Provider<Context> contextProvider,
      Provider<Preferences> preferencesProvider,
      Provider<NumberButtonViewFactory> buttonFactoryProvider) {
    this.contextProvider = checkNotNull(contextProvider, 1);
    this.preferencesProvider = checkNotNull(preferencesProvider, 2);
    this.buttonFactoryProvider = checkNotNull(buttonFactoryProvider, 3);
  }

  public NumberPanelView create() {
    return new NumberPanelView(
        checkNotNull(contextProvider.get(), 1),
        checkNotNull(preferencesProvider.get(), 2),
        checkNotNull(buttonFactoryProvider.get(), 3));
  }

  private static <T> T checkNotNull(T reference, int argumentIndex) {
    if (reference == null) {
      throw new NullPointerException(
          "@AutoFactory method argument is null but is not marked @Nullable. Argument index: "
              + argumentIndex);
    }
    return reference;
  }
}
