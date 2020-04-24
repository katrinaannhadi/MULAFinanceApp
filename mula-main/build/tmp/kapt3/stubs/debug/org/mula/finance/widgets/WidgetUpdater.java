package org.mula.finance.widgets;

import android.appwidget.*;
import android.content.*;
import org.mula.androidbase.AppContext;
import org.mula.finance.core.commands.Command;
import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.preferences.WidgetPreferences;
import org.mula.finance.core.tasks.TaskRunner;
import javax.inject.*;

/**
 * A WidgetUpdater listens to the commands being executed by the application and
 * updates the home-screen widgets accordingly.
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001f\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\fJ\u0006\u0010\u0014\u001a\u00020\fJ\u0015\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010\u0016J#\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00102\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0002\u00a2\u0006\u0002\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lorg/mula/finance/widgets/WidgetUpdater;", "Lorg/mula/finance/core/commands/CommandRunner$Listener;", "context", "Landroid/content/Context;", "commandRunner", "Lorg/mula/finance/core/commands/CommandRunner;", "taskRunner", "Lorg/mula/finance/core/tasks/TaskRunner;", "widgetPrefs", "Lorg/mula/finance/core/preferences/WidgetPreferences;", "(Landroid/content/Context;Lorg/mula/finance/core/commands/CommandRunner;Lorg/mula/finance/core/tasks/TaskRunner;Lorg/mula/finance/core/preferences/WidgetPreferences;)V", "onCommandExecuted", "", "command", "Lorg/mula/finance/core/commands/Command;", "refreshKey", "", "(Lorg/mula/finance/core/commands/Command;Ljava/lang/Long;)V", "startListening", "stopListening", "updateWidgets", "modifiedHabitId", "(Ljava/lang/Long;)V", "providerClass", "Ljava/lang/Class;", "(Ljava/lang/Long;Ljava/lang/Class;)V", "mula-main_debug"})
public final class WidgetUpdater implements org.mula.finance.core.commands.CommandRunner.Listener {
    private final android.content.Context context = null;
    private final org.mula.finance.core.commands.CommandRunner commandRunner = null;
    private final org.mula.finance.core.tasks.TaskRunner taskRunner = null;
    private final org.mula.finance.core.preferences.WidgetPreferences widgetPrefs = null;
    
    @java.lang.Override()
    public void onCommandExecuted(@org.jetbrains.annotations.NotNull()
    org.mula.finance.core.commands.Command command, @org.jetbrains.annotations.Nullable()
    java.lang.Long refreshKey) {
    }
    
    /**
     * Instructs the updater to start listening to commands. If any relevant
     * commands are executed after this method is called, the corresponding
     * widgets will get updated.
     */
    public final void startListening() {
    }
    
    /**
     * Instructs the updater to stop listening to commands. Every command
     * executed after this method is called will be ignored by the updater.
     */
    public final void stopListening() {
    }
    
    public final void updateWidgets(@org.jetbrains.annotations.Nullable()
    java.lang.Long modifiedHabitId) {
    }
    
    private final void updateWidgets(java.lang.Long modifiedHabitId, java.lang.Class<?> providerClass) {
    }
    
    public final void updateWidgets() {
    }
    
    @javax.inject.Inject()
    public WidgetUpdater(@org.jetbrains.annotations.NotNull()
    @org.mula.androidbase.AppContext()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.commands.CommandRunner commandRunner, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.tasks.TaskRunner taskRunner, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.preferences.WidgetPreferences widgetPrefs) {
        super();
    }
}