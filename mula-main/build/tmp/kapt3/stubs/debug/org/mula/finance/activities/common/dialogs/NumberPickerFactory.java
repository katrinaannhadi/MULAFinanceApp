package org.mula.finance.activities.common.dialogs;

import android.content.*;
import androidx.appcompat.app.*;
import android.text.*;
import android.view.*;
import android.view.inputmethod.*;
import android.widget.*;
import org.mula.finance.*;
import org.mula.androidbase.activities.ActivityContext;
import org.mula.androidbase.utils.InterfaceUtils;
import org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior;
import javax.inject.*;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lorg/mula/finance/activities/common/dialogs/NumberPickerFactory;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "create", "Landroidx/appcompat/app/AlertDialog;", "value", "", "unit", "", "callback", "Lorg/mula/finance/core/ui/screens/habits/list/ListHabitsBehavior$NumberPickerCallback;", "refreshInitialValue", "", "picker", "Landroid/widget/NumberPicker;", "mula-main_debug"})
public final class NumberPickerFactory {
    private final android.content.Context context = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.app.AlertDialog create(double value, @org.jetbrains.annotations.NotNull()
    java.lang.String unit, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior.NumberPickerCallback callback) {
        return null;
    }
    
    private final void refreshInitialValue(android.widget.NumberPicker picker) {
    }
    
    @javax.inject.Inject()
    public NumberPickerFactory(@org.jetbrains.annotations.NotNull()
    @org.mula.androidbase.activities.ActivityContext()
    android.content.Context context) {
        super();
    }
}