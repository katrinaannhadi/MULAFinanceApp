package org.mula.finance.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.mula.finance.AsyncTasks.QuestionAsyncTaskDelegate;
import org.mula.finance.AsyncTasks.QuestionCategoryAsyncTaskDelegate;
import org.mula.finance.AsyncTasks.QuestionCategoryRetrieveAsyncTask;
import org.mula.finance.AsyncTasks.QuestionInsertAsyncTask;
import org.mula.finance.AsyncTasks.ScoreAsyncTaskDelegate;
import org.mula.finance.AsyncTasks.ScoreInsertAsyncTask;
import org.mula.finance.AsyncTasks.ScoreListAsyncTaskDelegate;
import org.mula.finance.AsyncTasks.ScoreRetrieveAsyncTask;
import org.mula.finance.Databases.QuestionDatabase;
import org.mula.finance.Databases.ScoreDatabase;
import org.mula.finance.Models.Question;
import org.mula.finance.Models.Score;
import org.mula.finance.R;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity implements QuestionCategoryAsyncTaskDelegate, QuestionAsyncTaskDelegate, ScoreAsyncTaskDelegate, ScoreListAsyncTaskDelegate {

    private Button continueBtn;
    private TextView questionText;
    private RadioButton optionA;
    private RadioButton optionB;
    private RadioButton optionC;
    private TextView scoreText;
    // private QuizActivity quizActivity = this;

    private MediaPlayer mp;

    private String TAG = "QuizActivity";
    private QuestionDatabase db;
    private ScoreDatabase scoreDb;

    private int score;
    private int questionNum = 0;
    private Question currentQuestion;
    private List<Question> questionList;
    private QuizActivity quizActivity = this;

    private int difficulty;
    private List<Score> scoreCheck;
    private TextView categoryTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Log.d(TAG, "QuizActivity: SUCCESS");

        ConstraintLayout quizConstraintLayout = findViewById(R.id.quiz_constraint_layout);

        questionText = quizConstraintLayout.findViewById(R.id.text_question);
        scoreText = quizConstraintLayout.findViewById(R.id.text_score);

        optionA = quizConstraintLayout.findViewById(R.id.radio_quiz_a);
        optionB = quizConstraintLayout.findViewById(R.id.radio_quiz_b);
        optionC = quizConstraintLayout.findViewById(R.id.radio_quiz_c);
        categoryTitle = quizConstraintLayout.findViewById(R.id.category_header);



        mp = MediaPlayer.create(getApplicationContext(), R.raw.notification_high_intensity);

        continueBtn = quizConstraintLayout.findViewById(R.id.button_continue);
        continueBtn.setText("Continue");

        //TODO:: change to category
        Intent quizIntent = getIntent();
        difficulty = quizIntent.getIntExtra("Difficulty", 1);

        switch(difficulty){
            case 1:
                categoryTitle.setText("Credit");
                break;
            case 2:
                categoryTitle.setText("Investment");
                break;
            case 3:
                categoryTitle.setText("Savings");
                break;
        }

        db = db.getInstance(this);
        scoreDb = scoreDb.getInstance(this);
        score = 0;

        insertQuestionListInDatabase(getQuestionList());
        retrieveQuestionListFromDatabase(difficulty);




    }

    public void setQuestion(Question question){
        currentQuestion = question;
        scoreText.setText("Score: " + score);
        questionText.setText(" " + question.getQuestion()+ " ");
        optionA.setText(question.getOptionA());
        optionB.setText(question.getOptionB());
        optionC.setText(question.getOptionC());
    }



    @Override
    public void handleQuestionListReturned(List<Question> questionList) {
        currentQuestion = questionList.get(0);
        setQuestion(currentQuestion);
        final List<Question> questions = questionList;


        continueBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                RadioGroup radioGroup = findViewById(R.id.options_quiz);
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                } else {
                    RadioButton answer = findViewById(radioGroup.getCheckedRadioButtonId());
                    if (currentQuestion.getAnswer().contentEquals(answer.getText())) {
                        score = score + 1;
                        System.out.println("when does this work");
                    }
                    answer.setChecked(false);
                    Toast.makeText(getApplicationContext(), Integer.toString(questionNum), Toast.LENGTH_LONG).show();

                    // Below code is to make sure that the button text changes to finish quiz on final question, and to
                    if (questionNum < questions.size() - 2) {
                        questionNum++;

                        setQuestion(questions.get(questionNum));

                    } else if (questionNum == questions.size() - 2) {
                        questionNum++;
                        setQuestion(questions.get(questionNum));

                        continueBtn.setText("Finish Quiz");
                    } else {
                        try {

                            retrieveScoreListFromDb();


                        } catch (NullPointerException e) {
                            Score currentScore = new Score(0, score, difficulty);
                            insertScoreInDB(currentScore);
                        }

                        Toast.makeText(getApplicationContext(), Integer.toString(score), Toast.LENGTH_LONG).show();
                        mp.start();
                        finish();
                    }

                }
            }
        });

    }

    //to prevent errors, need to do clean up
    @Override
    public void handleQuestionReturned(Question question){
        int num = question.getId();
        System.out.println(num);
    }

    @Override
    public void handleScoreReturned(List<Score> scores){

    }

    @Override
    public void handleScoreListReturned(List<Score> scores){
        scoreCheck = scores;
        int id = scoreCheck.size();
        Score currentScore = new Score(id, score, difficulty);
        insertScoreInDB(currentScore);
    }

    public void insertScoreInDB(Score score){
        ScoreInsertAsyncTask insertScoreAsyncTask = new ScoreInsertAsyncTask();
        insertScoreAsyncTask.setScoreDatabase(scoreDb);
        insertScoreAsyncTask.setDelegate(quizActivity);
        insertScoreAsyncTask.execute(score);
    }

    public void retrieveScoreListFromDb(){
        ScoreRetrieveAsyncTask retrieveAsyncTask = new ScoreRetrieveAsyncTask();
        retrieveAsyncTask.setScoreDatabase(scoreDb);
        retrieveAsyncTask.setDelegate(quizActivity);
        retrieveAsyncTask.execute();
    }




    public void insertQuestionListInDatabase(List<Question> questionList){
        QuestionInsertAsyncTask insertAsyncTask = new QuestionInsertAsyncTask();
        insertAsyncTask.setQuestionDatabase(db);
        insertAsyncTask.setDelegate(quizActivity);
        insertAsyncTask.execute(questionList);

    }

    public void retrieveQuestionListFromDatabase(int questionCategory){
        QuestionCategoryRetrieveAsyncTask questionRetrieveAsyncTask = new QuestionCategoryRetrieveAsyncTask();
        questionRetrieveAsyncTask.setQuestionDatabase(db);
        questionRetrieveAsyncTask.setDelegate(quizActivity);
        questionRetrieveAsyncTask.execute(questionCategory);
    }




    public static List<Question> getQuestionList(){
        //TODO:: to put this somewhere that's not here
        //TODO:: add url from api, not sure we can find relevant data in our APIs for these questions
        //questions and answers from https://www.sageadvice.eu/2017/11/27/trivia-quiz-on-5th-edition-dd-rules/
        List<Question> questionList = new ArrayList<>();
        questionList.add(0, new Question(0,
                "Do online banks offer better interest rates? If so, then why?",
                "No",
                "Yes, because they don't exist",
                "Yes, because they have minimal overhead costs.",
                "Yes, because they have minimal overhead costs.",
                3));
        questionList.add(1, new Question(1,
                "Why is it good to have a good credit score?",
                "Because it serves you better in the long run.",
                "Because lenders will offer you better interest rates, saving you money.",
                "You will receive a cheaper loan.",
                "Because lenders will offer you better interest rates, saving you money.",
                1));
        questionList.add(2, new Question(2,
                "Imagine an investment pyramid, what's at the bottom? (Which investments are more complicated?)",
                "Stocks, bonds and cash",
                "Index and mutual funds",
                "Lifecycle funds",
                "Stock, bonds and cash",
                2));
        questionList.add(3, new Question(3,
                "What's one of the most effective ways to save?",
                "Using this app.",
                "Giving your savings to your parents for safe keep.",
                "Making a plan consisting of your expenditure and laying down clear goals.",
                "Making a plan consisting of your expenditure and laying down clear goals.",
                3));
        questionList.add(4, new Question(4,
                "How can a credit card save you money?",
                "It can enable you to pay for things ahead of time, allowing you to set aside money.",
                "It can have extra benefits such as gift cards and promotions.",
                "All of the above.",
                "All of the above.",
                1));
        questionList.add(5, new Question(5,
                "What percentage of punctual debt payoff accounts for your credit score?",
                "35%",
                "60%",
                "20%",
                "35%",
                1));
        questionList.add(6, new Question(6,
                "What does global equity fund?",
                "Incorporate shares of companies around the world.",
                "The global banks.",
                "The United States",
                "Incorporate shares of companies around the world.",
                2));
        questionList.add(7, new Question(7,
                "Why is it good to save around 50% of an unexpected monetary gift?",
                "You will treat all monetary gifts as disposable income.",
                "You will regret it later, when you find something else to buy.",
                "You shouldn't get used to spending more than what you can afford.",
                "You shouldn't get used to spending more than what you can afford.",
                1));
        questionList.add(8, new Question(8,
                "What's the simplest way to invest?",
                "Listening to financial experts.",
                "Listening to your economics major friend, and experimenting with investing.",
                "Through automatic lifecycle funds.",
                "Through automatic lifecycle funds.",
                2));
        questionList.add(9, new Question(9,
                "How many times should you check your super throughout your life?",
                "At least, once a year regardless.",
                "Every time, you change jobs.",
                "If the superfund company sends me a letter.",
                "At least, once a year regardless.",
                3));

        return questionList;
    }
}

