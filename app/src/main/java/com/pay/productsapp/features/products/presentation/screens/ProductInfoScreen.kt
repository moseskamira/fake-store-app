package com.pay.productsapp.features.products.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.pay.productsapp.features.products.data.models.Product
import com.pay.productsapp.features.products.presentation.ProductViewModel

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
                title = { Text("Product Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )


        },

    ) { padding ->

        if (isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {

            product?.let { p ->
                LazyColumn(
                    modifier = Modifier.padding(padding)
                ) {
                    item { ProductHeaderSection(p) }
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

@Composable
fun ProductHeaderSection(product: Product) {
    Column {

        AsyncImage(
            model = product.image,
            contentDescription = product.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )

        product.title?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun ProductInfoSection(product: Product) {
    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "Description",
            style = MaterialTheme.typography.titleMedium
        )

        product.description?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Price: $${product.price}",
            style = MaterialTheme.typography.titleLarge
        )
    }
}