package com.pay.productsapp.features.users.data.repositories

import com.pay.productsapp.core.network.responses.NetworkResponse
import com.pay.productsapp.core.network.retrofit.ApiClient
import com.pay.productsapp.features.users.data.mappers.toDomain
import com.pay.productsapp.features.users.domain.models.User
import com.pay.productsapp.features.users.domain.repositories.UserRepository

class UserRepositoryImpl(private val apiClient: ApiClient) : UserRepository {

    override suspend fun getUsers(): NetworkResponse<List<User>> {
        try {
            val response = apiClient.getUsers()
            if (response.isSuccessful) {
                val dtoList = response.body()
                val domainList = dtoList?.map { it.toDomain() } ?: emptyList()
                return NetworkResponse(success = true, data = domainList)
            } else {
                val error = response.errorBody()?.string()
                return NetworkResponse(success = false, error = error)
            }
        } catch (e: Exception) {
            return NetworkResponse(success = false, error = e.message)
        }

    }
}