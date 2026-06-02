package com.easy.demo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.easy.demo.databinding.ItemApiBinding

class ApiAdapter(
    private val items: List<ApiItem>,
    private val onItemClick: (ApiItem) -> Unit,
    private val onFavoriteClick: (ApiItem) -> Unit,
    private val onCopyClick: (ApiItem) -> Unit,
    private val onShareClick: (ApiItem) -> Unit
) : RecyclerView.Adapter<ApiAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemApiBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        
        fun bind(item: ApiItem) {
            binding.tvName.text = item.name
            binding.tvDescription.text = item.description
            binding.tvTag.text = item.tag
            
            val tagColor = when (item.tag) {
                "推荐" -> R.color.tag_recommend
                "热门" -> R.color.tag_hot
                else -> R.color.tag_default
            }
            binding.tvTag.setBackgroundResource(tagColor)
            
            val favoriteIcon = if (item.isFavorite) {
                android.R.drawable.btn_star_big_on
            } else {
                android.R.drawable.btn_star_big_off
            }
            binding.ivFavorite.setImageResource(favoriteIcon)
            
            binding.root.setOnClickListener { onItemClick(item) }
            binding.ivFavorite.setOnClickListener { onFavoriteClick(item) }
            binding.btnCopy.setOnClickListener { onCopyClick(item) }
            binding.btnShare.setOnClickListener { onShareClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemApiBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}