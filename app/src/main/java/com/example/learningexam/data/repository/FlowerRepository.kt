package com.example.learningexam.data.repository

import com.example.learningexam.data.db.dao.FlowerDao
import com.example.learningexam.data.db.entity.Flower
import kotlinx.coroutines.flow.Flow

class FlowerRepository(private val flowerDao: FlowerDao) {
    val allFlowers : Flow<List<Flower>> = flowerDao.getAllFlowers()

    suspend fun insert(flower: Flower) {
        flowerDao.insertFlower(flower)
    }

    suspend fun update(flower: Flower) {
        flowerDao.updateFlower(flower)
    }

    suspend fun deleteById(id : Int) {
        flowerDao.deleteFLower(id)
    }
}