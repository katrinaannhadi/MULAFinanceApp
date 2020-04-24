package org.mula.finance.Fragments;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import org.mula.finance.Models.Expense;

import java.util.List;

@Dao
public interface ExpenseDao {
    @Query("SELECT * FROM expense")
    List<Expense> getAll();

    @Insert
    void insert(Expense... expenses);

    @Query("DELETE FROM expense")
    void delete();
}
