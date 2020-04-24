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
public final class IntentScheduler_Factory implements Factory<IntentScheduler> {
  private final Provider<Context> contextProvider;

  private final Provider<PendingIntentFactory> pendingIntentsProvider;

  public IntentScheduler_Factory(Provider<Context> contextProvider,
      Provider<PendingIntentFactory> pendingIntentsProvider) {
    this.contextProvider = contextProvider;
    this.pendingIntentsProvider = pendingIntentsProvider;
  }

  @Override
  public IntentScheduler get() {
    return newInstance(contextProvider.get(), pendingIntentsProvider.get());
  }

  public static IntentScheduler_Factory create(Provider<Context> contextProvider,
      Provider<PendingIntentFactory> pendingIntentsProvider) {
    return new IntentScheduler_Factory(contextProvider, pendingIntentsProvider);
  }

  public static IntentScheduler newInstance(Context context, PendingIntentFactory pendingIntents) {
    return new IntentScheduler(context, pendingIntents);
  }
}
