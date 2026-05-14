package com.pay.productsapp.core.routes

sealed  class AppScreen(val route: String) {
    object Products : AppScreen("products")
    object ProductDetails : AppScreen("product_details")
}