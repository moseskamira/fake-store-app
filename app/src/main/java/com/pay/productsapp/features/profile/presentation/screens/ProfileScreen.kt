package com.pay.productsapp.features.profile.presentation.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.pay.productsapp.core.navigation.AppScreen
import com.pay.productsapp.core.utils.SessionManager
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(rootNavController: NavController, context: Context) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val scope = rememberCoroutineScope()
        Text(
            text = "Profile Screen",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "User Profile Information"
        )

        Button(
            onClick = {
                val sessionManager = SessionManager(context = context)
                scope.launch {
                    sessionManager.setIsLoggedIn(false)
                }
                rootNavController.navigate(AppScreen.Login.route)

            }
        ) {

            Text(text = "Logout")
        }
    }
}