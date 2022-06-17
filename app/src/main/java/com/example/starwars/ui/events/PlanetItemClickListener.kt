package com.example.starwars.ui.events

import com.example.starwars.data.response.SinglePlanetResponse

interface PlanetItemClickListener {
    fun onItemClicked(data : SinglePlanetResponse)
}