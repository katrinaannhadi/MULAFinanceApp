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

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"REQUEST_OPEN_DOCUMENT", "", "REQUEST_SETTINGS", "RESULT_BUG_REPORT", "RESULT_EXPORT_CSV", "RESULT_EXPORT_DB", "RESULT_IMPORT_DATA", "RESULT_REPAIR_DB", "uhabits-android_release"})
public final class ListHabitsScreenKt {
    public static final int RESULT_IMPORT_DATA = 1;
    public static final int RESULT_EXPORT_CSV = 2;
    public static final int RESULT_EXPORT_DB = 3;
    public static final int RESULT_BUG_REPORT = 4;
    public static final int RESULT_REPAIR_DB = 5;
    public static final int REQUEST_OPEN_DOCUMENT = 6;
    public static final int REQUEST_SETTINGS = 7;
}