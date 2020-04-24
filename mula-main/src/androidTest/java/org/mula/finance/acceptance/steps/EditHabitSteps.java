/* Mula */

package org.mula.finance.acceptance.steps;

import androidx.test.uiautomator.*;

import org.mula.finance.*;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.mula.finance.BaseUserInterfaceTest.*;

public class EditHabitSteps
{
    public static void clickSave()
    {
        onView(withId(R.id.buttonSave)).perform(click());
    }

    public static void pickFrequency(String freq)
    {
        onView(withId(R.id.spinner)).perform(click());
        device.findObject(By.text(freq)).click();
    }

    public static void pickColor(int color)
    {
        onView(withId(R.id.buttonPickColor)).perform(click());
        device.findObject(By.descStartsWith(String.format("Color %d", color))).click();
    }

    public static void typeName(String name)
    {
        typeTextWithId(R.id.tvName, name);
    }

    public static void typeQuestion(String name)
    {
        typeTextWithId(R.id.tvQuestion, name);
    }

    public static void typeDescription(String description)
    {
        typeTextWithId(R.id.tvDescription, description);
    }

    public static void setReminder()
    {
        onView(withId(R.id.tvReminderTime)).perform(click());
        onView(withId(R.id.done_button)).perform(click());
    }

    public static void clickReminderDays()
    {
        onView(withId(R.id.tvReminderDays)).perform(click());
    }

    public static void unselectAllDays()
    {
        onView(withText("Saturday")).perform(click());
        onView(withText("Sunday")).perform(click());
        onView(withText("Monday")).perform(click());
        onView(withText("Tuesday")).perform(click());
        onView(withText("Wednesday")).perform(click());
        onView(withText("Thursday")).perform(click());
        onView(withText("Friday")).perform(click());
    }

    private static void typeTextWithId(int id, String name)
    {
        onView(withId(id)).perform(clearText(), typeText(name), closeSoftKeyboard());
    }
}
