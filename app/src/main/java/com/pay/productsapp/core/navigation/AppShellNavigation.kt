package com.pay.productsapp.core.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pay.productsapp.features.auth.presentation.screens.ProfileScreen
import com.pay.productsapp.features.products.presentation.screens.ProductsScreen
import com.pay.productsapp.features.products.presentation.view_models.ProductViewModel
import com.pay.productsapp.features.users.presentation.screens.HomeScreen
import com.pay.productsapp.features.users.presentation.view_models.UserViewModel

@Composable
fun AppShellNavigation(
    modifier: Modifier = Modifier,
    rootNavController: NavController,
    productViewModel: ProductViewModel,
    navController: NavHostController,
    userViewModel: UserViewModel,  snackBarHostState: SnackbarHostState
) {
    NavHost(
        navController = navController,
        startDestination = AppShellNavScreen.Home.route,
        modifier = modifier
    ) {
        composable(AppShellNavScreen.Home.route) {
            HomeScreen(viewModel = userViewModel, snackBarHostState= snackBarHostState)
        }
        composable(AppShellNavScreen.Products.route) {
            ProductsScreen(
                productViewModel = productViewModel,
                navController = rootNavController
            )
        }
        composable(AppShellNavScreen.Profile.route) {
            ProfileScreen(rootNavController)
        }
    }
}