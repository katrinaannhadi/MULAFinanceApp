package org.mula.finance.activities;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.androidbase.activities.BaseActivity;
import org.mula.finance.core.preferences.Preferences;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AndroidThemeSwitcher_Factory implements Factory<AndroidThemeSwitcher> {
  private final Provider<BaseActivity> activityProvider;

  private final Provider<Preferences> preferencesProvider;

  public AndroidThemeSwitcher_Factory(Provider<BaseActivity> activityProvider,
      Provider<Preferences> preferencesProvider) {
    this.activityProvider = activityProvider;
    this.preferencesProvider = preferencesProvider;
  }

  @Override
  public AndroidThemeSwitcher get() {
    return newInstance(activityProvider.get(), preferencesProvider.get());
  }

  public static AndroidThemeSwitcher_Factory create(Provider<BaseActivity> activityProvider,
      Provider<Preferences> preferencesProvider) {
    return new AndroidThemeSwitcher_Factory(activityProvider, preferencesProvider);
  }

  public static AndroidThemeSwitcher newInstance(BaseActivity activity, Preferences preferences) {
    return new AndroidThemeSwitcher(activity, preferences);
  }
}
