package com.example.catourneandroid.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.catourneandroid.database.entity.TeamEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
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

  private final SharedSQLiteStatement __preparedStmtOfUpdateTeamById;

  public TeamDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTeamEntity = new EntityInsertionAdapter<TeamEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `TeamEntity` (`idTeam`,`statusTeam`,`position_team`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final TeamEntity entity) {
        statement.bindLong(1, entity.getIdTeam());
        if (entity.getStatusTeam() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getStatusTeam());
        }
        statement.bindLong(3, entity.getPositionTeam());
      }
    };
    this.__preparedStmtOfUpdateTeamById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE TeamEntity SET position_team = ? WHERE idTeam = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertTeam(final TeamEntity team, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTeamEntity.insert(team);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateTeamById(final int teamId, final int newPosition,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateTeamById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, newPosition);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, teamId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateTeamById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllTeams(final Continuation<? super List<TeamEntity>> $completion) {
    final String _sql = "SELECT * FROM TeamEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TeamEntity>>() {
      @Override
      @NonNull
      public List<TeamEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIdTeam = CursorUtil.getColumnIndexOrThrow(_cursor, "idTeam");
          final int _cursorIndexOfStatusTeam = CursorUtil.getColumnIndexOrThrow(_cursor, "statusTeam");
          final int _cursorIndexOfPositionTeam = CursorUtil.getColumnIndexOrThrow(_cursor, "position_team");
          final List<TeamEntity> _result = new ArrayList<TeamEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
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
    }, $completion);
  }

  @Override
  public Object getTeamById(final int teamId, final Continuation<? super TeamEntity> $completion) {
    final String _sql = "SELECT * FROM TeamEntity WHERE idTeam = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, teamId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<TeamEntity>() {
      @Override
      @Nullable
      public TeamEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIdTeam = CursorUtil.getColumnIndexOrThrow(_cursor, "idTeam");
          final int _cursorIndexOfStatusTeam = CursorUtil.getColumnIndexOrThrow(_cursor, "statusTeam");
          final int _cursorIndexOfPositionTeam = CursorUtil.getColumnIndexOrThrow(_cursor, "position_team");
          final TeamEntity _result;
          if (_cursor.moveToFirst()) {
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
            _result = new TeamEntity(_tmpIdTeam,_tmpStatusTeam,_tmpPositionTeam);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
