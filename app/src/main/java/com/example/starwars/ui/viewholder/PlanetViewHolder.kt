package com.example.starwars.ui.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.data.response.SinglePlanetResponse
import com.example.starwars.databinding.ItemPlanetCardBinding
import com.example.starwars.ui.events.PlanetItemClickListener

class PlanetViewHolder(private val _binding : ItemPlanetCardBinding) : RecyclerView.ViewHolder(_binding.root) {

    companion object {
        fun create(parent : ViewGroup) : PlanetViewHolder {
            val binding = ItemPlanetCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return PlanetViewHolder(binding)
        }
    }

    fun bind(singlePlanet : SinglePlanetResponse, listener : PlanetItemClickListener) {

        _binding.nameText.text = "Name : ${singlePlanet.name}"
        _binding.populationText.text = "Population : ${singlePlanet.population}"
        _binding.climateText.text = "Climate : ${singlePlanet.climate}"

    }

}