package org.mula.finance.preferences;

import android.content.*;
import android.preference.*;
import org.mula.finance.R;
import org.mula.androidbase.AppContext;
import org.mula.finance.core.AppScope;
import org.mula.finance.core.preferences.Preferences;
import javax.inject.*;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\rH\u0016J\u0018\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J\u0018\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lorg/mula/finance/preferences/SharedPreferencesStorage;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "Lorg/mula/finance/core/preferences/Preferences$Storage;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "preferences", "Lorg/mula/finance/core/preferences/Preferences;", "sharedPrefs", "Landroid/content/SharedPreferences;", "clear", "", "getBoolean", "", "key", "", "defValue", "getInt", "", "getLong", "", "getString", "onAttached", "onSharedPreferenceChanged", "sharedPreferences", "putBoolean", "value", "putInt", "putLong", "putString", "remove", "uhabits-android_release"})
@org.mula.finance.core.AppScope()
public final class SharedPreferencesStorage implements android.content.SharedPreferences.OnSharedPreferenceChangeListener, org.mula.finance.core.preferences.Preferences.Storage {
    private final android.content.SharedPreferences sharedPrefs = null;
    private org.mula.finance.core.preferences.Preferences preferences;
    
    @java.lang.Override()
    public void clear() {
    }
    
    @java.lang.Override()
    public boolean getBoolean(@org.jetbrains.annotations.NotNull()
    java.lang.String key, boolean defValue) {
        return false;
    }
    
    @java.lang.Override()
    public int getInt(@org.jetbrains.annotations.NotNull()
    java.lang.String key, int defValue) {
        return 0;
    }
    
    @java.lang.Override()
    public long getLong(@org.jetbrains.annotations.NotNull()
    java.lang.String key, long defValue) {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getString(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.String defValue) {
        return null;
    }
    
    @java.lang.Override()
    public void onAttached(@org.jetbrains.annotations.NotNull()
    org.mula.finance.core.preferences.Preferences preferences) {
    }
    
    @java.lang.Override()
    public void putBoolean(@org.jetbrains.annotations.NotNull()
    java.lang.String key, boolean value) {
    }
    
    @java.lang.Override()
    public void putInt(@org.jetbrains.annotations.NotNull()
    java.lang.String key, int value) {
    }
    
    @java.lang.Override()
    public void putLong(@org.jetbrains.annotations.NotNull()
    java.lang.String key, long value) {
    }
    
    @java.lang.Override()
    public void putString(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @java.lang.Override()
    public void remove(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    @java.lang.Override()
    public void onSharedPreferenceChanged(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences sharedPreferences, @org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    @javax.inject.Inject()
    public SharedPreferencesStorage(@org.jetbrains.annotations.NotNull()
    @org.mula.androidbase.AppContext()
    android.content.Context context) {
        super();
    }
}