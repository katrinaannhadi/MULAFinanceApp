package org.mula.finance.AsyncTasks;

import org.mula.finance.Models.Score;

import java.util.List;

public interface ScoreAsyncTaskDelegate {
    void handleScoreReturned(List<Score> scores);
}
