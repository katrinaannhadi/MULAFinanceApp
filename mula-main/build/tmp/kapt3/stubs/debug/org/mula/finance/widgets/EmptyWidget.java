package org.mula.finance.widgets;

import android.content.*;
import android.view.*;
import org.mula.finance.widgets.views.*;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\u0005H\u0014J\b\u0010\n\u001a\u00020\u0005H\u0014J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016\u00a8\u0006\u0011"}, d2 = {"Lorg/mula/finance/widgets/EmptyWidget;", "Lorg/mula/finance/widgets/BaseWidget;", "context", "Landroid/content/Context;", "widgetId", "", "(Landroid/content/Context;I)V", "buildView", "Lorg/mula/finance/widgets/views/EmptyWidgetView;", "getDefaultHeight", "getDefaultWidth", "getOnClickPendingIntent", "", "refreshData", "", "v", "Landroid/view/View;", "mula-main_debug"})
public final class EmptyWidget extends org.mula.finance.widgets.BaseWidget {
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Void getOnClickPendingIntent(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @java.lang.Override()
    public void refreshData(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected org.mula.finance.widgets.views.EmptyWidgetView buildView() {
        return null;
    }
    
    @java.lang.Override()
    protected int getDefaultHeight() {
        return 0;
    }
    
    @java.lang.Override()
    protected int getDefaultWidth() {
        return 0;
    }
    
    public EmptyWidget(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int widgetId) {
        super(null, 0);
    }
}