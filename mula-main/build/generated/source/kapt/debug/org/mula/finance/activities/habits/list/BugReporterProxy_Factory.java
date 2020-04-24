package org.mula.finance.activities.habits.list;

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
public final class BugReporterProxy_Factory implements Factory<BugReporterProxy> {
  private final Provider<Context> contextProvider;

  public BugReporterProxy_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public BugReporterProxy get() {
    return newInstance(contextProvider.get());
  }

  public static BugReporterProxy_Factory create(Provider<Context> contextProvider) {
    return new BugReporterProxy_Factory(contextProvider);
  }

  public static BugReporterProxy newInstance(Context context) {
    return new BugReporterProxy(context);
  }
}
