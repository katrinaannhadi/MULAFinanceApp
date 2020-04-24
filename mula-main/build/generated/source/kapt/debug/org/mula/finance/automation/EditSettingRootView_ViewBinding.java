// Generated code from Butter Knife. Do not modify!
package org.mula.finance.automation;

import android.view.View;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import org.mula.finance.R;

public final class EditSettingRootView_ViewBinding implements Unbinder {
  private EditSettingRootView target;

  private View view7f0a0087;

  @UiThread
  public EditSettingRootView_ViewBinding(EditSettingRootView target) {
    this(target, target);
  }

  @UiThread
  public EditSettingRootView_ViewBinding(final EditSettingRootView target, View source) {
    this.target = target;

    View view;
    target.tbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'tbar'", Toolbar.class);
    target.habitSpinner = Utils.findRequiredViewAsType(source, R.id.habitSpinner, "field 'habitSpinner'", AppCompatSpinner.class);
    target.actionSpinner = Utils.findRequiredViewAsType(source, R.id.actionSpinner, "field 'actionSpinner'", AppCompatSpinner.class);
    view = Utils.findRequiredView(source, 2131361927, "method 'onClickSave'");
    view7f0a0087 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickSave();
      }
    });
  }

  @Override
  public void unbind() {
    EditSettingRootView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tbar = null;
    target.habitSpinner = null;
    target.actionSpinner = null;

    view7f0a0087.setOnClickListener(null);
    view7f0a0087 = null;
  }
}
