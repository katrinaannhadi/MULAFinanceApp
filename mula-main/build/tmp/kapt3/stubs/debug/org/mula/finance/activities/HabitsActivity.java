package org.mula.finance.activities;

import android.content.*;
import android.os.*;
import org.mula.finance.*;
import org.mula.androidbase.activities.ActivityContextModule;
import org.mula.androidbase.activities.BaseActivity;
import org.mula.androidbase.activities.BaseActivityModule;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lorg/mula/finance/activities/HabitsActivity;", "Lorg/mula/androidbase/activities/BaseActivity;", "()V", "appComponent", "Lorg/mula/finance/HabitsApplicationComponent;", "getAppComponent", "()Lorg/mula/finance/HabitsApplicationComponent;", "setAppComponent", "(Lorg/mula/finance/HabitsApplicationComponent;)V", "component", "Lorg/mula/finance/activities/HabitsActivityComponent;", "getComponent", "()Lorg/mula/finance/activities/HabitsActivityComponent;", "setComponent", "(Lorg/mula/finance/activities/HabitsActivityComponent;)V", "getHabitFromIntent", "Lorg/mula/finance/core/models/Habit;", "habitList", "Lorg/mula/finance/core/models/HabitList;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "mula-main_debug"})
public abstract class HabitsActivity extends org.mula.androidbase.activities.BaseActivity {
    @org.jetbrains.annotations.NotNull()
    public org.mula.finance.activities.HabitsActivityComponent component;
    @org.jetbrains.annotations.NotNull()
    public org.mula.finance.HabitsApplicationComponent appComponent;
    
    @org.jetbrains.annotations.NotNull()
    public final org.mula.finance.activities.HabitsActivityComponent getComponent() {
        return null;
    }
    
    public final void setComponent(@org.jetbrains.annotations.NotNull()
    org.mula.finance.activities.HabitsActivityComponent p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.mula.finance.HabitsApplicationComponent getAppComponent() {
        return null;
    }
    
    public final void setAppComponent(@org.jetbrains.annotations.NotNull()
    org.mula.finance.HabitsApplicationComponent p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final org.mula.finance.core.models.Habit getHabitFromIntent(org.mula.finance.core.models.HabitList habitList) {
        return null;
    }
    
    public HabitsActivity() {
        super();
    }
}