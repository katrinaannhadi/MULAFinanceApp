/* Mula */

package org.mula.finance.activities.habits.list

import android.app.*
import android.content.*
import androidx.annotation.*
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import dagger.*
import org.mula.finance.*
import org.mula.finance.activities.common.dialogs.*
import org.mula.finance.activities.habits.edit.*
import org.mula.finance.activities.habits.list.views.*
import org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior.Message.*
import org.mula.finance.intents.*
import org.mula.finance.tasks.*
import org.mula.androidbase.activities.ActivityScope
import org.mula.androidbase.activities.BaseActivity
import org.mula.androidbase.activities.BaseScreen
import org.mula.androidbase.utils.FileUtils
import org.mula.finance.core.commands.*
import org.mula.finance.core.models.Habit
import org.mula.finance.core.preferences.Preferences
import org.mula.finance.core.tasks.TaskRunner
import org.mula.finance.core.ui.ThemeSwitcher
import org.mula.finance.core.ui.callbacks.OnColorPickedCallback
import org.mula.finance.core.ui.callbacks.OnConfirmedCallback
import org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior
import org.mula.finance.core.ui.screens.habits.list.ListHabitsMenuBehavior
import org.mula.finance.core.ui.screens.habits.list.ListHabitsSelectionMenuBehavior
import java.io.*
import javax.inject.*

const val RESULT_IMPORT_DATA = 1
const val RESULT_EXPORT_CSV = 2
const val RESULT_EXPORT_DB = 3
const val RESULT_BUG_REPORT = 4
const val RESULT_REPAIR_DB = 5
const val REQUEST_OPEN_DOCUMENT = 6
const val REQUEST_SETTINGS = 7

@ActivityScope
class ListHabitsScreen
@Inject constructor(
        activity: BaseActivity,
        rootView: ListHabitsRootView,
        private val commandRunner: CommandRunner,
        private val intentFactory: IntentFactory,
        private val themeSwitcher: ThemeSwitcher,
        private val preferences: Preferences,
        private val adapter: HabitCardListAdapter,
        private val taskRunner: TaskRunner,
        private val exportDBFactory: ExportDBTaskFactory,
        private val importTaskFactory: ImportDataTaskFactory,
        private val confirmDeleteDialogFactory: ConfirmDeleteDialogFactory,
        private val colorPickerFactory: ColorPickerDialogFactory,
        private val editHabitDialogFactory: EditHabitDialogFactory,
        private val numberPickerFactory: NumberPickerFactory,
        private val behavior: Lazy<ListHabitsBehavior>,
        private val menu: Lazy<ListHabitsMenu>,
        private val selectionMenu: Lazy<ListHabitsSelectionMenu>

) : BaseScreen(activity),
    CommandRunner.Listener,
    ListHabitsBehavior.Screen,
    ListHabitsMenuBehavior.Screen,
    ListHabitsSelectionMenuBehavior.Screen {

    init {
        setRootView(rootView)
    }

    fun onAttached() {
        setMenu(menu.get())
        setSelectionMenu(selectionMenu.get())
        commandRunner.addListener(this)
    }

    fun onDettached() {
        commandRunner.removeListener(this)
    }

    override fun onCommandExecuted(command: Command, refreshKey: Long?) {
        if (command.isRemote) return
        showMessage(getExecuteString(command))
    }

    override fun onResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQUEST_OPEN_DOCUMENT -> onOpenDocumentResult(resultCode, data)
            REQUEST_SETTINGS -> onSettingsResult(resultCode)
        }
    }

    private fun onOpenDocumentResult(resultCode: Int, data: Intent?) {
        if (data == null) return
        if (resultCode != Activity.RESULT_OK) return
        try {
            val inStream = activity.contentResolver.openInputStream(data.data!!)
            val cacheDir = activity.externalCacheDir
            val tempFile = File.createTempFile("import", "", cacheDir)
            FileUtils.copy(inStream, tempFile)
            onImportData(tempFile) { tempFile.delete() }
        } catch (e: IOException) {
            showMessage(R.string.could_not_import)
            e.printStackTrace()
        }
    }

    private fun onSettingsResult(resultCode: Int) {
        when (resultCode) {
            RESULT_IMPORT_DATA -> showImportScreen()
            RESULT_EXPORT_CSV -> behavior.get().onExportCSV()
            RESULT_EXPORT_DB -> onExportDB()
            RESULT_BUG_REPORT -> behavior.get().onSendBugReport()
            RESULT_REPAIR_DB -> behavior.get().onRepairDB()
        }
    }

    override fun applyTheme() {
        themeSwitcher.apply()
        activity.restartWithFade(ListHabitsActivity::class.java)
    }

    override fun showCreateBooleanHabitScreen() {
        val dialog = editHabitDialogFactory.createBoolean()
        activity.showDialog(dialog, "editHabit")
    }

    override fun showCreateNumericalHabitScreen() {
        val dialog = editHabitDialogFactory.createNumerical()
        activity.showDialog(dialog, "editHabit")
    }

    override fun showDeleteConfirmationScreen(callback: OnConfirmedCallback) {
        activity.showDialog(confirmDeleteDialogFactory.create(callback))
    }

    override fun showEditHabitsScreen(habits: List<Habit>) {
        val dialog = editHabitDialogFactory.edit(habits[0])
        activity.showDialog(dialog, "editNumericalHabit")
    }

    override fun showHabitScreen(habit: Habit) {
        val intent = intentFactory.startShowHabitActivity(activity, habit)
        activity.startActivity(intent)
    }

    fun showImportScreen() {
        val intent = intentFactory.openDocument()
        activity.startActivityForResult(intent, REQUEST_OPEN_DOCUMENT)
    }

    override fun showIntroScreen() {
        val intent = intentFactory.startIntroActivity(activity)
        activity.startActivity(intent)
    }

    override fun showMessage(m: ListHabitsBehavior.Message) {
        showMessage(when (m) {
                        COULD_NOT_EXPORT -> R.string.could_not_export
                        IMPORT_SUCCESSFUL -> R.string.habits_imported
                        IMPORT_FAILED -> R.string.could_not_import
                        DATABASE_REPAIRED -> R.string.database_repaired
                        COULD_NOT_GENERATE_BUG_REPORT -> R.string.bug_report_failed
                        FILE_NOT_RECOGNIZED -> R.string.file_not_recognized
                    })
    }

    override fun showSendBugReportToDeveloperScreen(log: String) {
        val to = R.string.bugReportTo
        val subject = R.string.bugReportSubject
        showSendEmailScreen(to, subject, log)
    }

    override fun showSettingsScreen() {
        val intent = intentFactory.startSettingsActivity(activity)
        activity.startActivityForResult(intent, REQUEST_SETTINGS)
    }

    override fun showColorPicker(defaultColor: Int,
                                 callback: OnColorPickedCallback) {
        val picker = colorPickerFactory.create(defaultColor)
        picker.setListener(callback)
        activity.showDialog(picker, "picker")
    }

    override fun showNumberPicker(value: Double,
                                  unit: String,
                                  callback: ListHabitsBehavior.NumberPickerCallback) {
        numberPickerFactory.create(value, unit, callback).show()
    }

    @StringRes
    private fun getExecuteString(command: Command): Int? {
        when (command) {
            is ArchiveHabitsCommand -> return R.string.toast_habit_archived
            is ChangeHabitColorCommand -> return R.string.toast_habit_changed
            is CreateHabitCommand -> return R.string.toast_habit_created
            is DeleteHabitsCommand -> return R.string.toast_habit_deleted
            is EditHabitCommand -> return R.string.toast_habit_changed
            is UnarchiveHabitsCommand -> return R.string.toast_habit_unarchived
            else -> return null
        }
    }

    private fun onImportData(file: File, onFinished: () -> Unit) {
        taskRunner.execute(importTaskFactory.create(file) { result ->
            if (result == ImportDataTask.SUCCESS) {
                adapter.refresh()
                showMessage(R.string.habits_imported)
            } else if (result == ImportDataTask.NOT_RECOGNIZED) {
                showMessage(R.string.file_not_recognized)
            } else {
                showMessage(R.string.could_not_import)
            }
            onFinished()
        })
    }

    private fun onExportDB() {
        taskRunner.execute(exportDBFactory.create { filename ->
            if (filename != null) showSendFileScreen(filename)
            else showMessage(R.string.could_not_export)
        })
    }
}
