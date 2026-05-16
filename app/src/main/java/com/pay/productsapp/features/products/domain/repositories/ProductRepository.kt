package com.pay.productsapp.features.products.domain.repositories

import com.pay.productsapp.features.products.data.models.ProductDTO

interface ProductRepository {
    suspend fun getProducts(): List<ProductDTO>
    suspend fun getProductInfo(prodId: Int): ProductDTO
}