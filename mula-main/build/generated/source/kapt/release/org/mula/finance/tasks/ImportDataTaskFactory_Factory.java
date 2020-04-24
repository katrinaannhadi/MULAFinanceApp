package org.mula.finance.tasks;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.finance.core.io.GenericImporter;
import org.mula.finance.core.models.ModelFactory;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ImportDataTaskFactory_Factory implements Factory<ImportDataTaskFactory> {
  private final Provider<GenericImporter> importerProvider;

  private final Provider<ModelFactory> modelFactoryProvider;

  public ImportDataTaskFactory_Factory(Provider<GenericImporter> importerProvider,
      Provider<ModelFactory> modelFactoryProvider) {
    this.importerProvider = importerProvider;
    this.modelFactoryProvider = modelFactoryProvider;
  }

  @Override
  public ImportDataTaskFactory get() {
    return newInstance(importerProvider, modelFactoryProvider);
  }

  public static ImportDataTaskFactory_Factory create(Provider<GenericImporter> importerProvider,
      Provider<ModelFactory> modelFactoryProvider) {
    return new ImportDataTaskFactory_Factory(importerProvider, modelFactoryProvider);
  }

  public static ImportDataTaskFactory newInstance(Provider<GenericImporter> importerProvider,
      Provider<ModelFactory> modelFactoryProvider) {
    return new ImportDataTaskFactory(importerProvider, modelFactoryProvider);
  }
}
