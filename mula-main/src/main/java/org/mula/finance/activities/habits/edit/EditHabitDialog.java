/* Mula */

package org.mula.finance.activities.habits.edit;

import android.app.*;
import android.content.*;
import android.os.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.*;
import android.text.format.*;
import android.view.*;

import com.android.datetimepicker.time.TimePickerDialog;

import org.mula.finance.*;
import org.mula.finance.R;
import org.mula.finance.activities.*;
import org.mula.finance.activities.common.dialogs.*;
import org.mula.finance.activities.habits.edit.views.*;
import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.models.Frequency;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.ModelFactory;
import org.mula.finance.core.models.WeekdayList;
import org.mula.finance.core.preferences.Preferences;

import butterknife.*;

import static android.view.View.*;

public class EditHabitDialog extends AppCompatDialogFragment
{
    public static final String BUNDLE_HABIT_ID = "habitId";

    public static final String BUNDLE_HABIT_TYPE = "habitType";

    private static final String WEEKDAY_PICKER_TAG = "weekdayPicker";

    protected Habit originalHabit;

    protected Preferences prefs;

    protected CommandRunner commandRunner;

    protected HabitList habitList;

    protected HabitsApplicationComponent component;

    protected ModelFactory modelFactory;

    @BindView(R.id.namePanel)
    NameDescriptionPanel namePanel;

    @BindView(R.id.reminderPanel)
    ReminderPanel reminderPanel;

    @BindView(R.id.frequencyPanel)
    FrequencyPanel frequencyPanel;

    @BindView(R.id.targetPanel)
    TargetPanel targetPanel;

    private ColorPickerDialogFactory colorPickerDialogFactory;

    @Override
    public int getTheme()
    {
        HabitsActivity activity = (HabitsActivity) getActivity();
        return activity.getComponent().getThemeSwitcher().getDialogTheme();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        HabitsActivity activity = (HabitsActivity) getActivity();
        colorPickerDialogFactory =
            activity.getComponent().getColorPickerDialogFactory();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view;
        view = inflater.inflate(R.layout.edit_habit, container, false);

        initDependencies();
        ButterKnife.bind(this, view);

        originalHabit = parseHabitFromArguments();
        getDialog().setTitle(getTitle());

        populateForm();
        setupReminderController();
        setupNameController();

        restoreChildFragmentListeners();

        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialog = super.onCreateDialog(savedInstanceState);
        final Window window = dialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        }
        return dialog;
    }

    protected int getTitle()
    {
        if (originalHabit != null) return R.string.edit_habit;
        else return R.string.create_habit;
    }

    protected void saveHabit(@NonNull Habit habit)
    {
        if (originalHabit == null)
        {
            commandRunner.execute(component
                .getCreateHabitCommandFactory()
                .create(habitList, habit), null);
        }
        else
        {
            commandRunner.execute(component.getEditHabitCommandFactory().
                create(habitList, originalHabit, habit), originalHabit.getId());
        }
    }

    private int getTypeFromArguments()
    {
        return getArguments().getInt(BUNDLE_HABIT_TYPE);
    }

    private void initDependencies()
    {
        Context appContext = getContext().getApplicationContext();
        HabitsApplication app = (HabitsApplication) appContext;

        component = app.getComponent();
        prefs = component.getPreferences();
        habitList = component.getHabitList();
        commandRunner = component.getCommandRunner();
        modelFactory = component.getModelFactory();
    }

    @OnClick(R.id.buttonDiscard)
    void onButtonDiscardClick()
    {
        dismiss();
    }

    @OnClick(R.id.buttonSave)
    void onSaveButtonClick()
    {
        int type = getTypeFromArguments();

        if (!namePanel.validate()) return;
        if (type == Habit.YES_NO_HABIT && !frequencyPanel.validate()) return;
        if (type == Habit.NUMBER_HABIT && !targetPanel.validate()) return;

        Habit habit = modelFactory.buildHabit();
        if( originalHabit != null )
            habit.copyFrom(originalHabit);
        habit.setName(namePanel.getName());
        habit.setDescription(namePanel.getDescription());
        habit.setQuestion(namePanel.getQuestion());
        habit.setColor(namePanel.getColor());
        habit.setReminder(reminderPanel.getReminder());
        habit.setFrequency(frequencyPanel.getFrequency());
        habit.setUnit(targetPanel.getUnit());
        habit.setTargetValue(targetPanel.getTargetValue());
        habit.setType(type);

        saveHabit(habit);
        dismiss();
    }

    @Nullable
    private Habit parseHabitFromArguments()
    {
        Bundle arguments = getArguments();
        if (arguments == null) return null;

        Long id = (Long) arguments.get(BUNDLE_HABIT_ID);
        if (id == null) return null;

        Habit habit = habitList.getById(id);
        if (habit == null) throw new IllegalStateException();

        return habit;
    }

    private void populateForm()
    {
        Habit habit = modelFactory.buildHabit();
        habit.setFrequency(Frequency.DAILY);
        habit.setColor(prefs.getDefaultHabitColor(habit.getColor()));
        habit.setType(getTypeFromArguments());

        if (originalHabit != null) habit.copyFrom(originalHabit);

        if (habit.isNumerical()) frequencyPanel.setVisibility(GONE);
        else targetPanel.setVisibility(GONE);

        namePanel.populateFrom(habit);
        frequencyPanel.setFrequency(habit.getFrequency());
        targetPanel.setTargetValue(habit.getTargetValue());
        targetPanel.setUnit(habit.getUnit());
        if (habit.hasReminder()) reminderPanel.setReminder(habit.getReminder());
    }

    private void setupNameController()
    {
        namePanel.setController(new NameDescriptionPanel.Controller()
        {
            @Override
            public void onColorPickerClicked(int previousColor)
            {
                ColorPickerDialog picker =
                    colorPickerDialogFactory.create(previousColor);

                picker.setListener(c ->
                {
                    prefs.setDefaultHabitColor(c);
                    namePanel.setColor(c);
                });

                picker.show(getFragmentManager(), "picker");
            }
        });
    }

    private void setupReminderController()
    {
        reminderPanel.setController(new ReminderPanel.Controller()
        {
            @Override
            public void onTimeClicked(int currentHour, int currentMin)
            {
                TimePickerDialog timePicker;
                boolean is24HourMode = DateFormat.is24HourFormat(getContext());
                timePicker =
                    TimePickerDialog.newInstance(reminderPanel, currentHour,
                        currentMin, is24HourMode);
                timePicker.show(getFragmentManager(), "timePicker");
            }

            @Override
            public void onWeekdayClicked(WeekdayList currentDays)
            {
                WeekdayPickerDialog dialog = new WeekdayPickerDialog();
                dialog.setListener(reminderPanel);
                dialog.setSelectedDays(currentDays);
                dialog.show(getChildFragmentManager(), WEEKDAY_PICKER_TAG);
            }
        });
    }

    private void restoreChildFragmentListeners()
    {
        final WeekdayPickerDialog dialog =
                (WeekdayPickerDialog) getChildFragmentManager()
                        .findFragmentByTag(WEEKDAY_PICKER_TAG);
        if(dialog != null) dialog.setListener(reminderPanel);
    }
}
