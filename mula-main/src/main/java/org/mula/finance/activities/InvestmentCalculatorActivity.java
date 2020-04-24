package org.mula.finance.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.mula.finance.Fragments.LineChartFragment;
import org.mula.finance.Fragments.PieChartFragment;
import org.mula.finance.R;


public class InvestmentCalculatorActivity extends AppCompatActivity {

    private EditText tvInvestmentAmount;
    private EditText tvAnnualInterestRate;
    private TextView tvTotalContributions;
    private TextView tvAdditionalContributions;
    private TextView tvTimesCompounded;
    private EditText tvNumberOfYears;
    private TextView tvFutureValue;
    private TextView tvInterestPrinciple;
    private TextView tvInterestContribution;
    private TextView tvTotalInterest;


    private Button btCompute;
    private Button btReset;
    private Button btGraph;


    private static final String TAG = "InvestmentCalculatorActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investment_calculator);

        tvInvestmentAmount = findViewById(R.id.tv_StartingAmount);
        tvNumberOfYears = findViewById(R.id.tv_Years);
        tvAnnualInterestRate = findViewById(R.id.tv_ReturnRate);
        tvFutureValue = findViewById(R.id.tv_FutureValue);
        tvTotalContributions = findViewById(R.id.tv_TotalContributions);
        tvAdditionalContributions = findViewById(R.id.tv_AdditionalContributions);
        tvTimesCompounded = findViewById(R.id.tv_TimesCompounded);
        tvInterestPrinciple = findViewById(R.id.tv_InterestPrincipal);
        tvInterestContribution = findViewById(R.id.tv_InterestContributions);
        tvTotalInterest = findViewById(R.id.tv_TotalInterest);


        btCompute = findViewById(R.id.bt_calculate);
        btReset = findViewById(R.id.bt_refresh);

        btCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeValue();

            }
        });
        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCalc();
            }
        });


    }

    @SuppressLint("DefaultLocale")
    private void computeValue() {
        try {
            double r = Double.parseDouble(String.valueOf(tvAnnualInterestRate.getText()));
            double t = Double.parseDouble(String.valueOf(tvNumberOfYears.getText()));
            System.out.println("testing1 : " + t);
            double P = Double.parseDouble(String.valueOf(tvInvestmentAmount.getText()));
            double PMT = Double.parseDouble(String.valueOf(tvAdditionalContributions.getText()));
            double n = Double.parseDouble(String.valueOf(tvTimesCompounded.getText()));

            double pow = Math.pow(1+((r/100)/n),n*t);
            double A = P*pow;
            double B = PMT*((pow-1)/((r/100)))*12;
            double totalContributions = PMT*t*12;
            double futureValue = A+B;
            double interestPrincipal = A-P;
            double interestContributions = B-totalContributions;
            double totalInterest = (((interestPrincipal+interestContributions)/futureValue)*100);


            tvFutureValue.setText(String.format("%.2f", futureValue));
            tvTotalContributions.setText(String.format("%.2f", totalContributions));
            tvInterestPrinciple.setText(String.format("%.2f", interestPrincipal));
            tvInterestContribution.setText(String.format("%.2f", interestContributions));
            tvTotalInterest.setText(String.format("%.2f", totalInterest));

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            Bundle arguments = new Bundle();
            arguments.putDouble("Future Value", futureValue);
            arguments.putDouble("Interest Principle", interestPrincipal);
            arguments.putDouble("Interest Contributions", interestContributions);
            PieChartFragment fragment = new PieChartFragment();
            fragment.setArguments(arguments);
            transaction.replace(R.id.pieFragment,fragment);
            transaction.commit();

            FragmentManager fragmentManager2 = getSupportFragmentManager();
            FragmentTransaction transaction2 = fragmentManager2.beginTransaction();
            Bundle arguments2 = new Bundle();
            arguments2.putDouble("Interest Rate", r);
            arguments2.putDouble("Year", t);
            arguments2.putDouble("Initial Investment", P);
            arguments2.putDouble("Additional Contributions", PMT);
            arguments2.putDouble("Times Compounded",n);
            LineChartFragment fragment2 = new LineChartFragment();
            fragment2.setArguments(arguments2);
            transaction2.replace(R.id.lineFragment,fragment2);
            transaction2.commit();



        } catch (Exception e) {
            Toast.makeText(this, "Please enter numeric values", Toast.LENGTH_SHORT).show();

            //add no zero exception
        }
    }

    private void resetCalc() {
        tvInvestmentAmount.setText("");
        tvAnnualInterestRate.setText("");
        tvNumberOfYears.setText("");
        tvFutureValue.setText("");
        tvTimesCompounded.setText("");
        tvAdditionalContributions.setText("");
        tvTotalContributions.setText("");
        tvInterestContribution.setText("");
        tvInterestPrinciple.setText("");
        tvTotalInterest.setText("");

        double futureValue = 0;
        double interestPrincipal = 0;
        double interestContributions = 0;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Bundle arguments = new Bundle();
        arguments.putDouble("Future Value", futureValue);
        arguments.putDouble("Interest Principle", interestPrincipal);
        arguments.putDouble("Interest Contributions", interestContributions);
        PieChartFragment fragment = new PieChartFragment();
        fragment.setArguments(arguments);
        transaction.replace(R.id.pieFragment,fragment);
        transaction.commit();

        double r = 0;
        double t = 0;
        double P = 0;
        double PMT = 0;
        double n = 0;

        FragmentManager fragmentManager2 = getSupportFragmentManager();
        FragmentTransaction transaction2 = fragmentManager2.beginTransaction();
        Bundle arguments2 = new Bundle();
        arguments2.putDouble("Interest Rate", r);
        arguments2.putDouble("Year", t);
        arguments2.putDouble("Initial Investment", P);
        arguments2.putDouble("Additional Contributions", PMT);
        arguments2.putDouble("Times Compounded", n);
        LineChartFragment fragment2 = new LineChartFragment();
        fragment2.setArguments(arguments2);
        transaction2.replace(R.id.lineFragment,fragment2);
        transaction2.commit();

    }

}
