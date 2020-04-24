package org.mula.finance.tasks;

import android.content.Context;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;
import org.mula.androidbase.AndroidDirFinder;
import org.mula.androidbase.AppContext;

@Generated(
  value = "com.google.auto.factory.processor.AutoFactoryProcessor",
  comments = "https://github.com/google/auto/tree/master/factory"
)
public class ExportDBTaskFactory {
  private final Provider<Context> contextProvider;

  private final Provider<AndroidDirFinder> systemProvider;

  @Inject
  public ExportDBTaskFactory(
      @AppContext Provider<Context> contextProvider, Provider<AndroidDirFinder> systemProvider) {
    this.contextProvider = checkNotNull(contextProvider, 1);
    this.systemProvider = checkNotNull(systemProvider, 2);
  }

  public ExportDBTask create(ExportDBTask.Listener listener) {
    return new ExportDBTask(
        checkNotNull(contextProvider.get(), 1),
        checkNotNull(systemProvider.get(), 2),
        checkNotNull(listener, 3));
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
