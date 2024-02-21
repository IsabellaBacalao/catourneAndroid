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

    suspend fun getUsersByPosition(position: Int): List<UserEntity> {
        return userDao.getUsersByPosition(position)
    }

    suspend fun updateScore(user: UserEntity) {
        val userId = user.idPseudo
        val newScore = user.score
        if (userId != null) {
            userDao.updateScore(userId, newScore)
        }
    }

    suspend fun deleteAllUsers() {
        userDao.deleteAllUsers()
    }

    suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }
}
