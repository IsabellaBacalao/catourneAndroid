package com.example.catourneandroid.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/example/catourneandroid/database/MyDatabase;", "Landroidx/room/RoomDatabase;", "()V", "teamDao", "Lcom/example/catourneandroid/database/dao/TeamDao;", "userDao", "Lcom/example/catourneandroid/database/dao/UserDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.example.catourneandroid.database.entity.UserEntity.class, com.example.catourneandroid.database.entity.TeamEntity.class}, version = 3, exportSchema = false)
public abstract class MyDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.example.catourneandroid.database.MyDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.catourneandroid.database.MyDatabase.Companion Companion = null;
    
    public MyDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.catourneandroid.database.dao.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.catourneandroid.database.dao.TeamDao teamDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/catourneandroid/database/MyDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/catourneandroid/database/MyDatabase;", "getDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.catourneandroid.database.MyDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}