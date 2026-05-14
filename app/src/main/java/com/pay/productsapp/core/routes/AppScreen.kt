package com.pay.productsapp.core.routes

sealed  class AppScreen(val route: String) {
    data object Products : AppScreen("products")
    data object ProductDetails : AppScreen("product_details")
}