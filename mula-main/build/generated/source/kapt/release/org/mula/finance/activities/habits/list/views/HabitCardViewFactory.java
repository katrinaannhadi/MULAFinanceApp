package org.mula.finance.activities.habits.list.views;

import android.content.Context;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;
import org.mula.androidbase.activities.ActivityContext;
import org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior;

@Generated(
  value = "com.google.auto.factory.processor.AutoFactoryProcessor",
  comments = "https://github.com/google/auto/tree/master/factory"
)
public final class HabitCardViewFactory {
  private final Provider<Context> contextProvider;

  private final Provider<CheckmarkPanelViewFactory> checkmarkPanelFactoryProvider;

  private final Provider<NumberPanelViewFactory> numberPanelFactoryProvider;

  private final Provider<ListHabitsBehavior> behaviorProvider;

  @Inject
  public HabitCardViewFactory(
      @ActivityContext Provider<Context> contextProvider,
      Provider<CheckmarkPanelViewFactory> checkmarkPanelFactoryProvider,
      Provider<NumberPanelViewFactory> numberPanelFactoryProvider,
      Provider<ListHabitsBehavior> behaviorProvider) {
    this.contextProvider = checkNotNull(contextProvider, 1);
    this.checkmarkPanelFactoryProvider = checkNotNull(checkmarkPanelFactoryProvider, 2);
    this.numberPanelFactoryProvider = checkNotNull(numberPanelFactoryProvider, 3);
    this.behaviorProvider = checkNotNull(behaviorProvider, 4);
  }

  public HabitCardView create() {
    return new HabitCardView(
        checkNotNull(contextProvider.get(), 1),
        checkNotNull(checkmarkPanelFactoryProvider.get(), 2),
        checkNotNull(numberPanelFactoryProvider.get(), 3),
        checkNotNull(behaviorProvider.get(), 4));
  }

  private static <T> T checkNotNull(T reference, int argumentIndex) {
    if (reference == null) {
      throw new NullPointerException(
          "@AutoFactory method argument is null but is not marked @Nullable. Argument index: "
              + argumentIndex);
    }
    return reference;
  }
}
