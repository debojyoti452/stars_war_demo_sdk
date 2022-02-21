package com.example.lib.src.remote.impl

import android.content.Context
import com.example.lib.src.component.base.ResponseOnListener
import com.example.lib.src.remote.api.NetworkModule
import com.example.lib.src.remote.model.Film
import com.example.lib.src.remote.model.People
import com.example.lib.src.remote.model.Planet
import com.example.lib.src.remote.repository.StarWarsRepository
import com.example.lib.src.remote.exception.StarWarErrorExtractor
import com.example.lib.src.utils.Response

/**
 * [StarWarsApiImpl] It is our Repository where we call to server and get back
 * @property Response<T> as a Generic Type.
 * We are using Kotlin Coroutines and suspend function to make async network calls.
 * [ResponseOnListener] Callback function which return fetched result to ViewModel.
 */
internal class StarWarsApiImpl constructor(
    private val service: NetworkModule = NetworkModule(),
    private val context: Context,
) : StarWarsRepository {
    override suspend fun getPeople(listener: ResponseOnListener<Response<People>>) {
        listener.onResult(Response.Loading)
        val result = kotlin.runCatching { service.apiService(context).getPeoples() }

        if (result.isFailure) {
            result.exceptionOrNull()?.let {
                val errMsg = StarWarErrorExtractor.extractErrorMessage(it)
                listener.onResult(Response.Error(errMsg))
            }
        }
        listener.onResult(Response.Success(result.getOrNull() ?: People()))
    }

    override suspend fun getPlanets(listener: ResponseOnListener<Response<Planet>>) {
        listener.onResult(Response.Loading)
        val result = kotlin.runCatching { service.apiService(context).getPlanets() }

        if (result.isFailure) {
            result.exceptionOrNull()?.let {
                val errMsg = StarWarErrorExtractor.extractErrorMessage(it)
                listener.onResult(Response.Error(errMsg))
            }
        }
        listener.onResult(Response.Success(result.getOrNull() ?: Planet()))
    }

    override suspend fun getFilms(listener: ResponseOnListener<Response<Film>>) {
        listener.onResult(Response.Loading)
        val result = kotlin.runCatching { service.apiService(context).getFilms() }

        if (result.isFailure) {
            result.exceptionOrNull()?.let {
                val errMsg = StarWarErrorExtractor.extractErrorMessage(it)
                listener.onResult(Response.Error(errMsg))
            }
        }
        listener.onResult(Response.Success(result.getOrNull() ?: Film()))
    }
}
