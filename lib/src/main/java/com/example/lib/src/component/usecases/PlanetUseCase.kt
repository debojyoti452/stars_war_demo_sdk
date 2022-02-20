package com.example.lib.src.component.usecases

import android.content.Context
import com.example.lib.src.component.base.ResponseOnListener
import com.example.lib.src.remote.impl.StarWarsApiImpl
import com.example.lib.src.remote.model.Planet
import com.example.lib.src.utils.Response
import com.example.lib.src.utils.SuspendUseCase

internal class PlanetUseCase constructor(
    private val context: Context
) : SuspendUseCase<ResponseOnListener<Response<Planet>>>() {
    override suspend fun execute(callBack: ResponseOnListener<Response<Planet>>?) {
        if (callBack != null) {
            StarWarsApiImpl(
                context = context
            ).getPlanets(callBack)
        }

    }
}
