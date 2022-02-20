package com.example.lib.src.utils

sealed class Response<out T : Any> {
    data class Success<out T : Any>(val data: T) : Response<T>()
    object Loading : Response<Nothing>()
    data class Error(val exception: String?) : Response<Nothing>()
}
