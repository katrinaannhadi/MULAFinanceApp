package org.mula.finance.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.mula.finance.Databases.QuestionDatabase;
import org.mula.finance.Fragments.CalculatorFragment;
import org.mula.finance.Fragments.DailyQuizFragment;
import org.mula.finance.Fragments.HomeFragment;
import org.mula.finance.Fragments.InformationFragment;
import org.mula.finance.R;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements DailyQuizFragment.OnFragmentInteractionListener {

    //keep
    private View popupView;

    private Fragment infoFragment;
    private Fragment calculatorFragment;
    private Fragment homeFragment;

    private BottomNavigationView bottomNav;

    private QuestionDatabase db;

    //for the question num
    private Random random;
    private int randomNum;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Calendar calendar;

    private int today;
    private int lastDay;
    private int streak;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.navigation_view);
        infoFragment = new InformationFragment();
        homeFragment = new HomeFragment();
        calculatorFragment = new CalculatorFragment();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("MULA");

        pref = this.getSharedPreferences("My Pref", 0);
        editor = pref.edit();
        calendar = Calendar.getInstance();
        random = new Random();

        today = calendar.get(Calendar.DAY_OF_YEAR); // today in year
        lastDay = pref.getInt("LAST_DATE", 0);
        streak = pref.getInt("QUIZ_STREAK", 0);

        if(lastDay != today){
            editor.putInt("ANSWERED", 0).commit();
        }

        swapMenuFragment(homeFragment);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navGoals:
                        swapMenuFragment(homeFragment);
                        break;
                    case R.id.navCalculators:
                        swapMenuFragment(calculatorFragment);
                        break;
                    case R.id.navLearn:
                        swapMenuFragment(infoFragment);
                        break;

                }
                return true;
            }
        });

        showQuizPopup();


    }


    //swap fragment for the ui
    private void swapMenuFragment(Fragment fragment) {
        FragmentManager fragmentManager =  getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(int num) {

    }

    //swap fragment for quiz popup
    private void showQuizPopup() {

        if (today == lastDay || pref.getInt("ANSWERED", 0) != 0) {

        } else {
            if (lastDay != today - 1) {
                streak = 0;
                editor.putInt("QUIZ_STREAK", streak);
            }

            randomNum = random.nextInt(10);

            editor.putInt("LAST_DATE", today);
            editor.commit();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment previous = fragmentManager.findFragmentByTag("quiz");
            if (previous != null) {
                fragmentTransaction.remove(previous);
            }
            fragmentTransaction.addToBackStack(null);

            DialogFragment quizPopup = DailyQuizFragment.newInstance(randomNum);
            quizPopup.show(fragmentManager, "quiz");

        }

    }


}

