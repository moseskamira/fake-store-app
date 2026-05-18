package com.pay.productsapp.core.navigation

sealed class AppScreen(val route: String) {
    data object Login : AppScreen("login")
    data object AppShell : AppScreen("app-shell")
    data object ProductDetails : AppScreen("product_details")
}