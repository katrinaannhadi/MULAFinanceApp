package org.mula.finance.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.mula.finance.Adapters.CalculatorAdapter;
import org.mula.finance.AsyncTasks.ScoreAsyncTaskDelegate;
import org.mula.finance.AsyncTasks.ScoreListAsyncTaskDelegate;
import org.mula.finance.AsyncTasks.ScoreRetrieveAsyncTask;
import org.mula.finance.Databases.ScoreDatabase;
import org.mula.finance.Models.IntentLink;
import org.mula.finance.Models.Score;
import org.mula.finance.R;

import java.util.ArrayList;
import java.util.List;

public class QuizStartActivity extends AppCompatActivity implements ScoreAsyncTaskDelegate, ScoreListAsyncTaskDelegate {

    private View view;
    private RecyclerView rv;
    private ArrayList<IntentLink> calc;
    private TextView titleAverage;
    private TextView titleTopCategory;
    private TextView textAverage;
    private TextView textTopCategory;
    private ArrayList<IntentLink> categoryList;
    private ScoreDatabase db;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_start);

        titleAverage = findViewById(R.id.text_quiz_average);
        titleTopCategory = findViewById(R.id.text_high_score);
        textAverage = findViewById(R.id.text_score);
        textTopCategory = findViewById(R.id.text_percentage);
        titleAverage.setText("Top Score:");
        titleTopCategory.setText("Top Category:");

        calc = new ArrayList<>();

        calc.add(0, new IntentLink("Credit", new Intent(this, QuizActivity.class), R.drawable.image_credit, Color.YELLOW));
        calc.add(1, new IntentLink("Investment", new Intent(this, QuizActivity.class), R.drawable.image_investment, Color.YELLOW));
        calc.add(2, new IntentLink("Savings", new Intent(this, QuizActivity.class), R.drawable.image_savings, Color.YELLOW));

        CalculatorAdapter calcAdapter = new CalculatorAdapter(calc);

        rv = findViewById(R.id.rv_quiz);
        rv.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(mLayoutManager);

        rv.setAdapter(calcAdapter);
        db = db.getInstance(this);

        retrieveScoreListFromDb();




    }

    @Override
    protected void onResume(){
        super.onResume();
        retrieveScoreListFromDb();
    }

    @Override
    public void handleScoreReturned(List<Score> scores){
        int num = 0;
    }

    @Override
    public void handleScoreListReturned(List<Score> scores){
        try{

            int topCategory = 0;
            int highScore = 0;

            for(int i = 0; i < scores.size(); i++){
                if(highScore < scores.get(i).getScore()){
                    topCategory = scores.get(i).getCategory();
                    highScore = scores.get(i).getScore();
                }
            }


            try {
                textAverage.setText(Integer.toString(highScore));
            } catch (ArithmeticException e){
                textAverage.setText(0);
            }

            switch (topCategory){
                case 1:
                    textTopCategory.setText("Credit");
                    break;
                case 2:
                    textTopCategory.setText("Investment");
                    break;
                case 3:
                    textTopCategory.setText("Tax");
                    break;
                default:
                    textTopCategory.setText("N/A");
                    break;
            }

        }catch(NullPointerException e) {

        }

    }

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    public void retrieveScoreListFromDb(){
        ScoreRetrieveAsyncTask retrieveAsyncTask = new ScoreRetrieveAsyncTask();
        retrieveAsyncTask.setScoreDatabase(db);
        retrieveAsyncTask.setDelegate(this);
        retrieveAsyncTask.execute();
    }

    private void startQuiz(int number){
        Context c = view.getContext();
        Intent intent = new Intent(c, QuizActivity.class);
        intent.putExtra("Difficulty", number);
        c.startActivity(intent);
    }
}

