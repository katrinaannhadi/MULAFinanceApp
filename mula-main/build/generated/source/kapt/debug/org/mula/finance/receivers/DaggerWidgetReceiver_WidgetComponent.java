package org.mula.finance.receivers;

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
final class DaggerWidgetReceiver_WidgetComponent implements WidgetReceiver.WidgetComponent {
  private final HabitsApplicationComponent habitsApplicationComponent;

  private DaggerWidgetReceiver_WidgetComponent(
      HabitsApplicationComponent habitsApplicationComponentParam) {
    this.habitsApplicationComponent = habitsApplicationComponentParam;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public WidgetBehavior getWidgetController() {
    return new WidgetBehavior(Preconditions.checkNotNull(habitsApplicationComponent.getHabitList(), "Cannot return null from a non-@Nullable component method"), Preconditions.checkNotNull(habitsApplicationComponent.getCommandRunner(), "Cannot return null from a non-@Nullable component method"), Preconditions.checkNotNull(habitsApplicationComponent.getNotificationTray(), "Cannot return null from a non-@Nullable component method"));}

  static final class Builder {
    private HabitsApplicationComponent habitsApplicationComponent;

    private Builder() {
    }

    public Builder habitsApplicationComponent(
        HabitsApplicationComponent habitsApplicationComponent) {
      this.habitsApplicationComponent = Preconditions.checkNotNull(habitsApplicationComponent);
      return this;
    }

    public WidgetReceiver.WidgetComponent build() {
      Preconditions.checkBuilderRequirement(habitsApplicationComponent, HabitsApplicationComponent.class);
      return new DaggerWidgetReceiver_WidgetComponent(habitsApplicationComponent);
    }
  }
}
