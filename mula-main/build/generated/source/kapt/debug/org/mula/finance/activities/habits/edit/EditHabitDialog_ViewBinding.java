// Generated code from Butter Knife. Do not modify!
package org.mula.finance.activities.habits.edit;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import org.mula.finance.R;
import org.mula.finance.activities.habits.edit.views.FrequencyPanel;
import org.mula.finance.activities.habits.edit.views.NameDescriptionPanel;
import org.mula.finance.activities.habits.edit.views.ReminderPanel;
import org.mula.finance.activities.habits.edit.views.TargetPanel;

public class EditHabitDialog_ViewBinding implements Unbinder {
  private EditHabitDialog target;

  private View view7f0a0081;

  private View view7f0a0087;

  @UiThread
  public EditHabitDialog_ViewBinding(final EditHabitDialog target, View source) {
    this.target = target;

    View view;
    target.namePanel = Utils.findRequiredViewAsType(source, R.id.namePanel, "field 'namePanel'", NameDescriptionPanel.class);
    target.reminderPanel = Utils.findRequiredViewAsType(source, R.id.reminderPanel, "field 'reminderPanel'", ReminderPanel.class);
    target.frequencyPanel = Utils.findRequiredViewAsType(source, R.id.frequencyPanel, "field 'frequencyPanel'", FrequencyPanel.class);
    target.targetPanel = Utils.findRequiredViewAsType(source, R.id.targetPanel, "field 'targetPanel'", TargetPanel.class);
    view = Utils.findRequiredView(source, R.id.buttonDiscard, "method 'onButtonDiscardClick'");
    view7f0a0081 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onButtonDiscardClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.buttonSave, "method 'onSaveButtonClick'");
    view7f0a0087 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onSaveButtonClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    EditHabitDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.namePanel = null;
    target.reminderPanel = null;
    target.frequencyPanel = null;
    target.targetPanel = null;

    view7f0a0081.setOnClickListener(null);
    view7f0a0081 = null;
    view7f0a0087.setOnClickListener(null);
    view7f0a0087 = null;
  }
}
