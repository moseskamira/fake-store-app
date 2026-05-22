package com.pay.productsapp.features.products.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.pay.productsapp.core.network.responses.NetworkResponse
import com.pay.productsapp.core.network.retrofit.ApiClient
import com.pay.productsapp.features.products.data.data_source.local.dao.ProductDao
import com.pay.productsapp.features.products.domain.models.Product
import com.pay.productsapp.features.products.domain.repositories.ProductRepository
import toDomain

class ProductRepositoryImpl(private val apiClient: ApiClient, private val prodDao: ProductDao) :
    ProductRepository {
    override suspend fun getProducts(): NetworkResponse<List<Product>> {
        try {
            val response = apiClient.fetchProducts(limit = "25", sort = "desc")
            if (response.isSuccessful) {
                val dtoList = response.body()
                val domainList = dtoList?.map { dtoItem ->
                    dtoItem.toDomain()
                }
                return NetworkResponse(data = domainList, success = true)
            } else {
                val error = response.errorBody()?.string()
                return NetworkResponse(success = false, error = error)
            }
        } catch (e: Exception) {
            val error = e.message
            return NetworkResponse(success = false, error = error)
        }
    }

    override suspend fun getDBProducts(): LiveData<List<Product>> {
        return prodDao.readProducts().map { entities ->
            entities.map { entity ->
                entity.toDomain()
            }
        }
    }

    override suspend fun getProductInfo(prodId: Int): NetworkResponse<Product> {
        try {
            val response = apiClient.fetchProduct(prodId.toString())
            if (response.isSuccessful) {
                val dto = response.body()
                val domain = dto?.toDomain()
                return NetworkResponse(success = true, data = domain)
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