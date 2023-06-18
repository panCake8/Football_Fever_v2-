package com.pancake.footballfever.data.remote.interceptor

import com.pancake.footballfever.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
            .addHeader(API_HEADER_KEY, BuildConfig.API_KEY)
            .addHeader(API_HEADER_HOST, BuildConfig.API_HOST)
        return chain.proceed(builder.build())
    }

    companion object {
        private const val API_HEADER_KEY = "X-RapidAPI-Key"
        private const val API_HEADER_HOST = "X-RapidAPI-Host"
    }
}