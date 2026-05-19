package com.pay.productsapp.core.navigation

sealed class AppShellNavScreen(
    val route: String,
    val title: String
) {
    data object Home : AppShellNavScreen("home", "Home")
    data object Products : AppShellNavScreen("products", "Products")
    data object Profile : AppShellNavScreen("profile", "Profile")
}