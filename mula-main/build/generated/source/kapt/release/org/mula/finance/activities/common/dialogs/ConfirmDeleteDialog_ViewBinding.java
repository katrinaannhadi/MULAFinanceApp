// Generated code from Butter Knife. Do not modify!
package org.mula.finance.activities.common.dialogs;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import java.lang.Deprecated;
import java.lang.Override;
import org.mula.finance.R;

public class ConfirmDeleteDialog_ViewBinding implements Unbinder {
  @UiThread
  public ConfirmDeleteDialog_ViewBinding(ConfirmDeleteDialog target) {
    this(target, target.getContext());
  }

  /**
   * @deprecated Use {@link #ConfirmDeleteDialog_ViewBinding(ConfirmDeleteDialog, Context)} for direct creation.
   *     Only present for runtime invocation through {@code ButterKnife.bind()}.
   */
  @Deprecated
  @UiThread
  public ConfirmDeleteDialog_ViewBinding(ConfirmDeleteDialog target, View source) {
    this(target, source.getContext());
  }

  @UiThread
  public ConfirmDeleteDialog_ViewBinding(ConfirmDeleteDialog target, Context context) {
    Resources res = context.getResources();
    target.question = res.getString(R.string.delete_habits_message);
    target.yes = res.getString(android.R.string.yes);
    target.no = res.getString(android.R.string.no);
  }

  @Override
  @CallSuper
  public void unbind() {
  }
}
