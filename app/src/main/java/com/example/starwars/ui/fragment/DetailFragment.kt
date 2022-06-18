package com.example.starwars.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.starwars.data.response.SinglePlanetResponse
import com.example.starwars.databinding.FragmentDetailBinding
import com.example.starwars.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private var singlePlanetResponse : SinglePlanetResponse? = null
    private val mainViewModel : MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater)
        singlePlanetResponse = mainViewModel.singlePlanetResponseLiveData.value
        onBind()
        return binding.root
    }

    private fun onBind() {
        singlePlanetResponse.let {
            binding.planetName.text = singlePlanetResponse?.name
            binding.rotationPeriodVal.text = singlePlanetResponse?.rotation_period
            binding.orbitalPerioddVal.text = singlePlanetResponse?.orbital_period
            binding.diameterVal.text = singlePlanetResponse?.diameter
            binding.climateVal.text = singlePlanetResponse?.climate
            binding.gravityVal.text = singlePlanetResponse?.gravity
            binding.terrainVal.text = singlePlanetResponse?.terrain
            binding.surfaceWaterVal.text = singlePlanetResponse?.surface_water
            binding.populationVal.text = singlePlanetResponse?.population
        }
    }

}