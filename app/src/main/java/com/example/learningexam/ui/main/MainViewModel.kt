package com.example.learningexam.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.learningexam.data.db.entity.Flower
import com.example.learningexam.data.repository.FlowerRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: FlowerRepository) : ViewModel() {
    val allFlowers : LiveData<List<Flower>> = repository.allFlowers.asLiveData()

    fun insert(flower: Flower) = viewModelScope.launch {
        repository.insert(flower)
    }

    fun update(flower: Flower) = viewModelScope.launch {
        repository.update(flower)
    }

    fun delete(id : Int) = viewModelScope.launch {
        repository.deleteById(id)
    }
}