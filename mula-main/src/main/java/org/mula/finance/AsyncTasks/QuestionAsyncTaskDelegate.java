package org.mula.finance.AsyncTasks;

import org.mula.finance.Models.Question;

public interface QuestionAsyncTaskDelegate {

    void handleQuestionReturned(Question question);
}
