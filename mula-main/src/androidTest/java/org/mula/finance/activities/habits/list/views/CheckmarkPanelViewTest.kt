/* Mula */

package org.mula.finance.activities.habits.list.views

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.*
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.*
import org.mula.finance.*
import org.mula.finance.core.models.Checkmark.*
import org.mula.finance.utils.*
import org.junit.*
import org.junit.runner.*
import org.mula.finance.core.models.Timestamp

@RunWith(AndroidJUnit4::class)
@MediumTest
class CheckmarkPanelViewTest : BaseViewTest() {

    private val PATH = "habits/list/CheckmarkPanelView"
    private lateinit var view: CheckmarkPanelView

    @Before
    override fun setUp() {
        super.setUp()
        prefs.isCheckmarkSequenceReversed = false

        val checkmarks = intArrayOf(CHECKED_EXPLICITLY,
                                    CHECKED_EXPLICITLY,
                                    CHECKED_IMPLICITLY,
                                    UNCHECKED,
                                    UNCHECKED,
                                    UNCHECKED,
                                    CHECKED_EXPLICITLY)

        view = component.getCheckmarkPanelViewFactory().create().apply {
            values = checkmarks
            buttonCount = 4
            color = PaletteUtils.getAndroidTestColor(7)
        }
        view.onAttachedToWindow()
        measureView(view, dpToPixels(200), dpToPixels(200))
    }

    @After
    public override fun tearDown() {
        super.tearDown()
    }

    @Test
    fun testRender() {
        assertRenders(view, "$PATH/render.png")
    }

//    // Flaky test
//    @Test
//    fun testRender_withDifferentColor() {
//        view.color = PaletteUtils.getAndroidTestColor(1)
//        assertRenders(view, "$PATH/render_different_color.png")
//    }

//    // Flaky test
//    @Test
//    fun testRender_Reversed() {
//        prefs.isCheckmarkSequenceReversed = true
//        assertRenders(view, "$PATH/render_reversed.png")
//    }

//    // Flaky test
//    @Test
//    fun testRender_withOffset() {
//        view.dataOffset = 3
//        assertRenders(view, "$PATH/render_offset.png")
//    }

    @Test
    fun testToggle() {
        var timestamps = mutableListOf<Timestamp>()
        view.onToggle = { timestamps.add(it) }
        view.buttons[0].performLongClick()
        view.buttons[2].performLongClick()
        view.buttons[3].performLongClick()
        assertThat(timestamps, equalTo(listOf(day(0), day(2), day(3))))
    }

    @Test
    fun testToggle_withOffset() {
        val timestamps = mutableListOf<Timestamp>()
        view.dataOffset = 3
        view.onToggle = { timestamps += it }
        view.buttons[0].performLongClick()
        view.buttons[2].performLongClick()
        view.buttons[3].performLongClick()
        assertThat(timestamps, equalTo(listOf(day(3), day(5), day(6))))
    }
}