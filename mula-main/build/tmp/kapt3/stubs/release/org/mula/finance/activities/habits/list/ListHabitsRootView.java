package org.mula.finance.activities.habits.list;

import android.content.*;
import androidx.appcompat.widget.Toolbar;
import android.widget.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import org.mula.androidbase.activities.*;
import org.mula.finance.*;
import org.mula.finance.activities.common.views.*;
import org.mula.finance.activities.habits.list.views.*;
import org.mula.finance.core.models.*;
import org.mula.finance.core.preferences.*;
import org.mula.finance.core.tasks.*;
import org.mula.finance.core.ui.screens.habits.list.*;
import org.mula.finance.core.utils.*;
import org.mula.finance.utils.*;
import javax.inject.*;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BA\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J\b\u0010.\u001a\u00020\u0013H\u0016J\b\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020+H\u0016J\b\u00102\u001a\u000203H\u0014J\b\u00104\u001a\u000203H\u0014J\b\u00105\u001a\u000203H\u0016J(\u00106\u001a\u0002032\u0006\u00107\u001a\u0002002\u0006\u00108\u001a\u0002002\u0006\u00109\u001a\u0002002\u0006\u0010:\u001a\u000200H\u0014J\b\u0010;\u001a\u000203H\u0002J\b\u0010<\u001a\u000203H\u0002R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\'\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020+\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-\u00a8\u0006="}, d2 = {"Lorg/mula/finance/activities/habits/list/ListHabitsRootView;", "Lorg/mula/androidbase/activities/BaseRootView;", "Lorg/mula/finance/core/models/ModelObservable$Listener;", "context", "Landroid/content/Context;", "hintListFactory", "Lorg/mula/finance/core/ui/screens/habits/list/HintListFactory;", "preferences", "Lorg/mula/finance/core/preferences/Preferences;", "midnightTimer", "Lorg/mula/finance/core/utils/MidnightTimer;", "runner", "Lorg/mula/finance/core/tasks/TaskRunner;", "listAdapter", "Lorg/mula/finance/activities/habits/list/views/HabitCardListAdapter;", "habitCardListViewFactory", "error/NonExistentClass", "(Landroid/content/Context;Lorg/mula/finance/core/ui/screens/habits/list/HintListFactory;Lorg/mula/finance/core/preferences/Preferences;Lorg/mula/finance/core/utils/MidnightTimer;Lorg/mula/finance/core/tasks/TaskRunner;Lorg/mula/finance/activities/habits/list/views/HabitCardListAdapter;Lerror/NonExistentClass;)V", "bmenu", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "getBmenu", "()Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "header", "Lorg/mula/finance/activities/habits/list/views/HeaderView;", "getHeader", "()Lorg/mula/finance/activities/habits/list/views/HeaderView;", "hintView", "Lorg/mula/finance/activities/habits/list/views/HintView;", "getHintView", "()Lorg/mula/finance/activities/habits/list/views/HintView;", "listView", "Lorg/mula/finance/activities/habits/list/views/HabitCardListView;", "getListView", "()Lorg/mula/finance/activities/habits/list/views/HabitCardListView;", "llEmpty", "Lorg/mula/finance/activities/habits/list/views/EmptyListView;", "getLlEmpty", "()Lorg/mula/finance/activities/habits/list/views/EmptyListView;", "progressBar", "Lorg/mula/finance/activities/common/views/TaskProgressBar;", "getProgressBar", "()Lorg/mula/finance/activities/common/views/TaskProgressBar;", "tbar", "Landroidx/appcompat/widget/Toolbar;", "getTbar", "()Landroidx/appcompat/widget/Toolbar;", "getBottomNav", "getCheckmarkCount", "", "getToolbar", "onAttachedToWindow", "", "onDetachedFromWindow", "onModelChange", "onSizeChanged", "w", "h", "oldw", "oldh", "setupControllers", "updateEmptyView", "uhabits-android_release"})
@org.mula.androidbase.activities.ActivityScope()
public final class ListHabitsRootView extends org.mula.androidbase.activities.BaseRootView implements org.mula.finance.core.models.ModelObservable.Listener {
    @org.jetbrains.annotations.NotNull()
    private final org.mula.finance.activities.habits.list.views.HabitCardListView listView = null;
    @org.jetbrains.annotations.NotNull()
    private final org.mula.finance.activities.habits.list.views.EmptyListView llEmpty = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.appcompat.widget.Toolbar tbar = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.android.material.bottomnavigation.BottomNavigationView bmenu = null;
    @org.jetbrains.annotations.NotNull()
    private final org.mula.finance.activities.common.views.TaskProgressBar progressBar = null;
    @org.jetbrains.annotations.NotNull()
    private final org.mula.finance.activities.habits.list.views.HintView hintView = null;
    @org.jetbrains.annotations.NotNull()
    private final org.mula.finance.activities.habits.list.views.HeaderView header = null;
    private final org.mula.finance.activities.habits.list.views.HabitCardListAdapter listAdapter = null;
    
    @org.jetbrains.annotations.NotNull()
    public final org.mula.finance.activities.habits.list.views.HabitCardListView getListView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.mula.finance.activities.habits.list.views.EmptyListView getLlEmpty() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.widget.Toolbar getTbar() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.material.bottomnavigation.BottomNavigationView getBmenu() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.mula.finance.activities.common.views.TaskProgressBar getProgressBar() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.mula.finance.activities.habits.list.views.HintView getHintView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.mula.finance.activities.habits.list.views.HeaderView getHeader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.appcompat.widget.Toolbar getToolbar() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.google.android.material.bottomnavigation.BottomNavigationView getBottomNav() {
        return null;
    }
    
    @java.lang.Override()
    public void onModelChange() {
    }
    
    private final void setupControllers() {
    }
    
    @java.lang.Override()
    protected void onAttachedToWindow() {
    }
    
    @java.lang.Override()
    protected void onDetachedFromWindow() {
    }
    
    @java.lang.Override()
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    }
    
    private final int getCheckmarkCount() {
        return 0;
    }
    
    private final void updateEmptyView() {
    }
    
    @javax.inject.Inject()
    public ListHabitsRootView(@org.jetbrains.annotations.NotNull()
    @org.mula.androidbase.activities.ActivityContext()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.ui.screens.habits.list.HintListFactory hintListFactory, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.preferences.Preferences preferences, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.utils.MidnightTimer midnightTimer, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.tasks.TaskRunner runner, @org.jetbrains.annotations.NotNull()
    org.mula.finance.activities.habits.list.views.HabitCardListAdapter listAdapter, @org.jetbrains.annotations.NotNull()
    HabitCardListViewFactory habitCardListViewFactory) {
        super(null);
    }
}