package org.mula.finance.activities.habits.list.views;

import android.content.*;
import com.google.auto.factory.*;
import org.mula.androidbase.activities.ActivityContext;
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.utils.DateUtils;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010 \u001a\u00020\u0002H\u0014J\b\u0010!\u001a\u00020\u0014H\u0014R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\nR$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R<\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006\""}, d2 = {"Lorg/mula/finance/activities/habits/list/views/CheckmarkPanelView;", "Lorg/mula/finance/activities/habits/list/views/ButtonPanelView;", "Lorg/mula/finance/activities/habits/list/views/CheckmarkButtonView;", "context", "Landroid/content/Context;", "preferences", "Lorg/mula/finance/core/preferences/Preferences;", "buttonFactory", "error/NonExistentClass", "(Landroid/content/Context;Lorg/mula/finance/core/preferences/Preferences;Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "value", "", "color", "getColor", "()I", "setColor", "(I)V", "Lkotlin/Function1;", "Lorg/mula/finance/core/models/Timestamp;", "", "onToggle", "getOnToggle", "()Lkotlin/jvm/functions/Function1;", "setOnToggle", "(Lkotlin/jvm/functions/Function1;)V", "values", "", "getValues", "()[I", "setValues", "([I)V", "createButton", "setupButtons", "uhabits-android_release"})
@com.google.auto.factory.AutoFactory()
public final class CheckmarkPanelView extends org.mula.finance.activities.habits.list.views.ButtonPanelView<org.mula.finance.activities.habits.list.views.CheckmarkButtonView> {
    @org.jetbrains.annotations.NotNull()
    private int[] values;
    private int color;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super org.mula.finance.core.models.Timestamp, kotlin.Unit> onToggle;
    private final CheckmarkButtonViewFactory buttonFactory = null;
    
    @org.jetbrains.annotations.NotNull()
    public final int[] getValues() {
        return null;
    }
    
    public final void setValues(@org.jetbrains.annotations.NotNull()
    int[] values) {
    }
    
    public final int getColor() {
        return 0;
    }
    
    public final void setColor(int value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<org.mula.finance.core.models.Timestamp, kotlin.Unit> getOnToggle() {
        return null;
    }
    
    public final void setOnToggle(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super org.mula.finance.core.models.Timestamp, kotlin.Unit> value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected org.mula.finance.activities.habits.list.views.CheckmarkButtonView createButton() {
        return null;
    }
    
    @java.lang.Override()
    protected synchronized void setupButtons() {
    }
    
    public CheckmarkPanelView(@org.jetbrains.annotations.NotNull()
    @org.mula.androidbase.activities.ActivityContext()
    @com.google.auto.factory.Provided()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    @com.google.auto.factory.Provided()
    org.mula.finance.core.preferences.Preferences preferences, @org.jetbrains.annotations.NotNull()
    @com.google.auto.factory.Provided()
    CheckmarkButtonViewFactory buttonFactory) {
        super(null, null);
    }
}