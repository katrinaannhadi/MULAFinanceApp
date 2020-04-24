/* Mula */

package org.mula.finance;

import android.content.*;

import org.mula.androidbase.*;

import org.mula.androidbase.*;
import org.mula.finance.core.*;
import org.mula.finance.core.commands.*;
import org.mula.finance.core.io.*;
import org.mula.finance.core.models.*;
import org.mula.finance.core.preferences.*;
import org.mula.finance.core.reminders.*;
import org.mula.finance.core.tasks.*;
import org.mula.finance.core.ui.*;
import org.mula.finance.core.ui.screens.habits.list.*;
import org.mula.finance.core.utils.*;
import org.mula.finance.intents.*;
import org.mula.finance.receivers.*;
import org.mula.finance.sync.*;
import org.mula.finance.tasks.*;
import org.mula.finance.widgets.*;

import dagger.*;

@AppScope
@Component(modules = {
    AppContextModule.class,
    HabitsModule.class,
    AndroidTaskRunner.class,
})
public interface HabitsApplicationComponent
{
    CommandRunner getCommandRunner();

    @AppContext
    Context getContext();

    CreateHabitCommandFactory getCreateHabitCommandFactory();

    EditHabitCommandFactory getEditHabitCommandFactory();

    GenericImporter getGenericImporter();

    HabitCardListCache getHabitCardListCache();

    HabitList getHabitList();

    IntentFactory getIntentFactory();

    IntentParser getIntentParser();

    MidnightTimer getMidnightTimer();

    ModelFactory getModelFactory();

    NotificationTray getNotificationTray();

    PendingIntentFactory getPendingIntentFactory();

    Preferences getPreferences();

    ReminderScheduler getReminderScheduler();

    ReminderController getReminderController();

    SyncManager getSyncManager();

    TaskRunner getTaskRunner();

    WidgetPreferences getWidgetPreferences();

    WidgetUpdater getWidgetUpdater();
}
