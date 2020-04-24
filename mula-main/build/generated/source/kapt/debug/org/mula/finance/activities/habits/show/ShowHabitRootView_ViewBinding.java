// Generated code from Butter Knife. Do not modify!
package org.mula.finance.activities.habits.show;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import org.mula.finance.R;
import org.mula.finance.activities.habits.show.views.BarCard;
import org.mula.finance.activities.habits.show.views.FrequencyCard;
import org.mula.finance.activities.habits.show.views.HistoryCard;
import org.mula.finance.activities.habits.show.views.NotesCard;
import org.mula.finance.activities.habits.show.views.OverviewCard;
import org.mula.finance.activities.habits.show.views.ScoreCard;
import org.mula.finance.activities.habits.show.views.StreakCard;
import org.mula.finance.activities.habits.show.views.SubtitleCard;

public class ShowHabitRootView_ViewBinding implements Unbinder {
  private ShowHabitRootView target;

  @UiThread
  public ShowHabitRootView_ViewBinding(ShowHabitRootView target) {
    this(target, target);
  }

  @UiThread
  public ShowHabitRootView_ViewBinding(ShowHabitRootView target, View source) {
    this.target = target;

    target.frequencyCard = Utils.findRequiredViewAsType(source, R.id.frequencyCard, "field 'frequencyCard'", FrequencyCard.class);
    target.streakCard = Utils.findRequiredViewAsType(source, R.id.streakCard, "field 'streakCard'", StreakCard.class);
    target.subtitleCard = Utils.findRequiredViewAsType(source, R.id.subtitleCard, "field 'subtitleCard'", SubtitleCard.class);
    target.notesCard = Utils.findRequiredViewAsType(source, R.id.notesCard, "field 'notesCard'", NotesCard.class);
    target.habitNotes = Utils.findRequiredViewAsType(source, R.id.habitNotes, "field 'habitNotes'", TextView.class);
    target.overviewCard = Utils.findRequiredViewAsType(source, R.id.overviewCard, "field 'overviewCard'", OverviewCard.class);
    target.scoreCard = Utils.findRequiredViewAsType(source, R.id.scoreCard, "field 'scoreCard'", ScoreCard.class);
    target.historyCard = Utils.findRequiredViewAsType(source, R.id.historyCard, "field 'historyCard'", HistoryCard.class);
    target.barCard = Utils.findRequiredViewAsType(source, R.id.barCard, "field 'barCard'", BarCard.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ShowHabitRootView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.frequencyCard = null;
    target.streakCard = null;
    target.subtitleCard = null;
    target.notesCard = null;
    target.habitNotes = null;
    target.overviewCard = null;
    target.scoreCard = null;
    target.historyCard = null;
    target.barCard = null;
    target.toolbar = null;
  }
}
