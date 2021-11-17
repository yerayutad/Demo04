package com.example.demo004

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demo004.databinding.ItemBeerBinding
import com.example.demo004.extensions.imageUrl
import com.example.demo004.model.Beer

class BeerAdapter: ListAdapter<Beer, BeerAdapter.ViewHolder>(BeerItemCallback()) {
    inner class ViewHolder(val binding: ItemBeerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemBeerBinding = ItemBeerBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val beer = getItem(position)
        holder.binding.tvBeerName.text = beer.name
        holder.binding.tvBeerAvb.text = beer.abv.toString()
        holder.binding.ivBeerImage.imageUrl(beer.imageUrl)
    }

}

class BeerItemCallback: DiffUtil.ItemCallback<Beer>(){
    override fun areItemsTheSame(oldItem: Beer, newItem: Beer): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Beer, newItem: Beer): Boolean {
        return oldItem.id == newItem.id
    }
}