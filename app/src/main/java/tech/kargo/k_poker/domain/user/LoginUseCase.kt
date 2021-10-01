package tech.kargo.k_poker.domain.user

import tech.kargo.k_poker.data.AuthRepository
import tech.kargo.utilities.exception.MessageException

class LoginUseCase(var authRepository: AuthRepository) {

    fun execute(username: String, password: String) {
        if (username.isEmpty()) {
            throw MessageException("Invalid username")
        }

        if (password.isEmpty()) {
            throw MessageException("Invalid password")
        }

        val token = authRepository.requestLogin(username, password)
        authRepository.saveToken(token)
    }
}