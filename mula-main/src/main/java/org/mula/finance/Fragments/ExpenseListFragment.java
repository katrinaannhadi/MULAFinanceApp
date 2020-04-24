package org.mula.finance.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.mula.finance.Adapters.ExpenseListAdapter;
import org.mula.finance.AsyncTasks.ExpenseAsyncTaskDelegate;
import org.mula.finance.AsyncTasks.ExpenseListRetrieveAsyncTask;
import org.mula.finance.AsyncTasks.ExpenseRetrieveAsyncTask;
import org.mula.finance.Databases.AppDatabase;
import org.mula.finance.Models.Expense;
import org.mula.finance.R;

import java.util.List;


public class ExpenseListFragment extends Fragment implements ExpenseAsyncTaskDelegate {

    private static final String ARG_PARAM1 = "param1";

    //category
    private String mParam1;

    private View view;
    private RecyclerView rv;
    private RecyclerView.LayoutManager layoutManager;
    private TextView categoryText;
    private AppDatabase db;

    public ExpenseListFragment() {
        // Required empty public constructor
    }


    public static ExpenseListFragment newInstance(String param1) {
        ExpenseListFragment fragment = new ExpenseListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_expense_list, container, false);

        categoryText = view.findViewById(R.id.text_category);
        categoryText.setText(mParam1);

        rv = view.findViewById(R.id.rv_expenses);
        layoutManager = new LinearLayoutManager(view.getContext());
        rv.setLayoutManager(layoutManager);

        db = AppDatabase.getInstance(view.getContext());

        if(mParam1 == "All Expenses"){
            ExpenseRetrieveAsyncTask retrieve = new ExpenseRetrieveAsyncTask();
            retrieve.setAppDatabase(db);
            retrieve.setDelegate(this);
            retrieve.execute();

        } else {
            ExpenseListRetrieveAsyncTask retrieve = new ExpenseListRetrieveAsyncTask();
            retrieve.setAppDatabase(db);
            retrieve.setDelegate(this);
            retrieve.execute(mParam1);
        }





        return view;
    }

    @Override
    public void handleExpensesReturned(List<Expense> expenseList){
        ExpenseListAdapter adapter = new ExpenseListAdapter(expenseList);
        rv.setAdapter(adapter);
    }
}
