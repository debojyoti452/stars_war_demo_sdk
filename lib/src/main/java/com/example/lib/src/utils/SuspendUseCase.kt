package com.example.lib.src.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class SuspendUseCase<in Callback> {
    suspend operator fun invoke(callBack: Callback? = null){
        return withContext(Dispatchers.IO) {
            execute(callBack)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(callBack: Callback?)
}

