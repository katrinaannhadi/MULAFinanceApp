package org.mula.finance.intents;

import android.content.*;
import android.net.*;
import org.mula.finance.core.AppScope;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.Timestamp;
import org.mula.finance.core.utils.DateUtils;
import javax.inject.*;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000fB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lorg/mula/finance/intents/IntentParser;", "", "habits", "Lorg/mula/finance/core/models/HabitList;", "(Lorg/mula/finance/core/models/HabitList;)V", "parseCheckmarkIntent", "Lorg/mula/finance/intents/IntentParser$CheckmarkIntentData;", "intent", "Landroid/content/Intent;", "parseHabit", "Lorg/mula/finance/core/models/Habit;", "uri", "Landroid/net/Uri;", "parseTimestamp", "Lorg/mula/finance/core/models/Timestamp;", "CheckmarkIntentData", "mula-main_debug"})
@org.mula.finance.core.AppScope()
public final class IntentParser {
    private final org.mula.finance.core.models.HabitList habits = null;
    
    @org.jetbrains.annotations.NotNull()
    public final org.mula.finance.intents.IntentParser.CheckmarkIntentData parseCheckmarkIntent(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
        return null;
    }
    
    private final org.mula.finance.core.models.Habit parseHabit(android.net.Uri uri) {
        return null;
    }
    
    private final org.mula.finance.core.models.Timestamp parseTimestamp(android.content.Intent intent) {
        return null;
    }
    
    @javax.inject.Inject()
    public IntentParser(@org.jetbrains.annotations.NotNull()
    org.mula.finance.core.models.HabitList habits) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lorg/mula/finance/intents/IntentParser$CheckmarkIntentData;", "", "habit", "Lorg/mula/finance/core/models/Habit;", "timestamp", "Lorg/mula/finance/core/models/Timestamp;", "(Lorg/mula/finance/core/models/Habit;Lorg/mula/finance/core/models/Timestamp;)V", "getHabit", "()Lorg/mula/finance/core/models/Habit;", "setHabit", "(Lorg/mula/finance/core/models/Habit;)V", "getTimestamp", "()Lorg/mula/finance/core/models/Timestamp;", "setTimestamp", "(Lorg/mula/finance/core/models/Timestamp;)V", "mula-main_debug"})
    public static final class CheckmarkIntentData {
        @org.jetbrains.annotations.NotNull()
        private org.mula.finance.core.models.Habit habit;
        @org.jetbrains.annotations.NotNull()
        private org.mula.finance.core.models.Timestamp timestamp;
        
        @org.jetbrains.annotations.NotNull()
        public final org.mula.finance.core.models.Habit getHabit() {
            return null;
        }
        
        public final void setHabit(@org.jetbrains.annotations.NotNull()
        org.mula.finance.core.models.Habit p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.mula.finance.core.models.Timestamp getTimestamp() {
            return null;
        }
        
        public final void setTimestamp(@org.jetbrains.annotations.NotNull()
        org.mula.finance.core.models.Timestamp p0) {
        }
        
        public CheckmarkIntentData(@org.jetbrains.annotations.NotNull()
        org.mula.finance.core.models.Habit habit, @org.jetbrains.annotations.NotNull()
        org.mula.finance.core.models.Timestamp timestamp) {
            super();
        }
    }
}