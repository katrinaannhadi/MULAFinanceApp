package org.mula.finance.AsyncTasks;

import android.os.AsyncTask;

import org.mula.finance.Databases.QuestionDatabase;
import org.mula.finance.Models.Question;

import java.util.List;

public class QuestionCategoryRetrieveAsyncTask extends AsyncTask<Integer, Integer, List<Question>> {

    private QuestionCategoryAsyncTaskDelegate delegate;
    private QuestionDatabase questionDatabase;

    public void setDelegate(QuestionCategoryAsyncTaskDelegate delegate){this.delegate = delegate;}
    public void setQuestionDatabase (QuestionDatabase questionDatabase){this.questionDatabase = questionDatabase;}

    @Override
    protected List<Question> doInBackground(Integer... integers) {
        return questionDatabase.questionDao().getQuestionCategory(integers[0]);
    }

    protected void onPostExecute(List<Question> questionList){
        delegate.handleQuestionListReturned(questionList);
    }

}
