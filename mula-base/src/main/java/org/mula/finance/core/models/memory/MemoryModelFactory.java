/* Mula */

package org.mula.finance.core.models.memory;

import org.mula.finance.core.database.Repository;
import org.mula.finance.core.models.CheckmarkList;
import org.mula.finance.core.models.Habit;
import org.mula.finance.core.models.HabitList;
import org.mula.finance.core.models.ModelFactory;
import org.mula.finance.core.models.RepetitionList;
import org.mula.finance.core.models.ScoreList;
import org.mula.finance.core.models.StreakList;
import org.mula.finance.core.models.sqlite.records.HabitRecord;
import org.mula.finance.core.models.sqlite.records.RepetitionRecord;

public class MemoryModelFactory implements ModelFactory
{
    @Override
    public CheckmarkList buildCheckmarkList(Habit habit)
    {
        return new MemoryCheckmarkList(habit);
    }

    @Override
    public HabitList buildHabitList()
    {
        return new MemoryHabitList();
    }

    @Override
    public RepetitionList buildRepetitionList(Habit habit)
    {
        return new MemoryRepetitionList(habit);
    }

    @Override
    public ScoreList buildScoreList(Habit habit)
    {
        return new MemoryScoreList(habit);
    }

    @Override
    public StreakList buildStreakList(Habit habit)
    {
        return new MemoryStreakList(habit);
    }

    @Override
    public Repository<HabitRecord> buildHabitListRepository()
    {
        throw new IllegalStateException();
    }

    @Override
    public Repository<RepetitionRecord> buildRepetitionListRepository()
    {
        throw new IllegalStateException();
    }
}
