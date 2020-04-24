/* Mula */

package org.mula.finance.activities.common.views

import android.content.*
import android.widget.*
import org.mula.androidbase.activities.BaseRootView
import org.mula.finance.core.tasks.Task
import org.mula.finance.core.tasks.TaskRunner

class TaskProgressBar(
        context: Context,
        private val runner: TaskRunner
) : ProgressBar(
        context,
        null,
        android.R.attr.progressBarStyleHorizontal
), TaskRunner.Listener {

    init {
        visibility = BaseRootView.GONE
        isIndeterminate = true
    }

    override fun onTaskStarted(task: Task?) = update()
    override fun onTaskFinished(task: Task?) = update()

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        runner.addListener(this)
        update()
    }

    override fun onDetachedFromWindow() {
        runner.removeListener(this)
        super.onDetachedFromWindow()
    }

    fun update() {
        val callback = {
            val activeTaskCount = runner.activeTaskCount
            val newVisibility = when (activeTaskCount) {
                0 -> GONE
                else -> VISIBLE
            }
            if (visibility != newVisibility) visibility = newVisibility
        }
        postDelayed(callback, 500)
    }
}
