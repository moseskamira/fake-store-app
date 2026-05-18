package com.pay.productsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pay.productsapp.core.navigation.RootNavigation
import com.pay.productsapp.core.themes.ProductsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProductsAppTheme {
                RootNavigation()
            }
        }
    }
}