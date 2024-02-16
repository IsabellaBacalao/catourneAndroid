package com.example.catourneandroid.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.catourneandroid.database.entity.UserEntity;
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
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserEntity> __insertionAdapterOfUserEntity;

  private final EntityDeletionOrUpdateAdapter<UserEntity> __deletionAdapterOfUserEntity;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserEntity = new EntityInsertionAdapter<UserEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `UserEntity` (`idPseudo`,`pseudo`,`idScore`,`idTeam`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserEntity value) {
        stmt.bindLong(1, value.getIdPseudo());
        if (value.getPseudo() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPseudo());
        }
        stmt.bindLong(3, value.getIdScore());
        stmt.bindLong(4, value.getIdTeam());
      }
    };
    this.__deletionAdapterOfUserEntity = new EntityDeletionOrUpdateAdapter<UserEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `UserEntity` WHERE `idPseudo` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserEntity value) {
        stmt.bindLong(1, value.getIdPseudo());
      }
    };
  }

  @Override
  public Object insertUser(final UserEntity user, final Continuation<? super Unit> $completion) {
    return Completable.fromCallable(new Callable<Void>() {
      @Override
      public Void call() throws Exception {
      }
    });
  }

  @Override
  public void delete(final UserEntity user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUserEntity.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
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
      final int _cursorIndexOfIdScore = CursorUtil.getColumnIndexOrThrow(_cursor, "idScore");
      final int _cursorIndexOfIdTeam = CursorUtil.getColumnIndexOrThrow(_cursor, "idTeam");
      final List<UserEntity> _result = new ArrayList<UserEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserEntity _item;
        final int _tmpIdPseudo;
        _tmpIdPseudo = _cursor.getInt(_cursorIndexOfIdPseudo);
        final String _tmpPseudo;
        if (_cursor.isNull(_cursorIndexOfPseudo)) {
          _tmpPseudo = null;
        } else {
          _tmpPseudo = _cursor.getString(_cursorIndexOfPseudo);
        }
        final int _tmpIdScore;
        _tmpIdScore = _cursor.getInt(_cursorIndexOfIdScore);
        final int _tmpIdTeam;
        _tmpIdTeam = _cursor.getInt(_cursorIndexOfIdTeam);
        _item = new UserEntity(_tmpIdPseudo,_tmpPseudo,_tmpIdScore,_tmpIdTeam);
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
    return UserDao.DefaultImpls.insertData(UserDao_Impl.this, userDao, scoreDao, teamDao, $completion);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
