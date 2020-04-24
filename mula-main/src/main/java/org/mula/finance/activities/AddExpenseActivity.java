package org.mula.finance.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.mula.finance.AsyncTasks.InsertExpenseAsyncTask;
import org.mula.finance.Databases.AppDatabase;
import org.mula.finance.Models.Expense;
import org.mula.finance.R;
import org.mula.finance.utils.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddExpenseActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText valueText;
    private EditText descriptionText;
    private Date chosenDate;
    private Button datePicker;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Spinner categorySpinner;
    private String chosenCategory;
    private String[] categories;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        datePicker = (Button) findViewById(R.id.date_picker);
        valueText = (EditText) findViewById(R.id.value);
        descriptionText = (EditText) findViewById(R.id.description);
        categorySpinner = findViewById(R.id.spinner);
        categories = Constants.categories;

        categorySpinner.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item, categories);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        categorySpinner.setAdapter(aa);

        datePicker.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(AddExpenseActivity.this,
                        R.style.Theme_MaterialComponents_Light_Dialog_Alert, mDateSetListener, year, month, day);
                dialog.getDatePicker().setMaxDate(cal.getTimeInMillis());
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month++;
                String date = String.format("%02d/%02d/%d", dayOfMonth, month, year);
                try {
                    datePicker.setText(date);
                    chosenDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                } catch (ParseException e){

                }
            }
        };
    }

    public void addToDatabase(View view) {
        if(valueText.getText() == null ||
           descriptionText.getText() == null ||
           chosenCategory == null ||
           chosenDate == null) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        Expense e = new Expense();
        e.category = chosenCategory;
        e.date = chosenDate.getTime();
        e.description = descriptionText.getText().toString();
        e.value = valueText.getText().toString();

        AppDatabase db = AppDatabase.getInstance(getApplicationContext());
        new InsertExpenseAsyncTask(db).execute(e);

        Intent intent = new Intent(this, ExpenseTrackerActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        chosenCategory = categories[position];
        System.out.println(chosenCategory);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

