package com.example.starwars.data.service

import com.example.starwars.data.response.PlanetResponse
import com.example.starwars.data.response.SinglePlanetResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StarWarsService {

    @GET("planets")
    suspend fun getPlanetListAsync(@Query("page") page : Int) : Response<PlanetResponse>

    @GET("planets/{id}")
    suspend fun getPlanetAsync(@Path("id") id : Int) : Response<SinglePlanetResponse>
}