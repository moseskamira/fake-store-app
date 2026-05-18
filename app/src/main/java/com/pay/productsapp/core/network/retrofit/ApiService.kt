package com.pay.productsapp.core.network.retrofit

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService private constructor() {
    companion object {
        private val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        private val okHttpClient = okhttp3.OkHttpClient.Builder()
            .addInterceptor(TokenInterceptor()).addInterceptor(loggingInterceptor)
            .build()
        private val appRetrofit: Retrofit =
            Retrofit.Builder().baseUrl(Apis.BASE_URL).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create()).build()
        val apiClient: ApiClient = appRetrofit.create(ApiClient::class.java)
    }


}