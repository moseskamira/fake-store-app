package com.pay.productsapp.features.users.domain.models

data class User(
    val id: Long,
    val email: String,
    val username: String,
    val phone: String,
    val city: String,
    val street: String,
    val number: Long,
    val zipcode: String,
    val firstname: String,
    val lastname: String,
    val lat: String,
    val long: String,
)