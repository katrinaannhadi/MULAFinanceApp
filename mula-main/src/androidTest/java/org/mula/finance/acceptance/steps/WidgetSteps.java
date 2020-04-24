/* Mula */

package org.mula.finance.acceptance.steps;

import androidx.test.uiautomator.*;

import static android.os.Build.VERSION.SDK_INT;
import static junit.framework.Assert.*;
import static org.mula.finance.BaseUserInterfaceTest.*;

public class WidgetSteps {
    public static void clickCheckmarkWidget() throws Exception {
        String view_id = "org.mula.finance:id/imageView";
        device.findObject(new UiSelector().resourceId(view_id)).click();
    }

    public static void clickText(String s) throws Exception {
        UiObject object = device.findObject(new UiSelector().text(s));
        if (!object.waitForExists(1000)) {
            object = device.findObject(new UiSelector().text(s.toUpperCase()));
        }
        object.click();
    }

    public static void dragCheckmarkWidgetToHomeScreen() throws Exception {
        openWidgetScreen();
        dragWidgetToHomeScreen();
    }

    private static void dragWidgetToHomeScreen() throws Exception {
        int height = device.getDisplayHeight();
        int width = device.getDisplayWidth();
        device.findObject(new UiSelector().text("Checkmark"))
                .dragTo(width / 2, height / 2, 8);
    }

    private static void openWidgetScreen() throws Exception {
        int h = device.getDisplayHeight();
        int w = device.getDisplayWidth();
        if (SDK_INT <= 21) {
            device.pressHome();
            device.waitForIdle();
            device.findObject(new UiSelector().description("Apps")).click();
            device.findObject(new UiSelector().description("Apps")).click();
            device.findObject(new UiSelector().description("Widgets")).click();
        } else {
            String list_id = "com.android.launcher3:id/widgets_list_view";
            device.pressHome();
            device.waitForIdle();
            device.drag(w / 2, h / 2, w / 2, h / 2, 8);
            UiObject button = device.findObject(new UiSelector().text("WIDGETS"));
            if(!button.waitForExists(1000)) {
                button = device.findObject(new UiSelector().text("Widgets"));
            }
            button.click();
            if (SDK_INT == 28) {
                new UiScrollable(new UiSelector().resourceId(list_id))
                        .scrollForward();
            }
            new UiScrollable(new UiSelector().resourceId(list_id))
                    .scrollIntoView(new UiSelector().text("Checkmark"));
        }
    }

    public static void verifyCheckmarkWidgetIsShown() throws Exception {
        String view_id = "org.mula.finance:id/imageView";
        assertTrue(device.findObject(new UiSelector().resourceId(view_id)).exists());
        assertFalse(device.findObject(new UiSelector().textStartsWith("Habit deleted")).exists());
    }
}
