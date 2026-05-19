package com.pay.productsapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pay.productsapp.core.network.retrofit.AuthState
import com.pay.productsapp.features.auth.presentation.screens.AppShellScreen
import com.pay.productsapp.features.auth.presentation.screens.LoginScreen
import com.pay.productsapp.features.auth.presentation.view_models.AuthViewModel
import com.pay.productsapp.features.products.presentation.screens.ProductInfoScreen
import com.pay.productsapp.features.products.presentation.view_models.ProductViewModel
import com.pay.productsapp.features.users.presentation.view_models.UserViewModel

@Composable
fun RootNavigation() {
    val navController = rememberNavController()
    val productViewModel: ProductViewModel = viewModel()
    val userViewModel: UserViewModel = viewModel()
    val authViewModel: AuthViewModel = viewModel()
    val token by AuthState.token.collectAsState()
    val isLoggedIn = !token.isNullOrEmpty()
    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) {
            AppScreen.AppShell.route
        } else AppScreen.Login.route
    ) {
        composable(route = AppScreen.Login.route) {
            LoginScreen(navController = navController, authViewModel = authViewModel)
        }
        composable(AppScreen.AppShell.route) {
            AppShellScreen(
                productViewModel = productViewModel,
                rootNavController = navController,
                userViewModel = userViewModel
            )
        }
        composable(
            route = AppScreen.ProductDetails.route + "/{pId}",
            arguments = listOf(
                navArgument("pId") {
                    type = NavType.IntType
                    nullable = false
                }
            )
        ) { entry ->
            ProductInfoScreen(
                productViewModel = productViewModel,
                prodId = entry.arguments?.getInt("pId") ?: 0,
                navController = navController
            )
        }
    }
}