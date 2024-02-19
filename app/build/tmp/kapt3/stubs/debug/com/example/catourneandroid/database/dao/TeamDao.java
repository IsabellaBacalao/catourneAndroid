package com.example.catourneandroid.database.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/example/catourneandroid/database/dao/TeamDao;", "", "getAllTeams", "", "Lcom/example/catourneandroid/database/entity/TeamEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTeam", "", "team", "(Lcom/example/catourneandroid/database/entity/TeamEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface TeamDao {
    
    @androidx.room.Query(value = "SELECT * FROM TeamEntity")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllTeams(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.catourneandroid.database.entity.TeamEntity>> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertTeam(@org.jetbrains.annotations.NotNull()
    com.example.catourneandroid.database.entity.TeamEntity team, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}