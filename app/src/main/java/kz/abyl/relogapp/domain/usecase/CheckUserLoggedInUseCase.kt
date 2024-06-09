package kz.abyl.relogapp.domain.usecase

import kz.abyl.relogapp.domain.repository.AuthRepository

class CheckUserLoggedInUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(): Boolean {
        return repository.checkCurrentUser()
    }
}