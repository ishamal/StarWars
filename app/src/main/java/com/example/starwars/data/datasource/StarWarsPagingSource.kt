package com.example.starwars.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.starwars.data.service.StarWarsService
import com.example.starwars.data.response.SinglePlanetResponse
import java.lang.Exception
import javax.inject.Inject

class StarWarsPagingSource  @Inject constructor(private val starWarsService: StarWarsService) :
    PagingSource<Int, SinglePlanetResponse>() {

    override fun getRefreshKey(state: PagingState<Int, SinglePlanetResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SinglePlanetResponse> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = starWarsService.getPlanetListAsync(nextPageNumber).body()
            LoadResult.Page(
                data = response?.results?.toList() ?: emptyList(),
                prevKey = if (response?.previous == null)  null else nextPageNumber - 1,
                nextKey = if (response?.next == null)  null else nextPageNumber + 1
            )
        } catch (e : Exception) {
            LoadResult.Error(e)
        }
    }
}