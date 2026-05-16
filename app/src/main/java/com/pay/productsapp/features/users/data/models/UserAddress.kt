package com.pay.productsapp.features.users.data.models

data class UserAddress(
    val geolocation: Geolocation,
    val city: String,
    val street: String,
    val number: Long,
    val zipcode: String,
)