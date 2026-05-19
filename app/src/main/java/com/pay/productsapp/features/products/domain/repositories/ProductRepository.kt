package com.pay.productsapp.features.products.domain.repositories

import com.pay.productsapp.core.network.responses.NetworkResponse
import com.pay.productsapp.features.products.data.models.ProductDTO

interface ProductRepository {
    suspend fun getProducts(): NetworkResponse<List<ProductDTO>>
    suspend fun getProductInfo(prodId: Int): NetworkResponse<ProductDTO>
}