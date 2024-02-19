package com.example.catourneandroid.database.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\r"}, d2 = {"Lcom/example/catourneandroid/database/dao/UserDao;", "", "delete", "", "user", "Lcom/example/catourneandroid/database/entity/UserEntity;", "getAllUsers", "", "getUserById", "teamId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUser", "app_debug"})
@androidx.room.Dao()
public abstract interface UserDao {
    
    @androidx.room.Query(value = "SELECT * FROM UserEntity")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.catourneandroid.database.entity.UserEntity> getAllUsers();
    
    @androidx.room.Query(value = "SELECT * FROM UserEntity WHERE idTeam = :teamId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserById(int teamId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.catourneandroid.database.entity.UserEntity> $completion);
    
    @androidx.room.Insert()
    public abstract void insertUser(@org.jetbrains.annotations.NotNull()
    com.example.catourneandroid.database.entity.UserEntity user);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.example.catourneandroid.database.entity.UserEntity user);
}