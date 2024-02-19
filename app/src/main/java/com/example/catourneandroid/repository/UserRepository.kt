package com.example.catourneandroid.repository

import androidx.lifecycle.LiveData
import com.example.catourneandroid.database.dao.UserDao
import com.example.catourneandroid.database.entity.UserEntity


class UserRepository(private val userDao: UserDao) {

    suspend fun getAllUsers(): List<UserEntity> =
        userDao.getAllUsers()

    suspend fun getUserById(teamId: Int): UserEntity? {
        return userDao.getUserById(teamId)
    }
    suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }
}
