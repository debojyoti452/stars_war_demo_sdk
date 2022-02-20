package com.example.lib.src.remote.service

import com.example.lib.src.remote.model.Film
import com.example.lib.src.remote.model.People
import com.example.lib.src.remote.model.Planet
import retrofit2.http.GET

internal interface StarWarsApiService {
    @GET("people/")
    suspend fun getPeoples(): People

    @GET("planets/")
    suspend fun getPlanets(): Planet

    @GET("films/")
    suspend fun getFilms(): Film
}
