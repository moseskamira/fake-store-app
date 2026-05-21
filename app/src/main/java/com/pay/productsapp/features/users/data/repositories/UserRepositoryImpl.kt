package com.pay.productsapp.features.users.data.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.pay.productsapp.core.network.responses.NetworkResponse
import com.pay.productsapp.core.network.retrofit.ApiClient
import com.pay.productsapp.features.users.data.data_source.local.database.AppDatabase
import com.pay.productsapp.features.users.data.mappers.toDomain
import com.pay.productsapp.features.users.data.mappers.toEntity
import com.pay.productsapp.features.users.domain.models.User
import com.pay.productsapp.features.users.domain.repositories.UserRepository

class UserRepositoryImpl(private val apiClient: ApiClient, private val context: Context) :
    UserRepository {
    private val userDao = AppDatabase.getDatabase(context).userDao()

    override suspend fun getUsers(): NetworkResponse<List<User>> {
        try {
            val response = apiClient.getUsers()
            if (response.isSuccessful) {
                val dtoList = response.body()
                dtoList?.map { entity-> userDao.addUser(entity.toEntity())
                }
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

    override suspend fun getDBUsers(): LiveData<List<User>> {
        return userDao.readUsers().map { entities ->
            entities.map { entity ->
                entity.toDomain()
            }

        }

    }
}