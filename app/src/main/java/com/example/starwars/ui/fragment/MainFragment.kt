package com.example.starwars.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwars.R
import com.example.starwars.data.response.SinglePlanetResponse
import com.example.starwars.databinding.FragmentMainBinding
import com.example.starwars.ui.adapter.PlanetAdapter
import com.example.starwars.ui.events.PlanetItemClickListener
import com.example.starwars.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment(), PlanetItemClickListener {

    private lateinit var binding: FragmentMainBinding
    private val mainViewModel  : MainViewModel by activityViewModels()
    private var planetAdapter : PlanetAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        initGridView()
        getData()
        return binding.root
    }

    private fun initGridView() {
        planetAdapter = PlanetAdapter(this)
        binding.planetListView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = planetAdapter
        }
    }

    private fun getData() = lifecycleScope.launch {
        mainViewModel.getPlanets().collectLatest {
            planetAdapter?.submitData(it)
        }
    }

    override fun onItemClicked(data: SinglePlanetResponse) {
        mainViewModel.setSinglePlanetData(data)
        try {
            findNavController().navigate(R.id.action_mainFragment_to_detailFragment)
        } catch (e : Exception) {}
    }
}