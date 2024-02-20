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

    @Insert
    fun insertUser(user: UserEntity)

    @Delete
    fun delete(user: UserEntity)

}
