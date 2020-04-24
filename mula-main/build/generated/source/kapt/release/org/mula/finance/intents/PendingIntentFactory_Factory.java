package org.mula.finance.intents;

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
public final class PendingIntentFactory_Factory implements Factory<PendingIntentFactory> {
  private final Provider<Context> contextProvider;

  private final Provider<IntentFactory> intentFactoryProvider;

  public PendingIntentFactory_Factory(Provider<Context> contextProvider,
      Provider<IntentFactory> intentFactoryProvider) {
    this.contextProvider = contextProvider;
    this.intentFactoryProvider = intentFactoryProvider;
  }

  @Override
  public PendingIntentFactory get() {
    return newInstance(contextProvider.get(), intentFactoryProvider.get());
  }

  public static PendingIntentFactory_Factory create(Provider<Context> contextProvider,
      Provider<IntentFactory> intentFactoryProvider) {
    return new PendingIntentFactory_Factory(contextProvider, intentFactoryProvider);
  }

  public static PendingIntentFactory newInstance(Context context, IntentFactory intentFactory) {
    return new PendingIntentFactory(context, intentFactory);
  }
}
