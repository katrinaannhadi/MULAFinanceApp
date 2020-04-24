package org.mula.finance.tasks;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.androidbase.AndroidDirFinder;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ExportDBTaskFactory_Factory implements Factory<ExportDBTaskFactory> {
  private final Provider<Context> contextProvider;

  private final Provider<AndroidDirFinder> systemProvider;

  public ExportDBTaskFactory_Factory(Provider<Context> contextProvider,
      Provider<AndroidDirFinder> systemProvider) {
    this.contextProvider = contextProvider;
    this.systemProvider = systemProvider;
  }

  @Override
  public ExportDBTaskFactory get() {
    return newInstance(contextProvider, systemProvider);
  }

  public static ExportDBTaskFactory_Factory create(Provider<Context> contextProvider,
      Provider<AndroidDirFinder> systemProvider) {
    return new ExportDBTaskFactory_Factory(contextProvider, systemProvider);
  }

  public static ExportDBTaskFactory newInstance(Provider<Context> contextProvider,
      Provider<AndroidDirFinder> systemProvider) {
    return new ExportDBTaskFactory(contextProvider, systemProvider);
  }
}
