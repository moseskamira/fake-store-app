package com.pay.productsapp.features.auth.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pay.productsapp.core.navigation.AppScreen
import com.pay.productsapp.core.navigation.AppShellNavigation
import com.pay.productsapp.core.navigation.BottomNavScreen
import com.pay.productsapp.features.products.presentation.view_models.ProductViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppShellScreen(
    productViewModel: ProductViewModel,
    rootNavController: NavController
) {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavScreen.Home,
        BottomNavScreen.Products,
        BottomNavScreen.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val currentTitle = items.find { it.route == currentRoute }?.title ?: "App"

    Scaffold(modifier = Modifier.fillMaxWidth(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = currentTitle)
                }
            )
        },

        bottomBar = {
            NavigationBar {
                items.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = when (item.route) {
                                    "home" -> Icons.Default.Home
                                    "products" -> Icons.Default.Menu
                                    else -> Icons.Default.Person
                                },
                                contentDescription = item.title
                            )
                        },
                        label = {
                            Text(text = item.title)
                        }
                    )
                }
            }
        }

    ) {
        AppShellNavigation(
            rootNavController = rootNavController,
            productViewModel = productViewModel,
            navController = navController
        )
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Home Screen",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Welcome to Products App"
        )
    }
}

@Composable
fun ProfileScreen(rootNavController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Profile Screen",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "User Profile Information"
        )

        Button(
            onClick = {
                rootNavController.navigate(AppScreen.Login)

            }
        ) {

            Text(text = "Logout")
        }
    }
}
