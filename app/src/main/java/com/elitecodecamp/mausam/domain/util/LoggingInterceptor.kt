package com.elitecodecamp.mausam.domain.util

import okhttp3.Interceptor
import okhttp3.Response

class LoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.toString()
        println("URL Request: $url")
        return chain.proceed(request)
    }

}