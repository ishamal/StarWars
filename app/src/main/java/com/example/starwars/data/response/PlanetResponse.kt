package com.example.starwars.data.response

import kotlin.random.Random

data class PlanetResponse(
    var count : Int?,
    var next : String?,
    var previous : String?,
    var results : List<SinglePlanetResponse>?
)

data class SinglePlanetResponse(
    var name : String?,
    var rotation_period : String?,
    var orbital_period : String?,
    var diameter : String?,
    var climate : String?,
    var gravity : String?,
    var terrain : String?,
    var surface_water : String?,
    var population : String?,
    var created : String?,
    var edited : String?,
    var residents : List<String>?,
    var films : List<String>?,
    var urlImage : Int? = Random.nextInt(1, 10000)
)