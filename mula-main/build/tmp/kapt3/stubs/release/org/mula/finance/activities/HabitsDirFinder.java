package org.mula.finance.activities;

import org.mula.androidbase.AndroidDirFinder;
import org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior;
import org.mula.finance.core.ui.screens.habits.show.ShowHabitMenuBehavior;
import java.io.*;
import javax.inject.*;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lorg/mula/finance/activities/HabitsDirFinder;", "Lorg/mula/finance/core/ui/screens/habits/show/ShowHabitMenuBehavior$System;", "Lorg/mula/finance/core/ui/screens/habits/list/ListHabitsBehavior$DirFinder;", "androidDirFinder", "Lorg/mula/androidbase/AndroidDirFinder;", "(Lorg/mula/androidbase/AndroidDirFinder;)V", "getCSVOutputDir", "Ljava/io/File;", "uhabits-android_release"})
public final class HabitsDirFinder implements org.mula.finance.core.ui.screens.habits.show.ShowHabitMenuBehavior.System, org.mula.finance.core.ui.screens.habits.list.ListHabitsBehavior.DirFinder {
    private final org.mula.androidbase.AndroidDirFinder androidDirFinder = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.io.File getCSVOutputDir() {
        return null;
    }
    
    @javax.inject.Inject()
    public HabitsDirFinder(@org.jetbrains.annotations.NotNull()
    org.mula.androidbase.AndroidDirFinder androidDirFinder) {
        super();
    }
}