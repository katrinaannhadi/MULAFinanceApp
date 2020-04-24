package org.mula.finance.utils;

import android.graphics.*;
import androidx.annotation.*;
import androidx.appcompat.widget.Toolbar;
import android.view.*;
import android.widget.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import org.mula.finance.*;
import org.mula.androidbase.utils.InterfaceUtils;
import org.mula.androidbase.utils.StyledResources;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a&\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n\u001a&\u0010\f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n\u001aS\u0010\r\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2#\b\u0002\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00060\u0010\u001a\n\u0010\u0015\u001a\u00020\u0016*\u00020\u0017\u001a\n\u0010\u0018\u001a\u00020\u0019*\u00020\u0017\u001a\u0012\u0010\u001a\u001a\u00020\u001b*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\n\u001a\u0012\u0010\u001d\u001a\u00020\u001b*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001b\u001a\n\u0010\u001f\u001a\u00020 *\u00020\u0002\u001a\n\u0010!\u001a\u00020\"*\u00020\u0002\u001a\u0014\u0010#\u001a\u00020\u0006*\u00020\u00022\b\b\u0001\u0010$\u001a\u00020\n\u001a\u0012\u0010%\u001a\u00020\u001b*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001b\u001a\u0012\u0010&\u001a\u00020\'*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\n\u001a\u0012\u0010(\u001a\u00020\n*\u00020\u001b2\u0006\u0010)\u001a\u00020\n\u001a\u0012\u0010(\u001a\u00020\n*\u00020\n2\u0006\u0010)\u001a\u00020\n\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006*"}, d2 = {"sres", "Lorg/mula/androidbase/utils/StyledResources;", "Landroid/view/View;", "getSres", "(Landroid/view/View;)Lorg/mula/androidbase/utils/StyledResources;", "addAtBottom", "", "Landroid/widget/RelativeLayout;", "view", "width", "", "height", "addAtTop", "addBelow", "subject", "applyCustomRules", "Lkotlin/Function1;", "Landroid/widget/RelativeLayout$LayoutParams;", "Lkotlin/ParameterName;", "name", "params", "buildBottomNav", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "Landroid/view/ViewGroup;", "buildToolbar", "Landroidx/appcompat/widget/Toolbar;", "dim", "", "id", "dp", "value", "getFontAwesome", "Landroid/graphics/Typeface;", "isRTL", "", "showMessage", "stringId", "sp", "str", "", "toMeasureSpec", "mode", "uhabits-android_release"})
public final class ViewExtensionsKt {
    
    public static final void addBelow(@org.jetbrains.annotations.NotNull()
    android.widget.RelativeLayout $receiver, @org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    android.view.View subject, int width, int height, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.widget.RelativeLayout.LayoutParams, kotlin.Unit> applyCustomRules) {
    }
    
    public static final void addAtBottom(@org.jetbrains.annotations.NotNull()
    android.widget.RelativeLayout $receiver, @org.jetbrains.annotations.NotNull()
    android.view.View view, int width, int height) {
    }
    
    public static final void addAtTop(@org.jetbrains.annotations.NotNull()
    android.widget.RelativeLayout $receiver, @org.jetbrains.annotations.NotNull()
    android.view.View view, int width, int height) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final androidx.appcompat.widget.Toolbar buildToolbar(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup $receiver) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.google.android.material.bottomnavigation.BottomNavigationView buildBottomNav(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup $receiver) {
        return null;
    }
    
    public static final void showMessage(@org.jetbrains.annotations.NotNull()
    android.view.View $receiver, @androidx.annotation.StringRes()
    int stringId) {
    }
    
    public static final int toMeasureSpec(int $receiver, int mode) {
        return 0;
    }
    
    public static final int toMeasureSpec(float $receiver, int mode) {
        return 0;
    }
    
    public static final boolean isRTL(@org.jetbrains.annotations.NotNull()
    android.view.View $receiver) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.graphics.Typeface getFontAwesome(@org.jetbrains.annotations.NotNull()
    android.view.View $receiver) {
        return null;
    }
    
    public static final float dim(@org.jetbrains.annotations.NotNull()
    android.view.View $receiver, int id) {
        return 0.0F;
    }
    
    public static final float sp(@org.jetbrains.annotations.NotNull()
    android.view.View $receiver, float value) {
        return 0.0F;
    }
    
    public static final float dp(@org.jetbrains.annotations.NotNull()
    android.view.View $receiver, float value) {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String str(@org.jetbrains.annotations.NotNull()
    android.view.View $receiver, int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final org.mula.androidbase.utils.StyledResources getSres(@org.jetbrains.annotations.NotNull()
    android.view.View $receiver) {
        return null;
    }
}