/* Mula */

package org.mula.finance.activities.habits.edit.views;

import android.content.*;
import android.content.res.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.mula.finance.R;
import org.mula.finance.activities.common.views.*;
import org.mula.finance.utils.*;
import org.mula.finance.core.models.Habit;

import butterknife.*;


public class NameDescriptionPanel extends FrameLayout
{
    @BindView(R.id.tvName)
    EditText tvName;

    @BindView(R.id.tvQuestion)
    ExampleEditText tvQuestion;

    @BindView(R.id.tvDescription)
    ExampleEditText tvDescription;

    private int color;

    @NonNull
    private Controller controller;

    public NameDescriptionPanel(@NonNull Context context,
                                @Nullable AttributeSet attrs)
    {
        super(context, attrs);

        View view = inflate(context, R.layout.edit_habit_name, null);
        ButterKnife.bind(this, view);
        addView(view);

        controller = new Controller() {};
    }

    public int getColor()
    {
        return color;
    }

    public void setColor(int color)
    {
        this.color = color;
        tvName.setTextColor(PaletteUtils.getColor(getContext(), color));
    }

    @NonNull
    public String getDescription()
    {
        return tvDescription.getRealText().trim();
    }

    @NonNull
    public String getQuestion()
    {
        return tvQuestion.getRealText().trim();
    }

    @NonNull
    public String getName()
    {
        return tvName.getText().toString().trim();
    }

    public void populateFrom(@NonNull Habit habit)
    {
        Resources res = getResources();

        if(habit.isNumerical())
            tvQuestion.setExample(res.getString(R.string.example_question_numerical));
        else
            tvQuestion.setExample(res.getString(R.string.example_question_boolean));

        setColor(habit.getColor());
        tvName.setText(habit.getName());
        tvQuestion.setRealText(habit.getQuestion());
        tvDescription.setRealText(habit.getDescription());
    }

    public boolean validate()
    {
        Resources res = getResources();

        if (getName().isEmpty())
        {
            tvName.setError(
                res.getString(R.string.validation_name_should_not_be_blank));
            return false;
        }

        return true;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state)
    {
        BundleSavedState bss = (BundleSavedState) state;
        setColor(bss.bundle.getInt("color"));
        super.onRestoreInstanceState(bss.getSuperState());
    }

    @Override
    protected Parcelable onSaveInstanceState()
    {
        Parcelable superState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putInt("color", color);
        return new BundleSavedState(superState, bundle);
    }

    @OnClick(R.id.buttonPickColor)
    void showColorPicker()
    {
        controller.onColorPickerClicked(color);
    }

    public void setController(@NonNull Controller controller)
    {
        this.controller = controller;
    }

    public interface Controller
    {
        /**
         * Called when the user has clicked the widget to select a new
         * color for the habit.
         *
         * @param previousColor the color previously selected
         */
        default void onColorPickerClicked(int previousColor) {}
    }
}
