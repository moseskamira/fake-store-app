package com.pay.productsapp.features.products.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.pay.productsapp.core.navigation.AppScreen
import com.pay.productsapp.features.products.data.models.ProductDto
import com.pay.productsapp.features.products.domain.models.Product

@Composable
fun ProductsList(products: List<Product>, navController: NavController) {
   LazyColumn {
        items(products.size) { index ->
            val prod = products[index]
            ProductItemCard(product= prod, onClick = {pId->
                navController.navigate(
                    "${AppScreen.ProductDetails.route}/$pId"
                )

            })

        }
    }
}