package org.mula.finance.widgets;

import android.app.*;
import android.content.*;
import android.os.*;
import android.widget.*;
import org.mula.finance.*;
import org.mula.finance.core.preferences.WidgetPreferences;
import java.util.*;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lorg/mula/finance/widgets/HabitPickerDialog;", "Landroid/app/Activity;", "()V", "widgetId", "", "widgetPreferences", "Lorg/mula/finance/core/preferences/WidgetPreferences;", "widgetUpdater", "Lorg/mula/finance/widgets/WidgetUpdater;", "confirm", "", "selectedIds", "", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "mula-main_debug"})
public final class HabitPickerDialog extends android.app.Activity {
    private int widgetId;
    private org.mula.finance.core.preferences.WidgetPreferences widgetPreferences;
    private org.mula.finance.widgets.WidgetUpdater widgetUpdater;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void confirm(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Long> selectedIds) {
    }
    
    public HabitPickerDialog() {
        super();
    }
}