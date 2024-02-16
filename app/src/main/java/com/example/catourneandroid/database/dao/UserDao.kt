package com.example.catourneandroid.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.catourneandroid.database.entity.UserEntity

@Dao

interface UserDao {
    @Query("SELECT * FROM UserEntity")
    fun getAllUsers(): LiveData<List<UserEntity>>

    /*@Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    @Insert
    fun insertAll(vararg users: User)
     */
    @Insert
    suspend fun insertUser(user: UserEntity)

    suspend fun insertData(userDao: UserDao, scoreDao: ScoreDao, teamDao: TeamDao) {

        val user = UserEntity(idPseudo = 1, pseudo = "User1", idScore = 1, idTeam = 1)

        userDao.insertUser(user)
    }

    @Delete
    fun delete(user: UserEntity)
}