package com.pay.productsapp.features.users.domain.repositories

import androidx.lifecycle.LiveData
import com.pay.productsapp.core.network.responses.NetworkResponse
import com.pay.productsapp.features.users.domain.models.User

interface UserRepository {
    suspend fun getUsers(): NetworkResponse<List<User>>
    suspend fun getDBUsers(): LiveData<List<User>>
}