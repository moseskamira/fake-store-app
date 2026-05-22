package com.pay.store.features.products.domain.repositories

import androidx.lifecycle.LiveData
import com.pay.store.core.network.responses.NetworkResponse
import com.pay.store.features.products.domain.models.Product

interface ProductRepository {
    suspend fun getProducts(): NetworkResponse<List<Product>>
    suspend fun getDBProducts(): LiveData<List<Product>>
    suspend fun getProductInfo(prodId: Int): NetworkResponse<Product>
}