package com.example.catourneandroid.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Table team
@Entity
data class TeamEntity(
    @PrimaryKey val idTeam: Int,
    @ColumnInfo(name = "status_team") val statusTeam: String,
    @ColumnInfo(name = "position_team") val positionTeam: Int
)
