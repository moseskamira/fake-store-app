package com.pay.productsapp.features.products.presentation.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.pay.productsapp.core.routes.AppScreen
import com.pay.productsapp.features.products.presentation.ProductViewModel
import com.pay.productsapp.features.products.presentation.components.ProductItemCard

@Composable
fun ProductScreen(productViewModel: ProductViewModel = viewModel(), navController: NavController) {
    val products by productViewModel.products.observeAsState(emptyList())
    val isLoading by productViewModel.isLoading.observeAsState(false)
    LaunchedEffect(Unit) {
        productViewModel.loadProducts()
    }
    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            if (isLoading) {
                Box(modifier = Modifier.align(Alignment.Center)) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            } else {
                LazyColumn {
                    items(products) { product ->
                        Box(
                            modifier = Modifier.clickable {
                                product.id?.let { pId ->
                                    navController.navigate("${AppScreen.ProductDetails.route}/$pId")
                                }
                            }
                        ) {
                            ProductItemCard(product, onClick = { })
                        }
                    }
                }
            }
        }
    }
}