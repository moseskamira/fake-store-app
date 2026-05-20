package com.pay.productsapp.features.users.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pay.productsapp.features.auth.domain.repositories.AuthRepository
import com.pay.productsapp.features.auth.presentation.view_models.AuthViewModel
import com.pay.productsapp.features.users.domain.repositories.UserRepository


class UserViewModelFactory(
    private val userRepo: UserRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(userRepo) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}