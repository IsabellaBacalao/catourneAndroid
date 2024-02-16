package com.example.catourneandroid.database.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J&\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/example/catourneandroid/database/dao/UserDao;", "", "delete", "", "user", "Lcom/example/catourneandroid/database/entity/UserEntity;", "getAllUsers", "", "insertData", "userDao", "scoreDao", "Lcom/example/catourneandroid/database/dao/ScoreDao;", "teamDao", "Lcom/example/catourneandroid/database/dao/TeamDao;", "(Lcom/example/catourneandroid/database/dao/UserDao;Lcom/example/catourneandroid/database/dao/ScoreDao;Lcom/example/catourneandroid/database/dao/TeamDao;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUser", "(Lcom/example/catourneandroid/database/entity/UserEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface UserDao {
    
    @androidx.room.Query(value = "SELECT * FROM UserEntity")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.catourneandroid.database.entity.UserEntity> getAllUsers();
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertUser(@org.jetbrains.annotations.NotNull()
    com.example.catourneandroid.database.entity.UserEntity user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertData(@org.jetbrains.annotations.NotNull()
    com.example.catourneandroid.database.dao.UserDao userDao, @org.jetbrains.annotations.NotNull()
    com.example.catourneandroid.database.dao.ScoreDao scoreDao, @org.jetbrains.annotations.NotNull()
    com.example.catourneandroid.database.dao.TeamDao teamDao, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.example.catourneandroid.database.entity.UserEntity user);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
        
        @org.jetbrains.annotations.Nullable()
        public static java.lang.Object insertData(@org.jetbrains.annotations.NotNull()
        com.example.catourneandroid.database.dao.UserDao $this, @org.jetbrains.annotations.NotNull()
        com.example.catourneandroid.database.dao.UserDao userDao, @org.jetbrains.annotations.NotNull()
        com.example.catourneandroid.database.dao.ScoreDao scoreDao, @org.jetbrains.annotations.NotNull()
        com.example.catourneandroid.database.dao.TeamDao teamDao, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
            return null;
        }
    }
}