package com.pay.productsapp.features.users.presentation.view_models

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pay.productsapp.features.users.data.models.UserDTO
import com.pay.productsapp.features.users.data.repositories.UserRepositoryImpl
import com.pay.productsapp.features.users.domain.repositories.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private  val userRepo: UserRepository): ViewModel() {
    private var _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error
    private val _users = MutableLiveData<List<UserDTO>>()
    val users: LiveData<List<UserDTO>> = _users


    @SuppressLint("SuspiciousIndentation")
    fun getUsers(){
        if(_users.value.isNullOrEmpty())
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            val response = userRepo.getUsers()
            if(response.success){
               val  responseData = response.data
                _users.value = responseData
            }else{
                val errorMessage = response.error
                _error.value = errorMessage;
            }
            _isLoading.value = false
        }
    }
}