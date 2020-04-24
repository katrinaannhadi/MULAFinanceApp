// Generated code from Butter Knife. Do not modify!
package org.mula.finance.activities.habits.edit.views;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import org.mula.finance.R;

public class ReminderPanel_ViewBinding implements Unbinder {
  private ReminderPanel target;

  private View view7f0a0249;

  private View view7f0a0248;

  @UiThread
  public ReminderPanel_ViewBinding(ReminderPanel target) {
    this(target, target);
  }

  @UiThread
  public ReminderPanel_ViewBinding(final ReminderPanel target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tvReminderTime, "field 'tvReminderTime' and method 'onDateSpinnerClick'");
    target.tvReminderTime = Utils.castView(view, R.id.tvReminderTime, "field 'tvReminderTime'", TextView.class);
    view7f0a0249 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onDateSpinnerClick();
      }
    });
    target.llReminderDays = Utils.findRequiredViewAsType(source, R.id.llReminderDays, "field 'llReminderDays'", ViewGroup.class);
    view = Utils.findRequiredView(source, R.id.tvReminderDays, "field 'tvReminderDays' and method 'onWeekdayClicked'");
    target.tvReminderDays = Utils.castView(view, R.id.tvReminderDays, "field 'tvReminderDays'", TextView.class);
    view7f0a0248 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onWeekdayClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ReminderPanel target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvReminderTime = null;
    target.llReminderDays = null;
    target.tvReminderDays = null;

    view7f0a0249.setOnClickListener(null);
    view7f0a0249 = null;
    view7f0a0248.setOnClickListener(null);
    view7f0a0248 = null;
  }
}
