package org.mula.finance.DataAccessObjects;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import org.mula.finance.Models.Question;
import org.mula.finance.Models.Score;

import java.util.List;

@Dao
public interface ScoreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Score> score);

    @Insert
    void insert(Score... scores);

    @Update
    public void update(Score... scores);

    @Delete
    public void delete(Score score);

    @Query("SELECT * FROM score")
    List<Score> getAllScores();

    @Query("SELECT * FROM score WHERE id = :number")
    public Score getScores(int number);

    @Query("SELECT * FROM score WHERE category = :number")
    public List<Score> getScoreCategory(int number);
}
