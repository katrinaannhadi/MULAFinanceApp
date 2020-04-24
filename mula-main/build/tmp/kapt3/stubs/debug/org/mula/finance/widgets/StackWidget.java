package org.mula.finance.widgets;

import android.appwidget.*;
import android.content.*;
import android.net.*;
import android.view.*;
import android.widget.*;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.utils.StringUtils;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u0005H\u0014J\b\u0010\u000f\u001a\u00020\u0005H\u0014J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lorg/mula/finance/widgets/StackWidget;", "Lorg/mula/finance/widgets/BaseWidget;", "context", "Landroid/content/Context;", "widgetId", "", "widgetType", "Lorg/mula/finance/widgets/StackWidgetType;", "habits", "", "Lorg/mula/finance/core/models/Habit;", "(Landroid/content/Context;ILorg/mula/finance/widgets/StackWidgetType;Ljava/util/List;)V", "buildView", "", "getDefaultHeight", "getDefaultWidth", "getOnClickPendingIntent", "getRemoteViews", "Landroid/widget/RemoteViews;", "width", "height", "refreshData", "", "v", "Landroid/view/View;", "mula-main_debug"})
public final class StackWidget extends org.mula.finance.widgets.BaseWidget {
    private final org.mula.finance.widgets.StackWidgetType widgetType = null;
    private final java.util.List<org.mula.finance.core.models.Habit> habits = null;
    
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
    protected android.widget.RemoteViews getRemoteViews(int width, int height) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected java.lang.Void buildView() {
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
    
    public StackWidget(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int widgetId, @org.jetbrains.annotations.NotNull()
    org.mula.finance.widgets.StackWidgetType widgetType, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends org.mula.finance.core.models.Habit> habits) {
        super(null, 0);
    }
}