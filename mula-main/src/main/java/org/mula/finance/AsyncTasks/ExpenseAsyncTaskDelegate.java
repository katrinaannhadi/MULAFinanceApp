package org.mula.finance.AsyncTasks;

import org.mula.finance.Models.Expense;

import java.util.List;

public interface ExpenseAsyncTaskDelegate {
    void handleExpensesReturned(List<Expense> expenses);
}
