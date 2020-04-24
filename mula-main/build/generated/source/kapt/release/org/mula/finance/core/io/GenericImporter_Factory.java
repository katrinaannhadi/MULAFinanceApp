package org.mula.finance.core.io;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.models.HabitList;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class GenericImporter_Factory implements Factory<GenericImporter> {
  private final Provider<HabitList> habitsProvider;

  private final Provider<LoopDBImporter> loopDBImporterProvider;

  private final Provider<RewireDBImporter> rewireDBImporterProvider;

  private final Provider<TickmateDBImporter> tickmateDBImporterProvider;

  private final Provider<HabitBullCSVImporter> habitBullCSVImporterProvider;

  public GenericImporter_Factory(Provider<HabitList> habitsProvider,
      Provider<LoopDBImporter> loopDBImporterProvider,
      Provider<RewireDBImporter> rewireDBImporterProvider,
      Provider<TickmateDBImporter> tickmateDBImporterProvider,
      Provider<HabitBullCSVImporter> habitBullCSVImporterProvider) {
    this.habitsProvider = habitsProvider;
    this.loopDBImporterProvider = loopDBImporterProvider;
    this.rewireDBImporterProvider = rewireDBImporterProvider;
    this.tickmateDBImporterProvider = tickmateDBImporterProvider;
    this.habitBullCSVImporterProvider = habitBullCSVImporterProvider;
  }

  @Override
  public GenericImporter get() {
    return newInstance(habitsProvider.get(), loopDBImporterProvider.get(), rewireDBImporterProvider.get(), tickmateDBImporterProvider.get(), habitBullCSVImporterProvider.get());
  }

  public static GenericImporter_Factory create(Provider<HabitList> habitsProvider,
      Provider<LoopDBImporter> loopDBImporterProvider,
      Provider<RewireDBImporter> rewireDBImporterProvider,
      Provider<TickmateDBImporter> tickmateDBImporterProvider,
      Provider<HabitBullCSVImporter> habitBullCSVImporterProvider) {
    return new GenericImporter_Factory(habitsProvider, loopDBImporterProvider, rewireDBImporterProvider, tickmateDBImporterProvider, habitBullCSVImporterProvider);
  }

  public static GenericImporter newInstance(HabitList habits, LoopDBImporter loopDBImporter,
      RewireDBImporter rewireDBImporter, TickmateDBImporter tickmateDBImporter,
      HabitBullCSVImporter habitBullCSVImporter) {
    return new GenericImporter(habits, loopDBImporter, rewireDBImporter, tickmateDBImporter, habitBullCSVImporter);
  }
}
