package org.mula.finance.database;

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
public final class AndroidDatabaseOpener_Factory implements Factory<AndroidDatabaseOpener> {
  @Override
  public AndroidDatabaseOpener get() {
    return newInstance();
  }

  public static AndroidDatabaseOpener_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AndroidDatabaseOpener newInstance() {
    return new AndroidDatabaseOpener();
  }

  private static final class InstanceHolder {
    private static final AndroidDatabaseOpener_Factory INSTANCE = new AndroidDatabaseOpener_Factory();
  }
}
