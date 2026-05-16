package com.pay.productsapp.features.products.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.pay.productsapp.core.routes.AppScreen
import com.pay.productsapp.features.products.presentation.ProductViewModel
import com.pay.productsapp.features.products.presentation.components.ProductItemCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(productViewModel: ProductViewModel, navController: NavController) {
    val products by productViewModel.products.observeAsState(emptyList())
    val isLoading by productViewModel.isLoading.observeAsState(false)
    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Products",textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()) },
        )
    }) { padding ->
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
                        ProductItemCard(product, onClick = { prodId ->
                            navController.navigate("${AppScreen.ProductDetails.route}/$prodId")
                        })
                    }
                }
            }
        }
    }
}