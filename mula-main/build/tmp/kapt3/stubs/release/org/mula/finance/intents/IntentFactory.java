package org.mula.finance.intents;

import android.content.*;
import android.net.*;
import org.mula.finance.activities.habits.show.*;
import org.mula.finance.activities.intro.*;
import org.mula.finance.activities.settings.*;
import org.mula.finance.core.models.Habit;
import javax.inject.*;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f\u00a8\u0006\u0010"}, d2 = {"Lorg/mula/finance/intents/IntentFactory;", "", "()V", "buildSendToIntent", "Landroid/content/Intent;", "url", "", "buildViewIntent", "openDocument", "startIntroActivity", "context", "Landroid/content/Context;", "startSettingsActivity", "startShowHabitActivity", "habit", "Lorg/mula/finance/core/models/Habit;", "uhabits-android_release"})
public final class IntentFactory {
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Intent openDocument() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Intent startIntroActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Intent startSettingsActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Intent startShowHabitActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.models.Habit habit) {
        return null;
    }
    
    private final android.content.Intent buildSendToIntent(java.lang.String url) {
        return null;
    }
    
    private final android.content.Intent buildViewIntent(java.lang.String url) {
        return null;
    }
    
    @javax.inject.Inject()
    public IntentFactory() {
        super();
    }
}