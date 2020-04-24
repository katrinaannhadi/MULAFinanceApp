/* Mula */

package org.mula.finance.activities.common.dialogs;

import android.content.*;

import org.mula.finance.R;
import org.mula.finance.utils.*;
import org.mula.androidbase.activities.ActivityContext;
import org.mula.androidbase.activities.ActivityScope;
import org.mula.androidbase.utils.StyledResources;

import javax.inject.*;

@ActivityScope
public class ColorPickerDialogFactory
{
    private final Context context;

    @Inject
    public ColorPickerDialogFactory(@ActivityContext Context context)
    {
        this.context = context;
    }

    public ColorPickerDialog create(int paletteColor)
    {
        ColorPickerDialog dialog = new ColorPickerDialog();
        StyledResources res = new StyledResources(context);
        int color = PaletteUtils.getColor(context, paletteColor);

        dialog.initialize(R.string.color_picker_default_title, res.getPalette(),
            color, 4, com.android.colorpicker.ColorPickerDialog.SIZE_SMALL);

        return dialog;
    }
}
