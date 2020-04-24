package org.mula.finance.AsyncTasks;

import android.os.AsyncTask;

import org.mula.finance.Databases.AppDatabase;
import org.mula.finance.Databases.ScoreDatabase;
import org.mula.finance.Models.Expense;
import org.mula.finance.Models.Score;

import java.util.List;

public  class ExpenseListRetrieveAsyncTask extends AsyncTask<String, Integer, List<Expense>> {
    private ExpenseAsyncTaskDelegate delegate;
    //Expense Database
    private AppDatabase db;

    public void setDelegate(ExpenseAsyncTaskDelegate delegate) {this.delegate = delegate;}
    public void setAppDatabase(AppDatabase db) {this.db = db;}

    @Override
    protected List<Expense> doInBackground(String... strings) {

        return db.expenseDao().getCategoryList(strings[0]);
    }

    protected void onPostExecute(List<Expense> expenses){
        delegate.handleExpensesReturned(expenses);
    }
}
