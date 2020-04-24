// Generated code from Butter Knife. Do not modify!
package org.mula.finance.activities.habits.show.views;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import org.mula.finance.R;
import org.mula.finance.activities.common.views.ScoreChart;

public class ScoreCard_ViewBinding implements Unbinder {
  private ScoreCard target;

  private View view7f0a01d5;

  @UiThread
  public ScoreCard_ViewBinding(ScoreCard target) {
    this(target, target);
  }

  @UiThread
  public ScoreCard_ViewBinding(final ScoreCard target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.spinner, "field 'spinner' and method 'onItemSelected'");
    target.spinner = Utils.castView(view, R.id.spinner, "field 'spinner'", Spinner.class);
    view7f0a01d5 = view;
    ((AdapterView<?>) view).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> p0, View p1, int p2, long p3) {
        target.onItemSelected(p2);
      }

      @Override
      public void onNothingSelected(AdapterView<?> p0) {
      }
    });
    target.chart = Utils.findRequiredViewAsType(source, R.id.scoreView, "field 'chart'", ScoreChart.class);
    target.title = Utils.findRequiredViewAsType(source, R.id.title, "field 'title'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ScoreCard target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.spinner = null;
    target.chart = null;
    target.title = null;

    ((AdapterView<?>) view7f0a01d5).setOnItemSelectedListener(null);
    view7f0a01d5 = null;
  }
}
