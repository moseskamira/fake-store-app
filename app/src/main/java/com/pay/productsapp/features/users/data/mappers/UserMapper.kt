package com.pay.productsapp.features.users.data.mappers

import com.pay.productsapp.features.users.data.data_source.local.entities.UserEntity
import com.pay.productsapp.features.users.data.models.UserDto
import com.pay.productsapp.features.users.domain.models.User


fun UserDto.toDomain(): User {
    return User(
        id = id,
        email = email,
        username = username,
        phone = phone,
        city = address.city,
        street = address.street,
        number = address.number,
        zipcode = address.zipcode,
        firstname = name.firstname,
        lastname = name.lastname,
        lat = address.geolocation.lat,
        long = address.geolocation.long,

        )
}


fun UserDto.toEntity(): UserEntity {
    return UserEntity(
        id = id,
        email = email,
        username = username,
        phone = phone,
        city = address.city,
        street = address.street,
        number = address.number,
        zipcode = address.zipcode,
        firstname = name.firstname,
        lastname = name.lastname,
        lat = address.geolocation.lat,
        long = address.geolocation.long,

        )
}

fun UserEntity.toDomain(): User {
    return User(
        id = id,
        email = email,
        username = username,
        phone = phone,
        city = city,
        street = street,
        number = number,
        zipcode = zipcode,
        firstname = firstname,
        lastname = lastname,
        lat = lat,
        long = long,
    )
}