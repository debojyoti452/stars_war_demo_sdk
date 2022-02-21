package com.example.lib.src.remote.api

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.example.lib.BuildConfig
import com.example.lib.src.remote.interceptor.HeaderInterceptor
import com.example.lib.src.remote.interceptor.NetworkInterceptor
import com.example.lib.src.remote.service.StarWarsApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val CONNECTION_TIMEOUT = 30L
private const val READ_WRITE_TIMEOUT = 60L

internal class NetworkModule {

    private fun okHttpClient(context: Context): OkHttpClient.Builder {
        val builder = OkHttpClient.Builder()
            .addInterceptor(NetworkInterceptor(context = context))
            .addInterceptor(HeaderInterceptor())
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_WRITE_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(READ_WRITE_TIMEOUT, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(logging)
        }

        return builder
    }

    private fun createRetrofitService(context: Context): Retrofit {
        return Retrofit.Builder()
//            .baseUrl(BuildConfig.STARWARS_BASE_URL)
            .baseUrl("https://swapi.dev/api/")
            .client(okHttpClient(context = context).build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    fun apiService(context: Context): StarWarsApiService {
        return createRetrofitService(context = context)
            .create(StarWarsApiService::class.java)
    }
}
