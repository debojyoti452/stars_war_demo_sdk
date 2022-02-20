package com.example.lib.src.remote.model

import com.example.lib.src.utils.ConverterUtils
import com.google.gson.annotations.SerializedName

data class Planet(
    @SerializedName("count")
    val itemCount: Int? = null,
    @SerializedName("next")
    val nextPage: String? = null,
    @SerializedName("previous")
    val prevPage: String? = null,
    @SerializedName("results")
    val dataList: List<PlanetData>? = null,
) {
    fun getFiveClimateAndPopulation(): List<Pair<String?, String?>>? {
        return dataList?.let { ConverterUtils.getClimateAndPopulationFromPlanet(it) }
    }
}

data class PlanetData(

    @field:SerializedName("films")
    val films: List<String?>? = null,

    @field:SerializedName("edited")
    val edited: String? = null,

    @field:SerializedName("created")
    val created: String? = null,

    @field:SerializedName("climate")
    val climate: String? = null,

    @field:SerializedName("rotation_period")
    val rotationPeriod: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("population")
    val population: String? = null,

    @field:SerializedName("orbital_period")
    val orbitalPeriod: String? = null,

    @field:SerializedName("surface_water")
    val surfaceWater: String? = null,

    @field:SerializedName("diameter")
    val diameter: String? = null,

    @field:SerializedName("gravity")
    val gravity: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("residents")
    val residents: List<String?>? = null,

    @field:SerializedName("terrain")
    val terrain: String? = null
)
