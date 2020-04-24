/* Mula */

package org.mula.finance.core.preferences;

import org.mula.finance.core.AppScope;

import javax.inject.Inject;

@AppScope
public class WidgetPreferences {
    private Preferences.Storage storage;

    @Inject
    public WidgetPreferences(Preferences.Storage storage) {
        this.storage = storage;
    }

    public void addWidget(int widgetId, long habitIds[]) {
        storage.putLongArray(getHabitIdKey(widgetId), habitIds);
    }

    public long[] getHabitIdsFromWidgetId(int widgetId) {
        long[] habitIds;
        String habitIdKey = getHabitIdKey(widgetId);
        try {
            habitIds = storage.getLongArray(habitIdKey, new long[]{-1});
        } catch (ClassCastException e) {
            // Up to Loop 1.7.11, this preference was not an array, but a single
            // long. Trying to read the old preference causes a cast exception.
            habitIds = new long[1];
            habitIds[0] = storage.getLong(habitIdKey, -1);
            storage.putLongArray(habitIdKey, habitIds);
        }
        return habitIds;
    }

    public void removeWidget(int id) {
        String habitIdKey = getHabitIdKey(id);
        storage.remove(habitIdKey);
    }

    public long getSnoozeTime(long id)
    {
        return storage.getLong(getSnoozeKey(id), 0);
    }

    private String getHabitIdKey(int id) {
        return String.format("widget-%06d-habit", id);
    }

    private String getSnoozeKey(long id)
    {
        return String.format("snooze-%06d", id);
    }

    public void removeSnoozeTime(long id)
    {
        storage.putLong(getSnoozeKey(id), 0);
    }

    public void setSnoozeTime(Long id, long time)
    {
        storage.putLong(getSnoozeKey(id), time);
    }
}
