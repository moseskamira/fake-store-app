package com.pay.store.features.users.data.models

data class UserDto(
    val address: UserAddressDto,
    val id: Long,
    val email: String,
    val username: String,
    val password: String,
    val name: UserNameDto,
    val phone: String,
)




