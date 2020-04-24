package org.mula.finance.activities.habits.list.views;

import android.content.*;
import android.graphics.*;
import android.text.*;
import org.mula.finance.*;
import org.mula.finance.activities.common.views.*;
import org.mula.finance.utils.*;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.utils.MidnightTimer;
import java.util.*;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001$B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0014J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0018\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\fH\u0014J\b\u0010#\u001a\u00020\u0019H\u0002R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00060\u0013R\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006%"}, d2 = {"Lorg/mula/finance/activities/habits/list/views/HeaderView;", "Lorg/mula/finance/activities/common/views/ScrollableChart;", "Lorg/mula/finance/core/preferences/Preferences$Listener;", "Lorg/mula/finance/core/utils/MidnightTimer$MidnightListener;", "context", "Landroid/content/Context;", "prefs", "Lorg/mula/finance/core/preferences/Preferences;", "midnightTimer", "Lorg/mula/finance/core/utils/MidnightTimer;", "(Landroid/content/Context;Lorg/mula/finance/core/preferences/Preferences;Lorg/mula/finance/core/utils/MidnightTimer;)V", "value", "", "buttonCount", "getButtonCount", "()I", "setButtonCount", "(I)V", "drawer", "Lorg/mula/finance/activities/habits/list/views/HeaderView$Drawer;", "getMidnightTimer", "()Lorg/mula/finance/core/utils/MidnightTimer;", "getPrefs", "()Lorg/mula/finance/core/preferences/Preferences;", "atMidnight", "", "onAttachedToWindow", "onCheckmarkSequenceChanged", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "updateScrollDirection", "Drawer", "mula-main_debug"})
public final class HeaderView extends org.mula.finance.activities.common.views.ScrollableChart implements org.mula.finance.core.preferences.Preferences.Listener, org.mula.finance.core.utils.MidnightTimer.MidnightListener {
    private org.mula.finance.activities.habits.list.views.HeaderView.Drawer drawer;
    private int buttonCount;
    @org.jetbrains.annotations.NotNull()
    private final org.mula.finance.core.preferences.Preferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final org.mula.finance.core.utils.MidnightTimer midnightTimer = null;
    
    public final int getButtonCount() {
        return 0;
    }
    
    public final void setButtonCount(int value) {
    }
    
    @java.lang.Override()
    public void atMidnight() {
    }
    
    @java.lang.Override()
    public void onCheckmarkSequenceChanged() {
    }
    
    @java.lang.Override()
    protected void onAttachedToWindow() {
    }
    
    @java.lang.Override()
    protected void onDetachedFromWindow() {
    }
    
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    @java.lang.Override()
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    }
    
    private final void updateScrollDirection() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.mula.finance.core.preferences.Preferences getPrefs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.mula.finance.core.utils.MidnightTimer getMidnightTimer() {
        return null;
    }
    
    public HeaderView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.preferences.Preferences prefs, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.utils.MidnightTimer midnightTimer) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lorg/mula/finance/activities/habits/list/views/HeaderView$Drawer;", "", "(Lorg/mula/finance/activities/habits/list/views/HeaderView;)V", "paint", "Landroid/text/TextPaint;", "rect", "Landroid/graphics/RectF;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "mula-main_debug"})
    final class Drawer {
        private final android.graphics.RectF rect = null;
        private final android.text.TextPaint paint = null;
        
        public final void draw(@org.jetbrains.annotations.NotNull()
        android.graphics.Canvas canvas) {
        }
        
        public Drawer() {
            super();
        }
    }
}