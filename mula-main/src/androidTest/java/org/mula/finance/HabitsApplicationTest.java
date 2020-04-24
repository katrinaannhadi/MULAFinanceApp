/* Mula */

package org.mula.finance;

import androidx.test.filters.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.*;
import org.junit.runner.*;
import org.mula.androidbase.AndroidBugReporter;

import java.io.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class HabitsApplicationTest extends BaseAndroidTest
{
    @Test
    public void test_getLogcat() throws IOException
    {
        String msg = "LOGCAT TEST";
        new RuntimeException(msg).printStackTrace();

        String log = new AndroidBugReporter(targetContext).getLogcat();
        assertThat(log, containsString(msg));
    }
}
