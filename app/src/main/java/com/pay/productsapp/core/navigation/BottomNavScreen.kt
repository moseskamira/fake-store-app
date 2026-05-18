package com.pay.productsapp.core.navigation

sealed class BottomNavScreen(
    val route: String,
    val title: String
) {
    data object Home : BottomNavScreen("home", "Home")
    data object Products : BottomNavScreen("products", "Products")
    data object Profile : BottomNavScreen("profile", "Profile")
}