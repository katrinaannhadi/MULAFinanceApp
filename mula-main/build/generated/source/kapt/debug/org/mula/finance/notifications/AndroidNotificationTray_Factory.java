package org.mula.finance.notifications;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.intents.PendingIntentFactory;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AndroidNotificationTray_Factory implements Factory<AndroidNotificationTray> {
  private final Provider<Context> contextProvider;

  private final Provider<PendingIntentFactory> pendingIntentsProvider;

  private final Provider<Preferences> preferencesProvider;

  private final Provider<RingtoneManager> ringtoneManagerProvider;

  public AndroidNotificationTray_Factory(Provider<Context> contextProvider,
      Provider<PendingIntentFactory> pendingIntentsProvider,
      Provider<Preferences> preferencesProvider,
      Provider<RingtoneManager> ringtoneManagerProvider) {
    this.contextProvider = contextProvider;
    this.pendingIntentsProvider = pendingIntentsProvider;
    this.preferencesProvider = preferencesProvider;
    this.ringtoneManagerProvider = ringtoneManagerProvider;
  }

  @Override
  public AndroidNotificationTray get() {
    return newInstance(contextProvider.get(), pendingIntentsProvider.get(), preferencesProvider.get(), ringtoneManagerProvider.get());
  }

  public static AndroidNotificationTray_Factory create(Provider<Context> contextProvider,
      Provider<PendingIntentFactory> pendingIntentsProvider,
      Provider<Preferences> preferencesProvider,
      Provider<RingtoneManager> ringtoneManagerProvider) {
    return new AndroidNotificationTray_Factory(contextProvider, pendingIntentsProvider, preferencesProvider, ringtoneManagerProvider);
  }

  public static AndroidNotificationTray newInstance(Context context,
      PendingIntentFactory pendingIntents, Preferences preferences,
      RingtoneManager ringtoneManager) {
    return new AndroidNotificationTray(context, pendingIntents, preferences, ringtoneManager);
  }
}
