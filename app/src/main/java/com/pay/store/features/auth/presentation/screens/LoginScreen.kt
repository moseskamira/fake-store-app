package com.pay.store.features.auth.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pay.store.core.navigation.AppScreen
import com.pay.store.features.auth.data.models.LoginRequest
import com.pay.store.features.auth.presentation.view_models.AuthViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    authViewModel: AuthViewModel,
) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val loginResponse by authViewModel.loginResponse.observeAsState()
    val isLoading by authViewModel.isLoading.observeAsState(false)
    val errorMessage by authViewModel.error.observeAsState("")
    val snackBarHostState = remember { SnackbarHostState() }
    LaunchedEffect(loginResponse?.token) {
        val token = loginResponse?.token
        if (!token.isNullOrEmpty()) {
            navController.navigate(AppScreen.AppShell.route) {
                popUpTo(AppScreen.Login.route) { inclusive = true }
            }
        }
    }

    LaunchedEffect(errorMessage) {
        val message = errorMessage
        if (!message.isNullOrBlank()) {
            snackBarHostState.showSnackbar(
                message = message
            )
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome Back",
                fontSize = 28.sp,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Login to continue",
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(32.dp))
            OutlinedTextField(
                value = email.value,
                onValueChange = { newValue ->
                    email.value = newValue
                },
                label = {
                    Text(text = "UserName")
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                label = {
                    Text(text = "Password")
                },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(24.dp))
            if (isLoading) {
                Box(contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }

            } else {
                Button(
                    onClick = {
                        if (email.value.isNotEmpty() && password.value.isNotEmpty()) {
                            val loginRequest = LoginRequest(email.value, password.value)
                            authViewModel.login(loginRequest)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(text = "Login")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(
                onClick = {
                    // Navigate to register
                }
            ) {
                Text(text = "Test User: username: mor_2314 | password: 83r5^_", fontSize = 14.sp)
            }
        }
    }
}

