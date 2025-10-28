package com.example.learningexam.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.learningexam.data.db.dao.FlowerDao
import com.example.learningexam.data.db.entity.Flower

@Database(entities = [Flower::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract  fun flowerDao() : FlowerDao

    companion object {
        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context : Context) : AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "flower_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}