package com.example.catourneandroid.database.entity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003JB\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e\u00a8\u0006\u001f"}, d2 = {"Lcom/example/catourneandroid/database/entity/UserEntity;", "", "idPseudo", "", "pseudo", "", "score", "userPosition", "idTeam", "(Ljava/lang/Integer;Ljava/lang/String;III)V", "getIdPseudo", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIdTeam", "()I", "getPseudo", "()Ljava/lang/String;", "getScore", "getUserPosition", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;III)Lcom/example/catourneandroid/database/entity/UserEntity;", "equals", "", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(foreignKeys = {@androidx.room.ForeignKey(entity = com.example.catourneandroid.database.entity.TeamEntity.class, parentColumns = {"idTeam"}, childColumns = {"idTeam"}, onDelete = 5)})
public final class UserEntity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer idPseudo = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String pseudo = null;
    private final int score = 0;
    private final int userPosition = 0;
    private final int idTeam = 0;
    
    public UserEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Integer idPseudo, @org.jetbrains.annotations.NotNull()
    java.lang.String pseudo, int score, int userPosition, int idTeam) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getIdPseudo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPseudo() {
        return null;
    }
    
    public final int getScore() {
        return 0;
    }
    
    public final int getUserPosition() {
        return 0;
    }
    
    public final int getIdTeam() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.catourneandroid.database.entity.UserEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer idPseudo, @org.jetbrains.annotations.NotNull()
    java.lang.String pseudo, int score, int userPosition, int idTeam) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}