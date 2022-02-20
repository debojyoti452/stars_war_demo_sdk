package com.example.lib.src.remote.repository

import com.example.lib.src.component.base.ResponseOnListener
import com.example.lib.src.remote.model.*
import com.example.lib.src.utils.Response

internal interface StarWarsRepository {
    suspend fun getPeople(listener : ResponseOnListener<Response<People>>)
    suspend fun getPlanets(listener : ResponseOnListener<Response<Planet>>)
    suspend fun getFilms(listener: ResponseOnListener<Response<Film>>)
}
