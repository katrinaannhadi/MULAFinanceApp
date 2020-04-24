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
public class LinksTest extends BaseUserInterfaceTest
{
    @Test
    public void shouldLinkToSourceCode() throws Exception
    {
        launchApp();
        clickMenu(ABOUT);
        clickText("View source code at GitHub");
        verifyOpensWebsite("https://github.com/iSoron/uhabits");
    }

//    @Test
//    public void shouldLinkToTranslationWebsite() throws Exception
//    {
//        launchApp();
//        clickMenu(ABOUT);
//        clickText("Help translate this app");
//        verifyOpensWebsite("translate.loophabits.org");
//    }

    @Test
    public void shouldLinkToHelp() throws Exception {
        launchApp();
        clickMenu(HELP);
        verifyOpensWebsite("loophabits.org/faq.html");
    }

    @Test
    public void shouldLinkToHelpFromSettings() throws Exception {
        launchApp();
        clickMenu(SETTINGS);
        clickText("Help & FAQ");
        verifyOpensWebsite("loophabits.org/faq.html");
    }
}
