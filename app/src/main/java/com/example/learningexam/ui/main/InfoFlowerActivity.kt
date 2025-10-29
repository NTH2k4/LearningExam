package com.example.learningexam.ui.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learningexam.data.db.entity.Flower
import com.example.learningexam.databinding.ActivityInfoFlowerBinding

class InfoFlowerActivity : AppCompatActivity() {
    private lateinit var binding : ActivityInfoFlowerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityInfoFlowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val flower = intent.getSerializableExtra("FLOWER") as? Flower
        if (flower != null) {
            binding.name.text = flower.name
            binding.description.text = flower.description
            binding.price.text = "Giá: ${flower.price}"
            binding.unit.text = "Đơn vị: ${flower.unit}"
        }
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}