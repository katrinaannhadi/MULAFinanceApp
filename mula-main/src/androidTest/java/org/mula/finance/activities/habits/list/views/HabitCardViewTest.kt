/* Mula */

package org.mula.finance.activities.habits.list.views

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.*
import org.mula.finance.*
import org.junit.*
import org.junit.runner.*
import org.mula.finance.core.models.Habit

@RunWith(AndroidJUnit4::class)
@MediumTest
class HabitCardViewTest : BaseViewTest() {

    val PATH = "habits/list/HabitCardView"
    lateinit private var view: HabitCardView
    lateinit private var habit1: Habit
    lateinit private var habit2: Habit

    override fun setUp() {
        super.setUp()
        setTheme(R.style.AppBaseTheme)

        habit1 = fixtures.createLongHabit()
        habit2 = fixtures.createLongNumericalHabit()
        view = component.getHabitCardViewFactory().create().apply {
            habit = habit1
            values = habit1.checkmarks.allValues
            score = habit1.scores.todayValue
            isSelected = false
            buttonCount = 5
        }
        latch.countDown()

        latch.await()
        measureView(view, dpToPixels(400), dpToPixels(50))
    }

    @Test
    fun testRender() {
        assertRenders(view, "$PATH/render.png")
    }

    @Test
    fun testRender_selected() {
        view.isSelected = true
        measureView(view, dpToPixels(400), dpToPixels(50))
        assertRenders(view, "$PATH/render_selected.png")
    }

    @Test
    fun testRender_numerical() {
        view.apply {
            habit = habit2
            values = habit2.checkmarks.allValues
        }
        assertRenders(view, "$PATH/render_numerical.png")
    }

    @Test
    fun testChangeModel() {
        habit1.name = "Wake up early"
        habit1.color = 2
        habit1.observable.notifyListeners()
        Thread.sleep(500)
        assertRenders(view, "$PATH/render_changed.png")
    }
}
