package com.pradeep.mvpImplementation.retrofit

import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Retrofit

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


object RetrofitHelper {
    private const val BASE_URL = "https://api.escuelajs.co/api/v1/"

    fun getInstance(): Retrofit {
        val client = OkHttpClient.Builder()
            .connectTimeout(2, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}