package com.pay.productsapp.features.auth.domain.repositories

import com.pay.productsapp.core.network.responses.NetworkResponse
import com.pay.productsapp.features.auth.data.models.LoginRequest
import com.pay.productsapp.features.auth.data.models.LoginResponse

interface AuthRepository {
    suspend fun login(request: LoginRequest): NetworkResponse<LoginResponse>
}