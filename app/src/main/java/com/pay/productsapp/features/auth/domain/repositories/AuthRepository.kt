package com.pay.productsapp.features.auth.domain.repositories

import com.pay.productsapp.features.auth.data.models.LoginRequest
import com.pay.productsapp.features.auth.data.models.LoginResponse

interface AuthRepository {
    suspend fun login(request: LoginRequest): LoginResponse


}