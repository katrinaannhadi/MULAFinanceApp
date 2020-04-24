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
import org.mula.finance.activities.common.views.RingView;

public class OverviewCard_ViewBinding implements Unbinder {
  private OverviewCard target;

  @UiThread
  public OverviewCard_ViewBinding(OverviewCard target) {
    this(target, target);
  }

  @UiThread
  public OverviewCard_ViewBinding(OverviewCard target, View source) {
    this.target = target;

    target.scoreRing = Utils.findRequiredViewAsType(source, R.id.scoreRing, "field 'scoreRing'", RingView.class);
    target.scoreLabel = Utils.findRequiredViewAsType(source, R.id.scoreLabel, "field 'scoreLabel'", TextView.class);
    target.monthDiffLabel = Utils.findRequiredViewAsType(source, R.id.monthDiffLabel, "field 'monthDiffLabel'", TextView.class);
    target.yearDiffLabel = Utils.findRequiredViewAsType(source, R.id.yearDiffLabel, "field 'yearDiffLabel'", TextView.class);
    target.totalCountLabel = Utils.findRequiredViewAsType(source, R.id.totalCountLabel, "field 'totalCountLabel'", TextView.class);
    target.title = Utils.findRequiredViewAsType(source, R.id.title, "field 'title'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OverviewCard target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.scoreRing = null;
    target.scoreLabel = null;
    target.monthDiffLabel = null;
    target.yearDiffLabel = null;
    target.totalCountLabel = null;
    target.title = null;
  }
}
