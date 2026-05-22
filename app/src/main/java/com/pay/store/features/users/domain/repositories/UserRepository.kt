package com.pay.store.features.users.domain.repositories

import androidx.lifecycle.LiveData
import com.pay.store.core.network.responses.NetworkResponse
import com.pay.store.features.users.domain.models.User

interface UserRepository {
    suspend fun getUsers(): NetworkResponse<List<User>>
    suspend fun getDBUsers(): LiveData<List<User>>
}