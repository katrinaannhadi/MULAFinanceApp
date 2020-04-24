/* Mula */

package org.mula.finance;

import android.content.*;

import androidx.test.uiautomator.*;

import com.linkedin.android.testbutler.*;

import org.junit.*;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.preferences.Preferences;
import org.mula.finance.core.ui.screens.habits.list.HabitCardListCache;
import org.mula.finance.core.utils.DateUtils;

import static androidx.test.InstrumentationRegistry.getContext;
import static androidx.test.InstrumentationRegistry.getTargetContext;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static androidx.test.uiautomator.UiDevice.*;

public class BaseUserInterfaceTest
{
    private static final String PKG = "org.mula.finance";
    public static final String EMPTY_DESCRIPTION_HABIT_NAME = "Read books";

    public static UiDevice device;

    private HabitsApplicationComponent component;

    private HabitList habitList;

    private Preferences prefs;

    private HabitFixtures fixtures;

    private HabitCardListCache cache;

    public static void startActivity(Class cls)
    {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(PKG, cls.getCanonicalName()));
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().startActivity(intent);
    }

    @Before
    public void setUp() throws Exception
    {
        device = getInstance(getInstrumentation());
        TestButler.setup(getTargetContext());
        TestButler.verifyAnimationsDisabled(getTargetContext());

        HabitsApplication app =
            (HabitsApplication) getTargetContext().getApplicationContext();
        component = app.getComponent();
        habitList = component.getHabitList();
        prefs = component.getPreferences();
        cache = component.getHabitCardListCache();
        fixtures = new HabitFixtures(component.getModelFactory(), habitList);
        resetState();
    }

    @After
    public void tearDown() throws Exception
    {
        for (int i = 0; i < 10; i++) device.pressBack();
        TestButler.teardown(getTargetContext());
    }

    private void resetState() throws Exception
    {
        prefs.clear();
        prefs.setFirstRun(false);
        prefs.updateLastHint(100, DateUtils.getToday());
        habitList.removeAll();
        cache.refreshAllHabits();
        Thread.sleep(1000);

        Habit h1 = fixtures.createEmptyHabit();
        h1.setName("Wake up early");
        h1.setQuestion("Did you wake up early today?");
        h1.setDescription("test description 1");
        h1.setColor(5);
        habitList.update(h1);

        Habit h2 = fixtures.createShortHabit();
        h2.setName("Track time");
        h2.setQuestion("Did you track your time?");
        h2.setDescription("test description 2");
        h2.setColor(5);
        habitList.update(h2);

        Habit h3 = fixtures.createLongHabit();
        h3.setName("Meditate");
        h3.setQuestion("Did meditate today?");
        h3.setDescription("test description 3");
        h3.setColor(10);
        habitList.update(h3);

        Habit h4 = fixtures.createEmptyHabit();
        h4.setName(EMPTY_DESCRIPTION_HABIT_NAME);
        h4.setQuestion("Did you read books today?");
        h4.setDescription("");
        h4.setColor(2);
        habitList.update(h4);
    }

    protected void rotateDevice() throws Exception
    {
        device.setOrientationLeft();
        device.setOrientationNatural();
    }
}
