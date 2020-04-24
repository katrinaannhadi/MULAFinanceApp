/* Mula */

package org.mula.finance.core.models;

import org.mula.finance.core.database.Repository;
import org.mula.finance.core.models.sqlite.records.HabitRecord;
import org.mula.finance.core.models.sqlite.records.RepetitionRecord;

/**
 * Interface implemented by factories that provide concrete implementations of
 * the core model classes.
 */
public interface ModelFactory
{
    CheckmarkList buildCheckmarkList(Habit habit);

    default Habit buildHabit()
    {
        return new Habit(this);
    }

    default Habit buildHabit(Habit.HabitData data)
    {
        return new Habit(this, data);
    }

    HabitList buildHabitList();

    RepetitionList buildRepetitionList(Habit habit);

    ScoreList buildScoreList(Habit habit);

    StreakList buildStreakList(Habit habit);

    Repository<HabitRecord> buildHabitListRepository();

    Repository<RepetitionRecord> buildRepetitionListRepository();
}
