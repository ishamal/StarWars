package com.example.starwars.ui.viewholder

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.starwars.BuildConfig
import com.example.starwars.R
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

    @SuppressLint("SetTextI18n")
    fun bind(singlePlanet : SinglePlanetResponse, listener : PlanetItemClickListener) {

        _binding.nameText.text = "${_binding.root.context.getString(R.string.name)} ${singlePlanet.name}"
        _binding.populationText.text = "${_binding.root.context.getString(R.string.population)} ${singlePlanet.population}"
        _binding.climateText.text = "${_binding.root.context.getString(R.string.climate)} ${singlePlanet.climate}"

        _binding.root.setOnClickListener {
            listener.onItemClicked(singlePlanet)
        }

        Glide
            .with(_binding.root.context)
            .load("${BuildConfig.IMAGE_BASE_URL}${singlePlanet.name}")
            .placeholder(R.drawable.background_image)
            .into(_binding.planetImage)

    }

}