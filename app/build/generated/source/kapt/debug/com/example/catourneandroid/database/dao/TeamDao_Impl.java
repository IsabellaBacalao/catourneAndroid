package com.example.catourneandroid.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.catourneandroid.database.entity.TeamEntity;
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
public final class TeamDao_Impl implements TeamDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TeamEntity> __insertionAdapterOfTeamEntity;

  public TeamDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTeamEntity = new EntityInsertionAdapter<TeamEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `TeamEntity` (`idTeam`,`statusTeam`,`positionTeam`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TeamEntity value) {
        stmt.bindLong(1, value.getIdTeam());
        if (value.getStatusTeam() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getStatusTeam());
        }
        stmt.bindLong(3, value.getPositionTeam());
      }
    };
  }

  @Override
  public Object insertTeam(final TeamEntity team, final Continuation<? super Unit> $completion) {
    return Completable.fromCallable(new Callable<Void>() {
      @Override
      public Void call() throws Exception {
      }
    });
  }

  @Override
  public List<TeamEntity> getAllTeams() {
    final String _sql = "SELECT * FROM TeamEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIdTeam = CursorUtil.getColumnIndexOrThrow(_cursor, "idTeam");
      final int _cursorIndexOfStatusTeam = CursorUtil.getColumnIndexOrThrow(_cursor, "statusTeam");
      final int _cursorIndexOfPositionTeam = CursorUtil.getColumnIndexOrThrow(_cursor, "positionTeam");
      final List<TeamEntity> _result = new ArrayList<TeamEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TeamEntity _item;
        final int _tmpIdTeam;
        _tmpIdTeam = _cursor.getInt(_cursorIndexOfIdTeam);
        final String _tmpStatusTeam;
        if (_cursor.isNull(_cursorIndexOfStatusTeam)) {
          _tmpStatusTeam = null;
        } else {
          _tmpStatusTeam = _cursor.getString(_cursorIndexOfStatusTeam);
        }
        final int _tmpPositionTeam;
        _tmpPositionTeam = _cursor.getInt(_cursorIndexOfPositionTeam);
        _item = new TeamEntity(_tmpIdTeam,_tmpStatusTeam,_tmpPositionTeam);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Object insertData(final UserDao userDao, final ScoreDao scoreDao, final TeamDao teamDao,
      final Continuation<? super Unit> $completion) {
    return TeamDao.DefaultImpls.insertData(TeamDao_Impl.this, userDao, scoreDao, teamDao, $completion);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
