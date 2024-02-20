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
import com.example.catourneandroid.database.entity.UserEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
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
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserEntity> __insertionAdapterOfUserEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllUsers;

  private final SharedSQLiteStatement __preparedStmtOfDeleteUserById;

  public UserDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserEntity = new EntityInsertionAdapter<UserEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `UserEntity` (`idPseudo`,`pseudo`,`score`,`idTeam`) VALUES (?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserEntity entity) {
        if (entity.getIdPseudo() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getIdPseudo());
        }
        if (entity.getPseudo() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getPseudo());
        }
        statement.bindLong(3, entity.getScore());
        statement.bindLong(4, entity.getIdTeam());
      }
    };
    this.__preparedStmtOfDeleteAllUsers = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM UserEntity";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteUserById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM UserEntity WHERE idPseudo = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertUser(final UserEntity user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUserEntity.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Object deleteAllUsers(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllUsers.acquire();
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
          __preparedStmtOfDeleteAllUsers.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteUserById(final int userId, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteUserById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, userId);
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
          __preparedStmtOfDeleteUserById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public List<UserEntity> getAllUsers() {
    final String _sql = "SELECT * FROM UserEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIdPseudo = CursorUtil.getColumnIndexOrThrow(_cursor, "idPseudo");
      final int _cursorIndexOfPseudo = CursorUtil.getColumnIndexOrThrow(_cursor, "pseudo");
      final int _cursorIndexOfScore = CursorUtil.getColumnIndexOrThrow(_cursor, "score");
      final int _cursorIndexOfIdTeam = CursorUtil.getColumnIndexOrThrow(_cursor, "idTeam");
      final List<UserEntity> _result = new ArrayList<UserEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final UserEntity _item;
        final Integer _tmpIdPseudo;
        if (_cursor.isNull(_cursorIndexOfIdPseudo)) {
          _tmpIdPseudo = null;
        } else {
          _tmpIdPseudo = _cursor.getInt(_cursorIndexOfIdPseudo);
        }
        final String _tmpPseudo;
        if (_cursor.isNull(_cursorIndexOfPseudo)) {
          _tmpPseudo = null;
        } else {
          _tmpPseudo = _cursor.getString(_cursorIndexOfPseudo);
        }
        final int _tmpScore;
        _tmpScore = _cursor.getInt(_cursorIndexOfScore);
        final int _tmpIdTeam;
        _tmpIdTeam = _cursor.getInt(_cursorIndexOfIdTeam);
        _item = new UserEntity(_tmpIdPseudo,_tmpPseudo,_tmpScore,_tmpIdTeam);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Object getUserById(final int userId, final Continuation<? super UserEntity> $completion) {
    final String _sql = "SELECT * FROM UserEntity WHERE idPseudo = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<UserEntity>() {
      @Override
      @Nullable
      public UserEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIdPseudo = CursorUtil.getColumnIndexOrThrow(_cursor, "idPseudo");
          final int _cursorIndexOfPseudo = CursorUtil.getColumnIndexOrThrow(_cursor, "pseudo");
          final int _cursorIndexOfScore = CursorUtil.getColumnIndexOrThrow(_cursor, "score");
          final int _cursorIndexOfIdTeam = CursorUtil.getColumnIndexOrThrow(_cursor, "idTeam");
          final UserEntity _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmpIdPseudo;
            if (_cursor.isNull(_cursorIndexOfIdPseudo)) {
              _tmpIdPseudo = null;
            } else {
              _tmpIdPseudo = _cursor.getInt(_cursorIndexOfIdPseudo);
            }
            final String _tmpPseudo;
            if (_cursor.isNull(_cursorIndexOfPseudo)) {
              _tmpPseudo = null;
            } else {
              _tmpPseudo = _cursor.getString(_cursorIndexOfPseudo);
            }
            final int _tmpScore;
            _tmpScore = _cursor.getInt(_cursorIndexOfScore);
            final int _tmpIdTeam;
            _tmpIdTeam = _cursor.getInt(_cursorIndexOfIdTeam);
            _result = new UserEntity(_tmpIdPseudo,_tmpPseudo,_tmpScore,_tmpIdTeam);
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

  @Override
  public Object getUserByIdTeam(final int teamId,
      final Continuation<? super UserEntity> $completion) {
    final String _sql = "SELECT * FROM UserEntity WHERE idTeam = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, teamId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<UserEntity>() {
      @Override
      @Nullable
      public UserEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIdPseudo = CursorUtil.getColumnIndexOrThrow(_cursor, "idPseudo");
          final int _cursorIndexOfPseudo = CursorUtil.getColumnIndexOrThrow(_cursor, "pseudo");
          final int _cursorIndexOfScore = CursorUtil.getColumnIndexOrThrow(_cursor, "score");
          final int _cursorIndexOfIdTeam = CursorUtil.getColumnIndexOrThrow(_cursor, "idTeam");
          final UserEntity _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmpIdPseudo;
            if (_cursor.isNull(_cursorIndexOfIdPseudo)) {
              _tmpIdPseudo = null;
            } else {
              _tmpIdPseudo = _cursor.getInt(_cursorIndexOfIdPseudo);
            }
            final String _tmpPseudo;
            if (_cursor.isNull(_cursorIndexOfPseudo)) {
              _tmpPseudo = null;
            } else {
              _tmpPseudo = _cursor.getString(_cursorIndexOfPseudo);
            }
            final int _tmpScore;
            _tmpScore = _cursor.getInt(_cursorIndexOfScore);
            final int _tmpIdTeam;
            _tmpIdTeam = _cursor.getInt(_cursorIndexOfIdTeam);
            _result = new UserEntity(_tmpIdPseudo,_tmpPseudo,_tmpScore,_tmpIdTeam);
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
