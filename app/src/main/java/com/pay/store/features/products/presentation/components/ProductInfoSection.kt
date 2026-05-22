package com.pay.store.features.products.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pay.store.features.products.domain.models.Product

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
            style = MaterialTheme.typography.titleMedium
        )
    }
}