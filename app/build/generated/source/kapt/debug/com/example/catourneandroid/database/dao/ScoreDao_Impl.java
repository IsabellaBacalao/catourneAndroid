package com.example.catourneandroid.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.catourneandroid.database.entity.ScoreEntity;
import io.reactivex.Completable;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.Void;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ScoreDao_Impl implements ScoreDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ScoreEntity> __insertionAdapterOfScoreEntity;

  public ScoreDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfScoreEntity = new EntityInsertionAdapter<ScoreEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ScoreEntity` (`idScore`,`score`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ScoreEntity value) {
        stmt.bindLong(1, value.getIdScore());
        stmt.bindLong(2, value.getScore());
      }
    };
  }

  @Override
  public Object insertScore(final ScoreEntity score, final Continuation<? super Unit> $completion) {
    return Completable.fromCallable(new Callable<Void>() {
      @Override
      public Void call() throws Exception {
      }
    });
  }

  @Override
  public List<ScoreEntity> getAllScores() {
    final String _sql = "SELECT * FROM ScoreEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIdScore = CursorUtil.getColumnIndexOrThrow(_cursor, "idScore");
      final int _cursorIndexOfScore = CursorUtil.getColumnIndexOrThrow(_cursor, "score");
      final List<ScoreEntity> _result = new ArrayList<ScoreEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ScoreEntity _item;
        final int _tmpIdScore;
        _tmpIdScore = _cursor.getInt(_cursorIndexOfIdScore);
        final int _tmpScore;
        _tmpScore = _cursor.getInt(_cursorIndexOfScore);
        _item = new ScoreEntity(_tmpIdScore,_tmpScore);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Object insertData(final ScoreDao scoreDao, final Continuation<? super Unit> $completion) {
    return ScoreDao.DefaultImpls.insertData(ScoreDao_Impl.this, scoreDao, $completion);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
