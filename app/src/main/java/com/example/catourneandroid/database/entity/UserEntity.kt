package com.example.catourneandroid.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

// Table user
@Entity(
    foreignKeys = [
        ForeignKey(
            entity = ScoreEntity::class,
            parentColumns = ["idScore"],
            childColumns = ["idScore"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = TeamEntity::class,
            parentColumns = ["idTeam"],
            childColumns = ["idTeam"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class UserEntity(
    @PrimaryKey val idPseudo: Int,
    val pseudo: String,
    val idScore: Int,
    val idTeam: Int
)
