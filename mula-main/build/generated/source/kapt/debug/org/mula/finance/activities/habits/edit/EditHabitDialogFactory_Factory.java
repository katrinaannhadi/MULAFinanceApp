package org.mula.finance.activities.habits.edit;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class EditHabitDialogFactory_Factory implements Factory<EditHabitDialogFactory> {
  @Override
  public EditHabitDialogFactory get() {
    return newInstance();
  }

  public static EditHabitDialogFactory_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static EditHabitDialogFactory newInstance() {
    return new EditHabitDialogFactory();
  }

  private static final class InstanceHolder {
    private static final EditHabitDialogFactory_Factory INSTANCE = new EditHabitDialogFactory_Factory();
  }
}
