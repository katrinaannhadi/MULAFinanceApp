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

public class SubtitleCard_ViewBinding implements Unbinder {
  private SubtitleCard target;

  @UiThread
  public SubtitleCard_ViewBinding(SubtitleCard target) {
    this(target, target);
  }

  @UiThread
  public SubtitleCard_ViewBinding(SubtitleCard target, View source) {
    this.target = target;

    target.questionLabel = Utils.findRequiredViewAsType(source, R.id.questionLabel, "field 'questionLabel'", TextView.class);
    target.frequencyLabel = Utils.findRequiredViewAsType(source, R.id.frequencyLabel, "field 'frequencyLabel'", TextView.class);
    target.reminderLabel = Utils.findRequiredViewAsType(source, R.id.reminderLabel, "field 'reminderLabel'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SubtitleCard target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.questionLabel = null;
    target.frequencyLabel = null;
    target.reminderLabel = null;
  }
}
