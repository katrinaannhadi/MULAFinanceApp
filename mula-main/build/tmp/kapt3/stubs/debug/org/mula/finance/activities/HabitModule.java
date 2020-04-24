package org.mula.finance.activities;

import org.mula.finance.core.models.Habit;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lorg/mula/finance/activities/HabitModule;", "", "habit", "Lorg/mula/finance/core/models/Habit;", "(Lorg/mula/finance/core/models/Habit;)V", "getHabit", "mula-main_debug"})
@dagger.Module()
public final class HabitModule {
    private final org.mula.finance.core.models.Habit habit = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final org.mula.finance.core.models.Habit getHabit() {
        return null;
    }
    
    public HabitModule(@org.jetbrains.annotations.NotNull()
    org.mula.finance.core.models.Habit habit) {
        super();
    }
}