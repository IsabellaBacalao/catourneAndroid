package com.example.catourneandroid.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

// Table score
@Entity
data class ScoreEntity(
    @PrimaryKey val idScore: Int,
    val score: Int
)
