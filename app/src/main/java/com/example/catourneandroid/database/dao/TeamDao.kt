package com.example.catourneandroid.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.catourneandroid.database.entity.TeamEntity

@Dao
interface TeamDao {
    @Query("SELECT * FROM TeamEntity")
    suspend fun getAllTeams(): List<TeamEntity>

    @Insert
    suspend fun insertTeam(team: TeamEntity)

    @Query("SELECT * FROM TeamEntity WHERE idTeam = :teamId LIMIT 1")
    suspend fun getTeamById(teamId: Int): TeamEntity?
}