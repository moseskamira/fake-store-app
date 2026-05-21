package com.pay.productsapp.features.products.domain.repositories

import androidx.lifecycle.LiveData
import com.pay.productsapp.core.network.responses.NetworkResponse
import com.pay.productsapp.features.products.domain.models.Product

interface ProductRepository {
    suspend fun getProducts(): NetworkResponse<List<Product>>
    suspend fun getDBProducts(): LiveData<List<Product>>
    suspend fun getProductInfo(prodId: Int): NetworkResponse<Product>
}