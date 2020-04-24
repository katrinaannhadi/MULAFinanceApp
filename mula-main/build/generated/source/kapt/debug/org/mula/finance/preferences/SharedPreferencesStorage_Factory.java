package org.mula.finance.preferences;

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
public final class SharedPreferencesStorage_Factory implements Factory<SharedPreferencesStorage> {
  private final Provider<Context> contextProvider;

  public SharedPreferencesStorage_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public SharedPreferencesStorage get() {
    return newInstance(contextProvider.get());
  }

  public static SharedPreferencesStorage_Factory create(Provider<Context> contextProvider) {
    return new SharedPreferencesStorage_Factory(contextProvider);
  }

  public static SharedPreferencesStorage newInstance(Context context) {
    return new SharedPreferencesStorage(context);
  }
}
