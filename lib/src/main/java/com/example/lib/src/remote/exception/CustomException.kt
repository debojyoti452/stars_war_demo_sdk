package com.example.lib.src.remote.exception

class CustomException(override val message: String, val throwable: Throwable? = null) : Exception(message)
