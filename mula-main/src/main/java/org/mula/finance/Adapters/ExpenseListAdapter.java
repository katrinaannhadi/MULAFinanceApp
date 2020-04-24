package org.mula.finance.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import org.mula.finance.Models.Expense;
import org.mula.finance.Models.IntentLink;
import org.mula.finance.R;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class ExpenseListAdapter extends RecyclerView.Adapter<ExpenseListAdapter.ExpenseListViewHolder> {
    //retrieve
    private List<Expense> data;
    private TextView dateText, valueText, descriptionText;


    public ExpenseListAdapter (List<Expense> data){this.data = data;}

    public static class ExpenseListViewHolder extends RecyclerView.ViewHolder {
        private View view;



        public ExpenseListViewHolder(View view) {
            super(view);
            this.view = view;


        }
    }

    @NonNull
    @Override
    public ExpenseListAdapter.ExpenseListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chunk_expense, parent, false);
        ExpenseListAdapter.ExpenseListViewHolder expenseViewHolder = new ExpenseListAdapter.ExpenseListViewHolder(v);

        dateText = v.findViewById(R.id.text_date);
        valueText = v.findViewById(R.id.text_amount);
        descriptionText = v.findViewById(R.id.text_description);


        return expenseViewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull ExpenseListAdapter.ExpenseListViewHolder calcViewHolder, int position){
        final Expense expense = data.get(position);
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(expense.date),
                TimeZone.getDefault().toZoneId());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd");
        dateText.setText(dateTime.format(format));
        valueText.setText(expense.value);
        descriptionText.setText(expense.description);

    }

    @Override
    public int getItemCount() { return data.size();}
    public List<Expense> getData() {return this.data;}
}
