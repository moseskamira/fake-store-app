package com.pay.productsapp.core.network.retrofit

import com.pay.productsapp.features.auth.data.models.LoginRequest
import com.pay.productsapp.features.auth.data.models.LoginResponse
import com.pay.productsapp.features.carts.data.models.CartDTO
import com.pay.productsapp.features.products.data.models.ProductDTO
import com.pay.productsapp.features.users.data.models.UserDTO
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {

    @GET(value = "products")
    suspend fun fetchProducts(
        @Query("limit") limit: String,
        @Query("sort") sort: String
    ): List<ProductDTO>

    @GET(value = "products/{id}")
    suspend fun fetchProduct(@Path("id") prodId: String): ProductDTO

    @GET("products/categories")
    suspend fun getCategories(): List<String>

    @GET("products/category/{category}")
    suspend fun getProductsByCategory(
        @Path("category") category: String
    ): List<ProductDTO>

    @GET("users")
    suspend fun getUsers(): List<UserDTO>

    @GET("carts")
    suspend fun getCarts(): List<CartDTO>

    @GET("carts/{id}")
    suspend fun getSingleCart(@Path("id") cartId: String): CartDTO

    @POST("auth/login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse
}