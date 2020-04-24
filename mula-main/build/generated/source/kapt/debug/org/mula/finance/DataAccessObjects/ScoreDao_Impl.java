package org.mula.finance.DataAccessObjects;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mula.finance.Models.Score;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ScoreDao_Impl implements ScoreDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Score> __insertionAdapterOfScore;

  private final EntityInsertionAdapter<Score> __insertionAdapterOfScore_1;

  private final EntityDeletionOrUpdateAdapter<Score> __deletionAdapterOfScore;

  private final EntityDeletionOrUpdateAdapter<Score> __updateAdapterOfScore;

  public ScoreDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfScore = new EntityInsertionAdapter<Score>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Score` (`id`,`score`,`category`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Score value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getScore());
        stmt.bindLong(3, value.getCategory());
      }
    };
    this.__insertionAdapterOfScore_1 = new EntityInsertionAdapter<Score>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Score` (`id`,`score`,`category`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Score value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getScore());
        stmt.bindLong(3, value.getCategory());
      }
    };
    this.__deletionAdapterOfScore = new EntityDeletionOrUpdateAdapter<Score>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Score` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Score value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfScore = new EntityDeletionOrUpdateAdapter<Score>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Score` SET `id` = ?,`score` = ?,`category` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Score value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getScore());
        stmt.bindLong(3, value.getCategory());
        stmt.bindLong(4, value.getId());
      }
    };
  }

  @Override
  public void insertAll(final List<Score> score) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfScore.insert(score);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final Score... scores) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfScore_1.insert(scores);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Score score) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfScore.handle(score);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Score... scores) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfScore.handleMultiple(scores);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Score> getAllScores() {
    final String _sql = "SELECT * FROM score";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfScore = CursorUtil.getColumnIndexOrThrow(_cursor, "score");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final List<Score> _result = new ArrayList<Score>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Score _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpScore;
        _tmpScore = _cursor.getInt(_cursorIndexOfScore);
        final int _tmpCategory;
        _tmpCategory = _cursor.getInt(_cursorIndexOfCategory);
        _item = new Score(_tmpId,_tmpScore,_tmpCategory);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Score getScores(final int number) {
    final String _sql = "SELECT * FROM score WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, number);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfScore = CursorUtil.getColumnIndexOrThrow(_cursor, "score");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final Score _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpScore;
        _tmpScore = _cursor.getInt(_cursorIndexOfScore);
        final int _tmpCategory;
        _tmpCategory = _cursor.getInt(_cursorIndexOfCategory);
        _result = new Score(_tmpId,_tmpScore,_tmpCategory);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Score> getScoreCategory(final int number) {
    final String _sql = "SELECT * FROM score WHERE category = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, number);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfScore = CursorUtil.getColumnIndexOrThrow(_cursor, "score");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final List<Score> _result = new ArrayList<Score>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Score _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpScore;
        _tmpScore = _cursor.getInt(_cursorIndexOfScore);
        final int _tmpCategory;
        _tmpCategory = _cursor.getInt(_cursorIndexOfCategory);
        _item = new Score(_tmpId,_tmpScore,_tmpCategory);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
