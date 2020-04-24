package org.mula.finance.DataAccessObjects;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.mula.finance.Models.Question;

import java.util.List;

@Dao
public interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Question> question);

    @Update
    public void update(Question... questions);

    @Delete
    public void delete(Question question);

    @Query("SELECT * FROM question")
    List<Question> getAllQuestions();

    @Query("SELECT * FROM question WHERE id = :number")
    public Question getQuestion(int number);

    @Query("SELECT * FROM question WHERE category = :number")
    public List<Question> getQuestionCategory(int number);
}
