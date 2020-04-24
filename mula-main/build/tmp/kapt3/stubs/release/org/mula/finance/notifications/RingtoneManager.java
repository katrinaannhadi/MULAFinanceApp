package org.mula.finance.notifications;

import android.content.*;
import android.net.*;
import android.preference.*;
import android.provider.*;
import org.mula.finance.R;
import org.mula.androidbase.AppContext;
import org.mula.finance.core.AppScope;
import javax.inject.*;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u0004\u0018\u00010\nJ\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lorg/mula/finance/notifications/RingtoneManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", "getName", "", "getURI", "Landroid/net/Uri;", "update", "", "data", "Landroid/content/Intent;", "uhabits-android_release"})
@org.mula.finance.core.AppScope()
public final class RingtoneManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    private final android.content.Context context = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getPrefs() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getURI() {
        return null;
    }
    
    public final void update(@org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @javax.inject.Inject()
    public RingtoneManager(@org.jetbrains.annotations.NotNull()
    @org.mula.androidbase.AppContext()
    android.content.Context context) {
        super();
    }
}