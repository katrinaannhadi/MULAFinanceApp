// Generated code from Butter Knife. Do not modify!
package org.mula.finance.activities.habits.show.views;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import org.mula.finance.R;
import org.mula.finance.activities.common.views.StreakChart;

public class StreakCard_ViewBinding implements Unbinder {
  private StreakCard target;

  @UiThread
  public StreakCard_ViewBinding(StreakCard target) {
    this(target, target);
  }

  @UiThread
  public StreakCard_ViewBinding(StreakCard target, View source) {
    this.target = target;

    target.title = Utils.findRequiredViewAsType(source, R.id.title, "field 'title'", TextView.class);
    target.streakChart = Utils.findRequiredViewAsType(source, R.id.streakChart, "field 'streakChart'", StreakChart.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    StreakCard target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.title = null;
    target.streakChart = null;
  }
}
