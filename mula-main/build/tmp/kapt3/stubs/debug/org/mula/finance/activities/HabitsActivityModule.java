package org.mula.finance.activities;

import org.mula.androidbase.activities.ActivityScope;
import org.mula.finance.core.ui.ThemeSwitcher;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H!\u00a2\u0006\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lorg/mula/finance/activities/HabitsActivityModule;", "", "()V", "getThemeSwitcher", "Lorg/mula/finance/core/ui/ThemeSwitcher;", "t", "Lorg/mula/finance/activities/AndroidThemeSwitcher;", "getThemeSwitcher$mula_main_debug", "mula-main_debug"})
@dagger.Module()
public abstract class HabitsActivityModule {
    
    @org.jetbrains.annotations.NotNull()
    @org.mula.androidbase.activities.ActivityScope()
    @dagger.Binds()
    public abstract org.mula.finance.core.ui.ThemeSwitcher getThemeSwitcher$mula_main_debug(@org.jetbrains.annotations.NotNull()
    org.mula.finance.activities.AndroidThemeSwitcher t);
    
    public HabitsActivityModule() {
        super();
    }
}