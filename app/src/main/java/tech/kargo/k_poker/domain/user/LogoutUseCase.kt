package tech.kargo.k_poker.domain.user

import tech.kargo.k_poker.data.AuthRepository

class LogoutUseCase(var authRepository: AuthRepository) {
    fun execute() {
        authRepository.requestLogout()
    }
}