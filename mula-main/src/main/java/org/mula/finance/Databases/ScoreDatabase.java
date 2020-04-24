package org.mula.finance.Databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import org.mula.finance.DataAccessObjects.ScoreDao;
import org.mula.finance.Models.Score;

@Database(entities = {Score.class}, version = 1)
public abstract class ScoreDatabase extends RoomDatabase {
    public abstract ScoreDao scoreDao();

    private static ScoreDatabase instance;
    public static ScoreDatabase getInstance(Context context){


        if(instance == null){
            instance = Room.databaseBuilder(context, ScoreDatabase.class, "scoreDB").build();
        }
        return instance;
    }
}
