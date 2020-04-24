package org.mula.finance.activities.habits.list;

import android.view.*;
import org.mula.finance.*;
import org.mula.androidbase.activities.ActivityScope;
import org.mula.androidbase.activities.BaseActivity;
import org.mula.androidbase.activities.BaseMenu;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.ui.ThemeSwitcher;
import org.mula.finance.core.ui.screens.habits.list.ListHabitsMenuBehavior;
import javax.inject.*;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lorg/mula/finance/activities/habits/list/ListHabitsMenu;", "Lorg/mula/androidbase/activities/BaseMenu;", "activity", "Lorg/mula/androidbase/activities/BaseActivity;", "preferences", "Lorg/mula/finance/core/preferences/Preferences;", "themeSwitcher", "Lorg/mula/finance/core/ui/ThemeSwitcher;", "behavior", "Lorg/mula/finance/core/ui/screens/habits/list/ListHabitsMenuBehavior;", "(Lorg/mula/androidbase/activities/BaseActivity;Lorg/mula/finance/core/preferences/Preferences;Lorg/mula/finance/core/ui/ThemeSwitcher;Lorg/mula/finance/core/ui/screens/habits/list/ListHabitsMenuBehavior;)V", "getMenuResourceId", "", "onCreate", "", "menu", "Landroid/view/Menu;", "onItemSelected", "", "item", "Landroid/view/MenuItem;", "uhabits-android_release"})
@org.mula.androidbase.activities.ActivityScope()
public final class ListHabitsMenu extends org.mula.androidbase.activities.BaseMenu {
    private final org.mula.finance.core.preferences.Preferences preferences = null;
    private final org.mula.finance.core.ui.ThemeSwitcher themeSwitcher = null;
    private final org.mula.finance.core.ui.screens.habits.list.ListHabitsMenuBehavior behavior = null;
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
    }
    
    @java.lang.Override()
    public boolean onItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    protected int getMenuResourceId() {
        return 0;
    }
    
    @javax.inject.Inject()
    public ListHabitsMenu(@org.jetbrains.annotations.NotNull()
    org.mula.androidbase.activities.BaseActivity activity, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.preferences.Preferences preferences, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.ui.ThemeSwitcher themeSwitcher, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.ui.screens.habits.list.ListHabitsMenuBehavior behavior) {
        super(null);
    }
}