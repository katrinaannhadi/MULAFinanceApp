package org.mula.finance.activities.common.dialogs;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NumberPickerFactory_Factory implements Factory<NumberPickerFactory> {
  private final Provider<Context> contextProvider;

  public NumberPickerFactory_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NumberPickerFactory get() {
    return newInstance(contextProvider.get());
  }

  public static NumberPickerFactory_Factory create(Provider<Context> contextProvider) {
    return new NumberPickerFactory_Factory(contextProvider);
  }

  public static NumberPickerFactory newInstance(Context context) {
    return new NumberPickerFactory(context);
  }
}
