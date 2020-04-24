package org.mula.finance.activities.common.views;

import android.content.*;
import android.widget.*;
import org.mula.androidbase.activities.BaseRootView;
import org.mula.finance.core.tasks.Task;
import org.mula.finance.core.tasks.TaskRunner;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0006\u0010\u000f\u001a\u00020\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lorg/mula/finance/activities/common/views/TaskProgressBar;", "Landroid/widget/ProgressBar;", "Lorg/mula/finance/core/tasks/TaskRunner$Listener;", "context", "Landroid/content/Context;", "runner", "Lorg/mula/finance/core/tasks/TaskRunner;", "(Landroid/content/Context;Lorg/mula/finance/core/tasks/TaskRunner;)V", "onAttachedToWindow", "", "onDetachedFromWindow", "onTaskFinished", "task", "Lorg/mula/finance/core/tasks/Task;", "onTaskStarted", "update", "mula-main_debug"})
public final class TaskProgressBar extends android.widget.ProgressBar implements org.mula.finance.core.tasks.TaskRunner.Listener {
    private final org.mula.finance.core.tasks.TaskRunner runner = null;
    
    @java.lang.Override()
    public void onTaskStarted(@org.jetbrains.annotations.Nullable()
    org.mula.finance.core.tasks.Task task) {
    }
    
    @java.lang.Override()
    public void onTaskFinished(@org.jetbrains.annotations.Nullable()
    org.mula.finance.core.tasks.Task task) {
    }
    
    @java.lang.Override()
    protected void onAttachedToWindow() {
    }
    
    @java.lang.Override()
    protected void onDetachedFromWindow() {
    }
    
    public final void update() {
    }
    
    public TaskProgressBar(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.tasks.TaskRunner runner) {
        super(null);
    }
}