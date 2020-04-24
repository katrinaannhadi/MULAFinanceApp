package org.mula.finance.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import org.mula.finance.activities.QuizActivity;
import org.mula.finance.AsyncTasks.QuestionAsyncTaskDelegate;
import org.mula.finance.AsyncTasks.QuestionInsertAsyncTask;
import org.mula.finance.AsyncTasks.QuestionRetrieveAsyncTask;
import org.mula.finance.Databases.QuestionDatabase;
import org.mula.finance.Models.Question;
import org.mula.finance.R;

import java.util.List;


public class DailyQuizFragment extends DialogFragment implements QuestionAsyncTaskDelegate {

    private OnFragmentInteractionListener mListener;
    private View view;

    private TextView question;
    private RadioGroup options;
    private RadioButton optionA;
    private RadioButton optionB;
    private RadioButton optionC;
    private Button finish;
    private QuestionDatabase db;
    private Context context;
    private DailyQuizFragment dailyQuizFragment = this;

    private RadioGroup radioGroup;
    private RadioButton answer;

    private Question questionObject;

    private int questionNum;
    private int streak;

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;


    public DailyQuizFragment() {
        // Required empty public constructor
    }

    public static DailyQuizFragment newInstance(int num){
        DailyQuizFragment f = new DailyQuizFragment();
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_daily_quiz, container);
        question = view.findViewById(R.id.text_question);
        options = view.findViewById(R.id.group_options);
        optionA = view.findViewById(R.id.radio_answer_1);
        optionB = view.findViewById(R.id.radio_answer_2);
        optionC = view.findViewById(R.id.radio_answer_3);
        finish = view.findViewById(R.id.button_submit);
        radioGroup = view.findViewById(R.id.group_options);


        context = getContext();
        //shared preferences
        pref = context.getSharedPreferences("My Pref", 0);
        editor = pref.edit();

        //database instancing
        db = db.getInstance(context);
        insertQuestionsInDatabase(QuizActivity.getQuestionList());

        Bundle bundle = this.getArguments();
        retrieveQuestionFromDatabase(bundle.getInt("num"));


        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(int num) {
        if (mListener != null) {
            mListener.onFragmentInteraction(num);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(int num);
    }

    public void setQuestion (Question questionData){
        question.setText(questionData.getQuestion());
        optionA.setText(questionData.getOptionA());
        optionB.setText(questionData.getOptionB());
        optionC.setText(questionData.getOptionC());

    }

    @Override
    public void handleQuestionReturned(Question question) {
        setQuestion(question);

        finish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                answer = view.findViewById(radioGroup.getCheckedRadioButtonId());
                streak = pref.getInt("QUIZ_STREAK", 0);
                editor.putInt("ANSWERED", 0).commit();

                try {
                    RadioButton answer = view.findViewById(radioGroup.getCheckedRadioButtonId());
                    if (questionObject.getAnswer().equals(answer.getText())){
                        Toast.makeText(getContext(), "Keep the streak going!", Toast.LENGTH_LONG).show();
                        streak++;


                    } else {
                        streak = 0;

                    }
                } catch (NullPointerException e) {
                    // Toast.makeText(getContext(), "Choose an answer!", Toast.LENGTH_LONG).show();
                } finally {
                    editor.putInt("QUIZ_STREAK", streak);
                    editor.putInt("ANSWERED", 1).commit();
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .remove(DailyQuizFragment.this).commit();
                }
            }
        });
    }

    public void insertQuestionsInDatabase(List<Question> questions){
        QuestionInsertAsyncTask insertAsyncTask = new QuestionInsertAsyncTask();
        insertAsyncTask.setDelegate(dailyQuizFragment);
        insertAsyncTask.setQuestionDatabase(db);
        insertAsyncTask.execute(questions);
    }

    public void retrieveQuestionFromDatabase(int questionNum){
        QuestionRetrieveAsyncTask retrieveAsyncTask = new QuestionRetrieveAsyncTask();
        retrieveAsyncTask.setDelegate(dailyQuizFragment);
        retrieveAsyncTask.setQuestionDatabase(db);
        retrieveAsyncTask.execute(questionNum);
    }
}
