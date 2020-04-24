package org.mula.finance.AsyncTasks;

import android.os.AsyncTask;

import org.mula.finance.DataAccessObjects.ExpenseDao;
import org.mula.finance.Databases.AppDatabase;
import org.mula.finance.Models.Expense;

public class InsertExpenseAsyncTask extends AsyncTask<Expense, Void, Void> {
    private ExpenseDao expenseDao;

    public InsertExpenseAsyncTask(AppDatabase db){
        expenseDao = db.expenseDao();
    }

    @Override
    protected Void doInBackground(Expense... expenses) {
        Expense e = expenses[0];
        expenseDao.insert(e);
        return null;
    }
}
