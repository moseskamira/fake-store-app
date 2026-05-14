package com.pay.productsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pay.productsapp.features.products.presentation.ProductViewModel
import com.pay.productsapp.ui.theme.ProductsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProductsAppTheme {
                ProductScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProductsAppTheme {
        Greeting("Android")
    }
}

@Composable
fun ProductScreen(productViewModel: ProductViewModel = viewModel()) {
    val products by productViewModel.products.observeAsState(emptyList())
    LaunchedEffect(Unit) {
        productViewModel.loadProducts()
    }
    Scaffold { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(products) { product ->
                Text(text = product.title ?: "")
            }
        }
    }
}