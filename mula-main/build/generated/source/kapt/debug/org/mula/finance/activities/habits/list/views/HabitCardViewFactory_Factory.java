package org.mula.finance.activities.habits.list.views;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HabitCardViewFactory_Factory implements Factory<HabitCardViewFactory> {
  private final Provider<Context> contextProvider;

  private final Provider<CheckmarkPanelViewFactory> checkmarkPanelFactoryProvider;

  private final Provider<NumberPanelViewFactory> numberPanelFactoryProvider;

  private final Provider<ListHabitsBehavior> behaviorProvider;

  public HabitCardViewFactory_Factory(Provider<Context> contextProvider,
      Provider<CheckmarkPanelViewFactory> checkmarkPanelFactoryProvider,
      Provider<NumberPanelViewFactory> numberPanelFactoryProvider,
      Provider<ListHabitsBehavior> behaviorProvider) {
    this.contextProvider = contextProvider;
    this.checkmarkPanelFactoryProvider = checkmarkPanelFactoryProvider;
    this.numberPanelFactoryProvider = numberPanelFactoryProvider;
    this.behaviorProvider = behaviorProvider;
  }

  @Override
  public HabitCardViewFactory get() {
    return newInstance(contextProvider, checkmarkPanelFactoryProvider, numberPanelFactoryProvider, behaviorProvider);
  }

  public static HabitCardViewFactory_Factory create(Provider<Context> contextProvider,
      Provider<CheckmarkPanelViewFactory> checkmarkPanelFactoryProvider,
      Provider<NumberPanelViewFactory> numberPanelFactoryProvider,
      Provider<ListHabitsBehavior> behaviorProvider) {
    return new HabitCardViewFactory_Factory(contextProvider, checkmarkPanelFactoryProvider, numberPanelFactoryProvider, behaviorProvider);
  }

  public static HabitCardViewFactory newInstance(Provider<Context> contextProvider,
      Provider<CheckmarkPanelViewFactory> checkmarkPanelFactoryProvider,
      Provider<NumberPanelViewFactory> numberPanelFactoryProvider,
      Provider<ListHabitsBehavior> behaviorProvider) {
    return new HabitCardViewFactory(contextProvider, checkmarkPanelFactoryProvider, numberPanelFactoryProvider, behaviorProvider);
  }
}
