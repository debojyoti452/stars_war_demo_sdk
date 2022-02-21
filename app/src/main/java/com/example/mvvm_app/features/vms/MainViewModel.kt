package com.example.mvvm_app.features.vms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lib.StarWars
import com.example.lib.src.component.base.ResponseOnListener
import com.example.lib.src.remote.model.Film
import com.example.lib.src.remote.model.FilmData
import com.example.lib.src.remote.model.People
import com.example.lib.src.remote.model.Planet
import com.example.lib.src.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private var initiateStarWars: StarWars
) : ViewModel() {

    private val _peopleEyeData = MutableLiveData<List<String?>>()
    val peopleEyeData: LiveData<List<String?>> = _peopleEyeData

    private val _populationData = MutableLiveData<List<Pair<String?, String?>>>()
    val populationData: LiveData<List<Pair<String?, String?>>> = _populationData

    private val _filmData = MutableLiveData<List<FilmData>>()
    val filmData: LiveData<List<FilmData>> = _filmData

    private val _errorMessage = MutableLiveData<Pair<Boolean, String>>()
    val errorMessage: LiveData<Pair<Boolean, String>> = _errorMessage

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val peopleOnResponseListener = object : ResponseOnListener<Response<People>> {
        override fun onResult(result: Response<People>) {
            when (result) {
                is Response.Success -> {
                    _loading.postValue(false)
                    _peopleEyeData.postValue(result.data.getEyeColors())
                }

                is Response.Error -> {
                    _loading.postValue(false)
                    _errorMessage.postValue(Pair(true, result.exception.toString()))
                }

                is Response.Loading -> {
                    _loading.postValue(true)
                }
            }
        }
    }

    private val planetOnResponseListener = object : ResponseOnListener<Response<Planet>> {
        override fun onResult(result: Response<Planet>) {
            when (result) {
                is Response.Success -> {
                    _loading.postValue(false)
                    _populationData.postValue(result.data.getFiveClimateAndPopulation())
                }

                is Response.Error -> {
                    _loading.postValue(false)
                    _errorMessage.postValue(Pair(true, result.exception.toString()))
                }

                is Response.Loading -> {
                    _loading.postValue(true)
                }
            }
        }
    }

    private val filmOnResponseListener = object : ResponseOnListener<Response<Film>> {
        override fun onResult(result: Response<Film>) {
            when (result) {
                is Response.Success -> {
                    _filmData.postValue(result.data.dataList)
                    _loading.postValue(false)
                }

                is Response.Error -> {
                    _loading.postValue(false)
                    _errorMessage.postValue(Pair(true, result.exception.toString()))
                }

                is Response.Loading -> {
                    _loading.postValue(true)
                }
            }
        }
    }


    fun getPlanetData() {
        viewModelScope.launch {
            initiateStarWars.getPlanets(onListener = planetOnResponseListener)
        }
    }

    fun getPeopleData() {
        viewModelScope.launch {
            initiateStarWars.getPeople(onListener = peopleOnResponseListener)
        }
    }


    fun getFilmData() {
        viewModelScope.launch {
            initiateStarWars.getFilm(onListener = filmOnResponseListener)
        }
    }

}
