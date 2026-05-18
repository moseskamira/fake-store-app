package com.pay.productsapp.features.auth.data.repositories

import com.pay.productsapp.core.network.responses.NetworkResponse
import com.pay.productsapp.core.network.retrofit.ApiClient
import com.pay.productsapp.core.network.retrofit.ApiService
import com.pay.productsapp.features.auth.data.models.LoginRequest
import com.pay.productsapp.features.auth.data.models.LoginResponse
import com.pay.productsapp.features.auth.domain.repositories.AuthRepository

class AuthRepositoryImpl : AuthRepository {
    private val apiClient: ApiClient = ApiService.apiClient
    override suspend fun login(request: LoginRequest): NetworkResponse<LoginResponse> {
        try {
            val response = apiClient.login(request)
            if (response.isSuccessful) {
                val data = response.body()
                return NetworkResponse(
                    data = data,
                    success = true
                )
            } else {
                val error = response.errorBody()?.string()
                return NetworkResponse(
                    error = error,
                    success = false
                )
            }
        } catch (e: Exception) {
            val error = e.message
            return NetworkResponse(
                error = error,
                success = false
            )
        }

    }


}