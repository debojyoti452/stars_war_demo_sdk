package com.example.lib.src.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * [SuspendUseCase] Abstract Suspend Base Class where we are calling api service
 * async using Dispatchers from Kotlin Coroutines.
 */
abstract class SuspendUseCase<in Callback> {
    suspend operator fun invoke(callBack: Callback? = null){
        return withContext(Dispatchers.IO) {
            execute(callBack)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(callBack: Callback?)
}

