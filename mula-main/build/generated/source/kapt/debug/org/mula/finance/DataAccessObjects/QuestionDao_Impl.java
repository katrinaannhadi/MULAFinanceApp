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
import org.mula.finance.Models.Question;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class QuestionDao_Impl implements QuestionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Question> __insertionAdapterOfQuestion;

  private final EntityDeletionOrUpdateAdapter<Question> __deletionAdapterOfQuestion;

  private final EntityDeletionOrUpdateAdapter<Question> __updateAdapterOfQuestion;

  public QuestionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfQuestion = new EntityInsertionAdapter<Question>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Question` (`id`,`question`,`optionA`,`optionB`,`optionC`,`answer`,`category`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Question value) {
        stmt.bindLong(1, value.getId());
        if (value.getQuestion() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getQuestion());
        }
        if (value.getOptionA() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getOptionA());
        }
        if (value.getOptionB() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOptionB());
        }
        if (value.getOptionC() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getOptionC());
        }
        if (value.getAnswer() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAnswer());
        }
        stmt.bindLong(7, value.getCategory());
      }
    };
    this.__deletionAdapterOfQuestion = new EntityDeletionOrUpdateAdapter<Question>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Question` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Question value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfQuestion = new EntityDeletionOrUpdateAdapter<Question>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Question` SET `id` = ?,`question` = ?,`optionA` = ?,`optionB` = ?,`optionC` = ?,`answer` = ?,`category` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Question value) {
        stmt.bindLong(1, value.getId());
        if (value.getQuestion() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getQuestion());
        }
        if (value.getOptionA() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getOptionA());
        }
        if (value.getOptionB() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOptionB());
        }
        if (value.getOptionC() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getOptionC());
        }
        if (value.getAnswer() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAnswer());
        }
        stmt.bindLong(7, value.getCategory());
        stmt.bindLong(8, value.getId());
      }
    };
  }

  @Override
  public void insertAll(final List<Question> question) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfQuestion.insert(question);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Question question) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfQuestion.handle(question);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Question... questions) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfQuestion.handleMultiple(questions);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Question> getAllQuestions() {
    final String _sql = "SELECT * FROM question";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfQuestion = CursorUtil.getColumnIndexOrThrow(_cursor, "question");
      final int _cursorIndexOfOptionA = CursorUtil.getColumnIndexOrThrow(_cursor, "optionA");
      final int _cursorIndexOfOptionB = CursorUtil.getColumnIndexOrThrow(_cursor, "optionB");
      final int _cursorIndexOfOptionC = CursorUtil.getColumnIndexOrThrow(_cursor, "optionC");
      final int _cursorIndexOfAnswer = CursorUtil.getColumnIndexOrThrow(_cursor, "answer");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final List<Question> _result = new ArrayList<Question>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Question _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpQuestion;
        _tmpQuestion = _cursor.getString(_cursorIndexOfQuestion);
        final String _tmpOptionA;
        _tmpOptionA = _cursor.getString(_cursorIndexOfOptionA);
        final String _tmpOptionB;
        _tmpOptionB = _cursor.getString(_cursorIndexOfOptionB);
        final String _tmpOptionC;
        _tmpOptionC = _cursor.getString(_cursorIndexOfOptionC);
        final String _tmpAnswer;
        _tmpAnswer = _cursor.getString(_cursorIndexOfAnswer);
        final int _tmpCategory;
        _tmpCategory = _cursor.getInt(_cursorIndexOfCategory);
        _item = new Question(_tmpId,_tmpQuestion,_tmpOptionA,_tmpOptionB,_tmpOptionC,_tmpAnswer,_tmpCategory);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Question getQuestion(final int number) {
    final String _sql = "SELECT * FROM question WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, number);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfQuestion = CursorUtil.getColumnIndexOrThrow(_cursor, "question");
      final int _cursorIndexOfOptionA = CursorUtil.getColumnIndexOrThrow(_cursor, "optionA");
      final int _cursorIndexOfOptionB = CursorUtil.getColumnIndexOrThrow(_cursor, "optionB");
      final int _cursorIndexOfOptionC = CursorUtil.getColumnIndexOrThrow(_cursor, "optionC");
      final int _cursorIndexOfAnswer = CursorUtil.getColumnIndexOrThrow(_cursor, "answer");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final Question _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpQuestion;
        _tmpQuestion = _cursor.getString(_cursorIndexOfQuestion);
        final String _tmpOptionA;
        _tmpOptionA = _cursor.getString(_cursorIndexOfOptionA);
        final String _tmpOptionB;
        _tmpOptionB = _cursor.getString(_cursorIndexOfOptionB);
        final String _tmpOptionC;
        _tmpOptionC = _cursor.getString(_cursorIndexOfOptionC);
        final String _tmpAnswer;
        _tmpAnswer = _cursor.getString(_cursorIndexOfAnswer);
        final int _tmpCategory;
        _tmpCategory = _cursor.getInt(_cursorIndexOfCategory);
        _result = new Question(_tmpId,_tmpQuestion,_tmpOptionA,_tmpOptionB,_tmpOptionC,_tmpAnswer,_tmpCategory);
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
  public List<Question> getQuestionCategory(final int number) {
    final String _sql = "SELECT * FROM question WHERE category = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, number);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfQuestion = CursorUtil.getColumnIndexOrThrow(_cursor, "question");
      final int _cursorIndexOfOptionA = CursorUtil.getColumnIndexOrThrow(_cursor, "optionA");
      final int _cursorIndexOfOptionB = CursorUtil.getColumnIndexOrThrow(_cursor, "optionB");
      final int _cursorIndexOfOptionC = CursorUtil.getColumnIndexOrThrow(_cursor, "optionC");
      final int _cursorIndexOfAnswer = CursorUtil.getColumnIndexOrThrow(_cursor, "answer");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final List<Question> _result = new ArrayList<Question>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Question _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpQuestion;
        _tmpQuestion = _cursor.getString(_cursorIndexOfQuestion);
        final String _tmpOptionA;
        _tmpOptionA = _cursor.getString(_cursorIndexOfOptionA);
        final String _tmpOptionB;
        _tmpOptionB = _cursor.getString(_cursorIndexOfOptionB);
        final String _tmpOptionC;
        _tmpOptionC = _cursor.getString(_cursorIndexOfOptionC);
        final String _tmpAnswer;
        _tmpAnswer = _cursor.getString(_cursorIndexOfAnswer);
        final int _tmpCategory;
        _tmpCategory = _cursor.getInt(_cursorIndexOfCategory);
        _item = new Question(_tmpId,_tmpQuestion,_tmpOptionA,_tmpOptionB,_tmpOptionC,_tmpAnswer,_tmpCategory);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
