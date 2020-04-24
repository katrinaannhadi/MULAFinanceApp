package org.mula.finance.widgets;

import android.content.*;
import android.view.*;
import org.mula.finance.activities.common.views.*;
import org.mula.finance.utils.*;
import org.mula.finance.widgets.views.*;
import org.mula.finance.core.models.Habit;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\u0005H\u0014J\b\u0010\r\u001a\u00020\u0005H\u0014J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lorg/mula/finance/widgets/FrequencyWidget;", "Lorg/mula/finance/widgets/BaseWidget;", "context", "Landroid/content/Context;", "widgetId", "", "habit", "Lorg/mula/finance/core/models/Habit;", "firstWeekday", "(Landroid/content/Context;ILorg/mula/finance/core/models/Habit;I)V", "buildView", "Lorg/mula/finance/widgets/views/GraphWidgetView;", "getDefaultHeight", "getDefaultWidth", "getOnClickPendingIntent", "Landroid/app/PendingIntent;", "refreshData", "", "v", "Landroid/view/View;", "mula-main_debug"})
public final class FrequencyWidget extends org.mula.finance.widgets.BaseWidget {
    private final org.mula.finance.core.models.Habit habit = null;
    private final int firstWeekday = 0;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.app.PendingIntent getOnClickPendingIntent(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @java.lang.Override()
    public void refreshData(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected org.mula.finance.widgets.views.GraphWidgetView buildView() {
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
    
    public FrequencyWidget(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int widgetId, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.models.Habit habit, int firstWeekday) {
        super(null, 0);
    }
}