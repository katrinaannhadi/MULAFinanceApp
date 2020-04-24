/* Mula */

package org.mula.finance.activities.habits.show;

import org.mula.finance.activities.*;
import org.mula.finance.core.ui.screens.habits.show.ShowHabitBehavior;
import org.mula.finance.core.ui.screens.habits.show.ShowHabitMenuBehavior;

import dagger.*;

@Module
public abstract class ShowHabitModule
{
    @Binds
    abstract ShowHabitBehavior.Screen getScreen(ShowHabitScreen screen);

    @Binds
    abstract ShowHabitMenuBehavior.Screen getMenuScreen(ShowHabitScreen screen);

    @Binds
    abstract ShowHabitMenuBehavior.System getSystem(HabitsDirFinder system);
}
