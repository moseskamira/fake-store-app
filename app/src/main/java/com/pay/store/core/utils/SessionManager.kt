package com.pay.store.core.utils

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SessionManager(private val context: Context) {

    companion object {
        private val TOKEN_KEY = stringPreferencesKey("auth_token")
        private val IS_LOGGED_IN_KEY = booleanPreferencesKey("is_logged_in_token")
    }

    suspend fun saveToken(token: String) {
        context.authDataStore.edit { prefs ->
            prefs[TOKEN_KEY] = token
        }
    }

    suspend fun setIsLoggedIn(value:Boolean) {
        context.authDataStore.edit { prefs ->
            prefs[IS_LOGGED_IN_KEY] = value
        }
    }

    fun getToken(): Flow<String?> =
        context.authDataStore.data.map { it[TOKEN_KEY] }

    fun isLoggedIn(): Flow<Boolean> {
        return context.authDataStore.data.map { prefs ->
            prefs[IS_LOGGED_IN_KEY] ?: false
        }
    }

    suspend fun clearSession() {
        context.authDataStore.edit { prefs ->
            prefs.clear()
        }
    }
}