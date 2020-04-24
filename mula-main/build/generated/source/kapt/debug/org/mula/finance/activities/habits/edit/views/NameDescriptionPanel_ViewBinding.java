// Generated code from Butter Knife. Do not modify!
package org.mula.finance.activities.habits.edit.views;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import org.mula.finance.R;

public class NameDescriptionPanel_ViewBinding implements Unbinder {
  private NameDescriptionPanel target;

  private View view7f0a0085;

  @UiThread
  public NameDescriptionPanel_ViewBinding(NameDescriptionPanel target) {
    this(target, target);
  }

  @UiThread
  public NameDescriptionPanel_ViewBinding(final NameDescriptionPanel target, View source) {
    this.target = target;

    View view;
    target.tvName = Utils.findRequiredViewAsType(source, R.id.tvName, "field 'tvName'", EditText.class);
    target.tvQuestion = Utils.findRequiredViewAsType(source, R.id.tvQuestion, "field 'tvQuestion'", ExampleEditText.class);
    target.tvDescription = Utils.findRequiredViewAsType(source, R.id.tvDescription, "field 'tvDescription'", ExampleEditText.class);
    view = Utils.findRequiredView(source, R.id.buttonPickColor, "method 'showColorPicker'");
    view7f0a0085 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.showColorPicker();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    NameDescriptionPanel target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvName = null;
    target.tvQuestion = null;
    target.tvDescription = null;

    view7f0a0085.setOnClickListener(null);
    view7f0a0085 = null;
  }
}
