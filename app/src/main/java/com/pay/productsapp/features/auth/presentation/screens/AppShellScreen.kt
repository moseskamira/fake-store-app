package com.pay.productsapp.features.auth.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pay.productsapp.core.navigation.AppScreen
import com.pay.productsapp.core.navigation.AppShellNavigation
import com.pay.productsapp.core.navigation.AppShellNavScreen
import com.pay.productsapp.features.products.presentation.view_models.ProductViewModel
import com.pay.productsapp.features.users.presentation.view_models.UserViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppShellScreen(
    productViewModel: ProductViewModel,
    rootNavController: NavController,
    userViewModel: UserViewModel
) {
    val navController = rememberNavController()
    val items = listOf(
        AppShellNavScreen.Home,
        AppShellNavScreen.Products,
        AppShellNavScreen.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val currentTitle = items.find { it.route == currentRoute }?.title ?: "App"
    val snackBarHostState = remember { SnackbarHostState() }

    Scaffold(containerColor = Color.White, modifier = Modifier.fillMaxWidth(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = currentTitle, fontSize = 16.sp)
                }
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
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

    ) { paddingValues ->
        AppShellNavigation(
            rootNavController = rootNavController,
            productViewModel = productViewModel,
            navController = navController,
            userViewModel = userViewModel,
            modifier = Modifier.padding(paddingValues),
            snackBarHostState = snackBarHostState
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
