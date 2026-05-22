package com.pay.store.core.network.retrofit

import kotlinx.coroutines.flow.MutableStateFlow

object AuthState {
    val token = MutableStateFlow<String?>(null)
}