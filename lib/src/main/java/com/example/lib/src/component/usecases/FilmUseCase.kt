package com.example.lib.src.component.usecases

import android.content.Context
import com.example.lib.src.component.base.ResponseOnListener
import com.example.lib.src.remote.impl.StarWarsApiImpl
import com.example.lib.src.remote.model.Film
import com.example.lib.src.utils.Response
import com.example.lib.src.utils.SuspendUseCase

internal class FilmUseCase constructor(
    private val context: Context
) : SuspendUseCase<ResponseOnListener<Response<Film>>>() {
    override suspend fun execute(callBack: ResponseOnListener<Response<Film>>?) {
        if (callBack != null) {
            StarWarsApiImpl(
                context = context
            ).getFilms(callBack)
        }
    }
}
