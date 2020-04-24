/* Mula */

package org.mula.finance.activities.common.dialogs;

import org.mula.finance.utils.*;
import org.mula.finance.core.ui.callbacks.OnColorPickedCallback;

/**
 * Dialog that allows the user to choose a color.
 */
public class ColorPickerDialog extends com.android.colorpicker.ColorPickerDialog
{
    public void setListener(OnColorPickedCallback callback)
    {
        super.setOnColorSelectedListener(c ->
        {
            c = PaletteUtils.colorToPaletteIndex(getContext(), c);
            callback.onColorPicked(c);
        });
    }
}
