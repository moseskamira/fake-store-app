package com.pay.productsapp.features.users.data.data_source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val email: String,
    val username: String,
    val password: String,
    val phone: String,

    // flatten name
    val firstName: String,
    val lastName: String,

    // flatten address
    val city: String,
    val street: String,
    val number: Long,
    val zipcode: String
)