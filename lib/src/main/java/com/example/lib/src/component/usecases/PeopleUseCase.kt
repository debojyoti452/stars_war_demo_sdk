package com.example.lib.src.component.usecases

import android.content.Context
import com.example.lib.src.component.base.ResponseOnListener
import com.example.lib.src.remote.impl.StarWarsApiImpl
import com.example.lib.src.remote.model.People
import com.example.lib.src.utils.Response
import com.example.lib.src.utils.SuspendUseCase

class PeopleUseCase constructor(
    private val context: Context
) : SuspendUseCase<ResponseOnListener<Response<People>>>() {
    override suspend fun execute(callBack: ResponseOnListener<Response<People>>?) {
        if (callBack != null) {
            StarWarsApiImpl(
                context = context
            ).getPeople(callBack)
        }
    }
}
