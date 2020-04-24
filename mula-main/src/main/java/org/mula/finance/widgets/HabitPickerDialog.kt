/* Mula */

package org.mula.finance.widgets

import android.app.*
import android.appwidget.AppWidgetManager.*
import android.content.*
import android.os.*
import android.widget.*
import android.widget.AbsListView.*
import org.mula.finance.*
import org.mula.finance.core.preferences.WidgetPreferences
import java.util.*

class HabitPickerDialog : Activity() {

    private var widgetId = 0
    private lateinit var widgetPreferences: WidgetPreferences
    private lateinit var widgetUpdater: WidgetUpdater

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = (applicationContext as HabitsApplication).component
        val habitList = component.habitList
        val preferences = component.preferences
        widgetPreferences = component.widgetPreferences
        widgetUpdater = component.widgetUpdater
        widgetId = intent.extras?.getInt(EXTRA_APPWIDGET_ID, INVALID_APPWIDGET_ID) ?: 0

        val habitIds = ArrayList<Long>()
        val habitNames = ArrayList<String>()
        for (h in habitList) {
            if (h.isArchived) continue
            habitIds.add(h.id!!)
            habitNames.add(h.name)
        }

        setContentView(R.layout.widget_configure_activity)
        val listView = findViewById<ListView>(R.id.listView)
        val saveButton = findViewById<Button>(R.id.buttonSave)

        if(preferences.isWidgetStackEnabled) {
            with(listView) {
                adapter = ArrayAdapter(context,
                                       android.R.layout.simple_list_item_multiple_choice,
                                       habitNames)
                choiceMode = CHOICE_MODE_MULTIPLE
                itemsCanFocus = false
            }
            saveButton.setOnClickListener {
                val selectedIds = mutableListOf<Long>()
                for (i in 0..listView.count) {
                    if (listView.isItemChecked(i)) {
                        selectedIds.add(habitIds[i])
                    }
                }
                confirm(selectedIds)
            }
        } else {
            saveButton.visibility = GONE
            with(listView) {
                adapter = ArrayAdapter(context,
                                       android.R.layout.simple_list_item_1,
                                       habitNames)
                choiceMode = CHOICE_MODE_SINGLE
                itemsCanFocus = false
            }
            listView.setOnItemClickListener { _, _, position, _ ->
                confirm(listOf(habitIds[position]))
            }
        }
    }

    fun confirm(selectedIds: List<Long>) {
        widgetPreferences.addWidget(widgetId, selectedIds.toLongArray())
        widgetUpdater.updateWidgets()
        setResult(RESULT_OK, Intent().apply {
            putExtra(EXTRA_APPWIDGET_ID, widgetId)
        })
        finish()
    }
}