package com.pay.productsapp.features.users.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.pay.productsapp.features.users.presentation.components.UserList
import com.pay.productsapp.features.users.presentation.view_models.UserViewModel


@Composable
fun HomeScreen(viewModel: UserViewModel,  snackBarHostState: SnackbarHostState) {
    val isLoading = viewModel.isLoading.observeAsState(false)
    val errorMessage = viewModel.error.observeAsState("");
    val users = viewModel.users.observeAsState(emptyList())
    LaunchedEffect(Unit) {
        viewModel.getUsers()
    }

    LaunchedEffect(errorMessage.value) {
        val errorMessageValue = errorMessage.value
        if (!errorMessageValue.isNullOrBlank()) {
            snackBarHostState.showSnackbar(
                message = errorMessageValue
            )
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        if (isLoading.value) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                CircularProgressIndicator()
            }
        } else {
            UserList(users = users.value)
        }
    }
}



