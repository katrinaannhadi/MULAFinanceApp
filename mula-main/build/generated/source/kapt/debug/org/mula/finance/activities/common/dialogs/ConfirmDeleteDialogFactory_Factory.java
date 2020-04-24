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
public final class ConfirmDeleteDialogFactory_Factory implements Factory<ConfirmDeleteDialogFactory> {
  private final Provider<Context> contextProvider;

  public ConfirmDeleteDialogFactory_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public ConfirmDeleteDialogFactory get() {
    return newInstance(contextProvider);
  }

  public static ConfirmDeleteDialogFactory_Factory create(Provider<Context> contextProvider) {
    return new ConfirmDeleteDialogFactory_Factory(contextProvider);
  }

  public static ConfirmDeleteDialogFactory newInstance(Provider<Context> contextProvider) {
    return new ConfirmDeleteDialogFactory(contextProvider);
  }
}
