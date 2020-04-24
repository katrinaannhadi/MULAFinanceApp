package org.mula.finance.activities;

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
public final class HabitsDirFinder_Factory implements Factory<HabitsDirFinder> {
  private final Provider<AndroidDirFinder> androidDirFinderProvider;

  public HabitsDirFinder_Factory(Provider<AndroidDirFinder> androidDirFinderProvider) {
    this.androidDirFinderProvider = androidDirFinderProvider;
  }

  @Override
  public HabitsDirFinder get() {
    return newInstance(androidDirFinderProvider.get());
  }

  public static HabitsDirFinder_Factory create(
      Provider<AndroidDirFinder> androidDirFinderProvider) {
    return new HabitsDirFinder_Factory(androidDirFinderProvider);
  }

  public static HabitsDirFinder newInstance(AndroidDirFinder androidDirFinder) {
    return new HabitsDirFinder(androidDirFinder);
  }
}
