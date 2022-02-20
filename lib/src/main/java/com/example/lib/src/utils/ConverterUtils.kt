package com.example.lib.src.utils

import com.example.lib.src.remote.model.PeopleData
import com.example.lib.src.remote.model.PlanetData

object ConverterUtils {
    /**
     * Get 5 People Eye Color by using map() -> from Kotlin Standard Lib functionality
     * For making it more exciting, used [List.shuffled] function so always it will
     * fetched random 5 eye color from the list.
     * [List.take] is used for limiting element to 5 only.
     */
    fun getEyeColorFromPeople(peopleList: List<PeopleData>): List<String?>? {
        if (peopleList.isEmpty()) {
            return null
        }
        return peopleList.map { it.eyeColor }.take(5)
//        return peopleList.shuffled().map { it.eyeColor }.take(5)
    }

    fun getClimateAndPopulationFromPlanet(planetList: List<PlanetData>): List<Pair<String?, String?>>? {
        if (planetList.isEmpty()) {
            return null
        }
        return planetList.map { Pair(it.population, it.climate) }.take(5)
    }
}
