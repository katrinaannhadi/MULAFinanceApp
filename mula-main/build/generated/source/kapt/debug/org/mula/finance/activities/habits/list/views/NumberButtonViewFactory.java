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
public final class NumberButtonViewFactory {
  private final Provider<Context> contextProvider;

  private final Provider<Preferences> preferencesProvider;

  @Inject
  public NumberButtonViewFactory(
      @ActivityContext Provider<Context> contextProvider,
      Provider<Preferences> preferencesProvider) {
    this.contextProvider = checkNotNull(contextProvider, 1);
    this.preferencesProvider = checkNotNull(preferencesProvider, 2);
  }

  public NumberButtonView create() {
    return new NumberButtonView(
        checkNotNull(contextProvider.get(), 1), checkNotNull(preferencesProvider.get(), 2));
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
