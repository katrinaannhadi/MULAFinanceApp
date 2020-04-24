package org.mula.finance.activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.mula.finance.R;

import java.io.File;
import java.text.DecimalFormat;

public class TaxCalculatorActivity extends AppCompatActivity {

        private EditText EditText1, EditText2;
        private TextView textViewR2, textViewR3, textViewR4;
        private Button calcBtn;
        private Button clearBtn;

        private MediaPlayer mp;
        private MediaPlayer mp2;
        RadioButton radioButton, radioButton2, radioButton3;



    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_taxcalc);

            EditText1 = (EditText) findViewById(R.id.EditText1);
            EditText2 = (EditText) findViewById(R.id.EditText2);
            textViewR2 = findViewById(R.id.textViewR2);
            textViewR3 = findViewById(R.id.textViewR3);
            textViewR4 = findViewById(R.id.textView4);
            calcBtn = findViewById(R.id.button);
            clearBtn = findViewById(R.id.button2);
            radioButton = (RadioButton) findViewById(R.id.radioButton);
            radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
            radioButton3 = (RadioButton) findViewById(R.id.radioButton3);

            mp = MediaPlayer.create(getApplicationContext(), R.raw.state_change_confirm_up);
            mp2 = MediaPlayer.create(getApplicationContext(), R.raw.navigation_backward_selection);




            calcBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    if (EditText1.getText()!= null && EditText2.getText() != null){
                       try { calculateTax();
                       } catch (NumberFormatException e){

                       }
                        mp.start();
                    }
                }
            });


            clearBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    clearText();
                    mp2.start();

                }
            });

        }




    public void calculateTax () {

        if (radioButton.isChecked()){ //yearly
            DecimalFormat formatter = new DecimalFormat("###,###,###.00");

            String s1 = EditText1.getText().toString();
            double grossIncome = Double.parseDouble(s1);
            double[] max = {0, 18200, 37000, 90000, 180000};
            double[] rate = {0, 0.19, 0.325, 0.37, 0.45};
            double left = grossIncome;
            double tax = 0.0d;

            for (int i = 1; i < max.length && left > 0; i++) {
                double df = Math.min(max[i] - max[i - 1], left);
                tax += rate[i] * df;
                left -= df;
                //System.out.println(df*rate[i]);
            }

            //hecs
            String s2 = EditText2.getText().toString();
            double tothecs;
            tothecs = Double.parseDouble(s2);
            Double test = 0.0;

            if (grossIncome >= 0 && grossIncome < 45881) {
                double abc = tothecs * 0;
                textViewR4.setText(formatter.format(abc));
            } else if (grossIncome >= 45881 && grossIncome < 52973 && tothecs > 0) {
                test = grossIncome * 0.01;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test));
                }
            } else if (grossIncome >= 52973 && grossIncome < 56151 && tothecs > 0) {
                test = grossIncome * 0.02;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test));
                }
            } else if (grossIncome >= 52973 && grossIncome < 59521 && tothecs > 0) {
                test = grossIncome * 0.025;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test));
                }
            } else if (grossIncome >= 59521 && grossIncome < 63092 && tothecs > 0) {
                test = grossIncome * 0.03;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test));
                }
            } else if (grossIncome >= 63092 && grossIncome < 66877 && tothecs > 0) {
                test = grossIncome * 0.035;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test));
                }
            } else if (grossIncome >= 66877 && grossIncome < 70890 && tothecs > 0) {
                test = grossIncome * 0.04;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test));
                }
            } else if (grossIncome >= 70890 && grossIncome < 75144 && tothecs > 0) {
                test = grossIncome * 0.045;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test));
                }
            } else if (grossIncome >= 75144 && grossIncome < 79652 && tothecs > 0) {
                test = grossIncome * 0.05;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test));
                }
            } else if (grossIncome >= 79652 && grossIncome < 84432 && tothecs > 0) {
                test = grossIncome * 0.055;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test));
                }
            } else if (grossIncome >= 84432 && grossIncome < 89498 && tothecs > 0) {
                test = grossIncome * 0.06;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test));
                }
            } else if (grossIncome >= 89498 && grossIncome < 94868 && tothecs > 0) {
                test = grossIncome * 0.065;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test));
                }
            } else if (grossIncome >= 94868 && grossIncome < 100560 && tothecs > 0) {
                test = grossIncome * 0.07;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test));
                }
            } else if (grossIncome >= 100560 && grossIncome < 106593 && tothecs > 0) {
                test = grossIncome * 0.075;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test));
                }
            } else if (grossIncome >= 106593 && grossIncome < 112989 && tothecs > 0) {
                test = grossIncome * 0.08;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test));
                }
            } else if (grossIncome >= 112989 && grossIncome < 119769 && tothecs > 0) {
                test = grossIncome * 0.085;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test));
                }
            } else if (grossIncome >= 119769 && grossIncome < 126955 && tothecs > 0) {
                test = grossIncome * 0.09;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test));
                }
            } else if (grossIncome >= 126955 && grossIncome < 134572 && tothecs > 0) {
                test = grossIncome * 0.095;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test));
                }
            } else if (grossIncome >= 134572 && tothecs > 0) {
                test = grossIncome * 0.1;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test));
                }
            }

            textViewR2.setText(formatter.format(tax));

            if (test > tothecs) {
                textViewR3.setText(formatter.format(grossIncome - tax - tothecs));
            } else {
                textViewR3.setText(formatter.format(grossIncome - tax - test));
            }











        } else if (radioButton2.isChecked()){ //fortnightly code
            DecimalFormat formatter = new DecimalFormat("###,###,###.00");

            String s1 = EditText1.getText().toString();
            double fnIncome = Double.parseDouble(s1);
            double[] max = {0, 18200, 37000, 90000, 180000};
            double[] rate = {0, 0.19, 0.325, 0.37, 0.45};
            double left = fnIncome*26;
            double week26Income = left;
            double tax = 0.0d;

            for (int i = 1; i < max.length && left > 0; i++) {
                double df = Math.min(max[i] - max[i - 1], left);
                tax += rate[i] * df;
                left -= df;
                //System.out.println(df*rate[i]);
            }

            //hecs
            String s2 = EditText2.getText().toString();
            double tothecs;
            tothecs = Double.parseDouble(s2);
            Double test = 0.0;

            if (week26Income >= 0 && week26Income < 45881) {
                double abc = tothecs * 0;
                textViewR4.setText(formatter.format(abc));
            } else if (week26Income >= 45881 && week26Income < 52973 && tothecs > 0) {
                test = week26Income * 0.01;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test/26));
                }
            } else if (week26Income >= 52973 && week26Income < 56151 && tothecs > 0) {
                test = week26Income * 0.02;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test/26));
                }
            } else if (week26Income >= 52973 && week26Income < 59521 && tothecs > 0) {
                test = week26Income * 0.025;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test/26));
                }
            } else if (week26Income >= 59521 && week26Income < 63092 && tothecs > 0) {
                test = week26Income * 0.03;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test/26));
                }
            } else if (week26Income >= 63092 && week26Income < 66877 && tothecs > 0) {
                test = week26Income * 0.035;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test/26));
                }
            } else if (week26Income >= 66877 && week26Income < 70890 && tothecs > 0) {
                test = week26Income * 0.04;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test/26));
                }
            } else if (week26Income >= 70890 && week26Income < 75144 && tothecs > 0) {
                test = week26Income * 0.045;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test/26));
                }
            } else if (week26Income >= 75144 && week26Income < 79652 && tothecs > 0) {
                test = week26Income * 0.05;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test/26));
                }
            } else if (week26Income >= 79652 && week26Income < 84432 && tothecs > 0) {
                test = week26Income * 0.055;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test/26));
                }
            } else if (week26Income >= 84432 && week26Income < 89498 && tothecs > 0) {
                test = week26Income * 0.06;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test/26));
                }
            } else if (week26Income >= 89498 && week26Income < 94868 && tothecs > 0) {
                test = week26Income * 0.065;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test/26));
                }
            } else if (week26Income >= 94868 && week26Income < 100560 && tothecs > 0) {
                test = week26Income * 0.07;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test/26));
                }
            } else if (week26Income >= 100560 && week26Income < 106593 && tothecs > 0) {
                test = week26Income * 0.075;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test/26));
                }
            } else if (week26Income >= 106593 && week26Income < 112989 && tothecs > 0) {
                test = week26Income * 0.08;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test/26));
                }
            } else if (week26Income >= 112989 && week26Income < 119769 && tothecs > 0) {
                test = week26Income * 0.085;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test/26));
                }
            } else if (week26Income >= 119769 && week26Income < 126955 && tothecs > 0) {
                test = week26Income * 0.09;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test/26));
                }
            } else if (week26Income >= 126955 && week26Income < 134572 && tothecs > 0) {
                test = week26Income * 0.095;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test/26));
                }
            } else if (week26Income >= 134572 && tothecs > 0) {
                test = week26Income * 0.1;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs));
                } else {
                    textViewR4.setText(formatter.format(test/26));
                }
            }

            textViewR2.setText(formatter.format(tax/26));

            if (test > tothecs) {
                textViewR3.setText(formatter.format(fnIncome - tax/26 - tothecs/26));
            } else {
                textViewR3.setText(formatter.format(fnIncome - tax/26 - test/26));
            }










            //weekly code
        } else if (radioButton3.isChecked()){

            DecimalFormat formatter = new DecimalFormat("###,###,###.00");

            String s1 = EditText1.getText().toString();
            double weekIncome = Double.parseDouble(s1);
            double[] max = {0, 18200, 37000, 90000, 180000};
            double[] rate = {0, 0.19, 0.325, 0.37, 0.45};
            double left = weekIncome*56;
            double week56Income = left;
            double tax = 0.0d;

            for (int i = 1; i < max.length && left > 0; i++) {
                double df = Math.min(max[i] - max[i - 1], left);
                tax += rate[i] * df;
                left -= df;
                //System.out.println(df*rate[i]);
            }

            //hecs
            String s2 = EditText2.getText().toString();
            double tothecs;
            tothecs = Double.parseDouble(s2);
            Double test = 0.0;

            if (week56Income >= 0 && week56Income < 45881) {
                double abc = tothecs * 0;
                textViewR4.setText(formatter.format(abc));
            } else if (week56Income >= 45881 && week56Income < 52973 && tothecs > 0) {
                test = week56Income * 0.01;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs/56));
                } else {
                    textViewR4.setText(formatter.format(test/56));
                }
            } else if (week56Income >= 52973 && week56Income < 56151 && tothecs > 0) {
                test = week56Income * 0.02;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs/56));
                } else {
                    textViewR4.setText(formatter.format(test/56));
                }
            } else if (week56Income >= 52973 && week56Income < 59521 && tothecs > 0) {
                test = week56Income * 0.025;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs/56));
                } else {
                    textViewR4.setText(formatter.format(test/56));
                }
            } else if (week56Income >= 59521 && week56Income < 63092 && tothecs > 0) {
                test = week56Income * 0.03;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs/56));
                } else {
                    textViewR4.setText(formatter.format(test/56));
                }
            } else if (week56Income >= 63092 && week56Income < 66877 && tothecs > 0) {
                test = week56Income * 0.035;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs/56));
                } else {
                    textViewR4.setText(formatter.format(test/56));
                }
            } else if (week56Income >= 66877 && week56Income < 70890 && tothecs > 0) {
                test = week56Income * 0.04;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs/56));
                } else {
                    textViewR4.setText(formatter.format(test/56));
                }
            } else if (week56Income >= 70890 && week56Income < 75144 && tothecs > 0) {
                test = week56Income * 0.045;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs/56));
                } else {
                    textViewR4.setText(formatter.format(test/56));
                }
            } else if (week56Income >= 75144 && week56Income < 79652 && tothecs > 0) {
                test = week56Income * 0.05;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs/56));
                } else {
                    textViewR4.setText(formatter.format(test/56));
                }
            } else if (week56Income >= 79652 && week56Income < 84432 && tothecs > 0) {
                test = week56Income * 0.055;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs/56));
                } else {
                    textViewR4.setText(formatter.format(test/56));
                }
            } else if (week56Income >= 84432 && week56Income < 89498 && tothecs > 0) {
                test = week56Income * 0.06;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs/56));
                } else {
                    textViewR4.setText(formatter.format(test/56));
                }
            } else if (week56Income >= 89498 && week56Income < 94868 && tothecs > 0) {
                test = week56Income * 0.065;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs/56));
                } else {
                    textViewR4.setText(formatter.format(test/56));
                }
            } else if (week56Income >= 94868 && week56Income < 100560 && tothecs > 0) {
                test = week56Income * 0.07;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs/56));
                } else {
                    textViewR4.setText(formatter.format(test/56));
                }
            } else if (week56Income >= 100560 && week56Income < 106593 && tothecs > 0) {
                test = week56Income * 0.075;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs/56));
                } else {
                    textViewR4.setText(formatter.format(test/56));
                }
            } else if (week56Income >= 106593 && week56Income < 112989 && tothecs > 0) {
                test = week56Income * 0.08;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs/56));
                } else {
                    textViewR4.setText(formatter.format(test/56));
                }
            } else if (week56Income >= 112989 && week56Income < 119769 && tothecs > 0) {
                test = week56Income * 0.085;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs/56));
                } else {
                    textViewR4.setText(formatter.format(test/56));
                }
            } else if (week56Income >= 119769 && week56Income < 126955 && tothecs > 0) {
                test = week56Income * 0.09;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs/56));
                } else {
                    textViewR4.setText(formatter.format(test/56));
                }
            } else if (week56Income >= 126955 && week56Income < 134572 && tothecs > 0) {
                test = week56Income * 0.095;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs/56));
                } else {
                    textViewR4.setText(formatter.format(test/56));
                }
            } else if (week56Income >= 134572 && tothecs > 0) {
                test = week56Income * 0.1;
                if (test > tothecs) {
                    textViewR4.setText(formatter.format(tothecs/56));
                } else {
                    textViewR4.setText(formatter.format(test/56));
                }
            }

            textViewR2.setText(formatter.format(tax/56));

            if (test > tothecs) {
                textViewR3.setText(formatter.format(weekIncome - tax/56 - tothecs/56));
            } else {
                textViewR3.setText(formatter.format(weekIncome - tax/56 - test/56));
            }
        }
    }

    public void clearText () {
        EditText1.getText().clear();
        EditText2.getText().clear();

    }
}