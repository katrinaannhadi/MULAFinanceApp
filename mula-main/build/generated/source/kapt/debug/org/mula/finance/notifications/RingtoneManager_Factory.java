package org.mula.finance.notifications;

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
public final class RingtoneManager_Factory implements Factory<RingtoneManager> {
  private final Provider<Context> contextProvider;

  public RingtoneManager_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public RingtoneManager get() {
    return newInstance(contextProvider.get());
  }

  public static RingtoneManager_Factory create(Provider<Context> contextProvider) {
    return new RingtoneManager_Factory(contextProvider);
  }

  public static RingtoneManager newInstance(Context context) {
    return new RingtoneManager(context);
  }
}
