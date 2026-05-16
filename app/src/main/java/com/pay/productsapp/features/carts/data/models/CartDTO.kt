package com.pay.productsapp.features.carts.data.models

import com.pay.productsapp.features.products.data.models.ProductDTO

data class CartDTO(
    val id: Long,
    val userId: Long,
    val date: String,
    val products: List<ProductDTO>
)
