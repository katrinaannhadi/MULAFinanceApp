package org.mula.finance.AsyncTasks;

import android.os.AsyncTask;

import org.mula.finance.Databases.ScoreDatabase;
import org.mula.finance.Models.Score;

import java.util.List;

public class ScoreRetrieveAsyncTask extends AsyncTask<Integer, Integer, List<Score>> {
    private ScoreListAsyncTaskDelegate delegate;
    private ScoreDatabase scoreDatabase;

    public void setDelegate(ScoreListAsyncTaskDelegate delegate) {this.delegate = delegate;}
    public void setScoreDatabase(ScoreDatabase scoreDatabase) {this.scoreDatabase = scoreDatabase;}

    @Override
    protected List<Score> doInBackground(Integer... integers) {
        return scoreDatabase.scoreDao().getAllScores();
    }

    protected void onPostExecute(List<Score> scores){
        delegate.handleScoreListReturned(scores);
    }
}
