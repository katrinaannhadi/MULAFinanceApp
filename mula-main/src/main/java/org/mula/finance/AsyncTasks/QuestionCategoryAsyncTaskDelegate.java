package org.mula.finance.AsyncTasks;

import org.mula.finance.Models.Question;

import java.util.List;

public interface QuestionCategoryAsyncTaskDelegate {
    void handleQuestionListReturned(List<Question> questionList);
}
