/* Mula */

package org.mula.finance.core.ui.screens.about;

import org.mula.finance.core.*;
import org.junit.*;
import org.mockito.*;
import org.mula.finance.core.preferences.Preferences;

import static org.mula.finance.core.ui.screens.about.AboutBehavior.Message.YOU_ARE_NOW_A_DEVELOPER;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

public class AboutBehaviorTest extends BaseUnitTest
{
    private AboutBehavior behavior;

    @Mock
    private Preferences prefs;

    @Mock
    private AboutBehavior.Screen screen;

    @Before
    public void setUp() throws Exception
    {
        super.setUp();
        behavior = new AboutBehavior(prefs, screen);
    }

    @Test
    public void onPressDeveloperCountdown() throws Exception
    {
        behavior.onPressDeveloperCountdown();
        behavior.onPressDeveloperCountdown();
        behavior.onPressDeveloperCountdown();
        behavior.onPressDeveloperCountdown();
        verifyZeroInteractions(screen);
        verifyZeroInteractions(prefs);

        behavior.onPressDeveloperCountdown();
        verify(screen).showMessage(YOU_ARE_NOW_A_DEVELOPER);
        verify(prefs).setDeveloper(true);

        behavior.onPressDeveloperCountdown();
        verifyZeroInteractions(screen);
        verifyZeroInteractions(prefs);
    }

    @Test
    public void onRateApp() throws Exception
    {
        behavior.onRateApp();
        verify(screen).showRateAppWebsite();
    }

    @Test
    public void onSendFeedback() throws Exception
    {
        behavior.onSendFeedback();
        verify(screen).showSendFeedbackScreen();
    }

    @Test
    public void onTranslateApp() throws Exception
    {
        behavior.onTranslateApp();
        verify(screen).showTranslationWebsite();
    }

    @Test
    public void onViewSourceCode() throws Exception
    {
        behavior.onViewSourceCode();
        verify(screen).showSourceCodeWebsite();
    }

}