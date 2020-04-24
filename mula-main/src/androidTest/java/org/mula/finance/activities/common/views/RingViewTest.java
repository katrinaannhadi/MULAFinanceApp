/* Mula */

package org.mula.finance.activities.common.views;

import android.graphics.*;
import androidx.test.filters.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.mula.finance.*;
import org.mula.finance.utils.*;
import org.junit.*;
import org.junit.runner.*;

import java.io.*;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class RingViewTest extends BaseViewTest
{
    private static final String BASE_PATH = "common/RingView/";

    private RingView view;

    @Override
    @Before
    public void setUp()
    {
        super.setUp();

        view = new RingView(targetContext);
        view.setPercentage(0.6f);
        view.setText("60%");
        view.setColor(PaletteUtils.getAndroidTestColor(0));
        view.setBackgroundColor(Color.WHITE);
        view.setThickness(dpToPixels(3));
    }

    @Test
    public void testRender_base() throws IOException
    {
        measureView(view, dpToPixels(100), dpToPixels(100));
        assertRenders(view, BASE_PATH + "render.png");
    }

    @Test
    public void testRender_withDifferentParams() throws IOException
    {
        view.setPercentage(0.25f);
        view.setColor(PaletteUtils.getAndroidTestColor(5));

        measureView(view, dpToPixels(200), dpToPixels(200));
        assertRenders(view, BASE_PATH + "renderDifferentParams.png");
    }
}
