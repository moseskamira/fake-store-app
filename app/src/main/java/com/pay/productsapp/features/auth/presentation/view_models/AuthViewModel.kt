package com.pay.productsapp.features.auth.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pay.productsapp.core.network.retrofit.AuthState
import com.pay.productsapp.features.auth.data.models.LoginRequest
import com.pay.productsapp.features.auth.data.models.LoginResponse
import com.pay.productsapp.features.auth.data.repositories.AuthRepositoryImpl
import com.pay.productsapp.features.auth.domain.repositories.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val authRepo: AuthRepository = AuthRepositoryImpl()
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error
    private val _loginResponse = MutableLiveData<LoginResponse?>()
    val loginResponse: LiveData<LoginResponse?> = _loginResponse
    fun login(request: LoginRequest) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            val result = authRepo.login(request)
            if (result.success) {
                val data = result.data
                _loginResponse.value = data
                data?.token?.let {
                    AuthState.token.value = it
                }
            } else {
                _error.value = result.error ?: "Login failed"
            }
            _isLoading.value = false
        }
    }
}