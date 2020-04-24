package org.mula.finance.activities.habits.list.views;

import android.content.*;
import com.google.auto.factory.*;
import org.mula.androidbase.activities.ActivityContext;
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.utils.DateUtils;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0013\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\r\u0010,\u001a\u00020\bH\u0014\u00a2\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\u0014H\u0014R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\nR$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R<\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\u001a@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020 @FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u00020\'2\u0006\u0010&\u001a\u00020\'@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lorg/mula/finance/activities/habits/list/views/NumberPanelView;", "Lorg/mula/finance/activities/habits/list/views/ButtonPanelView;", "Lorg/mula/finance/activities/habits/list/views/NumberButtonView;", "context", "Landroid/content/Context;", "preferences", "Lorg/mula/finance/core/preferences/Preferences;", "buttonFactory", "error/NonExistentClass", "(Landroid/content/Context;Lorg/mula/finance/core/preferences/Preferences;Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "value", "", "color", "getColor", "()I", "setColor", "(I)V", "Lkotlin/Function1;", "Lorg/mula/finance/core/models/Timestamp;", "", "onEdit", "getOnEdit", "()Lkotlin/jvm/functions/Function1;", "setOnEdit", "(Lkotlin/jvm/functions/Function1;)V", "", "threshold", "getThreshold", "()D", "setThreshold", "(D)V", "", "units", "getUnits", "()Ljava/lang/String;", "setUnits", "(Ljava/lang/String;)V", "values", "", "getValues", "()[D", "setValues", "([D)V", "createButton", "()Lerror/NonExistentClass;", "setupButtons", "mula-main_debug"})
@com.google.auto.factory.AutoFactory()
public final class NumberPanelView extends org.mula.finance.activities.habits.list.views.ButtonPanelView<org.mula.finance.activities.habits.list.views.NumberButtonView> {
    @org.jetbrains.annotations.NotNull()
    private double[] values;
    private double threshold;
    private int color;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String units;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super org.mula.finance.core.models.Timestamp, kotlin.Unit> onEdit;
    private final NumberButtonViewFactory buttonFactory = null;
    
    @org.jetbrains.annotations.NotNull()
    public final double[] getValues() {
        return null;
    }
    
    public final void setValues(@org.jetbrains.annotations.NotNull()
    double[] values) {
    }
    
    public final double getThreshold() {
        return 0.0;
    }
    
    public final void setThreshold(double value) {
    }
    
    public final int getColor() {
        return 0;
    }
    
    public final void setColor(int value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUnits() {
        return null;
    }
    
    public final void setUnits(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<org.mula.finance.core.models.Timestamp, kotlin.Unit> getOnEdit() {
        return null;
    }
    
    public final void setOnEdit(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super org.mula.finance.core.models.Timestamp, kotlin.Unit> value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected java.lang.Object createButton() {
        return null;
    }
    
    @java.lang.Override()
    protected synchronized void setupButtons() {
    }
    
    public NumberPanelView(@org.jetbrains.annotations.NotNull()
    @org.mula.androidbase.activities.ActivityContext()
    @com.google.auto.factory.Provided()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    @com.google.auto.factory.Provided()
    org.mula.finance.core.preferences.Preferences preferences, @org.jetbrains.annotations.NotNull()
    @com.google.auto.factory.Provided()
    NumberButtonViewFactory buttonFactory) {
        super(null, null);
    }
}