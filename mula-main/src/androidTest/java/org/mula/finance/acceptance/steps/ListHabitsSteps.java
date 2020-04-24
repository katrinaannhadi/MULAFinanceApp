/* Mula */

package org.mula.finance.acceptance.steps;

import androidx.test.espresso.*;
import android.view.*;

import org.hamcrest.*;
import org.mula.finance.R;
import org.mula.finance.activities.habits.list.views.*;

import java.util.*;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.*;
import static org.mula.finance.BaseUserInterfaceTest.device;
import static org.mula.finance.acceptance.steps.CommonSteps.clickText;

public abstract class ListHabitsSteps
{
    public static void clickMenu(MenuItem item)
    {
        switch (item)
        {
            case ABOUT:
                clickTextInsideOverflowMenu(R.string.about);
                break;

            case HELP:
                clickTextInsideOverflowMenu(R.string.help);
                break;

            case SETTINGS:
                clickTextInsideOverflowMenu(R.string.settings);
                break;

            case ADD:
                clickViewWithId(R.id.actionCreateBooleanHabit);
                break;

            case EDIT:
                clickViewWithId(R.id.action_edit_habit);
                break;

            case DELETE:
                clickTextInsideOverflowMenu(R.string.delete);
                break;

            case ARCHIVE:
                clickTextInsideOverflowMenu(R.string.archive);
                break;

            case UNARCHIVE:
                clickTextInsideOverflowMenu(R.string.unarchive);
                break;

            case TOGGLE_ARCHIVED:
                clickViewWithId(R.id.action_filter);
                clickText(R.string.hide_archived);
                break;

            case TOGGLE_COMPLETED:
                clickViewWithId(R.id.action_filter);
                clickText(R.string.hide_completed);
                break;
        }
    }

    private static void clickTextInsideOverflowMenu(int id) {
        onView(allOf(withContentDescription("More options"), withParent(withParent(withClassName(endsWith("Toolbar")))))).perform(click());
        onView(withText(id)).perform(click());
    }

    private static void clickViewWithId(int id)
    {
        onView(withId(id)).perform(click());
    }

    private static ViewAction longClickDescendantWithClass(Class cls, int count)
    {
        return new ViewAction()
        {

            @Override
            public Matcher<View> getConstraints()
            {
                return isEnabled();
            }

            @Override
            public String getDescription()
            {
                return "perform on children";
            }

            @Override
            public void perform(UiController uiController, View view)
            {
                LinkedList<ViewGroup> stack = new LinkedList<>();
                if (view instanceof ViewGroup) stack.push((ViewGroup) view);
                int countRemaining = count;

                while (!stack.isEmpty())
                {
                    ViewGroup vg = stack.pop();
                    for (int i = 0; i < vg.getChildCount(); i++)
                    {
                        View v = vg.getChildAt(i);
                        if (v instanceof ViewGroup) stack.push((ViewGroup) v);
                        if (cls.isInstance(v) && countRemaining > 0)
                        {
                            v.performLongClick();
                            uiController.loopMainThreadUntilIdle();
                            countRemaining--;
                        }
                    }
                }
            }
        };
    }

    public static void longPressCheckmarks(String habit, int count)
    {
        CommonSteps.scrollToText(habit);
        onView(allOf(hasDescendant(withText(habit)),
            withClassName(endsWith("HabitCardView")))).perform(
            longClickDescendantWithClass(CheckmarkButtonView.class, count));
        device.waitForIdle();
    }

    public enum MenuItem
    {
        ABOUT, HELP, SETTINGS, EDIT, DELETE, ARCHIVE, TOGGLE_ARCHIVED,
        UNARCHIVE, TOGGLE_COMPLETED, ADD
    }
}
