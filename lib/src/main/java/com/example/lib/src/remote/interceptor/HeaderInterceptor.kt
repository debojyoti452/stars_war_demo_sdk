package com.example.lib.src.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * It can be used for attaching Token or API key as header
 */
internal class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request()
                .newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .build()
        )
    }
}
