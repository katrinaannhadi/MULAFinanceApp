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
public final class ColorPickerDialogFactory_Factory implements Factory<ColorPickerDialogFactory> {
  private final Provider<Context> contextProvider;

  public ColorPickerDialogFactory_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public ColorPickerDialogFactory get() {
    return newInstance(contextProvider.get());
  }

  public static ColorPickerDialogFactory_Factory create(Provider<Context> contextProvider) {
    return new ColorPickerDialogFactory_Factory(contextProvider);
  }

  public static ColorPickerDialogFactory newInstance(Context context) {
    return new ColorPickerDialogFactory(context);
  }
}
