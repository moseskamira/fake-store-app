package com.pay.store.features.users.presentation.components

import UserItem
import androidx.compose.runtime.Composable
import com.pay.store.features.users.domain.models.User

@Composable
fun UserList(users: List<User>) {
    androidx.compose.foundation.lazy.LazyColumn {
        items(users.size) { index ->
            val user = users[index]
            UserItem(user)
        }
    }
}