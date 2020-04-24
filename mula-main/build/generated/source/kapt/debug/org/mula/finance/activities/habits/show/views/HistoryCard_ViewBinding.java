// Generated code from Butter Knife. Do not modify!
package org.mula.finance.activities.habits.show.views;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import org.mula.finance.R;
import org.mula.finance.activities.common.views.HistoryChart;

public class HistoryCard_ViewBinding implements Unbinder {
  private HistoryCard target;

  private View view7f0a00e4;

  @UiThread
  public HistoryCard_ViewBinding(HistoryCard target) {
    this(target, target);
  }

  @UiThread
  public HistoryCard_ViewBinding(final HistoryCard target, View source) {
    this.target = target;

    View view;
    target.chart = Utils.findRequiredViewAsType(source, R.id.historyChart, "field 'chart'", HistoryChart.class);
    target.title = Utils.findRequiredViewAsType(source, R.id.title, "field 'title'", TextView.class);
    view = Utils.findRequiredView(source, R.id.edit, "method 'onClickEditButton'");
    view7f0a00e4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickEditButton();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    HistoryCard target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.chart = null;
    target.title = null;

    view7f0a00e4.setOnClickListener(null);
    view7f0a00e4 = null;
  }
}
