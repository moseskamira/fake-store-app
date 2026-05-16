package com.pay.productsapp.features.products.presentation.screens

import ProductHeaderSection
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.pay.productsapp.features.products.presentation.view_models.ProductViewModel
import com.pay.productsapp.features.products.presentation.components.ProductInfoSection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductInfoScreen(
    productViewModel: ProductViewModel,
    prodId: Int, navController: NavController
) {
    val product by productViewModel.product.observeAsState()
    val isLoading by productViewModel.isLoadingPInfo.observeAsState(false)
    LaunchedEffect(prodId) {
        productViewModel.fetchProductInfo(prodId)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Product Details", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
            )
        },
    ) { padding ->
        if (isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = Color.Gray, modifier = Modifier.align(alignment = Alignment.Center))
            }
        } else {
            product?.let { p ->
                LazyColumn(
                    modifier = Modifier.padding(padding),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    item { p.image?.let { p.title?.let { it1 -> ProductHeaderSection(it, it1) } } }
                    item { ProductInfoSection(p) }
                }
            } ?: Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Product not found")
            }
        }
    }
}



