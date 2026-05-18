package com.pay.productsapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pay.productsapp.features.auth.presentation.screens.HomeScreen
import com.pay.productsapp.features.auth.presentation.screens.ProfileScreen
import com.pay.productsapp.features.products.presentation.screens.ProductScreen
import com.pay.productsapp.features.products.presentation.view_models.ProductViewModel

@Composable
fun AppShellNavigation(
    modifier: Modifier = Modifier,
    rootNavController: NavController,
    productViewModel: ProductViewModel,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavScreen.Home.route,
        modifier = modifier
    ) {
        composable(BottomNavScreen.Home.route) {
            HomeScreen()
        }
        composable(BottomNavScreen.Products.route) {
            ProductScreen(
                productViewModel = productViewModel,
                navController = rootNavController
            )
        }
        composable(BottomNavScreen.Profile.route) {
            ProfileScreen(rootNavController)
        }
    }
}