/* Mula */

package org.mula.finance.acceptance;

import androidx.test.filters.*;

import org.mula.finance.*;
import org.junit.*;

import static org.mula.finance.acceptance.steps.CommonSteps.*;
import static org.mula.finance.acceptance.steps.WidgetSteps.*;
import static org.mula.finance.acceptance.steps.WidgetSteps.clickText;

@LargeTest
public class WidgetTest extends BaseUserInterfaceTest
{
    @Test
    public void shouldCreateAndToggleCheckmarkWidget() throws Exception
    {
        dragCheckmarkWidgetToHomeScreen();
        clickText("Wake up early");
        verifyCheckmarkWidgetIsShown();
        clickCheckmarkWidget();

        launchApp();
        clickText("Wake up early");
        verifyDisplaysText("5%");

        pressHome();
        clickCheckmarkWidget();

        launchApp();
        clickText("Wake up early");
        verifyDisplaysText("0%");
    }
}
