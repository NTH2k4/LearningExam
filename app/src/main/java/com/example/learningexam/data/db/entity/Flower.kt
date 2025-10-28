package com.example.learningexam.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flowers")
data class Flower(
    @PrimaryKey(autoGenerate = true) var id : Int = 0,
    var name : String,
    var description : String = "",
    var price : Double,
    var unit : String,
)
