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
import org.mula.finance.activities.common.views.BarChart;

public class BarCard_ViewBinding implements Unbinder {
  private BarCard target;

  private View view7f0a0175;

  private View view7f0a0076;

  @UiThread
  public BarCard_ViewBinding(BarCard target) {
    this(target, target);
  }

  @UiThread
  public BarCard_ViewBinding(final BarCard target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.numericalSpinner, "field 'numericalSpinner' and method 'onNumericalItemSelected'");
    target.numericalSpinner = Utils.castView(view, R.id.numericalSpinner, "field 'numericalSpinner'", Spinner.class);
    view7f0a0175 = view;
    ((AdapterView<?>) view).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> p0, View p1, int p2, long p3) {
        target.onNumericalItemSelected(p2);
      }

      @Override
      public void onNothingSelected(AdapterView<?> p0) {
      }
    });
    view = Utils.findRequiredView(source, R.id.boolSpinner, "field 'boolSpinner' and method 'onBoolItemSelected'");
    target.boolSpinner = Utils.castView(view, R.id.boolSpinner, "field 'boolSpinner'", Spinner.class);
    view7f0a0076 = view;
    ((AdapterView<?>) view).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> p0, View p1, int p2, long p3) {
        target.onBoolItemSelected(p2);
      }

      @Override
      public void onNothingSelected(AdapterView<?> p0) {
      }
    });
    target.chart = Utils.findRequiredViewAsType(source, R.id.barChart, "field 'chart'", BarChart.class);
    target.title = Utils.findRequiredViewAsType(source, R.id.title, "field 'title'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BarCard target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.numericalSpinner = null;
    target.boolSpinner = null;
    target.chart = null;
    target.title = null;

    ((AdapterView<?>) view7f0a0175).setOnItemSelectedListener(null);
    view7f0a0175 = null;
    ((AdapterView<?>) view7f0a0076).setOnItemSelectedListener(null);
    view7f0a0076 = null;
  }
}
