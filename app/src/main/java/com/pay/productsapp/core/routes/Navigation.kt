package com.pay.productsapp.core.routes

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pay.productsapp.features.products.presentation.screens.ProductInfoScreen
import com.pay.productsapp.features.products.presentation.screens.ProductScreen

@Composable
fun Navigation() {
    val navController = rememberNavController();
    NavHost(navController = navController, startDestination = AppScreen.Products.route) {
        composable(route = AppScreen.Products.route) {
            ProductScreen(navController = navController);
        }
        composable(
            route = AppScreen.ProductDetails.route + "/{pId}",
            arguments = listOf(navArgument("pId") {
                type = NavType.IntType
                nullable = false

            })
        ) { entry ->
            ProductInfoScreen(prodId = entry.arguments?.getInt("pId") ?: 0, navController = navController)
        }

    }
}