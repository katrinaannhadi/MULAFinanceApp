package org.mula.finance.activities.habits.list.views;

import android.content.*;
import android.view.*;
import android.widget.*;
import org.mula.finance.*;
import org.mula.finance.utils.*;
import org.mula.finance.core.preferences.Preferences;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\r\u0010\u001c\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0004J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u001fH\u0016J\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000bH\u0014J\b\u0010&\u001a\u00020\u001fH$R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\'"}, d2 = {"Lorg/mula/finance/activities/habits/list/views/ButtonPanelView;", "T", "Landroid/view/View;", "Landroid/widget/LinearLayout;", "Lorg/mula/finance/core/preferences/Preferences$Listener;", "context", "Landroid/content/Context;", "preferences", "Lorg/mula/finance/core/preferences/Preferences;", "(Landroid/content/Context;Lorg/mula/finance/core/preferences/Preferences;)V", "value", "", "buttonCount", "getButtonCount", "()I", "setButtonCount", "(I)V", "buttons", "", "getButtons", "()Ljava/util/List;", "setButtons", "(Ljava/util/List;)V", "dataOffset", "getDataOffset", "setDataOffset", "getPreferences", "()Lorg/mula/finance/core/preferences/Preferences;", "createButton", "()Landroid/view/View;", "inflateButtons", "", "onAttachedToWindow", "onCheckmarkSequenceChanged", "onDetachedFromWindow", "onMeasure", "widthSpec", "heightSpec", "setupButtons", "mula-main_debug"})
public abstract class ButtonPanelView<T extends android.view.View> extends android.widget.LinearLayout implements org.mula.finance.core.preferences.Preferences.Listener {
    private int buttonCount;
    private int dataOffset;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<T> buttons;
    @org.jetbrains.annotations.NotNull()
    private final org.mula.finance.core.preferences.Preferences preferences = null;
    
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<T> getButtons() {
        return null;
    }
    
    public final void setButtons(@org.jetbrains.annotations.NotNull()
    java.util.List<T> p0) {
    }
    
    @java.lang.Override()
    public void onCheckmarkSequenceChanged() {
    }
    
    protected final synchronized void inflateButtons() {
    }
    
    @java.lang.Override()
    public void onAttachedToWindow() {
    }
    
    @java.lang.Override()
    public void onDetachedFromWindow() {
    }
    
    @java.lang.Override()
    protected void onMeasure(int widthSpec, int heightSpec) {
    }
    
    protected abstract void setupButtons();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract T createButton();
    
    @org.jetbrains.annotations.NotNull()
    public final org.mula.finance.core.preferences.Preferences getPreferences() {
        return null;
    }
    
    public ButtonPanelView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.preferences.Preferences preferences) {
        super(null);
    }
}