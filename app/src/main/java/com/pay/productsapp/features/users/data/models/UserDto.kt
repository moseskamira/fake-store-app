package com.pay.productsapp.features.users.data.models

data class UserDto(
    val address: UserAddressDto,
    val id: Long,
    val email: String,
    val username: String,
    val password: String,
    val name: UserNameDto,
    val phone: String,
)




