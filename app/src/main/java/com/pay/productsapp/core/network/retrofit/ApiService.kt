package com.pay.productsapp.core.network.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService private constructor() {
    companion object {
        private val appRetrofit: Retrofit =
            Retrofit.Builder().baseUrl(Apis.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        val apiClient: ApiClient = appRetrofit.create(ApiClient::class.java)
    }


}