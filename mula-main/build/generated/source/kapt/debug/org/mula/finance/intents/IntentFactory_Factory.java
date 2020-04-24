package org.mula.finance.intents;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class IntentFactory_Factory implements Factory<IntentFactory> {
  @Override
  public IntentFactory get() {
    return newInstance();
  }

  public static IntentFactory_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static IntentFactory newInstance() {
    return new IntentFactory();
  }

  private static final class InstanceHolder {
    private static final IntentFactory_Factory INSTANCE = new IntentFactory_Factory();
  }
}
