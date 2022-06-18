package com.example.starwars.ui.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.starwars.data.response.SinglePlanetResponse
import com.example.starwars.ui.events.PlanetItemClickListener
import com.example.starwars.ui.viewholder.PlanetViewHolder

class PlanetAdapter(var listener : PlanetItemClickListener) :
    PagingDataAdapter<SinglePlanetResponse, PlanetViewHolder>(COMPARATOR) {

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<SinglePlanetResponse>() {
            override fun areItemsTheSame(
                oldItem: SinglePlanetResponse,
                newItem: SinglePlanetResponse
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: SinglePlanetResponse,
                newItem: SinglePlanetResponse
            ): Boolean {
                return oldItem.name.equals(newItem.name,true)
            }
        }
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        val data = getItem(position)
        data?.let { holder.bind(it,listener) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        return PlanetViewHolder.create(parent)
    }

}