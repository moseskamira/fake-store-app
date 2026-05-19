package com.pay.productsapp.features.products.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pay.productsapp.core.network.retrofit.ApiService
import com.pay.productsapp.features.products.data.models.ProductDTO
import com.pay.productsapp.features.products.data.repositories.ProductRepositoryImpl
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val apiClient = ApiService.apiClient;
    private val productRepository = ProductRepositoryImpl(apiClient)
    private val _products = MutableLiveData<List<ProductDTO>>()
    val products: LiveData<List<ProductDTO>> = _products

    private val _product = MutableLiveData<ProductDTO>()
    val product: LiveData<ProductDTO> = _product
    private val productCache = mutableMapOf<Int, ProductDTO>()


    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading
    private val _error = MutableLiveData("")
    val error: LiveData<String> = _error
    private val _pInfoError = MutableLiveData("")
    val pInfoError: LiveData<String> = _pInfoError
    private val _isLoadingPInfo = MutableLiveData(false)
    val isLoadingPInfo: LiveData<Boolean> = _isLoadingPInfo

    init {
        loadProducts()
    }

    private fun loadProducts() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            val result = productRepository.getProducts()
            if (result.success) {
                val data = result.data
                _products.value = data
            } else {
                val errorMsg = result.error
                _error.value = errorMsg
            }
            _isLoading.value = false
        }
    }

    fun fetchProductInfo(
        pId: Int,
        forceRefresh: Boolean = false
    ) {
        val cachedProduct = productCache[pId]
        if (!forceRefresh && cachedProduct != null) {
            _product.value = cachedProduct
            return
        }
        viewModelScope.launch {
            _isLoadingPInfo.value = true
            _pInfoError.value = null
            val result = productRepository.getProductInfo(pId)
            if (result.success) {
                result.data?.let { data ->
                    productCache[pId] = data
                    _product.value = data
                }
            } else {
                val error = result.error
                _pInfoError.value = error
            }

            _isLoadingPInfo.value = false


        }
    }


}