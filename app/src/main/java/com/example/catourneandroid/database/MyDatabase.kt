package com.example.catourneandroid.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.catourneandroid.database.dao.ScoreDao
import com.example.catourneandroid.database.dao.TeamDao
import com.example.catourneandroid.database.dao.UserDao
import com.example.catourneandroid.database.entity.ScoreEntity
import com.example.catourneandroid.database.entity.TeamEntity
import com.example.catourneandroid.database.entity.UserEntity

@Database(entities = [UserEntity::class, TeamEntity::class, ScoreEntity::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    abstract fun teamDao(): TeamDao
    abstract fun scoreDao(): ScoreDao

    companion object {
        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getDatabase(context: Context): MyDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    "my_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
