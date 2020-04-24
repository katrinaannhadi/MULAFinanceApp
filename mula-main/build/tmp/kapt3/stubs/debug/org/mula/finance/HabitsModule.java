package org.mula.finance;

import org.mula.finance.database.*;
import org.mula.finance.intents.*;
import org.mula.finance.notifications.*;
import org.mula.finance.preferences.*;
import org.mula.finance.utils.*;
import org.mula.finance.core.AppScope;
import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.database.DatabaseOpener;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.ModelFactory;
import org.mula.finance.core.models.sqlite.SQLModelFactory;
import org.mula.finance.core.models.sqlite.SQLiteHabitList;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.preferences.WidgetPreferences;
import org.mula.finance.core.reminders.ReminderScheduler;
import org.mula.finance.core.tasks.TaskRunner;
import org.mula.finance.core.ui.NotificationTray;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J(\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u00a8\u0006\""}, d2 = {"Lorg/mula/finance/HabitsModule;", "", "()V", "getDatabaseOpener", "Lorg/mula/finance/core/database/DatabaseOpener;", "opener", "Lorg/mula/finance/database/AndroidDatabaseOpener;", "getHabitList", "Lorg/mula/finance/core/models/HabitList;", "list", "Lorg/mula/finance/core/models/sqlite/SQLiteHabitList;", "getModelFactory", "Lorg/mula/finance/core/models/ModelFactory;", "getPreferences", "Lorg/mula/finance/core/preferences/Preferences;", "storage", "Lorg/mula/finance/preferences/SharedPreferencesStorage;", "getReminderScheduler", "Lorg/mula/finance/core/reminders/ReminderScheduler;", "sys", "Lorg/mula/finance/intents/IntentScheduler;", "commandRunner", "Lorg/mula/finance/core/commands/CommandRunner;", "habitList", "widgetPreferences", "Lorg/mula/finance/core/preferences/WidgetPreferences;", "getTray", "Lorg/mula/finance/core/ui/NotificationTray;", "taskRunner", "Lorg/mula/finance/core/tasks/TaskRunner;", "preferences", "screen", "Lorg/mula/finance/notifications/AndroidNotificationTray;", "getWidgetPreferences", "mula-main_debug"})
@dagger.Module()
public final class HabitsModule {
    
    @org.jetbrains.annotations.NotNull()
    @org.mula.finance.core.AppScope()
    @dagger.Provides()
    public final org.mula.finance.core.preferences.Preferences getPreferences(@org.jetbrains.annotations.NotNull()
    org.mula.finance.preferences.SharedPreferencesStorage storage) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.mula.finance.core.AppScope()
    @dagger.Provides()
    public final org.mula.finance.core.reminders.ReminderScheduler getReminderScheduler(@org.jetbrains.annotations.NotNull()
    org.mula.finance.intents.IntentScheduler sys, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.commands.CommandRunner commandRunner, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.models.HabitList habitList, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.preferences.WidgetPreferences widgetPreferences) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.mula.finance.core.AppScope()
    @dagger.Provides()
    public final org.mula.finance.core.ui.NotificationTray getTray(@org.jetbrains.annotations.NotNull()
    org.mula.finance.core.tasks.TaskRunner taskRunner, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.commands.CommandRunner commandRunner, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.preferences.Preferences preferences, @org.jetbrains.annotations.NotNull()
    org.mula.finance.notifications.AndroidNotificationTray screen) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.mula.finance.core.AppScope()
    @dagger.Provides()
    public final org.mula.finance.core.preferences.WidgetPreferences getWidgetPreferences(@org.jetbrains.annotations.NotNull()
    org.mula.finance.preferences.SharedPreferencesStorage storage) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.mula.finance.core.AppScope()
    @dagger.Provides()
    public final org.mula.finance.core.models.ModelFactory getModelFactory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.mula.finance.core.AppScope()
    @dagger.Provides()
    public final org.mula.finance.core.models.HabitList getHabitList(@org.jetbrains.annotations.NotNull()
    org.mula.finance.core.models.sqlite.SQLiteHabitList list) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.mula.finance.core.AppScope()
    @dagger.Provides()
    public final org.mula.finance.core.database.DatabaseOpener getDatabaseOpener(@org.jetbrains.annotations.NotNull()
    org.mula.finance.database.AndroidDatabaseOpener opener) {
        return null;
    }
    
    public HabitsModule() {
        super();
    }
}