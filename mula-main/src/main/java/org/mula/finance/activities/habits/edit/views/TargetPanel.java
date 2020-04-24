/* Mula */

package org.mula.finance.activities.habits.edit.views;

import android.content.*;
import android.content.res.*;
import android.util.*;
import android.view.*;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.mula.finance.R;

import java.text.DecimalFormat;

import butterknife.*;


public class TargetPanel extends FrameLayout
{
    private DecimalFormat valueFormatter = new DecimalFormat("#.##");

    @BindView(R.id.tvUnit)
    ExampleEditText tvUnit;

    @BindView(R.id.tvTargetCount)
    TextView tvTargetValue;

    public TargetPanel(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);

        View view = inflate(context, R.layout.edit_habit_target, null);
        ButterKnife.bind(this, view);
        addView(view);
    }

    public double getTargetValue()
    {
        String sValue = tvTargetValue.getText().toString();
        return Double.parseDouble(sValue);
    }

    public void setTargetValue(double targetValue)
    {
        tvTargetValue.setText(valueFormatter.format(targetValue));
    }

    public String getUnit()
    {
        return tvUnit.getRealText();
    }

    public void setUnit(String unit)
    {
        tvUnit.setRealText(unit);
    }

    public boolean validate()
    {
        Resources res = getResources();
        String sValue = tvTargetValue.getText().toString();
        double value = Double.parseDouble(sValue);

        if (value <= 0)
        {
            tvTargetValue.setError(
                res.getString(R.string.validation_number_should_be_positive));
            return false;
        }

        return true;
    }
}
