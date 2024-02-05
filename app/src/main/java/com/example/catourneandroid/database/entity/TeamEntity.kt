package com.example.catourneandroid.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

// Table team
@Entity
data class TeamEntity(
    @PrimaryKey val idTeam: Int,
    val statusTeam: String,
    val positionTeam: Int
)
