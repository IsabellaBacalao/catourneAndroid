package com.example.catourneandroid.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.catourneandroid.database.dao.ScoreDao;
import com.example.catourneandroid.database.dao.ScoreDao_Impl;
import com.example.catourneandroid.database.dao.TeamDao;
import com.example.catourneandroid.database.dao.TeamDao_Impl;
import com.example.catourneandroid.database.dao.UserDao;
import com.example.catourneandroid.database.dao.UserDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MyDatabase_Impl extends MyDatabase {
  private volatile UserDao _userDao;

  private volatile TeamDao _teamDao;

  private volatile ScoreDao _scoreDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `UserEntity` (`idPseudo` INTEGER NOT NULL, `pseudo` TEXT NOT NULL, `idScore` INTEGER NOT NULL, `idTeam` INTEGER NOT NULL, PRIMARY KEY(`idPseudo`), FOREIGN KEY(`idScore`) REFERENCES `ScoreEntity`(`idScore`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`idTeam`) REFERENCES `TeamEntity`(`idTeam`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `TeamEntity` (`idTeam` INTEGER NOT NULL, `statusTeam` TEXT NOT NULL, `positionTeam` INTEGER NOT NULL, PRIMARY KEY(`idTeam`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ScoreEntity` (`idScore` INTEGER NOT NULL, `score` INTEGER NOT NULL, PRIMARY KEY(`idScore`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'a5a72270af7d379ee709d23fd5302a3c')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `UserEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `TeamEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `ScoreEntity`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUserEntity = new HashMap<String, TableInfo.Column>(4);
        _columnsUserEntity.put("idPseudo", new TableInfo.Column("idPseudo", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserEntity.put("pseudo", new TableInfo.Column("pseudo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserEntity.put("idScore", new TableInfo.Column("idScore", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserEntity.put("idTeam", new TableInfo.Column("idTeam", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserEntity = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysUserEntity.add(new TableInfo.ForeignKey("ScoreEntity", "CASCADE", "NO ACTION",Arrays.asList("idScore"), Arrays.asList("idScore")));
        _foreignKeysUserEntity.add(new TableInfo.ForeignKey("TeamEntity", "CASCADE", "NO ACTION",Arrays.asList("idTeam"), Arrays.asList("idTeam")));
        final HashSet<TableInfo.Index> _indicesUserEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserEntity = new TableInfo("UserEntity", _columnsUserEntity, _foreignKeysUserEntity, _indicesUserEntity);
        final TableInfo _existingUserEntity = TableInfo.read(_db, "UserEntity");
        if (! _infoUserEntity.equals(_existingUserEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "UserEntity(com.example.catourneandroid.database.entity.UserEntity).\n"
                  + " Expected:\n" + _infoUserEntity + "\n"
                  + " Found:\n" + _existingUserEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsTeamEntity = new HashMap<String, TableInfo.Column>(3);
        _columnsTeamEntity.put("idTeam", new TableInfo.Column("idTeam", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTeamEntity.put("statusTeam", new TableInfo.Column("statusTeam", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTeamEntity.put("positionTeam", new TableInfo.Column("positionTeam", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTeamEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTeamEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTeamEntity = new TableInfo("TeamEntity", _columnsTeamEntity, _foreignKeysTeamEntity, _indicesTeamEntity);
        final TableInfo _existingTeamEntity = TableInfo.read(_db, "TeamEntity");
        if (! _infoTeamEntity.equals(_existingTeamEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "TeamEntity(com.example.catourneandroid.database.entity.TeamEntity).\n"
                  + " Expected:\n" + _infoTeamEntity + "\n"
                  + " Found:\n" + _existingTeamEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsScoreEntity = new HashMap<String, TableInfo.Column>(2);
        _columnsScoreEntity.put("idScore", new TableInfo.Column("idScore", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScoreEntity.put("score", new TableInfo.Column("score", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysScoreEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesScoreEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoScoreEntity = new TableInfo("ScoreEntity", _columnsScoreEntity, _foreignKeysScoreEntity, _indicesScoreEntity);
        final TableInfo _existingScoreEntity = TableInfo.read(_db, "ScoreEntity");
        if (! _infoScoreEntity.equals(_existingScoreEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "ScoreEntity(com.example.catourneandroid.database.entity.ScoreEntity).\n"
                  + " Expected:\n" + _infoScoreEntity + "\n"
                  + " Found:\n" + _existingScoreEntity);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "a5a72270af7d379ee709d23fd5302a3c", "4a56e358fe25377066d0fa828ce4cba1");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "UserEntity","TeamEntity","ScoreEntity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `UserEntity`");
      _db.execSQL("DELETE FROM `TeamEntity`");
      _db.execSQL("DELETE FROM `ScoreEntity`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TeamDao.class, TeamDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ScoreDao.class, ScoreDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public TeamDao teamDao() {
    if (_teamDao != null) {
      return _teamDao;
    } else {
      synchronized(this) {
        if(_teamDao == null) {
          _teamDao = new TeamDao_Impl(this);
        }
        return _teamDao;
      }
    }
  }

  @Override
  public ScoreDao scoreDao() {
    if (_scoreDao != null) {
      return _scoreDao;
    } else {
      synchronized(this) {
        if(_scoreDao == null) {
          _scoreDao = new ScoreDao_Impl(this);
        }
        return _scoreDao;
      }
    }
  }
}
