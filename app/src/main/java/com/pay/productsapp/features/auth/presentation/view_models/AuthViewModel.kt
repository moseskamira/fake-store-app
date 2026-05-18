package com.pay.productsapp.features.auth.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pay.productsapp.core.network.retrofit.AuthState
import com.pay.productsapp.features.auth.data.models.LoginRequest
import com.pay.productsapp.features.auth.data.models.LoginResponse
import com.pay.productsapp.features.auth.data.repositories.AuthRepositoryImpl
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val authRepo = AuthRepositoryImpl()
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading
    private val _loginResponse = MutableLiveData<LoginResponse>()
    val loginResponse: LiveData<LoginResponse> = _loginResponse

    fun login(request: LoginRequest) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val response = authRepo.login(request)
                _loginResponse.value = response
                val token = _loginResponse.value?.token
                token?.let {
                    AuthState.token.value = token
                }
            } catch (e: Exception) {
                // Handle Exception
            } finally {
                _isLoading.value = false
            }
        }
    }
}