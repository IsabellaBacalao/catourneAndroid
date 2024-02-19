package com.example.catourneandroid.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0086@\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/catourneandroid/repository/TeamRepository;", "", "teamDao", "Lcom/example/catourneandroid/database/dao/TeamDao;", "(Lcom/example/catourneandroid/database/dao/TeamDao;)V", "getAllTeams", "", "Lcom/example/catourneandroid/database/entity/TeamEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTeam", "", "team", "(Lcom/example/catourneandroid/database/entity/TeamEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class TeamRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.catourneandroid.database.dao.TeamDao teamDao = null;
    
    public TeamRepository(@org.jetbrains.annotations.NotNull()
    com.example.catourneandroid.database.dao.TeamDao teamDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllTeams(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.catourneandroid.database.entity.TeamEntity>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertTeam(@org.jetbrains.annotations.NotNull()
    com.example.catourneandroid.database.entity.TeamEntity team, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}