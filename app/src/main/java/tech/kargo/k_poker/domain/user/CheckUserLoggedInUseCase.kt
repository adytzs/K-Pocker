package tech.kargo.k_poker.domain.user

import tech.kargo.k_poker.data.AuthRepository

class CheckUserLoggedInUseCase(var authRepository: AuthRepository) {

    fun execute() : Boolean {
        return authRepository.requestCheckLoggedIn()
    }

}