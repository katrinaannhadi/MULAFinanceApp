/* Mula */

package org.mula.finance.activities.habits.list.views

import android.content.*
import com.google.auto.factory.*
import org.mula.androidbase.activities.ActivityContext
import org.mula.finance.core.models.Timestamp
import org.mula.finance.core.preferences.Preferences
import org.mula.finance.core.utils.DateUtils

@AutoFactory
class NumberPanelView(
        @Provided @ActivityContext context: Context,
        @Provided preferences: Preferences,
        @Provided private val buttonFactory: NumberButtonViewFactory
) : ButtonPanelView<NumberButtonView>(context, preferences) {

    var values = DoubleArray(0)
        set(values) {
            field = values
            setupButtons()
        }

    var threshold = 0.0
        set(value) {
            field = value
            setupButtons()
        }

    var color = 0
        set(value) {
            field = value
            setupButtons()
        }

    var units = ""
        set(value) {
            field = value
            setupButtons()
        }

    var onEdit: (Timestamp) -> Unit = {}
        set(value) {
            field = value
            setupButtons()
        }

    override fun createButton() = buttonFactory.create()!!

    @Synchronized
    override fun setupButtons() {
        val today = DateUtils.getToday()

        buttons.forEachIndexed { index, button ->
            val timestamp = today.minus(index + dataOffset)
            button.value = when {
                index + dataOffset < values.size -> values[index + dataOffset]
                else -> 0.0
            }
            button.color = color
            button.threshold = threshold
            button.units = units
            button.onEdit = { onEdit(timestamp) }
        }
    }
}
