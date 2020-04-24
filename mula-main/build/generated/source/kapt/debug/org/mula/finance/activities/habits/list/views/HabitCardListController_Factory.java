package org.mula.finance.activities.habits.list.views;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.activities.habits.list.ListHabitsSelectionMenu;
import org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HabitCardListController_Factory implements Factory<HabitCardListController> {
  private final Provider<HabitCardListAdapter> adapterProvider;

  private final Provider<ListHabitsBehavior> behaviorProvider;

  private final Provider<ListHabitsSelectionMenu> selectionMenuProvider;

  public HabitCardListController_Factory(Provider<HabitCardListAdapter> adapterProvider,
      Provider<ListHabitsBehavior> behaviorProvider,
      Provider<ListHabitsSelectionMenu> selectionMenuProvider) {
    this.adapterProvider = adapterProvider;
    this.behaviorProvider = behaviorProvider;
    this.selectionMenuProvider = selectionMenuProvider;
  }

  @Override
  public HabitCardListController get() {
    return newInstance(adapterProvider.get(), behaviorProvider.get(), DoubleCheck.lazy(selectionMenuProvider));
  }

  public static HabitCardListController_Factory create(
      Provider<HabitCardListAdapter> adapterProvider, Provider<ListHabitsBehavior> behaviorProvider,
      Provider<ListHabitsSelectionMenu> selectionMenuProvider) {
    return new HabitCardListController_Factory(adapterProvider, behaviorProvider, selectionMenuProvider);
  }

  public static HabitCardListController newInstance(HabitCardListAdapter adapter,
      ListHabitsBehavior behavior, Lazy<ListHabitsSelectionMenu> selectionMenu) {
    return new HabitCardListController(adapter, behavior, selectionMenu);
  }
}
