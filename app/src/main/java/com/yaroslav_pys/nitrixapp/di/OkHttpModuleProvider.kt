package com.yaroslav_pys.nitrixapp.di

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object OkHttpModuleProvider {
    private const val TIMEOUT = 50L

    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(getHttpLoggingInterceptor())
            connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            readTimeout(TIMEOUT, TimeUnit.SECONDS)
        }.build()
    }



    private fun getHttpLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }


    class JsonCleaningInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalResponse = chain.proceed(chain.request())
            val originalResponseBody = originalResponse.body
            if (originalResponseBody != null) {
                val responseBodyString = originalResponseBody.string()
                val cleanedResponseBodyString = cleanJsonResponse(responseBodyString)
                return originalResponse.newBuilder()
                    .body(okhttp3.ResponseBody.create(originalResponseBody.contentType(), cleanedResponseBodyString))
                    .build()
            }
            return originalResponse
        }

        private fun cleanJsonResponse(response: String): String {
            val jsonString = response
                .removePrefix("var mediaJSON = ")
                .removeSuffix(";")
                .trim()
            return jsonString
        }
    }
}