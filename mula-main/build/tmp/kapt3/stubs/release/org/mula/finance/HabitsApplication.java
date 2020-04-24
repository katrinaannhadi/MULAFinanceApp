package org.mula.finance;

import android.app.*;
import android.content.*;
import org.mula.finance.utils.*;
import org.mula.finance.widgets.*;
import org.mula.androidbase.AppContextModule;
import org.mula.finance.core.database.UnsupportedDatabaseVersionException;
import org.mula.finance.core.reminders.ReminderScheduler;
import org.mula.finance.core.ui.NotificationTray;
import java.io.*;

/**
 * The Android application for Loop Habit Tracker.
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lorg/mula/finance/HabitsApplication;", "Landroid/app/Application;", "()V", "component", "Lorg/mula/finance/HabitsApplicationComponent;", "getComponent", "()Lorg/mula/finance/HabitsApplicationComponent;", "context", "Landroid/content/Context;", "notificationTray", "Lorg/mula/finance/core/ui/NotificationTray;", "reminderScheduler", "Lorg/mula/finance/core/reminders/ReminderScheduler;", "widgetUpdater", "Lorg/mula/finance/widgets/WidgetUpdater;", "onCreate", "", "onTerminate", "Companion", "uhabits-android_release"})
public final class HabitsApplication extends android.app.Application {
    private android.content.Context context;
    private org.mula.finance.widgets.WidgetUpdater widgetUpdater;
    private org.mula.finance.core.reminders.ReminderScheduler reminderScheduler;
    private org.mula.finance.core.ui.NotificationTray notificationTray;
    @org.jetbrains.annotations.NotNull()
    public static org.mula.finance.HabitsApplicationComponent component;
    public static final org.mula.finance.HabitsApplication.Companion Companion = null;
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    public void onTerminate() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.mula.finance.HabitsApplicationComponent getComponent() {
        return null;
    }
    
    public HabitsApplication() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lorg/mula/finance/HabitsApplication$Companion;", "", "()V", "component", "Lorg/mula/finance/HabitsApplicationComponent;", "getComponent", "()Lorg/mula/finance/HabitsApplicationComponent;", "setComponent", "(Lorg/mula/finance/HabitsApplicationComponent;)V", "isTestMode", "", "uhabits-android_release"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final org.mula.finance.HabitsApplicationComponent getComponent() {
            return null;
        }
        
        public final void setComponent(@org.jetbrains.annotations.NotNull()
        org.mula.finance.HabitsApplicationComponent p0) {
        }
        
        public final boolean isTestMode() {
            return false;
        }
        
        private Companion() {
            super();
        }
    }
}