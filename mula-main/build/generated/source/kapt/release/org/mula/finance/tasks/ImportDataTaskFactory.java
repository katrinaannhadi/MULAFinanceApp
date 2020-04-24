package org.mula.finance.tasks;

import java.io.File;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;
import org.mula.finance.core.io.GenericImporter;
import org.mula.finance.core.models.ModelFactory;

@Generated(
  value = "com.google.auto.factory.processor.AutoFactoryProcessor",
  comments = "https://github.com/google/auto/tree/master/factory"
)
public class ImportDataTaskFactory {
  private final Provider<GenericImporter> importerProvider;

  private final Provider<ModelFactory> modelFactoryProvider;

  @Inject
  public ImportDataTaskFactory(
      Provider<GenericImporter> importerProvider, Provider<ModelFactory> modelFactoryProvider) {
    this.importerProvider = checkNotNull(importerProvider, 1);
    this.modelFactoryProvider = checkNotNull(modelFactoryProvider, 2);
  }

  public ImportDataTask create(File file, ImportDataTask.Listener listener) {
    return new ImportDataTask(
        checkNotNull(importerProvider.get(), 1),
        checkNotNull(modelFactoryProvider.get(), 2),
        checkNotNull(file, 3),
        checkNotNull(listener, 4));
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
