package org.mula.finance.database;

import org.mula.finance.core.database.Cursor;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ\u0017\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lorg/mula/finance/database/AndroidCursor;", "Lorg/mula/finance/core/database/Cursor;", "cursor", "Landroid/database/Cursor;", "(Landroid/database/Cursor;)V", "close", "", "getDouble", "", "index", "", "(I)Ljava/lang/Double;", "getInt", "(I)Ljava/lang/Integer;", "getLong", "", "(I)Ljava/lang/Long;", "getString", "", "moveToNext", "", "mula-main_debug"})
public final class AndroidCursor implements org.mula.finance.core.database.Cursor {
    private final android.database.Cursor cursor = null;
    
    @java.lang.Override()
    public void close() {
    }
    
    @java.lang.Override()
    public boolean moveToNext() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Integer getInt(int index) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Long getLong(int index) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Double getDouble(int index) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getString(int index) {
        return null;
    }
    
    public AndroidCursor(@org.jetbrains.annotations.NotNull()
    android.database.Cursor cursor) {
        super();
    }
}