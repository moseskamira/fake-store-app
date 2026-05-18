package com.pay.productsapp.features.products.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.pay.productsapp.core.navigation.AppScreen
import com.pay.productsapp.features.products.presentation.components.ProductItemCard
import com.pay.productsapp.features.products.presentation.view_models.ProductViewModel

@Composable
fun ProductScreen(
    productViewModel: ProductViewModel,
    navController: NavController
) {
    val products by productViewModel.products.observeAsState(emptyList())
    val isLoading by productViewModel.isLoading.observeAsState(false)
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn {
                item {
                    Text(
                        text = "Products",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
                items(products) { product ->
                    ProductItemCard(
                        product = product,
                        onClick = { prodId ->
                            navController.navigate(
                                "${AppScreen.ProductDetails.route}/$prodId"
                            )
                        }
                    )
                }
            }
        }
    }
}