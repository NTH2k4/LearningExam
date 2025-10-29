package com.example.learningexam.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learningexam.data.db.AppDatabase
import com.example.learningexam.data.db.entity.Flower
import com.example.learningexam.data.repository.FlowerRepository
import com.example.learningexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private val adapter = MainAdapter { flower ->
//
//    }
    private lateinit var adapter : MainAdapter
    private val viewModel : MainViewModel by viewModels {
        val db = AppDatabase.getDatabase(applicationContext)
        val repository = FlowerRepository(db.flowerDao())
        MainViewModelFactory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        adapter = MainAdapter(
            onItemClickListener = { flower ->
                val intent = Intent(this, InfoFlowerActivity::class.java)
                intent.putExtra("FLOWER", flower)
                startActivity(intent)
            }
        )

        binding.rcListFlower.adapter = adapter

        binding.rcListFlower.layoutManager = LinearLayoutManager(this)

        viewModel.allFlowers.observe(this) { flowers ->
            adapter.submitList(flowers)
            if (flowers.isNullOrEmpty()) {
                viewModel.insert(Flower(name = "Hoa Hồng", description = "Biểu tượng của tình yêu", price = 12000.0, unit = "Bó"))
                viewModel.insert(Flower(name = "Hoa Cúc", description = "Biểu tượng của sự thanh cao", price = 26000.0, unit = "Bông"))
                viewModel.insert(Flower(name = "Hoa Lan", description = "Biểu tượng của sự sang trọng", price = 12500.0, unit = "Bó"))
            }
        }


    }

}