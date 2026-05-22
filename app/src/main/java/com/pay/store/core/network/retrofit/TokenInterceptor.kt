package com.pay.store.core.network.retrofit

import android.content.Context
import com.pay.store.core.utils.SessionManager
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val sessionManager = SessionManager(context = context)
        val token = runBlocking {
            sessionManager.getToken().first()
        }
        val request = chain.request()
            .newBuilder()
            .apply {
                if (token != null) {
                    addHeader("Authorization", "Bearer $token")
                }
            }
            .build()
        return chain.proceed(request)
    }
}
