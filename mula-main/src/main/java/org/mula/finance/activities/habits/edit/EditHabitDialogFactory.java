/* Mula */

package org.mula.finance.activities.habits.edit;

import android.os.*;

import androidx.annotation.NonNull;

import org.mula.finance.core.models.Habit;

import javax.inject.*;

import static org.mula.finance.activities.habits.edit.EditHabitDialog.*;

public class EditHabitDialogFactory
{
    @Inject
    public EditHabitDialogFactory()
    {
    }

    public EditHabitDialog createBoolean()
    {
        EditHabitDialog dialog = new EditHabitDialog();
        Bundle args = new Bundle();
        args.putInt(BUNDLE_HABIT_TYPE, Habit.YES_NO_HABIT);
        dialog.setArguments(args);
        return dialog;
    }

    public EditHabitDialog createNumerical()
    {
        EditHabitDialog dialog = new EditHabitDialog();
        Bundle args = new Bundle();
        args.putInt(BUNDLE_HABIT_TYPE, Habit.NUMBER_HABIT);
        dialog.setArguments(args);
        return dialog;
    }

    public EditHabitDialog edit(@NonNull Habit habit)
    {
        if (habit.getId() == null)
            throw new IllegalArgumentException("habit not saved");

        EditHabitDialog dialog = new EditHabitDialog();
        Bundle args = new Bundle();
        args.putLong(BUNDLE_HABIT_ID, habit.getId());
        args.putInt(BUNDLE_HABIT_TYPE, habit.getType());
        dialog.setArguments(args);
        return dialog;
    }
}
