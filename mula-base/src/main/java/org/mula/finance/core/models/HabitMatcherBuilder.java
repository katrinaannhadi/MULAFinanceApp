/* Mula */

package org.mula.finance.core.models;

public class HabitMatcherBuilder
{
    private boolean archivedAllowed = false;

    private boolean reminderRequired = false;

    private boolean completedAllowed = true;

    public HabitMatcher build()
    {
        return new HabitMatcher(archivedAllowed, reminderRequired,
            completedAllowed);
    }

    public HabitMatcherBuilder setArchivedAllowed(boolean archivedAllowed)
    {
        this.archivedAllowed = archivedAllowed;
        return this;
    }

    public HabitMatcherBuilder setCompletedAllowed(boolean completedAllowed)
    {
        this.completedAllowed = completedAllowed;
        return this;
    }

    public HabitMatcherBuilder setReminderRequired(boolean reminderRequired)
    {
        this.reminderRequired = reminderRequired;
        return this;
    }
}