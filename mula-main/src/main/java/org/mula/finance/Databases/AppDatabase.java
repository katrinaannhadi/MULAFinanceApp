package org.mula.finance.Databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import org.mula.finance.DataAccessObjects.ExpenseDao;
import org.mula.finance.Models.Expense;

@Database(entities = {Expense.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ExpenseDao expenseDao();

    private static AppDatabase instance;
    public static AppDatabase getInstance(Context context){
        if(instance != null) return instance;
        instance = Room.databaseBuilder(context, AppDatabase.class, "appdb").build();
        return instance;
    }
}
