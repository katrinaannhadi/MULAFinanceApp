/* Mula */

package org.mula.finance.core.ui.screens.habits.list;

import androidx.annotation.*;

import com.google.auto.factory.*;

import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.utils.DateUtils;

/**
 * Provides a list of hints to be shown at the application startup, and takes
 * care of deciding when a new hint should be shown.
 */
@AutoFactory
public class HintList
{
    private final Preferences prefs;

    @NonNull
    private final String[] hints;

    /**
     * Constructs a new list containing the provided hints.
     *
     * @param hints initial list of hints
     */
    public HintList(@Provided @NonNull Preferences prefs,
                    @NonNull String hints[])
    {
        this.prefs = prefs;
        this.hints = hints;
    }

    /**
     * Returns a new hint to be shown to the user.
     * <p>
     * The hint returned is marked as read on the list, and will not be returned
     * again. In case all hints have already been read, and there is nothing
     * left, returns null.
     *
     * @return the next hint to be shown, or null if none
     */
    public String pop()
    {
        int next = prefs.getLastHintNumber() + 1;
        if (next >= hints.length) return null;

        prefs.updateLastHint(next, DateUtils.getToday());
        return hints[next];
    }

    /**
     * Returns whether it is time to show a new hint or not.
     *
     * @return true if hint should be shown, false otherwise
     */
    public boolean shouldShow()
    {
        Timestamp today = DateUtils.getToday();
        Timestamp lastHintTimestamp = prefs.getLastHintTimestamp();
        return (lastHintTimestamp.isOlderThan(today));
    }
}
