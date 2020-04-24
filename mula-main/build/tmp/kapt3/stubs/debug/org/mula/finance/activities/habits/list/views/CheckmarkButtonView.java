package org.mula.finance.activities.habits.list.views;

import android.content.*;
import android.graphics.*;
import android.text.*;
import android.view.*;
import com.google.auto.factory.*;
import org.mula.finance.*;
import org.mula.finance.utils.*;
import org.mula.androidbase.activities.ActivityContext;
import org.mula.finance.core.preferences.Preferences;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001(B\u0019\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0001H\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0014J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u0001H\u0016J\u0018\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0014J\u0006\u0010\'\u001a\u00020\u0014R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00060\u0011R\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR$\u0010\t\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000f\u00a8\u0006)"}, d2 = {"Lorg/mula/finance/activities/habits/list/views/CheckmarkButtonView;", "Landroid/view/View;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "context", "Landroid/content/Context;", "preferences", "Lorg/mula/finance/core/preferences/Preferences;", "(Landroid/content/Context;Lorg/mula/finance/core/preferences/Preferences;)V", "value", "", "color", "getColor", "()I", "setColor", "(I)V", "drawer", "Lorg/mula/finance/activities/habits/list/views/CheckmarkButtonView$Drawer;", "onToggle", "Lkotlin/Function0;", "", "getOnToggle", "()Lkotlin/jvm/functions/Function0;", "setOnToggle", "(Lkotlin/jvm/functions/Function0;)V", "getPreferences", "()Lorg/mula/finance/core/preferences/Preferences;", "getValue", "setValue", "onClick", "v", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLongClick", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "performToggle", "Drawer", "mula-main_debug"})
@com.google.auto.factory.AutoFactory()
public final class CheckmarkButtonView extends android.view.View implements android.view.View.OnClickListener, android.view.View.OnLongClickListener {
    private int color;
    private int value;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onToggle;
    private org.mula.finance.activities.habits.list.views.CheckmarkButtonView.Drawer drawer;
    @org.jetbrains.annotations.NotNull()
    private final org.mula.finance.core.preferences.Preferences preferences = null;
    
    public final int getColor() {
        return 0;
    }
    
    public final void setColor(int value) {
    }
    
    public final int getValue() {
        return 0;
    }
    
    public final void setValue(int value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnToggle() {
        return null;
    }
    
    public final void setOnToggle(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    public final void performToggle() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    @java.lang.Override()
    public boolean onLongClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
        return false;
    }
    
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    @java.lang.Override()
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.mula.finance.core.preferences.Preferences getPreferences() {
        return null;
    }
    
    public CheckmarkButtonView(@org.jetbrains.annotations.NotNull()
    @org.mula.androidbase.activities.ActivityContext()
    @com.google.auto.factory.Provided()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    @com.google.auto.factory.Provided()
    org.mula.finance.core.preferences.Preferences preferences) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lorg/mula/finance/activities/habits/list/views/CheckmarkButtonView$Drawer;", "", "(Lorg/mula/finance/activities/habits/list/views/CheckmarkButtonView;)V", "lowContrastColor", "", "paint", "Landroid/text/TextPaint;", "rect", "Landroid/graphics/RectF;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "mula-main_debug"})
    final class Drawer {
        private final android.graphics.RectF rect = null;
        private final int lowContrastColor = 0;
        private final android.text.TextPaint paint = null;
        
        public final void draw(@org.jetbrains.annotations.NotNull()
        android.graphics.Canvas canvas) {
        }
        
        public Drawer() {
            super();
        }
    }
}