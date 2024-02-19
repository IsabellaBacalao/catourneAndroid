package com.example.catourneandroid.repository

import androidx.lifecycle.LiveData
import com.example.catourneandroid.database.dao.TeamDao
import com.example.catourneandroid.database.entity.TeamEntity

class TeamRepository(private val teamDao: TeamDao) {

    suspend fun getAllTeams(): List<TeamEntity> =
        teamDao.getAllTeams()


    // Function to insert a new team
    suspend fun insertTeam(team: TeamEntity) {
        teamDao.insertTeam(team)
    }
}