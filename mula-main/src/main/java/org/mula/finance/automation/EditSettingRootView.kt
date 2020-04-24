/* Mula */

package org.mula.finance.automation

import android.R.layout.*
import android.content.*
import androidx.appcompat.widget.*
import androidx.appcompat.widget.Toolbar
import android.widget.*
import butterknife.*
import org.mula.finance.R
import org.mula.androidbase.activities.BaseRootView
import org.mula.androidbase.utils.StyledResources
import org.mula.finance.core.models.HabitList
import java.util.*

class EditSettingRootView(
        context: Context,
        private val habitList: HabitList,
        private val controller: EditSettingController,
        args: SettingUtils.Arguments?
) : BaseRootView(context) {

    @BindView(R.id.toolbar)
    lateinit var tbar: Toolbar

    @BindView(R.id.habitSpinner)
    lateinit var habitSpinner: AppCompatSpinner

    @BindView(R.id.actionSpinner)
    lateinit var actionSpinner: AppCompatSpinner

    init {
        addView(inflate(getContext(), R.layout.automation, null))
        ButterKnife.bind(this)
        populateHabitSpinner()

        args?.let {
            habitSpinner.setSelection(habitList.indexOf(it.habit))
            actionSpinner.setSelection(it.action)
        }
    }

    override fun getToolbar(): Toolbar {
        return tbar
    }

    override fun getToolbarColor(): Int {
        val res = StyledResources(context)
        if (!res.getBoolean(R.attr.useGoalColorAsPrimary))
            return super.getToolbarColor()

        return res.getColor(R.attr.aboutScreenColor)
    }

    @OnClick(R.id.buttonSave)
    fun onClickSave() {
        val action = actionSpinner.selectedItemPosition
        val habitPosition = habitSpinner.selectedItemPosition
        val habit = habitList.getByPosition(habitPosition)
        controller.onSave(habit, action)
    }

    private fun populateHabitSpinner() {
        val names = habitList.mapTo(LinkedList<String>()) { it.name }
        val adapter = ArrayAdapter(context, simple_spinner_item, names)
        adapter.setDropDownViewResource(simple_spinner_dropdown_item)
        habitSpinner.adapter = adapter
    }
}
