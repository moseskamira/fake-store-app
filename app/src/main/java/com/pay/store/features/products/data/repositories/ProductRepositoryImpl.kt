package com.pay.store.features.products.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.pay.store.core.network.responses.NetworkResponse
import com.pay.store.core.network.retrofit.ApiClient
import com.pay.store.features.products.data.data_source.local.dao.ProductDao
import com.pay.store.features.products.domain.models.Product
import com.pay.store.features.products.domain.repositories.ProductRepository
import toDomain
import toEntity

class ProductRepositoryImpl(private val apiClient: ApiClient, private val prodDao: ProductDao) :
    ProductRepository {
    override suspend fun getProducts(): NetworkResponse<List<Product>> {
        try {
            val response = apiClient.fetchProducts(limit = "25", sort = "desc")
            if (response.isSuccessful) {
                val dtoList = response.body()
                dtoList?.map { dto ->
                    prodDao.addProduct(dto.toEntity())
                }
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

    override suspend fun getCategories(): NetworkResponse<List<String>> {
        try {
            val response = apiClient.getCategories()
            if (response.isSuccessful) {
                val responseData = response.body()
                return NetworkResponse(data = responseData, success = true)
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