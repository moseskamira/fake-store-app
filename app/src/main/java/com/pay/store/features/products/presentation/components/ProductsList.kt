package com.pay.store.features.products.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.pay.store.core.navigation.AppScreen
import com.pay.store.features.products.domain.models.Product

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