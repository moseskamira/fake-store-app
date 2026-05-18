package com.pay.productsapp.features.auth.data.repositories

import com.pay.productsapp.core.network.retrofit.ApiClient
import com.pay.productsapp.core.network.retrofit.ApiService
import com.pay.productsapp.features.auth.data.models.LoginRequest
import com.pay.productsapp.features.auth.data.models.LoginResponse
import com.pay.productsapp.features.auth.domain.repositories.AuthRepository

class AuthRepositoryImpl : AuthRepository {
    private val apiClient: ApiClient = ApiService.apiClient
    override suspend fun login(request: LoginRequest): LoginResponse {
        return apiClient.login(request)
    }


}