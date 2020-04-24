/* Mula */

package org.mula.finance.activities.habits.show;

import androidx.annotation.NonNull;

import org.mula.finance.*;
import org.mula.finance.activities.common.dialogs.*;
import org.mula.finance.activities.habits.edit.*;
import org.mula.androidbase.activities.ActivityScope;
import org.mula.androidbase.activities.BaseActivity;
import org.mula.androidbase.activities.BaseScreen;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.ui.callbacks.OnConfirmedCallback;
import org.mula.finance.core.ui.screens.habits.show.ShowHabitBehavior;
import org.mula.finance.core.ui.screens.habits.show.ShowHabitMenuBehavior;

import javax.inject.*;

import dagger.*;

@ActivityScope
public class ShowHabitScreen extends BaseScreen
    implements ShowHabitMenuBehavior.Screen,
               ShowHabitBehavior.Screen,
               HistoryEditorDialog.Controller,
               ShowHabitRootView.Controller
{
    @NonNull
    private final Habit habit;

    @NonNull
    private final EditHabitDialogFactory editHabitDialogFactory;

    @NonNull
    private final ConfirmDeleteDialogFactory confirmDeleteDialogFactory;

    private final Lazy<ShowHabitBehavior> behavior;

    @Inject
    public ShowHabitScreen(@NonNull BaseActivity activity,
                           @NonNull Habit habit,
                           @NonNull ShowHabitRootView view,
                           @NonNull ShowHabitsMenu menu,
                           @NonNull EditHabitDialogFactory editHabitDialogFactory,
                           @NonNull ConfirmDeleteDialogFactory confirmDeleteDialogFactory,
                           @NonNull Lazy<ShowHabitBehavior> behavior)
    {
        super(activity);
        setMenu(menu);
        setRootView(view);

        this.habit = habit;
        this.behavior = behavior;
        this.editHabitDialogFactory = editHabitDialogFactory;
        this.confirmDeleteDialogFactory = confirmDeleteDialogFactory;
        view.setController(this);
    }

    @Override
    public void onEditHistoryButtonClick()
    {
        behavior.get().onEditHistory();
    }

    @Override
    public void onToggleCheckmark(Timestamp timestamp)
    {
        behavior.get().onToggleCheckmark(timestamp);
    }

    @Override
    public void onToolbarChanged()
    {
        invalidateToolbar();
    }

    @Override
    public void reattachDialogs()
    {
        super.reattachDialogs();
        HistoryEditorDialog historyEditor = (HistoryEditorDialog) activity
            .getSupportFragmentManager()
            .findFragmentByTag("historyEditor");
        if (historyEditor != null) historyEditor.setController(this);
    }

    @Override
    public void showEditHabitScreen(@NonNull Habit habit)
    {
        activity.showDialog(editHabitDialogFactory.edit(habit), "editHabit");
    }

    @Override
    public void showEditHistoryScreen()
    {
        HistoryEditorDialog dialog = new HistoryEditorDialog();
        dialog.setHabit(habit);
        dialog.setController(this);
        dialog.show(activity.getSupportFragmentManager(), "historyEditor");
    }

    @Override
    public void showMessage(ShowHabitMenuBehavior.Message m)
    {
        switch (m)
        {
            case COULD_NOT_EXPORT:
                showMessage(R.string.could_not_export);

            case HABIT_DELETED:
                showMessage(R.string.delete_habits_message);
        }
    }

    @Override
    public void showDeleteConfirmationScreen(@NonNull OnConfirmedCallback callback) {
        activity.showDialog(confirmDeleteDialogFactory.create(callback));
    }

    @Override
    public void close() {
        activity.finish();
    }
}
