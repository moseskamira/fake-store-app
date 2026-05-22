package com.pay.store.features.carts.data.models

data class CartDTO(
    val id: Long,
    val userId: Long,
    val date: String,
    val products: List<CartProductDTO>
)
