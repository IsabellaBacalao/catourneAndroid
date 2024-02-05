package com.example.catourneandroid.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.catourneandroid.database.entity.ScoreEntity

@Dao
interface ScoreDao {
    @Query("SELECT * FROM ScoreEntity")
    fun getAllScores(): List<ScoreEntity>

    @Insert
    suspend fun insertScore(score: ScoreEntity)

    /*suspend fun insertData(scoreDao: ScoreDao) {
        val score = ScoreEntity(idScore = 1, score = 1)

        scoreDao.insertScore(score)
    }*/

}