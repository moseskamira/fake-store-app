package com.pay.productsapp.features.products.data.repositories

import com.pay.productsapp.core.network.retrofit.ApiClient
import com.pay.productsapp.features.products.data.models.Product
import com.pay.productsapp.features.products.domain.repositories.ProductRepository

class ProductRepositoryImpl(private  val apiClient: ApiClient) : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        return apiClient.fetchProducts()
    }

    override suspend fun getProductInfo(prodId: Int): Product {
        return apiClient.fetchProductInfo(prodId.toString())
    }
}