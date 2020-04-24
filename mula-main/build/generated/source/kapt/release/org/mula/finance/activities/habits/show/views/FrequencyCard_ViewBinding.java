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
import org.mula.finance.activities.common.views.FrequencyChart;

public class FrequencyCard_ViewBinding implements Unbinder {
  private FrequencyCard target;

  @UiThread
  public FrequencyCard_ViewBinding(FrequencyCard target) {
    this(target, target);
  }

  @UiThread
  public FrequencyCard_ViewBinding(FrequencyCard target, View source) {
    this.target = target;

    target.title = Utils.findRequiredViewAsType(source, R.id.title, "field 'title'", TextView.class);
    target.chart = Utils.findRequiredViewAsType(source, R.id.frequencyChart, "field 'chart'", FrequencyChart.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FrequencyCard target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.title = null;
    target.chart = null;
  }
}
