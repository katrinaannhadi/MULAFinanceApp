/* Mula */

package org.mula.finance.core.models;

public class HabitMatcher
{
    public static final HabitMatcher WITH_ALARM = new HabitMatcherBuilder()
        .setArchivedAllowed(true)
        .setReminderRequired(true)
        .build();

    private final boolean archivedAllowed;

    private final boolean reminderRequired;

    private final boolean completedAllowed;

    public HabitMatcher(boolean allowArchived,
                        boolean reminderRequired,
                        boolean completedAllowed)
    {
        this.archivedAllowed = allowArchived;
        this.reminderRequired = reminderRequired;
        this.completedAllowed = completedAllowed;
    }

    public boolean isArchivedAllowed()
    {
        return archivedAllowed;
    }

    public boolean isCompletedAllowed()
    {
        return completedAllowed;
    }

    public boolean isReminderRequired()
    {
        return reminderRequired;
    }

    public boolean matches(Habit habit)
    {
        if (!isArchivedAllowed() && habit.isArchived()) return false;
        if (isReminderRequired() && !habit.hasReminder()) return false;
        if (!isCompletedAllowed() && habit.isCompletedToday()) return false;
        return true;
    }
}
