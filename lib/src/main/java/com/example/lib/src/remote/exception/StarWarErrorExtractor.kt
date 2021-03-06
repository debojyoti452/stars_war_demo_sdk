package com.example.lib.src.remote.exception

import com.google.gson.JsonSyntaxException
import com.example.lib.src.utils.StarWarConstant.CONNECT_EXCEPTION
import com.example.lib.src.utils.StarWarConstant.PROTOCOL_EXCEPTION
import com.example.lib.src.utils.StarWarConstant.SOCKET_TIME_OUT_EXCEPTION
import com.example.lib.src.utils.StarWarConstant.UNKNOWN_NETWORK_EXCEPTION
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import timber.log.Timber
import java.net.*

/**
 * [StarWarErrorExtractor] is global interpreter to extract error messages during
 * failed network calls.
 */
object StarWarErrorExtractor {
    fun extractErrorMessage(throwable: Throwable): String {
        return when (throwable) {
            is ConnectException -> CONNECT_EXCEPTION
            is UnknownHostException -> {
                CONNECT_EXCEPTION
            }
            is SocketTimeoutException -> SOCKET_TIME_OUT_EXCEPTION
            is UnknownServiceException -> throwable.localizedMessage
                ?: UNKNOWN_NETWORK_EXCEPTION
            is ProtocolException -> PROTOCOL_EXCEPTION
            is HttpException -> {
                val response = throwable.response()
                try {
                    Timber.d(response?.body().toString())
                    return "Something went really bad."
                } catch (exception: JSONException) {
                    exception.localizedMessage
                }
            }
            is JsonSyntaxException -> throwable.message ?: ""
            else -> UNKNOWN_NETWORK_EXCEPTION
        }
    }
}
