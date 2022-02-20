package com.example.lib

import android.content.Context
import com.example.lib.src.component.base.ResponseOnListener
import com.example.lib.src.component.usecases.FilmUseCase
import com.example.lib.src.component.usecases.PeopleUseCase
import com.example.lib.src.component.usecases.PlanetUseCase
import com.example.lib.src.remote.model.Film
import com.example.lib.src.remote.model.People
import com.example.lib.src.remote.model.Planet
import com.example.lib.src.utils.Response
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import org.jetbrains.annotations.NotNull

/**
 * Main Class
 */
open class StarWars constructor() {

    private var appContext: Context? = null

    internal constructor(
        appContext: Context,
    ) : this() {
        this.appContext = appContext
    }

    /**
     * Builder Class
     */
    open class Builder {
        private lateinit var context: Context

        fun setContext(@NotNull context: Context): Builder {
            this.context = context
            return this
        }

        fun create(): StarWars {
            return StarWars(
                context
            )
        }
    }

    fun getPeople(onListener: ResponseOnListener<Response<People>>) {
        CoroutineScope(Main).launch {
            PeopleUseCase(
                appContext!!
            ).invoke(onListener)
        }
    }

    fun getPlanets(onListener: ResponseOnListener<Response<Planet>>) {
        CoroutineScope(Main).launch {
            PlanetUseCase(
                appContext!!
            ).invoke(onListener)
        }
    }

    fun getFilm(onListener: ResponseOnListener<Response<Film>>) {
        CoroutineScope(Main).launch {
            FilmUseCase(
                appContext!!
            ).invoke(onListener)
        }
    }
}
