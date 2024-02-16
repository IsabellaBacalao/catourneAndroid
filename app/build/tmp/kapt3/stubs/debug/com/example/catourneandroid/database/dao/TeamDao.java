package com.example.catourneandroid.database.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0000H\u0097@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/catourneandroid/database/dao/TeamDao;", "", "getAllTeams", "", "Lcom/example/catourneandroid/database/entity/TeamEntity;", "insertData", "", "userDao", "Lcom/example/catourneandroid/database/dao/UserDao;", "scoreDao", "Lcom/example/catourneandroid/database/dao/ScoreDao;", "teamDao", "(Lcom/example/catourneandroid/database/dao/UserDao;Lcom/example/catourneandroid/database/dao/ScoreDao;Lcom/example/catourneandroid/database/dao/TeamDao;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTeam", "team", "(Lcom/example/catourneandroid/database/entity/TeamEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface TeamDao {
    
    @androidx.room.Query(value = "SELECT * FROM TeamEntity")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.catourneandroid.database.entity.TeamEntity> getAllTeams();
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertTeam(@org.jetbrains.annotations.NotNull()
    com.example.catourneandroid.database.entity.TeamEntity team, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertData(@org.jetbrains.annotations.NotNull()
    com.example.catourneandroid.database.dao.UserDao userDao, @org.jetbrains.annotations.NotNull()
    com.example.catourneandroid.database.dao.ScoreDao scoreDao, @org.jetbrains.annotations.NotNull()
    com.example.catourneandroid.database.dao.TeamDao teamDao, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
        
        @androidx.room.Insert()
        @org.jetbrains.annotations.Nullable()
        public static java.lang.Object insertData(@org.jetbrains.annotations.NotNull()
        com.example.catourneandroid.database.dao.TeamDao $this, @org.jetbrains.annotations.NotNull()
        com.example.catourneandroid.database.dao.UserDao userDao, @org.jetbrains.annotations.NotNull()
        com.example.catourneandroid.database.dao.ScoreDao scoreDao, @org.jetbrains.annotations.NotNull()
        com.example.catourneandroid.database.dao.TeamDao teamDao, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
            return null;
        }
    }
}