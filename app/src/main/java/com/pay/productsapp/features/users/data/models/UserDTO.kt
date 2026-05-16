package com.pay.productsapp.features.users.data.models

import com.google.gson.annotations.SerializedName

data class UserDTO(
    val address: UserAddress,
    val id: Long,
    val email: String,
    val username: String,
    val password: String,
    val name: UserName,
    val phone: String,
    @SerializedName("__v")
    val v: Long,
)

//UserDto      -> network/API layer
//UserEntity   -> database layer
//User         -> domain/UI/business layer



