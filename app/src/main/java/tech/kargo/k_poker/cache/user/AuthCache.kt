package tech.kargo.k_poker.cache.user

import tech.kargo.k_poker.cache.utilities.CacheConstants
import tech.kargo.utilities.cache.CacheSharedPreferences

class AuthCache(var preferences: CacheSharedPreferences) {

    fun isLoggedIn() : Boolean {
        return preferences.getString(CacheConstants.KEY_TOKEN).isNotEmpty()
    }

    fun saveToken(token: String) {
        preferences.saveString(CacheConstants.KEY_TOKEN, token)
    }

    fun clearToken() {
        preferences.clear(CacheConstants.KEY_TOKEN)
    }

}