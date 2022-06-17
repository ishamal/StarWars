package com.example.starwars.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.starwars.data.repository.PlanetsRepository
import com.example.starwars.data.response.SinglePlanetResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor
    (
    private val repository: PlanetsRepository,
    application: Application
) : AndroidViewModel(application) {


    val plantList : Flow<PagingData<SinglePlanetResponse>> = repository.getPlanetList().cachedIn(viewModelScope)

    fun getPlanets() : Flow<PagingData<SinglePlanetResponse>> {
        return repository.getPlanetList().cachedIn(viewModelScope)
    }

}