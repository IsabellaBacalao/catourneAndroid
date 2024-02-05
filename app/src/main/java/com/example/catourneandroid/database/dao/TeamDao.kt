package com.example.catourneandroid.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.catourneandroid.database.entity.TeamEntity

@Dao
interface TeamDao {
    @Query("SELECT * FROM TeamEntity")
    fun getAllTeams(): List<TeamEntity>

    @Insert
    suspend fun insertTeam(team: TeamEntity)
/*
    @Insert

    suspend fun insertData(userDao: UserDao, scoreDao: ScoreDao, teamDao: TeamDao) {
        val teamBlue1 = TeamEntity(idTeam = 1, statusTeam = "blue", positionTeam = 1)
        val teamBlue2 = TeamEntity(idTeam = 2, statusTeam = "blue", positionTeam = 2)

        val teamRed1 = TeamEntity(idTeam = 3, statusTeam = "red", positionTeam = 1)
        val teamRed2 = TeamEntity(idTeam = 4, statusTeam = "red", positionTeam = 2)


        teamDao.insertTeam(teamBlue1)
        teamDao.insertTeam(teamBlue2)

        teamDao.insertTeam(teamRed1)
        teamDao.insertTeam(teamRed2)
    }*/
}