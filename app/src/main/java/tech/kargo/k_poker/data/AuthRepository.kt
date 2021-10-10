package tech.kargo.k_poker.data

import tech.kargo.k_poker.cache.user.AuthCache
import tech.kargo.k_poker.remote.user.AuthRemote

class AuthRepository(var cache: AuthCache, var remote: AuthRemote) {

    fun requestLogin(username: String, password: String) : String {
        return remote.loggedIn(username, password)
    }

    fun requestLogout() {
        cache.clearToken()
    }

    fun requestCheckLoggedIn() : Boolean {
        return cache.isLoggedIn()
    }

    fun saveToken(token: String) {
        cache.saveToken(token)
    }

}