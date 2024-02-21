package com.example.catourneandroid.repository

import com.example.catourneandroid.database.dao.UserDao
import com.example.catourneandroid.database.entity.UserEntity


class UserRepository(private val userDao: UserDao) {

    suspend fun getAllUsers(): List<UserEntity> =
        userDao.getAllUsers()

    suspend fun getUserById(userId: Int): UserEntity? {
        return userDao.getUserById(userId)
    }

    suspend fun getUserByIdTeam(teamId: Int): UserEntity? {
        return userDao.getUserByIdTeam(teamId)
    }

    suspend fun deleteAllUsers() {
        userDao.deleteAllUsers()
    }

    suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }
}
