package com.pay.productsapp.core.navigation

sealed  class AppScreen(val route: String) {
    data object Products : AppScreen("products")
    data object ProductDetails : AppScreen("product_details")
}