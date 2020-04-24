package org.mula.finance.activities.habits.list;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.androidbase.activities.BaseActivity;
import org.mula.finance.activities.common.dialogs.ColorPickerDialogFactory;
import org.mula.finance.activities.common.dialogs.ConfirmDeleteDialogFactory;
import org.mula.finance.activities.common.dialogs.NumberPickerFactory;
import org.mula.finance.activities.habits.edit.EditHabitDialogFactory;
import org.mula.finance.activities.habits.list.views.HabitCardListAdapter;
import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.tasks.TaskRunner;
import org.mula.finance.core.ui.ThemeSwitcher;
import org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior;
import org.mula.finance.intents.IntentFactory;
import org.mula.finance.tasks.ExportDBTaskFactory;
import org.mula.finance.tasks.ImportDataTaskFactory;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ListHabitsScreen_Factory implements Factory<ListHabitsScreen> {
  private final Provider<BaseActivity> activityProvider;

  private final Provider<ListHabitsRootView> rootViewProvider;

  private final Provider<CommandRunner> commandRunnerProvider;

  private final Provider<IntentFactory> intentFactoryProvider;

  private final Provider<ThemeSwitcher> themeSwitcherProvider;

  private final Provider<Preferences> preferencesProvider;

  private final Provider<HabitCardListAdapter> adapterProvider;

  private final Provider<TaskRunner> taskRunnerProvider;

  private final Provider<ExportDBTaskFactory> exportDBFactoryProvider;

  private final Provider<ImportDataTaskFactory> importTaskFactoryProvider;

  private final Provider<ConfirmDeleteDialogFactory> confirmDeleteDialogFactoryProvider;

  private final Provider<ColorPickerDialogFactory> colorPickerFactoryProvider;

  private final Provider<EditHabitDialogFactory> editHabitDialogFactoryProvider;

  private final Provider<NumberPickerFactory> numberPickerFactoryProvider;

  private final Provider<ListHabitsBehavior> behaviorProvider;

  private final Provider<ListHabitsMenu> menuProvider;

  private final Provider<ListHabitsSelectionMenu> selectionMenuProvider;

  public ListHabitsScreen_Factory(Provider<BaseActivity> activityProvider,
      Provider<ListHabitsRootView> rootViewProvider, Provider<CommandRunner> commandRunnerProvider,
      Provider<IntentFactory> intentFactoryProvider, Provider<ThemeSwitcher> themeSwitcherProvider,
      Provider<Preferences> preferencesProvider, Provider<HabitCardListAdapter> adapterProvider,
      Provider<TaskRunner> taskRunnerProvider,
      Provider<ExportDBTaskFactory> exportDBFactoryProvider,
      Provider<ImportDataTaskFactory> importTaskFactoryProvider,
      Provider<ConfirmDeleteDialogFactory> confirmDeleteDialogFactoryProvider,
      Provider<ColorPickerDialogFactory> colorPickerFactoryProvider,
      Provider<EditHabitDialogFactory> editHabitDialogFactoryProvider,
      Provider<NumberPickerFactory> numberPickerFactoryProvider,
      Provider<ListHabitsBehavior> behaviorProvider, Provider<ListHabitsMenu> menuProvider,
      Provider<ListHabitsSelectionMenu> selectionMenuProvider) {
    this.activityProvider = activityProvider;
    this.rootViewProvider = rootViewProvider;
    this.commandRunnerProvider = commandRunnerProvider;
    this.intentFactoryProvider = intentFactoryProvider;
    this.themeSwitcherProvider = themeSwitcherProvider;
    this.preferencesProvider = preferencesProvider;
    this.adapterProvider = adapterProvider;
    this.taskRunnerProvider = taskRunnerProvider;
    this.exportDBFactoryProvider = exportDBFactoryProvider;
    this.importTaskFactoryProvider = importTaskFactoryProvider;
    this.confirmDeleteDialogFactoryProvider = confirmDeleteDialogFactoryProvider;
    this.colorPickerFactoryProvider = colorPickerFactoryProvider;
    this.editHabitDialogFactoryProvider = editHabitDialogFactoryProvider;
    this.numberPickerFactoryProvider = numberPickerFactoryProvider;
    this.behaviorProvider = behaviorProvider;
    this.menuProvider = menuProvider;
    this.selectionMenuProvider = selectionMenuProvider;
  }

  @Override
  public ListHabitsScreen get() {
    return newInstance(activityProvider.get(), rootViewProvider.get(), commandRunnerProvider.get(), intentFactoryProvider.get(), themeSwitcherProvider.get(), preferencesProvider.get(), adapterProvider.get(), taskRunnerProvider.get(), exportDBFactoryProvider.get(), importTaskFactoryProvider.get(), confirmDeleteDialogFactoryProvider.get(), colorPickerFactoryProvider.get(), editHabitDialogFactoryProvider.get(), numberPickerFactoryProvider.get(), DoubleCheck.lazy(behaviorProvider), DoubleCheck.lazy(menuProvider), DoubleCheck.lazy(selectionMenuProvider));
  }

  public static ListHabitsScreen_Factory create(Provider<BaseActivity> activityProvider,
      Provider<ListHabitsRootView> rootViewProvider, Provider<CommandRunner> commandRunnerProvider,
      Provider<IntentFactory> intentFactoryProvider, Provider<ThemeSwitcher> themeSwitcherProvider,
      Provider<Preferences> preferencesProvider, Provider<HabitCardListAdapter> adapterProvider,
      Provider<TaskRunner> taskRunnerProvider,
      Provider<ExportDBTaskFactory> exportDBFactoryProvider,
      Provider<ImportDataTaskFactory> importTaskFactoryProvider,
      Provider<ConfirmDeleteDialogFactory> confirmDeleteDialogFactoryProvider,
      Provider<ColorPickerDialogFactory> colorPickerFactoryProvider,
      Provider<EditHabitDialogFactory> editHabitDialogFactoryProvider,
      Provider<NumberPickerFactory> numberPickerFactoryProvider,
      Provider<ListHabitsBehavior> behaviorProvider, Provider<ListHabitsMenu> menuProvider,
      Provider<ListHabitsSelectionMenu> selectionMenuProvider) {
    return new ListHabitsScreen_Factory(activityProvider, rootViewProvider, commandRunnerProvider, intentFactoryProvider, themeSwitcherProvider, preferencesProvider, adapterProvider, taskRunnerProvider, exportDBFactoryProvider, importTaskFactoryProvider, confirmDeleteDialogFactoryProvider, colorPickerFactoryProvider, editHabitDialogFactoryProvider, numberPickerFactoryProvider, behaviorProvider, menuProvider, selectionMenuProvider);
  }

  public static ListHabitsScreen newInstance(BaseActivity activity, ListHabitsRootView rootView,
      CommandRunner commandRunner, IntentFactory intentFactory, ThemeSwitcher themeSwitcher,
      Preferences preferences, HabitCardListAdapter adapter, TaskRunner taskRunner,
      ExportDBTaskFactory exportDBFactory, ImportDataTaskFactory importTaskFactory,
      ConfirmDeleteDialogFactory confirmDeleteDialogFactory,
      ColorPickerDialogFactory colorPickerFactory, EditHabitDialogFactory editHabitDialogFactory,
      NumberPickerFactory numberPickerFactory, Lazy<ListHabitsBehavior> behavior,
      Lazy<ListHabitsMenu> menu, Lazy<ListHabitsSelectionMenu> selectionMenu) {
    return new ListHabitsScreen(activity, rootView, commandRunner, intentFactory, themeSwitcher, preferences, adapter, taskRunner, exportDBFactory, importTaskFactory, confirmDeleteDialogFactory, colorPickerFactory, editHabitDialogFactory, numberPickerFactory, behavior, menu, selectionMenu);
  }
}
