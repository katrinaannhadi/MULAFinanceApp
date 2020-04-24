/* Mula */

package org.mula.finance.receivers;

import android.content.*;
import android.util.*;

import org.mula.finance.*;
import org.mula.finance.core.preferences.*;
import org.mula.finance.core.ui.widgets.*;
import org.mula.finance.intents.*;
import org.mula.finance.sync.*;

import dagger.*;

/**
 * The Android BroadcastReceiver for Loop Habit Tracker.
 * <p>
 * All broadcast messages are received and processed by this class.
 */
public class WidgetReceiver extends BroadcastReceiver
{
    public static final String ACTION_ADD_REPETITION =
            "org.mula.finance.ACTION_ADD_REPETITION";

    public static final String ACTION_DISMISS_REMINDER =
            "org.mula.finance.ACTION_DISMISS_REMINDER";

    public static final String ACTION_REMOVE_REPETITION =
            "org.mula.finance.ACTION_REMOVE_REPETITION";

    public static final String ACTION_TOGGLE_REPETITION =
            "org.mula.finance.ACTION_TOGGLE_REPETITION";

    private static final String TAG = "WidgetReceiver";

    @Override
    public void onReceive(final Context context, Intent intent)
    {
        HabitsApplication app =
                (HabitsApplication) context.getApplicationContext();

        WidgetComponent component = DaggerWidgetReceiver_WidgetComponent
                .builder()
                .habitsApplicationComponent(app.getComponent())
                .build();

        IntentParser parser = app.getComponent().getIntentParser();
        WidgetBehavior controller = component.getWidgetController();
        Preferences prefs = app.getComponent().getPreferences();

        Log.i(TAG, String.format("Received intent: %s", intent.toString()));

        if (prefs.isSyncEnabled())
            context.startService(new Intent(context, SyncService.class));

        try
        {
            IntentParser.CheckmarkIntentData data;
            data = parser.parseCheckmarkIntent(intent);

            switch (intent.getAction())
            {
                case ACTION_ADD_REPETITION:
                    Log.d(TAG, String.format(
                            "onAddRepetition habit=%d timestamp=%d",
                            data.getHabit().getId(),
                            data.getTimestamp().getUnixTime()));
                    controller.onAddRepetition(data.getHabit(),
                            data.getTimestamp());
                    break;

                case ACTION_TOGGLE_REPETITION:
                    Log.d(TAG, String.format(
                            "onToggleRepetition habit=%d timestamp=%d",
                            data.getHabit().getId(),
                            data.getTimestamp().getUnixTime()));
                    controller.onToggleRepetition(data.getHabit(),
                            data.getTimestamp());
                    break;

                case ACTION_REMOVE_REPETITION:
                    Log.d(TAG, String.format(
                            "onRemoveRepetition habit=%d timestamp=%d",
                            data.getHabit().getId(),
                            data.getTimestamp().getUnixTime()));
                    controller.onRemoveRepetition(data.getHabit(),
                            data.getTimestamp());
                    break;
            }
        }
        catch (RuntimeException e)
        {
            Log.e("WidgetReceiver", "could not process intent", e);
        }
    }

    @ReceiverScope
    @Component(dependencies = HabitsApplicationComponent.class)
    interface WidgetComponent
    {
        WidgetBehavior getWidgetController();
    }
}
