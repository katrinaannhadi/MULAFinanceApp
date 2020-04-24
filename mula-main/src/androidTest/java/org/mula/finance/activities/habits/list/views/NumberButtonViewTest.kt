/* Mula */

package org.mula.finance.activities.habits.list.views

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.*
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.*
import org.mula.finance.*
import org.mula.finance.utils.*
import org.junit.*
import org.junit.runner.*

@RunWith(AndroidJUnit4::class)
@MediumTest
class NumberButtonViewTest : BaseViewTest() {

    private val PATH = "habits/list/NumberButtonView"
    private lateinit var view: NumberButtonView
    var edited = false

    @Before
    override fun setUp() {
        super.setUp()
        view = component.getNumberButtonViewFactory().create().apply {
            units = "steps"
            threshold = 100.0
            color = PaletteUtils.getAndroidTestColor(8)
            onEdit = { edited = true }
        }
        measureView(view, dpToPixels(48), dpToPixels(48))
    }

    @Test
    fun testFormatValue() {
        assertThat(0.1235.toShortString(), equalTo("0.12"))
        assertThat(0.1000.toShortString(), equalTo("0.1"))
        assertThat(5.0.toShortString(), equalTo("5"))
        assertThat(5.25.toShortString(), equalTo("5.25"))
        assertThat(12.3456.toShortString(), equalTo("12.3"))
        assertThat(123.123.toShortString(), equalTo("123"))
        assertThat(321.2.toShortString(), equalTo("321"))
        assertThat(4321.2.toShortString(), equalTo("4.3k"))
        assertThat(54321.2.toShortString(), equalTo("54.3k"))
        assertThat(654321.2.toShortString(), equalTo("654k"))
        assertThat(7654321.2.toShortString(), equalTo("7.7M"))
        assertThat(87654321.2.toShortString(), equalTo("87.7M"))
        assertThat(987654321.2.toShortString(), equalTo("988M"))
        assertThat(1987654321.2.toShortString(), equalTo("2.0G"))
    }

    @Test
    fun testRender_aboveThreshold() {
        view.value = 500.0
        assertRenders(view, "$PATH/render_above.png")
    }

    @Test
    fun testRender_belowThreshold() {
        view.value = 99.0
        assertRenders(view, "$PATH/render_below.png")
    }

    @Test
    fun testRender_zero() {
        view.value = 0.0
        assertRenders(view, "$PATH/render_zero.png")
    }

    @Test
    fun testClick_shortToggleDisabled() {
        prefs.isShortToggleEnabled = false
        view.performClick()
        assertFalse(edited)
    }

    @Test
    fun testClick_shortToggleEnabled() {
        prefs.isShortToggleEnabled = true
        view.performClick()
        assertTrue(edited)
    }

    @Test
    fun testLongClick() {
        view.performLongClick()
        assertTrue(edited)
    }
}