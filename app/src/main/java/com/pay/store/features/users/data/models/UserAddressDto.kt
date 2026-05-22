package com.pay.store.features.users.data.models

data class UserAddressDto(
    val geolocation: GeoLocationDto,
    val city: String,
    val street: String,
    val number: Long,
    val zipcode: String,
)