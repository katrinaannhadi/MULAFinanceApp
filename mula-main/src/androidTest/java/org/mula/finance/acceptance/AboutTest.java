/* Mula */

package org.mula.finance.acceptance;

import androidx.test.filters.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.mula.finance.*;
import org.junit.*;
import org.junit.runner.*;

import static org.mula.finance.acceptance.steps.CommonSteps.*;
import static org.mula.finance.acceptance.steps.ListHabitsSteps.MenuItem.*;
import static org.mula.finance.acceptance.steps.ListHabitsSteps.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AboutTest extends BaseUserInterfaceTest
{
    @Test
    public void shouldDisplayAboutScreen() {
        launchApp();
        clickMenu(ABOUT);
        verifyDisplaysText("Loop Habit Tracker");
        verifyDisplaysText("Rate this app on Google Play");
        verifyDisplaysText("Developers");
        verifyDisplaysText("Translators");
    }

    @Test
    public void shouldDisplayAboutScreenFromSettings() {
        launchApp();
        clickMenu(SETTINGS);
        clickText("About");
        verifyDisplaysText("Translators");
    }
}
