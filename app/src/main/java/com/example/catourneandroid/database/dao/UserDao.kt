package com.example.catourneandroid.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.catourneandroid.database.entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM UserEntity")
    suspend fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM UserEntity WHERE idPseudo = :userId LIMIT 1")
    suspend fun getUserById(userId: Int): UserEntity?

    @Query("SELECT * FROM UserEntity WHERE idTeam = :teamId LIMIT 1")
    suspend fun getUserByIdTeam(teamId: Int): UserEntity?

    @Query("SELECT * FROM UserEntity WHERE userPosition = :position")
    suspend fun getUsersByPosition(position: Int): List<UserEntity>

    @Insert
    suspend fun insertUser(user: UserEntity)

    @Query("UPDATE UserEntity SET userPosition = :newPosition WHERE idPseudo = :userId")
    suspend fun updateScore(userId: Int, newPosition: Int)

    @Query("DELETE FROM UserEntity")
    suspend fun deleteAllUsers()

    @Query("DELETE FROM UserEntity WHERE idPseudo = :userId")
    suspend fun deleteUserById(userId: Int)


}
