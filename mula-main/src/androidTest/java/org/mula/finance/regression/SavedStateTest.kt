/*
 * Copyright (C) 2020 Álinson Santos Xavier <mula@gmail.com>
 *
 * This file is part of Loop Habit Tracker.
 *
 * Loop Habit Tracker is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * Loop Habit Tracker is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.mula.finance.regression

import androidx.test.filters.*

import org.mula.finance.*
import org.junit.*

import org.mula.finance.acceptance.steps.CommonSteps.*
import org.mula.finance.acceptance.steps.EditHabitSteps.*
import org.mula.finance.acceptance.steps.ListHabitsSteps.*
import org.mula.finance.acceptance.steps.ListHabitsSteps.MenuItem.*
import org.mula.finance.acceptance.steps.WidgetSteps.clickText
import org.mula.finance.activities.about.*
import java.lang.Thread.*

@LargeTest
class SavedStateTest : BaseUserInterfaceTest() {

    @Test
    @Throws(Exception::class)
    fun shouldNotCrashWhenRotatingWeekdayPickerDialog() {
        // https://github.com/iSoron/uhabits/issues/534
        launchApp()
        clickMenu(ADD)
        setReminder()
        clickReminderDays()
        unselectAllDays()
        rotateDevice()
        clickText("Monday")
    }

    /**
     * Make sure that the main activity can be recreated by using
     * BundleSavedState after being destroyed. See bug:
     * https://github.com/iSoron/finance/issues/287
     */
    @Test
    @Throws(Exception::class)
    fun testBundleSavedState() {
        launchApp()
        startActivity(AboutActivity::class.java)
        sleep(1000)
        device.pressBack()
    }
}