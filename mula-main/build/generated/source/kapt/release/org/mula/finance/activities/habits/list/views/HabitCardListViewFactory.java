package org.mula.finance.activities.habits.list.views;

import android.content.Context;
import dagger.Lazy;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;
import org.mula.androidbase.activities.ActivityContext;

@Generated(
  value = "com.google.auto.factory.processor.AutoFactoryProcessor",
  comments = "https://github.com/google/auto/tree/master/factory"
)
public final class HabitCardListViewFactory {
  private final Provider<Context> contextProvider;

  private final Provider<HabitCardListAdapter> adapterProvider;

  private final Provider<HabitCardViewFactory> cardViewFactoryProvider;

  private final Provider<Lazy<HabitCardListController>> controllerProvider;

  @Inject
  public HabitCardListViewFactory(
      @ActivityContext Provider<Context> contextProvider,
      Provider<HabitCardListAdapter> adapterProvider,
      Provider<HabitCardViewFactory> cardViewFactoryProvider,
      Provider<Lazy<HabitCardListController>> controllerProvider) {
    this.contextProvider = checkNotNull(contextProvider, 1);
    this.adapterProvider = checkNotNull(adapterProvider, 2);
    this.cardViewFactoryProvider = checkNotNull(cardViewFactoryProvider, 3);
    this.controllerProvider = checkNotNull(controllerProvider, 4);
  }

  public HabitCardListView create() {
    return new HabitCardListView(
        checkNotNull(contextProvider.get(), 1),
        checkNotNull(adapterProvider.get(), 2),
        checkNotNull(cardViewFactoryProvider.get(), 3),
        checkNotNull(controllerProvider.get(), 4));
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
