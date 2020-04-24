/* Mula */

package org.mula.finance.core.models;

import org.mula.finance.core.*;
import org.junit.*;

import static junit.framework.Assert.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsEqual.*;

public class WeekdayListTest extends BaseUnitTest
{
    @Test
    public void test()
    {
        int daysInt = 124;
        boolean[] daysArray = new boolean[]{
            false, false, true, true, true, true, true
        };

        WeekdayList list = new WeekdayList(daysArray);
        assertThat(list.toArray(), equalTo(daysArray));
        assertThat(list.toInteger(), equalTo(daysInt));

        list = new WeekdayList(daysInt);
        assertThat(list.toArray(), equalTo(daysArray));
        assertThat(list.toInteger(), equalTo(daysInt));
    }

    @Test
    public void testEmpty()
    {
        WeekdayList list = new WeekdayList(0);
        assertTrue(list.isEmpty());

        assertFalse(WeekdayList.EVERY_DAY.isEmpty());
    }
}
