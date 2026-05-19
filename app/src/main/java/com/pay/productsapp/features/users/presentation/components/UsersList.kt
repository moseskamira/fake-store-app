package com.pay.productsapp.features.users.presentation.components

import UserItem
import androidx.compose.runtime.Composable
import com.pay.productsapp.features.users.data.models.UserDTO

@Composable
fun UserList(users: List<UserDTO>) {
    androidx.compose.foundation.lazy.LazyColumn {
        items(users.size) { index ->
            val user = users[index]
            UserItem(user)
        }
    }
}