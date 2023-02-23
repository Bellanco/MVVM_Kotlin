package com.deromang.rick.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiGenerator {

    private const val TIMEOUT: Long = 30

    private const val BASE_URL: String = " https://rickandmortyapi.com/"

    fun createService(): ApiService =
        createService(BASE_URL)

    private fun createService(url: String): ApiService =
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                    .build()
            )
            .build()
            .create(ApiService::class.java)

}
