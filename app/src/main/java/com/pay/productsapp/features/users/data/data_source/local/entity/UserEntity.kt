package com.pay.productsapp.features.users.data.data_source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
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