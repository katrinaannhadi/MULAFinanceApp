/* Mula */

package org.mula.finance.activities.habits.list.views

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.*
import org.mula.finance.*
import org.mula.finance.utils.*
import org.junit.*
import org.junit.runner.*
import org.mula.finance.core.models.Checkmark

@RunWith(AndroidJUnit4::class)
@MediumTest
class CheckmarkButtonViewTest : BaseViewTest() {

    private val PATH = "habits/list/CheckmarkButtonView"
    lateinit var view: CheckmarkButtonView

    var toggled = false

    @Before
    override fun setUp() {
        super.setUp()
        view = component.getCheckmarkButtonViewFactory().create().apply {
            value = Checkmark.UNCHECKED
            color = PaletteUtils.getAndroidTestColor(5)
            onToggle = { toggled = true }
        }
        measureView(view, dpToPixels(48), dpToPixels(48))
    }

    @Test
    fun testRender_explicitCheck() {
        view.value = Checkmark.CHECKED_EXPLICITLY
        assertRendersCheckedExplicitly()
    }

    @Test
    fun testRender_implicitCheck() {
        view.value = Checkmark.CHECKED_IMPLICITLY
        assertRendersCheckedImplicitly()
    }

    @Test
    fun testRender_unchecked() {
        view.value = Checkmark.UNCHECKED
        assertRendersUnchecked()
    }

    @Test
    fun testClick_withShortToggleDisabled() {
        prefs.isShortToggleEnabled = false
        view.performClick()
        assertFalse(toggled)
    }

    @Test
    fun testClick_withShortToggleEnabled() {
        prefs.isShortToggleEnabled = true
        view.performClick()
        assertTrue(toggled)
    }

    @Test
    fun testLongClick() {
        view.performLongClick()
        assertTrue(toggled)
    }

    private fun assertRendersCheckedExplicitly() {
        assertRenders(view, "$PATH/render_explicit_check.png")
    }

    private fun assertRendersCheckedImplicitly() {
        assertRenders(view, "$PATH/render_implicit_check.png")
    }

    private fun assertRendersUnchecked() {
        assertRenders(view, "$PATH/render_unchecked.png")
    }
}