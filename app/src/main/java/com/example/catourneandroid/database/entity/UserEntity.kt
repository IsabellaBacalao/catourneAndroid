package com.example.catourneandroid.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

// Table user
@Entity(
    foreignKeys = [
        ForeignKey(
            entity = TeamEntity::class,
            parentColumns = ["idTeam"],
            childColumns = ["idTeam"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val idPseudo: Int? = null,
    val pseudo: String,
    var score: Int = 0,
    var userPosition: Int,
    var idTeam: Int
)
