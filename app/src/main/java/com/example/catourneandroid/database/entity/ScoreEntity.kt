package com.example.catourneandroid.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Table score
@Entity
data class ScoreEntity(
    @PrimaryKey val idScore: Int,
    @ColumnInfo(name = "my_column_score")val score: Int
)
