package org.mula.finance.intents;

import android.app.*;
import android.content.*;
import android.net.*;
import org.mula.finance.receivers.*;
import org.mula.androidbase.AppContext;
import org.mula.finance.core.AppScope;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.Timestamp;
import javax.inject.*;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ%\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\u0012\u00a2\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001d\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lorg/mula/finance/intents/PendingIntentFactory;", "", "context", "Landroid/content/Context;", "intentFactory", "Lorg/mula/finance/intents/IntentFactory;", "(Landroid/content/Context;Lorg/mula/finance/intents/IntentFactory;)V", "addCheckmark", "Landroid/app/PendingIntent;", "habit", "Lorg/mula/finance/core/models/Habit;", "timestamp", "Lorg/mula/finance/core/models/Timestamp;", "dismissNotification", "removeRepetition", "showHabit", "showReminder", "reminderTime", "", "(Lorg/mula/finance/core/models/Habit;Ljava/lang/Long;J)Landroid/app/PendingIntent;", "snoozeNotification", "toggleCheckmark", "(Lorg/mula/finance/core/models/Habit;Ljava/lang/Long;)Landroid/app/PendingIntent;", "mula-main_debug"})
@org.mula.finance.core.AppScope()
public final class PendingIntentFactory {
    private final android.content.Context context = null;
    private final org.mula.finance.intents.IntentFactory intentFactory = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.PendingIntent addCheckmark(@org.jetbrains.annotations.NotNull()
    org.mula.finance.core.models.Habit habit, @org.jetbrains.annotations.Nullable()
    org.mula.finance.core.models.Timestamp timestamp) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.PendingIntent dismissNotification(@org.jetbrains.annotations.NotNull()
    org.mula.finance.core.models.Habit habit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.PendingIntent removeRepetition(@org.jetbrains.annotations.NotNull()
    org.mula.finance.core.models.Habit habit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.PendingIntent showHabit(@org.jetbrains.annotations.NotNull()
    org.mula.finance.core.models.Habit habit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.PendingIntent showReminder(@org.jetbrains.annotations.NotNull()
    org.mula.finance.core.models.Habit habit, @org.jetbrains.annotations.Nullable()
    java.lang.Long reminderTime, long timestamp) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.PendingIntent snoozeNotification(@org.jetbrains.annotations.NotNull()
    org.mula.finance.core.models.Habit habit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.PendingIntent toggleCheckmark(@org.jetbrains.annotations.NotNull()
    org.mula.finance.core.models.Habit habit, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp) {
        return null;
    }
    
    @javax.inject.Inject()
    public PendingIntentFactory(@org.jetbrains.annotations.NotNull()
    @org.mula.androidbase.AppContext()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    org.mula.finance.intents.IntentFactory intentFactory) {
        super();
    }
}