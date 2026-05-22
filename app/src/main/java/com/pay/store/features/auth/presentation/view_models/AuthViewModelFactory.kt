package com.pay.store.features.auth.presentation.view_models


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pay.store.core.utils.SessionManager
import com.pay.store.features.auth.domain.repositories.AuthRepository

class AuthViewModelFactory(
    private val authRepository: AuthRepository,
    private val sesionManager: SessionManager
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            return AuthViewModel(authRepo = authRepository, sessionManager = sesionManager) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}