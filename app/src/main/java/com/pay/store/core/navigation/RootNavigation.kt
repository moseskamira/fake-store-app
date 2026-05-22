package com.pay.store.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pay.store.core.database.AppDatabase
import com.pay.store.core.network.retrofit.ApiService
import com.pay.store.core.utils.SessionManager
import com.pay.store.features.auth.data.repositories.AuthRepositoryImpl
import com.pay.store.features.auth.presentation.screens.AppShellScreen
import com.pay.store.features.auth.presentation.screens.LoginScreen
import com.pay.store.features.auth.presentation.view_models.AuthViewModel
import com.pay.store.features.auth.presentation.view_models.AuthViewModelFactory
import com.pay.store.features.products.data.repositories.ProductRepositoryImpl
import com.pay.store.features.products.presentation.screens.ProductInfoScreen
import com.pay.store.features.products.presentation.view_models.ProductViewModel
import com.pay.store.features.products.presentation.view_models.ProductViewModelFactory
import com.pay.store.features.users.data.repositories.UserRepositoryImpl
import com.pay.store.features.users.presentation.view_models.UserViewModel
import com.pay.store.features.users.presentation.view_models.UserViewModelFactory

@Composable
fun RootNavigation() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val apiClient = ApiService.getInstance(context).apiClient
    val prodDao = AppDatabase.getDatabase(context).productDao()
    val authRepo = AuthRepositoryImpl(apiClient = apiClient)
    val userRepo = UserRepositoryImpl(apiClient = apiClient, context = context)
    val prodRepo = ProductRepositoryImpl(apiClient = apiClient, prodDao = prodDao)
    val sessionManager  = SessionManager(context)
    val isLoggedIn by sessionManager.isLoggedIn().collectAsState(null)
    if (isLoggedIn == null) {
        return
    }
    val authFactory =
        AuthViewModelFactory(authRepository = authRepo, sesionManager = sessionManager)
    val userFactory = UserViewModelFactory(userRepo)
    val prodFactory = ProductViewModelFactory(prodRepo)
    val authViewModel: AuthViewModel = viewModel(factory = authFactory)
    val userViewModel: UserViewModel = viewModel(factory = userFactory)
    val productViewModel: ProductViewModel = viewModel(factory = prodFactory)
    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn==true) {
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