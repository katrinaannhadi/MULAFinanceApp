package org.mula.finance.automation;

import dagger.internal.Preconditions;
import javax.annotation.Generated;
import org.mula.finance.HabitsApplicationComponent;
import org.mula.finance.core.ui.widgets.WidgetBehavior;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerFireSettingReceiver_ReceiverComponent implements FireSettingReceiver.ReceiverComponent {
  private final HabitsApplicationComponent habitsApplicationComponent;

  private DaggerFireSettingReceiver_ReceiverComponent(
      HabitsApplicationComponent habitsApplicationComponentParam) {
    this.habitsApplicationComponent = habitsApplicationComponentParam;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public WidgetBehavior getWidgetController() {
    return new WidgetBehavior(Preconditions.checkNotNull(habitsApplicationComponent.getHabitList(), "Cannot return null from a non-@Nullable component method"), Preconditions.checkNotNull(habitsApplicationComponent.getCommandRunner(), "Cannot return null from a non-@Nullable component method"), Preconditions.checkNotNull(habitsApplicationComponent.getNotificationTray(), "Cannot return null from a non-@Nullable component method"));}

  public static final class Builder {
    private HabitsApplicationComponent habitsApplicationComponent;

    private Builder() {
    }

    public Builder habitsApplicationComponent(
        HabitsApplicationComponent habitsApplicationComponent) {
      this.habitsApplicationComponent = Preconditions.checkNotNull(habitsApplicationComponent);
      return this;
    }

    public FireSettingReceiver.ReceiverComponent build() {
      Preconditions.checkBuilderRequirement(habitsApplicationComponent, HabitsApplicationComponent.class);
      return new DaggerFireSettingReceiver_ReceiverComponent(habitsApplicationComponent);
    }
  }
}
