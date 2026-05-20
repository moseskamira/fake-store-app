package com.pay.productsapp.features.products.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pay.productsapp.features.products.domain.repositories.ProductRepository


class ProductViewModelFactory(
    private val prodRepo: ProductRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(ProductViewModel::class.java)) {
            return ProductViewModel(prodRepo) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}