package com.pay.productsapp.features.users.data.repositories

import com.pay.productsapp.core.network.responses.NetworkResponse
import com.pay.productsapp.core.network.retrofit.ApiService
import com.pay.productsapp.features.users.data.models.UserDTO
import com.pay.productsapp.features.users.domain.repositories.UserRepository

class UserRepositoryImpl : UserRepository {
    private val apiClient = ApiService.apiClient
    override suspend fun getUsers(): NetworkResponse<List<UserDTO>> {
        try {
            val response = apiClient.getUsers()
            if (response.isSuccessful) {
                val data = response.body()
                return NetworkResponse(success = true, data = data)
            } else {
                val error = response.errorBody()?.string()
                return NetworkResponse(success = false, error = error)
            }
        } catch (e: Exception) {
            return NetworkResponse(success = false, error = e.message)
        }

    }
}