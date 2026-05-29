package com.pay.store.core.network.retrofit

import com.pay.productsapp.features.products.data.models.ProductDto
import com.pay.store.features.auth.data.models.LoginRequest
import com.pay.store.features.auth.data.models.LoginResponse
import com.pay.store.features.carts.data.models.CartDTO
import com.pay.store.features.users.data.models.UserDto
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
    suspend fun getUsers(): Response<List<UserDto>>

    @GET(value = Apis.PRODUCTS)
    suspend fun fetchProducts(
        @Query("limit") limit: String,
        @Query("sort") sort: String
    ): Response<List<ProductDto>>

    @GET(value = Apis.PRODUCT_INFO)
    suspend fun fetchProduct(@Path("id") prodId: String): Response<ProductDto>

    @GET(Apis.CATEGORIES)
    suspend fun getCategories(): Response<List<String>>

    @GET(Apis.CATEGORY_PRODUCTS)
    suspend fun getProductsByCategory(
        @Path("category") category: String
    ): List<ProductDto>


    @GET(Apis.CARTS)
    suspend fun getCarts(): List<CartDTO>

    @GET(Apis.CART_INFO)
    suspend fun getSingleCart(@Path("id") cartId: String): CartDTO


}