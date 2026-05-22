package com.pay.store.core.network.responses

data class NetworkResponse<T>(
    val data: T? = null,
    val error: String? = null,
    val success: Boolean = false
)
