package com.example.learningexam.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.learningexam.data.db.entity.Flower
import kotlinx.coroutines.flow.Flow

@Dao
interface FlowerDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFlower(flower: Flower)

    @Update
    suspend fun updateFlower(flower: Flower)

    @Query("DELETE FROM flowers WHERE id = :id")
    suspend fun deleteFLower(id : Int)

    @Query("SELECT * FROM flowers")
    fun getAllFlowers() : Flow<List<Flower>>
}