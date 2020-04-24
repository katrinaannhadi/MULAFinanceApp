package org.mula.finance.activities.common.dialogs;

import android.content.Context;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;
import org.mula.androidbase.activities.ActivityContext;
import org.mula.finance.core.ui.callbacks.OnConfirmedCallback;

@Generated(
  value = "com.google.auto.factory.processor.AutoFactoryProcessor",
  comments = "https://github.com/google/auto/tree/master/factory"
)
public class ConfirmDeleteDialogFactory {
  private final Provider<Context> contextProvider;

  @Inject
  public ConfirmDeleteDialogFactory(@ActivityContext Provider<Context> contextProvider) {
    this.contextProvider = checkNotNull(contextProvider, 1);
  }

  public ConfirmDeleteDialog create(OnConfirmedCallback callback) {
    return new ConfirmDeleteDialog(
        checkNotNull(contextProvider.get(), 1), checkNotNull(callback, 2));
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
