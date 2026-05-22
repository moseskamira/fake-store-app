package com.pay.store.features.auth.domain.repositories

import com.pay.store.core.network.responses.NetworkResponse
import com.pay.store.features.auth.data.models.LoginRequest
import com.pay.store.features.auth.data.models.LoginResponse

interface AuthRepository {
    suspend fun login(request: LoginRequest): NetworkResponse<LoginResponse>
}