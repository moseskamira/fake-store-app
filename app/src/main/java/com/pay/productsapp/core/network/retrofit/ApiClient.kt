package com.pay.productsapp.core.network.retrofit

import com.pay.productsapp.features.auth.data.models.LoginRequest
import com.pay.productsapp.features.auth.data.models.LoginResponse
import com.pay.productsapp.features.carts.data.models.CartDTO
import com.pay.productsapp.features.products.data.models.ProductDTO
import com.pay.productsapp.features.users.data.models.UserDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {
    @POST(Apis.LOGIN)
    suspend fun login(
        @Body request: LoginRequest
    ): Response<LoginResponse>

    @GET(Apis.USERS)
    suspend fun getUsers(): Response<List<UserDTO>>

    @GET(value = Apis.PRODUCTS)
    suspend fun fetchProducts(
        @Query("limit") limit: String,
        @Query("sort") sort: String
    ): Response<List<ProductDTO>>

    @GET(value = Apis.PRODUCT_INFO)
    suspend fun fetchProduct(@Path("id") prodId: String): Response<ProductDTO>

    @GET(Apis.CATEGORIES)
    suspend fun getCategories(): List<String>

    @GET(Apis.CATEGORY_PRODUCTS)
    suspend fun getProductsByCategory(
        @Path("category") category: String
    ): List<ProductDTO>


    @GET(Apis.CARTS)
    suspend fun getCarts(): List<CartDTO>

    @GET(Apis.CART_INFO)
    suspend fun getSingleCart(@Path("id") cartId: String): CartDTO


}