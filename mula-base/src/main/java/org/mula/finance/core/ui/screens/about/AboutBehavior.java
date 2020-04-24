/* Mula */

package org.mula.finance.core.ui.screens.about;

import androidx.annotation.*;

import org.mula.finance.core.preferences.Preferences;

import javax.inject.*;

public class AboutBehavior
{
    private int developerCountdown = 5;

    @NonNull
    private Preferences prefs;

    @NonNull
    private Screen screen;

    @Inject
    public AboutBehavior(@NonNull Preferences prefs, @NonNull Screen screen)
    {
        this.prefs = prefs;
        this.screen = screen;
    }

    public void onPressDeveloperCountdown()
    {
        developerCountdown--;
        if (developerCountdown == 0)
        {
            prefs.setDeveloper(true);
            screen.showMessage(Message.YOU_ARE_NOW_A_DEVELOPER);
        }
    }

    public void onRateApp()
    {
        screen.showRateAppWebsite();
    }

    public void onSendFeedback()
    {
        screen.showSendFeedbackScreen();
    }

    public void onTranslateApp()
    {
        screen.showTranslationWebsite();
    }

    public void onViewSourceCode()
    {
        screen.showSourceCodeWebsite();
    }

    public void onClickPrivacy() {
        screen.showPrivacyPolicyWebsite();
    }

    public void onClickCodeContributors() {
        screen.showCodeContributorsWebsite();
    }

    public enum Message
    {
        YOU_ARE_NOW_A_DEVELOPER
    }

    public interface Screen
    {
        void showMessage(Message message);

        void showRateAppWebsite();

        void showSendFeedbackScreen();

        void showSourceCodeWebsite();

        void showTranslationWebsite();

        void showPrivacyPolicyWebsite();

        void showCodeContributorsWebsite();
    }

}
