package com.example.catourneandroid.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.catourneandroid.database.entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM UserEntity")
    fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM UserEntity WHERE idPseudo = :userId LIMIT 1")
    suspend fun getUserById(userId: Int): UserEntity?

    @Query("SELECT * FROM UserEntity WHERE idTeam = :teamId LIMIT 1")
    suspend fun getUserByIdTeam(teamId: Int): UserEntity?

    @Insert
    fun insertUser(user: UserEntity)

    @Query("DELETE FROM UserEntity")
    suspend fun deleteAllUsers()

    @Query("DELETE FROM UserEntity WHERE idPseudo = :userId")
    suspend fun deleteUserById(userId: Int)


}
