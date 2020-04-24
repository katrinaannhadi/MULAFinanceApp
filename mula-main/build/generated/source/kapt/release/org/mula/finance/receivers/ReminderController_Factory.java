package org.mula.finance.receivers;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.reminders.ReminderScheduler;
import org.mula.finance.core.ui.NotificationTray;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ReminderController_Factory implements Factory<ReminderController> {
  private final Provider<ReminderScheduler> reminderSchedulerProvider;

  private final Provider<NotificationTray> notificationTrayProvider;

  private final Provider<Preferences> preferencesProvider;

  public ReminderController_Factory(Provider<ReminderScheduler> reminderSchedulerProvider,
      Provider<NotificationTray> notificationTrayProvider,
      Provider<Preferences> preferencesProvider) {
    this.reminderSchedulerProvider = reminderSchedulerProvider;
    this.notificationTrayProvider = notificationTrayProvider;
    this.preferencesProvider = preferencesProvider;
  }

  @Override
  public ReminderController get() {
    return newInstance(reminderSchedulerProvider.get(), notificationTrayProvider.get(), preferencesProvider.get());
  }

  public static ReminderController_Factory create(
      Provider<ReminderScheduler> reminderSchedulerProvider,
      Provider<NotificationTray> notificationTrayProvider,
      Provider<Preferences> preferencesProvider) {
    return new ReminderController_Factory(reminderSchedulerProvider, notificationTrayProvider, preferencesProvider);
  }

  public static ReminderController newInstance(ReminderScheduler reminderScheduler,
      NotificationTray notificationTray, Preferences preferences) {
    return new ReminderController(reminderScheduler, notificationTray, preferences);
  }
}
