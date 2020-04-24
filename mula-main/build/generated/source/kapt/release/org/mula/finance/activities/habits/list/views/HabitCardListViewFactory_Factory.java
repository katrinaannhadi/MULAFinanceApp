package org.mula.finance.activities.habits.list.views;

import android.content.Context;
import dagger.Lazy;
import dagger.internal.Factory;
import dagger.internal.ProviderOfLazy;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HabitCardListViewFactory_Factory implements Factory<HabitCardListViewFactory> {
  private final Provider<Context> contextProvider;

  private final Provider<HabitCardListAdapter> adapterProvider;

  private final Provider<HabitCardViewFactory> cardViewFactoryProvider;

  private final Provider<HabitCardListController> controllerProvider;

  public HabitCardListViewFactory_Factory(Provider<Context> contextProvider,
      Provider<HabitCardListAdapter> adapterProvider,
      Provider<HabitCardViewFactory> cardViewFactoryProvider,
      Provider<HabitCardListController> controllerProvider) {
    this.contextProvider = contextProvider;
    this.adapterProvider = adapterProvider;
    this.cardViewFactoryProvider = cardViewFactoryProvider;
    this.controllerProvider = controllerProvider;
  }

  @Override
  public HabitCardListViewFactory get() {
    return newInstance(contextProvider, adapterProvider, cardViewFactoryProvider, ProviderOfLazy.create(controllerProvider));
  }

  public static HabitCardListViewFactory_Factory create(Provider<Context> contextProvider,
      Provider<HabitCardListAdapter> adapterProvider,
      Provider<HabitCardViewFactory> cardViewFactoryProvider,
      Provider<HabitCardListController> controllerProvider) {
    return new HabitCardListViewFactory_Factory(contextProvider, adapterProvider, cardViewFactoryProvider, controllerProvider);
  }

  public static HabitCardListViewFactory newInstance(Provider<Context> contextProvider,
      Provider<HabitCardListAdapter> adapterProvider,
      Provider<HabitCardViewFactory> cardViewFactoryProvider,
      Provider<Lazy<HabitCardListController>> controllerProvider) {
    return new HabitCardListViewFactory(contextProvider, adapterProvider, cardViewFactoryProvider, controllerProvider);
  }
}
