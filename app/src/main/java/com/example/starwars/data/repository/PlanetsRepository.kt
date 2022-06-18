package com.example.starwars.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.starwars.data.datasource.StarWarsPagingSource
import com.example.starwars.data.response.BaseApiResponse
import com.example.starwars.data.response.SinglePlanetResponse
import com.example.starwars.data.service.StarWarsService
import com.example.starwars.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PlanetsRepository@Inject constructor(
    private val starWarsPagingSource: StarWarsPagingSource,
    private val starWarsService: StarWarsService
) : BaseApiResponse() {

    fun getPlanetList() : Flow<PagingData<SinglePlanetResponse>> {
       return Pager(
           config = PagingConfig(pageSize = 2, enablePlaceholders = false),
           pagingSourceFactory = {starWarsPagingSource}
       ).flow
    }

    fun getSinglePlanet(id : Int) : Flow<NetworkResult<SinglePlanetResponse>> {
        return flow {
            emit(safeApiCall { starWarsService.getPlanetAsync(id) })
        }.flowOn(Dispatchers.IO)
    }
}