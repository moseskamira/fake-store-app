package com.pay.store.features.users.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.pay.store.features.users.domain.models.User
import com.pay.store.features.users.domain.repositories.UserRepository
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class UserViewModel(private val userRepo: UserRepository) : ViewModel() {
    private var _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users


    fun getUsers() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            val localUsers = userRepo.getDBUsers().asFlow().firstOrNull()
            if (!localUsers.isNullOrEmpty()) {
                _users.value = localUsers
            } else {
                val response = userRepo.getUsers()
                if (response.success) {
                    val responseData = response.data
                    _users.value = responseData
                } else {
                    val errorMessage = response.error
                    _error.value = errorMessage;
                }
            }
            _isLoading.value = false
        }
    }
}