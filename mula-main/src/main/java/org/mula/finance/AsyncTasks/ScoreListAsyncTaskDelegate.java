package org.mula.finance.AsyncTasks;

import org.mula.finance.Models.Score;

import java.util.List;

public interface ScoreListAsyncTaskDelegate {
    void handleScoreListReturned(List<Score> scores);
}
