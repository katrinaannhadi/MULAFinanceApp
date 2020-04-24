package org.mula.finance.activities.habits.list;

import android.app.*;
import android.content.*;
import androidx.annotation.*;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import org.mula.finance.*;
import org.mula.finance.activities.common.dialogs.*;
import org.mula.finance.activities.habits.edit.*;
import org.mula.finance.activities.habits.list.views.*;
import org.mula.finance.intents.*;
import org.mula.finance.tasks.*;
import org.mula.androidbase.activities.ActivityScope;
import org.mula.androidbase.activities.BaseActivity;
import org.mula.androidbase.activities.BaseScreen;
import org.mula.androidbase.utils.FileUtils;
import org.mula.finance.core.commands.*;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.tasks.TaskRunner;
import org.mula.finance.core.ui.ThemeSwitcher;
import org.mula.finance.core.ui.callbacks.OnColorPickedCallback;
import org.mula.finance.core.ui.callbacks.OnConfirmedCallback;
import org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior;
import org.mula.finance.core.ui.screens.habits.list.ListHabitsMenuBehavior;
import org.mula.finance.core.ui.screens.habits.list.ListHabitsSelectionMenuBehavior;
import java.io.*;
import javax.inject.*;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00de\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u00a1\u0001\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0!\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0!\u00a2\u0006\u0002\u0010\'J\b\u0010)\u001a\u00020*H\u0016J\u0017\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.H\u0003\u00a2\u0006\u0002\u0010/J\u0006\u00100\u001a\u00020*J\u001f\u00101\u001a\u00020*2\u0006\u0010-\u001a\u00020.2\b\u00102\u001a\u0004\u0018\u000103H\u0016\u00a2\u0006\u0002\u00104J\u0006\u00105\u001a\u00020*J\b\u00106\u001a\u00020*H\u0002J\u001e\u00107\u001a\u00020*2\u0006\u00108\u001a\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020*0;H\u0002J\u001a\u0010<\u001a\u00020*2\u0006\u0010=\u001a\u00020,2\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\"\u0010@\u001a\u00020*2\u0006\u0010A\u001a\u00020,2\u0006\u0010=\u001a\u00020,2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010B\u001a\u00020*2\u0006\u0010=\u001a\u00020,H\u0002J\u0018\u0010C\u001a\u00020*2\u0006\u0010D\u001a\u00020,2\u0006\u0010E\u001a\u00020FH\u0016J\b\u0010G\u001a\u00020*H\u0016J\b\u0010H\u001a\u00020*H\u0016J\u0010\u0010I\u001a\u00020*2\u0006\u0010E\u001a\u00020JH\u0016J\u0016\u0010K\u001a\u00020*2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020N0MH\u0016J\u0010\u0010O\u001a\u00020*2\u0006\u0010P\u001a\u00020NH\u0016J\u0006\u0010Q\u001a\u00020*J\b\u0010R\u001a\u00020*H\u0016J\u0010\u0010S\u001a\u00020*2\u0006\u0010T\u001a\u00020UH\u0016J \u0010V\u001a\u00020*2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010E\u001a\u00020[H\u0016J\u0010\u0010\\\u001a\u00020*2\u0006\u0010]\u001a\u00020ZH\u0016J\b\u0010^\u001a\u00020*H\u0016R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010(R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010(R\u0010\u0010\u0018\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010(R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006_"}, d2 = {"Lorg/mula/finance/activities/habits/list/ListHabitsScreen;", "Lorg/mula/androidbase/activities/BaseScreen;", "Lorg/mula/finance/core/commands/CommandRunner$Listener;", "Lorg/mula/finance/core/ui/screens/habits/list/ListHabitsBehavior$Screen;", "Lorg/mula/finance/core/ui/screens/habits/list/ListHabitsMenuBehavior$Screen;", "Lorg/mula/finance/core/ui/screens/habits/list/ListHabitsSelectionMenuBehavior$Screen;", "activity", "Lorg/mula/androidbase/activities/BaseActivity;", "rootView", "Lorg/mula/finance/activities/habits/list/ListHabitsRootView;", "commandRunner", "Lorg/mula/finance/core/commands/CommandRunner;", "intentFactory", "Lorg/mula/finance/intents/IntentFactory;", "themeSwitcher", "Lorg/mula/finance/core/ui/ThemeSwitcher;", "preferences", "Lorg/mula/finance/core/preferences/Preferences;", "adapter", "Lorg/mula/finance/activities/habits/list/views/HabitCardListAdapter;", "taskRunner", "Lorg/mula/finance/core/tasks/TaskRunner;", "exportDBFactory", "error/NonExistentClass", "importTaskFactory", "confirmDeleteDialogFactory", "colorPickerFactory", "Lorg/mula/finance/activities/common/dialogs/ColorPickerDialogFactory;", "editHabitDialogFactory", "Lorg/mula/finance/activities/habits/edit/EditHabitDialogFactory;", "numberPickerFactory", "Lorg/mula/finance/activities/common/dialogs/NumberPickerFactory;", "behavior", "Ldagger/Lazy;", "Lorg/mula/finance/core/ui/screens/habits/list/ListHabitsBehavior;", "menu", "Lorg/mula/finance/activities/habits/list/ListHabitsMenu;", "selectionMenu", "Lorg/mula/finance/activities/habits/list/ListHabitsSelectionMenu;", "(Lorg/mula/androidbase/activities/BaseActivity;Lorg/mula/finance/activities/habits/list/ListHabitsRootView;Lorg/mula/finance/core/commands/CommandRunner;Lorg/mula/finance/intents/IntentFactory;Lorg/mula/finance/core/ui/ThemeSwitcher;Lorg/mula/finance/core/preferences/Preferences;Lorg/mula/finance/activities/habits/list/views/HabitCardListAdapter;Lorg/mula/finance/core/tasks/TaskRunner;Lerror/NonExistentClass;Lerror/NonExistentClass;Lerror/NonExistentClass;Lorg/mula/finance/activities/common/dialogs/ColorPickerDialogFactory;Lorg/mula/finance/activities/habits/edit/EditHabitDialogFactory;Lorg/mula/finance/activities/common/dialogs/NumberPickerFactory;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Lerror/NonExistentClass;", "applyTheme", "", "getExecuteString", "", "command", "Lorg/mula/finance/core/commands/Command;", "(Lorg/mula/finance/core/commands/Command;)Ljava/lang/Integer;", "onAttached", "onCommandExecuted", "refreshKey", "", "(Lorg/mula/finance/core/commands/Command;Ljava/lang/Long;)V", "onDettached", "onExportDB", "onImportData", "file", "Ljava/io/File;", "onFinished", "Lkotlin/Function0;", "onOpenDocumentResult", "resultCode", "data", "Landroid/content/Intent;", "onResult", "requestCode", "onSettingsResult", "showColorPicker", "defaultColor", "callback", "Lorg/mula/finance/core/ui/callbacks/OnColorPickedCallback;", "showCreateBooleanHabitScreen", "showCreateNumericalHabitScreen", "showDeleteConfirmationScreen", "Lorg/mula/finance/core/ui/callbacks/OnConfirmedCallback;", "showEditHabitsScreen", "habits", "", "Lorg/mula/finance/core/models/Habit;", "showHabitScreen", "habit", "showImportScreen", "showIntroScreen", "showMessage", "m", "Lorg/mula/finance/core/ui/screens/habits/list/ListHabitsBehavior$Message;", "showNumberPicker", "value", "", "unit", "", "Lorg/mula/finance/core/ui/screens/habits/list/ListHabitsBehavior$NumberPickerCallback;", "showSendBugReportToDeveloperScreen", "log", "showSettingsScreen", "uhabits-android_release"})
@org.mula.androidbase.activities.ActivityScope()
public final class ListHabitsScreen extends org.mula.androidbase.activities.BaseScreen implements org.mula.finance.core.commands.CommandRunner.Listener, org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior.Screen, org.mula.finance.core.ui.screens.habits.list.ListHabitsMenuBehavior.Screen, org.mula.finance.core.ui.screens.habits.list.ListHabitsSelectionMenuBehavior.Screen {
    private final org.mula.finance.core.commands.CommandRunner commandRunner = null;
    private final org.mula.finance.intents.IntentFactory intentFactory = null;
    private final org.mula.finance.core.ui.ThemeSwitcher themeSwitcher = null;
    private final org.mula.finance.core.preferences.Preferences preferences = null;
    private final org.mula.finance.activities.habits.list.views.HabitCardListAdapter adapter = null;
    private final org.mula.finance.core.tasks.TaskRunner taskRunner = null;
    private final ExportDBTaskFactory exportDBFactory = null;
    private final ImportDataTaskFactory importTaskFactory = null;
    private final ConfirmDeleteDialogFactory confirmDeleteDialogFactory = null;
    private final org.mula.finance.activities.common.dialogs.ColorPickerDialogFactory colorPickerFactory = null;
    private final org.mula.finance.activities.habits.edit.EditHabitDialogFactory editHabitDialogFactory = null;
    private final org.mula.finance.activities.common.dialogs.NumberPickerFactory numberPickerFactory = null;
    private final dagger.Lazy<org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior> behavior = null;
    private final dagger.Lazy<org.mula.finance.activities.habits.list.ListHabitsMenu> menu = null;
    private final dagger.Lazy<org.mula.finance.activities.habits.list.ListHabitsSelectionMenu> selectionMenu = null;
    
    public final void onAttached() {
    }
    
    public final void onDettached() {
    }
    
    @java.lang.Override()
    public void onCommandExecuted(@org.jetbrains.annotations.NotNull()
    org.mula.finance.core.commands.Command command, @org.jetbrains.annotations.Nullable()
    java.lang.Long refreshKey) {
    }
    
    @java.lang.Override()
    public void onResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void onOpenDocumentResult(int resultCode, android.content.Intent data) {
    }
    
    private final void onSettingsResult(int resultCode) {
    }
    
    @java.lang.Override()
    public void applyTheme() {
    }
    
    @java.lang.Override()
    public void showCreateBooleanHabitScreen() {
    }
    
    @java.lang.Override()
    public void showCreateNumericalHabitScreen() {
    }
    
    @java.lang.Override()
    public void showDeleteConfirmationScreen(@org.jetbrains.annotations.NotNull()
    org.mula.finance.core.ui.callbacks.OnConfirmedCallback callback) {
    }
    
    @java.lang.Override()
    public void showEditHabitsScreen(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends org.mula.finance.core.models.Habit> habits) {
    }
    
    @java.lang.Override()
    public void showHabitScreen(@org.jetbrains.annotations.NotNull()
    org.mula.finance.core.models.Habit habit) {
    }
    
    public final void showImportScreen() {
    }
    
    @java.lang.Override()
    public void showIntroScreen() {
    }
    
    @java.lang.Override()
    public void showMessage(@org.jetbrains.annotations.NotNull()
    org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior.Message m) {
    }
    
    @java.lang.Override()
    public void showSendBugReportToDeveloperScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String log) {
    }
    
    @java.lang.Override()
    public void showSettingsScreen() {
    }
    
    @java.lang.Override()
    public void showColorPicker(int defaultColor, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.ui.callbacks.OnColorPickedCallback callback) {
    }
    
    @java.lang.Override()
    public void showNumberPicker(double value, @org.jetbrains.annotations.NotNull()
    java.lang.String unit, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior.NumberPickerCallback callback) {
    }
    
    @androidx.annotation.StringRes()
    private final java.lang.Integer getExecuteString(org.mula.finance.core.commands.Command command) {
        return null;
    }
    
    private final void onImportData(java.io.File file, kotlin.jvm.functions.Function0<kotlin.Unit> onFinished) {
    }
    
    private final void onExportDB() {
    }
    
    @javax.inject.Inject()
    public ListHabitsScreen(@org.jetbrains.annotations.NotNull()
    org.mula.androidbase.activities.BaseActivity activity, @org.jetbrains.annotations.NotNull()
    org.mula.finance.activities.habits.list.ListHabitsRootView rootView, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.commands.CommandRunner commandRunner, @org.jetbrains.annotations.NotNull()
    org.mula.finance.intents.IntentFactory intentFactory, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.ui.ThemeSwitcher themeSwitcher, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.preferences.Preferences preferences, @org.jetbrains.annotations.NotNull()
    org.mula.finance.activities.habits.list.views.HabitCardListAdapter adapter, @org.jetbrains.annotations.NotNull()
    org.mula.finance.core.tasks.TaskRunner taskRunner, @org.jetbrains.annotations.NotNull()
    ExportDBTaskFactory exportDBFactory, @org.jetbrains.annotations.NotNull()
    ImportDataTaskFactory importTaskFactory, @org.jetbrains.annotations.NotNull()
    ConfirmDeleteDialogFactory confirmDeleteDialogFactory, @org.jetbrains.annotations.NotNull()
    org.mula.finance.activities.common.dialogs.ColorPickerDialogFactory colorPickerFactory, @org.jetbrains.annotations.NotNull()
    org.mula.finance.activities.habits.edit.EditHabitDialogFactory editHabitDialogFactory, @org.jetbrains.annotations.NotNull()
    org.mula.finance.activities.common.dialogs.NumberPickerFactory numberPickerFactory, @org.jetbrains.annotations.NotNull()
    dagger.Lazy<org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior> behavior, @org.jetbrains.annotations.NotNull()
    dagger.Lazy<org.mula.finance.activities.habits.list.ListHabitsMenu> menu, @org.jetbrains.annotations.NotNull()
    dagger.Lazy<org.mula.finance.activities.habits.list.ListHabitsSelectionMenu> selectionMenu) {
        super(null);
    }
}