package com.example.starwars.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.starwars.data.repository.PlanetsRepository
import com.example.starwars.data.response.SinglePlanetResponse
import com.example.starwars.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor
    (
    private val repository: PlanetsRepository,
    application: Application
) : AndroidViewModel(application) {

    private var singlePlanetData  = MutableLiveData<SinglePlanetResponse>()
    val singlePlanetResponseLiveData : LiveData<SinglePlanetResponse> get() = singlePlanetData

    fun getPlanets() : Flow<PagingData<SinglePlanetResponse>> {
        return repository.getPlanetList().cachedIn(viewModelScope)
    }

    fun getPlanet(id : Int)  : Flow<NetworkResult<SinglePlanetResponse>>{
        return repository.getSinglePlanet(id).onEach {
            if (it is  NetworkResult.Success) {
                it.data?.name = "Ishara edit this"
            }
        }
    }

    fun setSinglePlanetData(singlePlanetResponse: SinglePlanetResponse) {
        singlePlanetData.postValue(singlePlanetResponse)
    }
}