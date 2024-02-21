package com.example.catourneandroid.database.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/example/catourneandroid/database/dao/UserDao;", "", "deleteAllUsers", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteUserById", "userId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllUsers", "", "Lcom/example/catourneandroid/database/entity/UserEntity;", "getUserById", "getUserByIdTeam", "teamId", "insertUser", "user", "(Lcom/example/catourneandroid/database/entity/UserEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface UserDao {
    
    @androidx.room.Query(value = "SELECT * FROM UserEntity")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllUsers(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.catourneandroid.database.entity.UserEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM UserEntity WHERE idPseudo = :userId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserById(int userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.catourneandroid.database.entity.UserEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM UserEntity WHERE idTeam = :teamId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserByIdTeam(int teamId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.catourneandroid.database.entity.UserEntity> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertUser(@org.jetbrains.annotations.NotNull()
    com.example.catourneandroid.database.entity.UserEntity user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM UserEntity")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAllUsers(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM UserEntity WHERE idPseudo = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteUserById(int userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}