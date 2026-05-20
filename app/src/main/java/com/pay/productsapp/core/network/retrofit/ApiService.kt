package com.pay.productsapp.core.network.retrofit

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService private constructor(context: Context) {

    companion object {
        @Volatile
        private var INSTANCE: ApiService? = null
        fun getInstance(context: Context): ApiService {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: ApiService(context.applicationContext).also {
                    INSTANCE = it
                }
            }
        }
    }

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(TokenInterceptor(context))
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(Apis.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiClient: ApiClient = retrofit.create(ApiClient::class.java)


}