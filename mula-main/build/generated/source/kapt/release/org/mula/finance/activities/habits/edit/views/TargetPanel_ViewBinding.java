// Generated code from Butter Knife. Do not modify!
package org.mula.finance.activities.habits.edit.views;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import org.mula.finance.R;

public class TargetPanel_ViewBinding implements Unbinder {
  private TargetPanel target;

  @UiThread
  public TargetPanel_ViewBinding(TargetPanel target) {
    this(target, target);
  }

  @UiThread
  public TargetPanel_ViewBinding(TargetPanel target, View source) {
    this.target = target;

    target.tvUnit = Utils.findRequiredViewAsType(source, R.id.tvUnit, "field 'tvUnit'", ExampleEditText.class);
    target.tvTargetValue = Utils.findRequiredViewAsType(source, R.id.tvTargetCount, "field 'tvTargetValue'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TargetPanel target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvUnit = null;
    target.tvTargetValue = null;
  }
}
