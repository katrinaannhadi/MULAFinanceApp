/* Mula */

package org.mula.finance.activities.common.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import org.mula.finance.R;
import org.mula.finance.core.models.WeekdayList;
import org.mula.finance.core.utils.DateUtils;

import java.util.Calendar;

/**
 * Dialog that allows the user to pick one or more days of the week.
 */
public class WeekdayPickerDialog extends AppCompatDialogFragment implements
                                                                 DialogInterface.OnMultiChoiceClickListener,
                                                                 DialogInterface.OnClickListener
{
    private static final String KEY_SELECTED_DAYS = "selectedDays";
    private boolean[] selectedDays;

    private OnWeekdaysPickedListener listener;

    @Override
    public void onClick(DialogInterface dialog, int which, boolean isChecked)
    {
        selectedDays[which] = isChecked;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null){
            selectedDays = savedInstanceState.getBooleanArray(KEY_SELECTED_DAYS);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBooleanArray(KEY_SELECTED_DAYS, selectedDays);
    }

    @Override
    public void onClick(DialogInterface dialog, int which)
    {
        if (listener != null)
            listener.onWeekdaysSet(new WeekdayList(selectedDays));
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder
            .setTitle(R.string.select_weekdays)
            .setMultiChoiceItems(DateUtils.getLongWeekdayNames(Calendar.SATURDAY),
                    selectedDays,
                    this)
            .setPositiveButton(android.R.string.yes, this)
            .setNegativeButton(android.R.string.cancel, (dialog, which) -> {
                dismiss();
            });

        return builder.create();
    }

    public void setListener(OnWeekdaysPickedListener listener)
    {
        this.listener = listener;
    }

    public void setSelectedDays(WeekdayList days)
    {
        this.selectedDays = days.toArray();
    }

    public interface OnWeekdaysPickedListener
    {
        void onWeekdaysSet(WeekdayList days);
    }
}
