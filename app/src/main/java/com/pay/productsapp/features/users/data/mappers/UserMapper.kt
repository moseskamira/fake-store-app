package com.pay.productsapp.features.users.data.mappers

import com.pay.productsapp.features.users.data.models.UserDto
import com.pay.productsapp.features.users.domain.models.User

// DTO → Domain
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


//fun UserDTO.toEntity(): UserEntity {
//    return UserEntity(
//        id = id,
//        email = email,
//        username = username,
//        phone = phone,
//        password = TODO(),
//        firstName = TODO(),
//        lastName = TODO(),
//        city = TODO(),
//        street = TODO(),
//        number = TODO(),
//        zipcode = TODO(),
//    )
//}
//
//
//fun UserEntity.toDomain(): User {
//    return User(
//        address = address,
//        email = email,
//        username = username,
//        name = name,
//        phone = phone
//    )
//}