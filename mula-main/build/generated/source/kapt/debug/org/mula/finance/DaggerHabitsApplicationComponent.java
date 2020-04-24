package org.mula.finance;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.androidbase.AppContextModule;
import org.mula.androidbase.AppContextModule_GetContextFactory;
import org.mula.androidbase.SSLContextProvider;
import org.mula.androidbase.SSLContextProvider_Factory;
import org.mula.finance.core.commands.CommandParser;
import org.mula.finance.core.commands.CommandParser_Factory;
import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.commands.CommandRunner_Factory;
import org.mula.finance.core.commands.CreateHabitCommandFactory;
import org.mula.finance.core.commands.EditHabitCommandFactory;
import org.mula.finance.core.database.DatabaseOpener;
import org.mula.finance.core.io.GenericImporter;
import org.mula.finance.core.io.HabitBullCSVImporter;
import org.mula.finance.core.io.LoopDBImporter;
import org.mula.finance.core.io.RewireDBImporter;
import org.mula.finance.core.io.TickmateDBImporter;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.ModelFactory;
import org.mula.finance.core.models.sqlite.SQLiteHabitList;
import org.mula.finance.core.models.sqlite.SQLiteHabitList_Factory;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.preferences.WidgetPreferences;
import org.mula.finance.core.reminders.ReminderScheduler;
import org.mula.finance.core.tasks.TaskRunner;
import org.mula.finance.core.ui.NotificationTray;
import org.mula.finance.core.ui.screens.habits.list.HabitCardListCache;
import org.mula.finance.core.ui.screens.habits.list.HabitCardListCache_Factory;
import org.mula.finance.core.utils.MidnightTimer;
import org.mula.finance.core.utils.MidnightTimer_Factory;
import org.mula.finance.database.AndroidDatabaseOpener_Factory;
import org.mula.finance.intents.IntentFactory;
import org.mula.finance.intents.IntentFactory_Factory;
import org.mula.finance.intents.IntentParser;
import org.mula.finance.intents.IntentParser_Factory;
import org.mula.finance.intents.IntentScheduler;
import org.mula.finance.intents.IntentScheduler_Factory;
import org.mula.finance.intents.PendingIntentFactory;
import org.mula.finance.intents.PendingIntentFactory_Factory;
import org.mula.finance.notifications.AndroidNotificationTray;
import org.mula.finance.notifications.AndroidNotificationTray_Factory;
import org.mula.finance.notifications.RingtoneManager;
import org.mula.finance.notifications.RingtoneManager_Factory;
import org.mula.finance.preferences.SharedPreferencesStorage;
import org.mula.finance.preferences.SharedPreferencesStorage_Factory;
import org.mula.finance.receivers.ReminderController;
import org.mula.finance.receivers.ReminderController_Factory;
import org.mula.finance.sync.SyncManager;
import org.mula.finance.sync.SyncManager_Factory;
import org.mula.finance.tasks.AndroidTaskRunner;
import org.mula.finance.tasks.AndroidTaskRunner_ProvideTaskRunnerFactory;
import org.mula.finance.widgets.WidgetUpdater;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerHabitsApplicationComponent implements HabitsApplicationComponent {
  private final AppContextModule appContextModule;

  private Provider<TaskRunner> provideTaskRunnerProvider;

  private Provider<CommandRunner> commandRunnerProvider;

  private Provider<ModelFactory> getModelFactoryProvider;

  private Provider<SQLiteHabitList> sQLiteHabitListProvider;

  private Provider<HabitList> getHabitListProvider;

  private Provider<DatabaseOpener> getDatabaseOpenerProvider;

  private Provider<HabitCardListCache> habitCardListCacheProvider;

  private Provider<IntentParser> intentParserProvider;

  private Provider<MidnightTimer> midnightTimerProvider;

  private Provider<Context> getContextProvider;

  private Provider<SharedPreferencesStorage> sharedPreferencesStorageProvider;

  private Provider<Preferences> getPreferencesProvider;

  private Provider<PendingIntentFactory> pendingIntentFactoryProvider;

  private Provider<RingtoneManager> ringtoneManagerProvider;

  private Provider<AndroidNotificationTray> androidNotificationTrayProvider;

  private Provider<NotificationTray> getTrayProvider;

  private Provider<IntentScheduler> intentSchedulerProvider;

  private Provider<WidgetPreferences> getWidgetPreferencesProvider;

  private Provider<ReminderScheduler> getReminderSchedulerProvider;

  private Provider<ReminderController> reminderControllerProvider;

  private Provider<SSLContextProvider> sSLContextProvider;

  private Provider<CommandParser> commandParserProvider;

  private Provider<SyncManager> syncManagerProvider;

  private DaggerHabitsApplicationComponent(AppContextModule appContextModuleParam,
      HabitsModule habitsModuleParam) {
    this.appContextModule = appContextModuleParam;
    initialize(appContextModuleParam, habitsModuleParam);
  }

  public static Builder builder() {
    return new Builder();
  }

  private LoopDBImporter getLoopDBImporter() {
    return new LoopDBImporter(getHabitListProvider.get(), getModelFactoryProvider.get(), getDatabaseOpenerProvider.get());}

  private RewireDBImporter getRewireDBImporter() {
    return new RewireDBImporter(getHabitListProvider.get(), getModelFactoryProvider.get(), getDatabaseOpenerProvider.get());}

  private TickmateDBImporter getTickmateDBImporter() {
    return new TickmateDBImporter(getHabitListProvider.get(), getModelFactoryProvider.get(), getDatabaseOpenerProvider.get());}

  private HabitBullCSVImporter getHabitBullCSVImporter() {
    return new HabitBullCSVImporter(getHabitListProvider.get(), getModelFactoryProvider.get());}

  @SuppressWarnings("unchecked")
  private void initialize(final AppContextModule appContextModuleParam,
      final HabitsModule habitsModuleParam) {
    this.provideTaskRunnerProvider = DoubleCheck.provider(AndroidTaskRunner_ProvideTaskRunnerFactory.create());
    this.commandRunnerProvider = DoubleCheck.provider(CommandRunner_Factory.create(provideTaskRunnerProvider));
    this.getModelFactoryProvider = DoubleCheck.provider(HabitsModule_GetModelFactoryFactory.create(habitsModuleParam));
    this.sQLiteHabitListProvider = SQLiteHabitList_Factory.create(getModelFactoryProvider);
    this.getHabitListProvider = DoubleCheck.provider(HabitsModule_GetHabitListFactory.create(habitsModuleParam, sQLiteHabitListProvider));
    this.getDatabaseOpenerProvider = DoubleCheck.provider(HabitsModule_GetDatabaseOpenerFactory.create(habitsModuleParam, AndroidDatabaseOpener_Factory.create()));
    this.habitCardListCacheProvider = DoubleCheck.provider(HabitCardListCache_Factory.create(getHabitListProvider, commandRunnerProvider, provideTaskRunnerProvider));
    this.intentParserProvider = DoubleCheck.provider(IntentParser_Factory.create(getHabitListProvider));
    this.midnightTimerProvider = DoubleCheck.provider(MidnightTimer_Factory.create());
    this.getContextProvider = AppContextModule_GetContextFactory.create(appContextModuleParam);
    this.sharedPreferencesStorageProvider = DoubleCheck.provider(SharedPreferencesStorage_Factory.create(getContextProvider));
    this.getPreferencesProvider = DoubleCheck.provider(HabitsModule_GetPreferencesFactory.create(habitsModuleParam, sharedPreferencesStorageProvider));
    this.pendingIntentFactoryProvider = DoubleCheck.provider(PendingIntentFactory_Factory.create(getContextProvider, IntentFactory_Factory.create()));
    this.ringtoneManagerProvider = DoubleCheck.provider(RingtoneManager_Factory.create(getContextProvider));
    this.androidNotificationTrayProvider = DoubleCheck.provider(AndroidNotificationTray_Factory.create(getContextProvider, pendingIntentFactoryProvider, getPreferencesProvider, ringtoneManagerProvider));
    this.getTrayProvider = DoubleCheck.provider(HabitsModule_GetTrayFactory.create(habitsModuleParam, provideTaskRunnerProvider, commandRunnerProvider, getPreferencesProvider, androidNotificationTrayProvider));
    this.intentSchedulerProvider = DoubleCheck.provider(IntentScheduler_Factory.create(getContextProvider, pendingIntentFactoryProvider));
    this.getWidgetPreferencesProvider = DoubleCheck.provider(HabitsModule_GetWidgetPreferencesFactory.create(habitsModuleParam, sharedPreferencesStorageProvider));
    this.getReminderSchedulerProvider = DoubleCheck.provider(HabitsModule_GetReminderSchedulerFactory.create(habitsModuleParam, intentSchedulerProvider, commandRunnerProvider, getHabitListProvider, getWidgetPreferencesProvider));
    this.reminderControllerProvider = DoubleCheck.provider(ReminderController_Factory.create(getReminderSchedulerProvider, getTrayProvider, getPreferencesProvider));
    this.sSLContextProvider = SSLContextProvider_Factory.create(getContextProvider);
    this.commandParserProvider = CommandParser_Factory.create(getHabitListProvider, getModelFactoryProvider);
    this.syncManagerProvider = DoubleCheck.provider(SyncManager_Factory.create(sSLContextProvider, getPreferencesProvider, commandRunnerProvider, commandParserProvider));
  }

  @Override
  public CommandRunner getCommandRunner() {
    return commandRunnerProvider.get();}

  @Override
  public Context getContext() {
    return AppContextModule_GetContextFactory.getContext(appContextModule);}

  @Override
  public CreateHabitCommandFactory getCreateHabitCommandFactory() {
    return new CreateHabitCommandFactory(getModelFactoryProvider);}

  @Override
  public EditHabitCommandFactory getEditHabitCommandFactory() {
    return new EditHabitCommandFactory(getModelFactoryProvider);}

  @Override
  public GenericImporter getGenericImporter() {
    return new GenericImporter(getHabitListProvider.get(), getLoopDBImporter(), getRewireDBImporter(), getTickmateDBImporter(), getHabitBullCSVImporter());}

  @Override
  public HabitCardListCache getHabitCardListCache() {
    return habitCardListCacheProvider.get();}

  @Override
  public HabitList getHabitList() {
    return getHabitListProvider.get();}

  @Override
  public IntentFactory getIntentFactory() {
    return new IntentFactory();}

  @Override
  public IntentParser getIntentParser() {
    return intentParserProvider.get();}

  @Override
  public MidnightTimer getMidnightTimer() {
    return midnightTimerProvider.get();}

  @Override
  public ModelFactory getModelFactory() {
    return getModelFactoryProvider.get();}

  @Override
  public NotificationTray getNotificationTray() {
    return getTrayProvider.get();}

  @Override
  public PendingIntentFactory getPendingIntentFactory() {
    return pendingIntentFactoryProvider.get();}

  @Override
  public Preferences getPreferences() {
    return getPreferencesProvider.get();}

  @Override
  public ReminderScheduler getReminderScheduler() {
    return getReminderSchedulerProvider.get();}

  @Override
  public ReminderController getReminderController() {
    return reminderControllerProvider.get();}

  @Override
  public SyncManager getSyncManager() {
    return syncManagerProvider.get();}

  @Override
  public TaskRunner getTaskRunner() {
    return provideTaskRunnerProvider.get();}

  @Override
  public WidgetPreferences getWidgetPreferences() {
    return getWidgetPreferencesProvider.get();}

  @Override
  public WidgetUpdater getWidgetUpdater() {
    return new WidgetUpdater(AppContextModule_GetContextFactory.getContext(appContextModule), commandRunnerProvider.get(), provideTaskRunnerProvider.get(), getWidgetPreferencesProvider.get());}

  public static final class Builder {
    private AppContextModule appContextModule;

    private HabitsModule habitsModule;

    private Builder() {
    }

    public Builder appContextModule(AppContextModule appContextModule) {
      this.appContextModule = Preconditions.checkNotNull(appContextModule);
      return this;
    }

    public Builder habitsModule(HabitsModule habitsModule) {
      this.habitsModule = Preconditions.checkNotNull(habitsModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder androidTaskRunner(AndroidTaskRunner androidTaskRunner) {
      Preconditions.checkNotNull(androidTaskRunner);
      return this;
    }

    public HabitsApplicationComponent build() {
      Preconditions.checkBuilderRequirement(appContextModule, AppContextModule.class);
      if (habitsModule == null) {
        this.habitsModule = new HabitsModule();
      }
      return new DaggerHabitsApplicationComponent(appContextModule, habitsModule);
    }
  }
}
