/* Mula */

package org.mula.finance.activities.common.dialogs;

import android.content.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.*;

import com.google.auto.factory.*;

import org.mula.finance.R;
import org.mula.androidbase.activities.ActivityContext;
import org.mula.finance.core.ui.callbacks.OnConfirmedCallback;

import butterknife.*;

/**
 * Dialog that asks the user confirmation before executing a delete operation.
 */
@AutoFactory(allowSubclasses = true)
public class ConfirmDeleteDialog extends AlertDialog
{
    @BindString(R.string.delete_habits_message)
    protected String question;

    @BindString(android.R.string.yes)
    protected String yes;

    @BindString(android.R.string.no)
    protected String no;

    protected ConfirmDeleteDialog(@Provided @ActivityContext Context context,
                                  @NonNull OnConfirmedCallback callback)
    {
        super(context);
        ButterKnife.bind(this);

        setTitle(R.string.delete_habits);
        setMessage(question);
        setButton(BUTTON_POSITIVE, yes, (dialog, which) -> callback.onConfirmed());
        setButton(BUTTON_NEGATIVE, no, (dialog, which) -> {});
    }
}
