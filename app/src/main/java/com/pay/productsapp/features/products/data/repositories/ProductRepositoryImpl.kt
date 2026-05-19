package com.pay.productsapp.features.products.data.repositories

import com.pay.productsapp.core.network.responses.NetworkResponse
import com.pay.productsapp.core.network.retrofit.ApiClient
import com.pay.productsapp.features.products.data.models.ProductDTO
import com.pay.productsapp.features.products.domain.repositories.ProductRepository

class ProductRepositoryImpl(private val apiClient: ApiClient) : ProductRepository {

    override suspend fun getProducts(): NetworkResponse<List<ProductDTO>> {
        try {
            val response = apiClient.fetchProducts(limit = "25", sort = "desc")
            if (response.isSuccessful) {
                val data = response.body()
                return NetworkResponse(data = data, success = true)
            } else {
                val error = response.errorBody()?.string()
                return NetworkResponse(success = false, error = error)
            }
        } catch (e: Exception) {
            val error = e.message
            return NetworkResponse(success = false, error = error)
        }
    }

    override suspend fun getProductInfo(prodId: Int): NetworkResponse<ProductDTO> {
        try {
            val response = apiClient.fetchProduct(prodId.toString())
            if (response.isSuccessful) {
                val data = response.body()
                return NetworkResponse(success = true, data = data)
            } else {
                val error = response.errorBody()?.string()
                return NetworkResponse(success = false, error = error)
            }
        } catch (e: Exception) {
            val error = e.message
            return NetworkResponse(success = false, error = error)

        }

    }
}