package com.pay.productsapp.features.products.data.repositories

import com.pay.productsapp.core.network.retrofit.ApiClient
import com.pay.productsapp.features.products.data.models.ProductDTO
import com.pay.productsapp.features.products.domain.repositories.ProductRepository

class ProductRepositoryImpl(private  val apiClient: ApiClient) : ProductRepository {

    override suspend fun getProducts(): List<ProductDTO> {
        return apiClient.fetchProducts(limit = "25", sort = "desc")
    }

    override suspend fun getProductInfo(prodId: Int): ProductDTO {
        return apiClient.fetchProduct(prodId.toString())
    }
}