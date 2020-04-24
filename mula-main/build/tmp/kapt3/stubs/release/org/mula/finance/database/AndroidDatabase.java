package org.mula.finance.database;

import android.content.*;
import android.database.sqlite.*;
import org.mula.finance.core.database.Database;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J1\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\r\"\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0006H\u0016J)\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\n2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\r\"\u00020\u0012H\u0016\u00a2\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016J-\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0019H\u0016\u00a2\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\u00020\u001c2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0019H\u0002J)\u0010\u0011\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\n2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\r\"\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0006H\u0016JG\u0010 \u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00192\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\r\"\u00020\nH\u0016\u00a2\u0006\u0002\u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lorg/mula/finance/database/AndroidDatabase;", "Lorg/mula/finance/core/database/Database;", "db", "Landroid/database/sqlite/SQLiteDatabase;", "(Landroid/database/sqlite/SQLiteDatabase;)V", "beginTransaction", "", "close", "delete", "tableName", "", "where", "params", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "endTransaction", "execute", "query", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "getVersion", "", "insert", "", "map", "", "(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/Long;", "mapToContentValues", "Landroid/content/ContentValues;", "Lorg/mula/finance/database/AndroidCursor;", "(Ljava/lang/String;[Ljava/lang/String;)Lorg/mula/finance/database/AndroidCursor;", "setTransactionSuccessful", "update", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;[Ljava/lang/String;)I", "uhabits-android_release"})
public final class AndroidDatabase implements org.mula.finance.core.database.Database {
    private final android.database.sqlite.SQLiteDatabase db = null;
    
    @java.lang.Override()
    public void beginTransaction() {
    }
    
    @java.lang.Override()
    public void setTransactionSuccessful() {
    }
    
    @java.lang.Override()
    public void endTransaction() {
    }
    
    @java.lang.Override()
    public void close() {
    }
    
    @java.lang.Override()
    public int getVersion() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.mula.finance.database.AndroidCursor query(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    java.lang.String... params) {
        return null;
    }
    
    @java.lang.Override()
    public void execute(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    java.lang.Object... params) {
    }
    
    @java.lang.Override()
    public int update(@org.jetbrains.annotations.NotNull()
    java.lang.String tableName, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> map, @org.jetbrains.annotations.NotNull()
    java.lang.String where, @org.jetbrains.annotations.NotNull()
    java.lang.String... params) {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Long insert(@org.jetbrains.annotations.NotNull()
    java.lang.String tableName, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> map) {
        return null;
    }
    
    @java.lang.Override()
    public void delete(@org.jetbrains.annotations.NotNull()
    java.lang.String tableName, @org.jetbrains.annotations.NotNull()
    java.lang.String where, @org.jetbrains.annotations.NotNull()
    java.lang.String... params) {
    }
    
    private final android.content.ContentValues mapToContentValues(java.util.Map<java.lang.String, ? extends java.lang.Object> map) {
        return null;
    }
    
    public AndroidDatabase(@org.jetbrains.annotations.NotNull()
    android.database.sqlite.SQLiteDatabase db) {
        super();
    }
}