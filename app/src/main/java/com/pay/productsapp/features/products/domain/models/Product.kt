package com.pay.productsapp.features.products.domain.models

data class Product(
    val id: Int?,
    val title: String?,
    val description: String?,
    val image: String?,
    val category: String?,
    val price: Double?
)