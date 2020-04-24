package org.mula.finance.AsyncTasks;

import android.os.AsyncTask;

import org.mula.finance.Databases.QuestionDatabase;
import org.mula.finance.Databases.ScoreDatabase;
import org.mula.finance.Models.Question;
import org.mula.finance.Models.Score;

import java.util.List;

public class ScoreInsertAsyncTask extends AsyncTask<Score, Integer, String> {
    private ScoreAsyncTaskDelegate delegate;
    private ScoreDatabase scoreDatabase;

    public void setDelegate(ScoreAsyncTaskDelegate delegate) {this.delegate = delegate;}
    public void setScoreDatabase(ScoreDatabase scoreDatabase) {this.scoreDatabase = scoreDatabase;}

    @Override
    protected String doInBackground(Score... scores){
        scoreDatabase.scoreDao().insert(scores);
        return null;
    }
}
