/* Mula */

package org.mula.finance.core.models;

import org.mula.finance.core.*;
import org.junit.*;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsEqual.*;
import static org.hamcrest.number.IsCloseTo.*;
import static org.mula.finance.core.models.Score.*;


public class ScoreTest extends BaseUnitTest
{
    private static final double E = 1e-6;

    @Override
    @Before
    public void setUp() throws Exception
    {
        super.setUp();
    }

    @Test
    public void test_compute_withDailyHabit()
    {
        int check = 1;
        double freq = 1.0;
        assertThat(compute(freq, 0, check), closeTo(0.051922, E));
        assertThat(compute(freq, 0.5, check), closeTo(0.525961, E));
        assertThat(compute(freq, 0.75, check), closeTo(0.762981, E));

        check = 0;
        assertThat(compute(freq, 0, check), closeTo(0, E));
        assertThat(compute(freq, 0.5, check), closeTo(0.474039, E));
        assertThat(compute(freq, 0.75, check), closeTo(0.711058, E));
    }

    @Test
    public void test_compute_withNonDailyHabit()
    {
        int check = 1;
        double freq = 1 / 3.0;
        assertThat(compute(freq, 0, check), closeTo(0.017616, E));
        assertThat(compute(freq, 0.5, check), closeTo(0.508808, E));
        assertThat(compute(freq, 0.75, check), closeTo(0.754404, E));

        check = 0;
        assertThat(compute(freq, 0, check), closeTo(0.0, E));
        assertThat(compute(freq, 0.5, check), closeTo(0.491192, E));
        assertThat(compute(freq, 0.75, check), closeTo(0.736788, E));
    }


    @Test
    public void testToString() throws Exception
    {
        Score score = new Score(Timestamp.ZERO.plus(100), 150.0);
        assertThat(score.toString(), equalTo( "{timestamp: 1970-04-11, value: 150.0}"));
    }
}
