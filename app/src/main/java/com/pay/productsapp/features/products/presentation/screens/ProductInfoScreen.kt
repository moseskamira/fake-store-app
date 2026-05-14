package com.pay.productsapp.features.products.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ProductInfoScreen(prodId: Int) {

    Scaffold(
        topBar = {
            // Optional: you can add TopAppBar later
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
//
//            AsyncImage(
//                model = product.image,
//                contentDescription = product.title,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(250.dp)
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            Text(
//                text = product.title ?: "",
//                style = MaterialTheme.typography.titleLarge
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            Text(
//                text = product.description ?: "",
//                style = MaterialTheme.typography.bodyMedium
//            )
//
//            Spacer(modifier = Modifier.height(12.dp))
//
//            Text(
//                text = "$${product.price}",
//                style = MaterialTheme.typography.titleMedium,
//                color = MaterialTheme.colorScheme.primary
//            )
        }
    }
}