package com.pay.productsapp.features.products.domain.repositories

import com.pay.productsapp.features.products.data.models.Product

interface ProductRepository {
    suspend fun getProducts(): List<Product>
    suspend fun getProductInfo(prodId: Int): Product
}