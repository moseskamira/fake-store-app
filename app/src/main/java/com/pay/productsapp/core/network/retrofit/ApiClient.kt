package com.pay.productsapp.core.network.retrofit

import com.pay.productsapp.features.products.data.models.Product
import okhttp3.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET(value = "products")
    suspend fun fetchProducts(): List<Product>

    @GET(value = "products/{id}")
    suspend fun fetchProductInfo(@Path("id") prodId: String): Product
}