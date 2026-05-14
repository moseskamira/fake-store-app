package com.pay.productsapp.features.products.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pay.productsapp.core.network.retrofit.ApiService
import com.pay.productsapp.features.products.data.models.Product
import com.pay.productsapp.features.products.data.repositories.ProductRepositoryImpl
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val apiClient = ApiService.apiClient;
    private val productRepository = ProductRepositoryImpl(apiClient)
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product> = _product


    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading
    private val _isLoadingPInfo = MutableLiveData(false)
    val isLoadingPInfo: LiveData<Boolean> = _isLoadingPInfo
    fun loadProducts() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val result = productRepository.getProducts()
                _products.value = result
            } catch (e: Exception) {
                // handle error
            }finally {
                _isLoading.value = false
            }
        }
    }

    fun fetchProductInfo(pId: Int) {
        viewModelScope.launch {
            try {
                _isLoadingPInfo.value = true
                val result = productRepository.getProductInfo(pId)
                _product.value = result
            } catch (e: Exception) {
                // handle error
            }finally {
                _isLoadingPInfo.value = false
            }
        }
    }


}