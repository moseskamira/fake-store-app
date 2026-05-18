package com.pay.productsapp.features.users.domain.repositories

import com.pay.productsapp.core.network.responses.NetworkResponse
import com.pay.productsapp.features.users.data.models.UserDTO

interface UserRepository {
    suspend fun getUsers(): NetworkResponse<List<UserDTO>>
}