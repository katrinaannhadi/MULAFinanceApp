package org.mula.finance.activities.habits.list.views;

import android.animation.*;
import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;
import org.mula.finance.*;
import org.mula.finance.utils.*;
import org.mula.finance.core.ui.screens.habits.list.HintList;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0006\u0010\u000e\u001a\u00020\fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lorg/mula/finance/activities/habits/list/views/HintView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "hintList", "Lorg/mula/finance/core/ui/screens/habits/list/HintList;", "(Landroid/content/Context;Lorg/mula/finance/core/ui/screens/habits/list/HintList;)V", "hintContent", "Landroid/widget/TextView;", "getHintContent", "()Landroid/widget/TextView;", "dismiss", "", "onAttachedToWindow", "showNext", "DismissAnimator", "uhabits-android_release"})
public final class HintView extends android.widget.LinearLayout {
    @org.jetbrains.annotations.NotNull()
    private final android.widget.TextView hintContent = null;
    private final org.mula.finance.core.ui.screens.habits.list.HintList hintList = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getHintContent() {
        return null;
    }
    
    @java.lang.Override()
    public void onAttachedToWindow() {
    }
    
    public final void showNext() {
    }
    
    private final void dismiss() {
    }
    
    public HintView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.ui.screens.habits.list.HintList hintList) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lorg/mula/finance/activities/habits/list/views/HintView$DismissAnimator;", "Landroid/animation/AnimatorListenerAdapter;", "(Lorg/mula/finance/activities/habits/list/views/HintView;)V", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "uhabits-android_release"})
    final class DismissAnimator extends android.animation.AnimatorListenerAdapter {
        
        @java.lang.Override()
        public void onAnimationEnd(@org.jetbrains.annotations.NotNull()
        android.animation.Animator animation) {
        }
        
        public DismissAnimator() {
            super();
        }
    }
}