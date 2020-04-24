package org.mula.finance.activities.habits.list;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.activities.habits.list.views.HabitCardListAdapter;
import org.mula.finance.activities.habits.list.views.HabitCardListController;
import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.ui.NotificationTray;
import org.mula.finance.core.ui.screens.habits.list.ListHabitsSelectionMenuBehavior;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ListHabitsSelectionMenu_Factory implements Factory<ListHabitsSelectionMenu> {
  private final Provider<ListHabitsScreen> screenProvider;

  private final Provider<HabitCardListAdapter> listAdapterProvider;

  private final Provider<CommandRunner> commandRunnerProvider;

  private final Provider<Preferences> prefsProvider;

  private final Provider<ListHabitsSelectionMenuBehavior> behaviorProvider;

  private final Provider<HabitCardListController> listControllerProvider;

  private final Provider<NotificationTray> notificationTrayProvider;

  public ListHabitsSelectionMenu_Factory(Provider<ListHabitsScreen> screenProvider,
      Provider<HabitCardListAdapter> listAdapterProvider,
      Provider<CommandRunner> commandRunnerProvider, Provider<Preferences> prefsProvider,
      Provider<ListHabitsSelectionMenuBehavior> behaviorProvider,
      Provider<HabitCardListController> listControllerProvider,
      Provider<NotificationTray> notificationTrayProvider) {
    this.screenProvider = screenProvider;
    this.listAdapterProvider = listAdapterProvider;
    this.commandRunnerProvider = commandRunnerProvider;
    this.prefsProvider = prefsProvider;
    this.behaviorProvider = behaviorProvider;
    this.listControllerProvider = listControllerProvider;
    this.notificationTrayProvider = notificationTrayProvider;
  }

  @Override
  public ListHabitsSelectionMenu get() {
    return newInstance(screenProvider.get(), listAdapterProvider.get(), commandRunnerProvider.get(), prefsProvider.get(), behaviorProvider.get(), DoubleCheck.lazy(listControllerProvider), notificationTrayProvider.get());
  }

  public static ListHabitsSelectionMenu_Factory create(Provider<ListHabitsScreen> screenProvider,
      Provider<HabitCardListAdapter> listAdapterProvider,
      Provider<CommandRunner> commandRunnerProvider, Provider<Preferences> prefsProvider,
      Provider<ListHabitsSelectionMenuBehavior> behaviorProvider,
      Provider<HabitCardListController> listControllerProvider,
      Provider<NotificationTray> notificationTrayProvider) {
    return new ListHabitsSelectionMenu_Factory(screenProvider, listAdapterProvider, commandRunnerProvider, prefsProvider, behaviorProvider, listControllerProvider, notificationTrayProvider);
  }

  public static ListHabitsSelectionMenu newInstance(ListHabitsScreen screen,
      HabitCardListAdapter listAdapter, CommandRunner commandRunner, Preferences prefs,
      ListHabitsSelectionMenuBehavior behavior, Lazy<HabitCardListController> listController,
      NotificationTray notificationTray) {
    return new ListHabitsSelectionMenu(screen, listAdapter, commandRunner, prefs, behavior, listController, notificationTray);
  }
}
