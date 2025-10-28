package com.example.learningexam.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.learningexam.data.db.entity.Flower
import com.example.learningexam.databinding.ItemFlowerBinding
import com.example.learningexam.ui.main.MainAdapter.MainViewHolder

class MainAdapter(
    private val onItemClickListener: (Flower) -> Unit
) : ListAdapter<Flower, MainViewHolder>(FlowerDiffCallBack()){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        val binding = ItemFlowerBinding.inflate(LayoutInflater.from(parent.context))
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MainViewHolder,
        position: Int
    ) {
        val flower = getItem(position)
        holder.bind(flower)
    }

    inner class MainViewHolder(private val binding : ItemFlowerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(flower: Flower) {
            binding.txtName.text = flower.name
            binding.txtDescription.text = flower.description.take(25)
            binding.txtUnit.text = "Đơn vị: " + flower.unit
            binding.txtPrice.text = "Giá: " + flower.price.toString()
            itemView.setOnClickListener {
                onItemClickListener(flower)
            }
        }
    }

}

class FlowerDiffCallBack : DiffUtil.ItemCallback<Flower>() {
    override fun areItemsTheSame(
        oldItem: Flower,
        newItem: Flower
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Flower,
        newItem: Flower
    ): Boolean {
        return oldItem == newItem
    }

}