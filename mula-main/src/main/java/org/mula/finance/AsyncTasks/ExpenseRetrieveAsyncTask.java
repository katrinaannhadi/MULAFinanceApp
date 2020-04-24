package org.mula.finance.AsyncTasks;

import android.os.AsyncTask;

import org.mula.finance.Databases.AppDatabase;
import org.mula.finance.Models.Expense;

import java.util.List;

public class ExpenseRetrieveAsyncTask extends AsyncTask<Integer, Integer, List<Expense>> {
    private ExpenseAsyncTaskDelegate delegate;
    //Expense Database
    private AppDatabase db;

    public void setDelegate(ExpenseAsyncTaskDelegate delegate) {this.delegate = delegate;}
    public void setAppDatabase(AppDatabase db) {this.db = db;}

    @Override
    protected List<Expense> doInBackground(Integer... integers) {
        return db.expenseDao().getAll();
    }

    protected void onPostExecute(List<Expense> expenses){
        delegate.handleExpensesReturned(expenses);
    }
}
