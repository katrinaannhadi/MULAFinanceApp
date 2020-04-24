package org.mula.finance.core.utils;

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
public final class MidnightTimer_Factory implements Factory<MidnightTimer> {
  @Override
  public MidnightTimer get() {
    return newInstance();
  }

  public static MidnightTimer_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static MidnightTimer newInstance() {
    return new MidnightTimer();
  }

  private static final class InstanceHolder {
    private static final MidnightTimer_Factory INSTANCE = new MidnightTimer_Factory();
  }
}
