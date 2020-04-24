package org.mula.finance.activities.habits.list.views;

import android.content.*;
import android.os.*;
import android.text.*;
import android.view.*;
import android.widget.*;
import com.google.auto.factory.*;
import org.mula.finance.*;
import org.mula.finance.activities.common.views.*;
import org.mula.finance.utils.*;
import org.mula.androidbase.activities.ActivityContext;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.ModelObservable;
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior;
import org.mula.finance.core.utils.DateUtils;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0019H\u0002J\b\u0010?\u001a\u00020=H\u0014J\b\u0010@\u001a\u00020=H\u0014J\b\u0010A\u001a\u00020=H\u0016J\u0010\u0010B\u001a\u00020=2\u0006\u0010C\u001a\u00020DH\u0016J\u0018\u0010E\u001a\u00020=2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020GH\u0002J\u000e\u0010E\u001a\u00020=2\u0006\u0010I\u001a\u00020JJ\u0010\u0010K\u001a\u00020=2\u0006\u0010C\u001a\u00020DH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0014R$\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0014R$\u0010&\u001a\u00020%2\u0006\u0010\u000b\u001a\u00020%8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010-\u001a\u00020%2\u0006\u0010\u000b\u001a\u00020%8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b.\u0010(\"\u0004\b/\u0010*R$\u00101\u001a\u0002002\u0006\u0010\u000b\u001a\u0002008F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00106\u001a\u0002072\u0006\u00106\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010;\u00a8\u0006L"}, d2 = {"Lorg/mula/finance/activities/habits/list/views/HabitCardView;", "Landroid/widget/FrameLayout;", "Lorg/mula/finance/core/models/ModelObservable$Listener;", "context", "Landroid/content/Context;", "checkmarkPanelFactory", "error/NonExistentClass", "numberPanelFactory", "behavior", "Lorg/mula/finance/core/ui/screens/habits/list/ListHabitsBehavior;", "(Landroid/content/Context;Lerror/NonExistentClass;Lerror/NonExistentClass;Lorg/mula/finance/core/ui/screens/habits/list/ListHabitsBehavior;)V", "value", "", "buttonCount", "getButtonCount", "()I", "setButtonCount", "(I)V", "checkmarkPanel", "Lorg/mula/finance/activities/habits/list/views/CheckmarkPanelView;", "Lerror/NonExistentClass;", "dataOffset", "getDataOffset", "setDataOffset", "newHabit", "Lorg/mula/finance/core/models/Habit;", "habit", "getHabit", "()Lorg/mula/finance/core/models/Habit;", "setHabit", "(Lorg/mula/finance/core/models/Habit;)V", "innerFrame", "Landroid/widget/LinearLayout;", "label", "Landroid/widget/TextView;", "numberPanel", "Lorg/mula/finance/activities/habits/list/views/NumberPanelView;", "", "score", "getScore", "()D", "setScore", "(D)V", "scoreRing", "Lorg/mula/finance/activities/common/views/RingView;", "threshold", "getThreshold", "setThreshold", "", "unit", "getUnit", "()Ljava/lang/String;", "setUnit", "(Ljava/lang/String;)V", "values", "", "getValues", "()[I", "setValues", "([I)V", "copyAttributesFrom", "", "h", "onAttachedToWindow", "onDetachedFromWindow", "onModelChange", "setSelected", "isSelected", "", "triggerRipple", "x", "", "y", "timestamp", "Lorg/mula/finance/core/models/Timestamp;", "updateBackground", "mula-main_debug"})
@com.google.auto.factory.AutoFactory()
public final class HabitCardView extends android.widget.FrameLayout implements org.mula.finance.core.models.ModelObservable.Listener {
    private int dataOffset;
    @org.jetbrains.annotations.Nullable()
    private org.mula.finance.core.models.Habit habit;
    private org.mula.finance.activities.habits.list.views.CheckmarkPanelView checkmarkPanel;
    private org.mula.finance.activities.habits.list.views.NumberPanelView numberPanel;
    private android.widget.LinearLayout innerFrame;
    private android.widget.TextView label;
    private org.mula.finance.activities.common.views.RingView scoreRing;
    private final CheckmarkPanelViewFactory checkmarkPanelFactory = null;
    private final NumberPanelViewFactory numberPanelFactory = null;
    private final org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior behavior = null;
    
    public final int getButtonCount() {
        return 0;
    }
    
    public final void setButtonCount(int value) {
    }
    
    public final int getDataOffset() {
        return 0;
    }
    
    public final void setDataOffset(int value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.mula.finance.core.models.Habit getHabit() {
        return null;
    }
    
    public final void setHabit(@org.jetbrains.annotations.Nullable()
    org.mula.finance.core.models.Habit newHabit) {
    }
    
    public final double getScore() {
        return 0.0;
    }
    
    public final void setScore(double value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUnit() {
        return null;
    }
    
    public final void setUnit(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final int[] getValues() {
        return null;
    }
    
    public final void setValues(@org.jetbrains.annotations.NotNull()
    int[] values) {
    }
    
    public final double getThreshold() {
        return 0.0;
    }
    
    public final void setThreshold(double value) {
    }
    
    @java.lang.Override()
    public void onModelChange() {
    }
    
    @java.lang.Override()
    public void setSelected(boolean isSelected) {
    }
    
    public final void triggerRipple(@org.jetbrains.annotations.NotNull()
    org.mula.finance.core.models.Timestamp timestamp) {
    }
    
    @java.lang.Override()
    protected void onAttachedToWindow() {
    }
    
    @java.lang.Override()
    protected void onDetachedFromWindow() {
    }
    
    private final void copyAttributesFrom(org.mula.finance.core.models.Habit h) {
    }
    
    private final void triggerRipple(float x, float y) {
    }
    
    private final void updateBackground(boolean isSelected) {
    }
    
    public HabitCardView(@org.jetbrains.annotations.NotNull()
    @org.mula.androidbase.activities.ActivityContext()
    @com.google.auto.factory.Provided()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    @com.google.auto.factory.Provided()
    CheckmarkPanelViewFactory checkmarkPanelFactory, @org.jetbrains.annotations.NotNull()
    @com.google.auto.factory.Provided()
    NumberPanelViewFactory numberPanelFactory, @org.jetbrains.annotations.NotNull()
    @com.google.auto.factory.Provided()
    org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior behavior) {
        super(null);
    }
}