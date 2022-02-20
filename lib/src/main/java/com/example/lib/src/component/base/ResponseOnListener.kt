package com.example.lib.src.component.base

interface ResponseOnListener<T : Any> {
    fun onResult(result: T)
}
