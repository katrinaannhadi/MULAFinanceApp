package org.mula.finance.database;

import android.database.sqlite.*;
import org.mula.finance.core.database.DatabaseOpener;
import java.io.*;
import javax.inject.*;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lorg/mula/finance/database/AndroidDatabaseOpener;", "Lorg/mula/finance/core/database/DatabaseOpener;", "()V", "open", "Lorg/mula/finance/database/AndroidDatabase;", "file", "Ljava/io/File;", "uhabits-android_release"})
public final class AndroidDatabaseOpener implements org.mula.finance.core.database.DatabaseOpener {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.mula.finance.database.AndroidDatabase open(@org.jetbrains.annotations.NotNull()
    java.io.File file) {
        return null;
    }
    
    @javax.inject.Inject()
    public AndroidDatabaseOpener() {
        super();
    }
}