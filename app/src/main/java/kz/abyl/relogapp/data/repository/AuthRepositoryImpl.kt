package kz.abyl.relogapp.data.repository

import kz.abyl.relogapp.domain.repository.AuthRepository

class AuthRepositoryImpl(

): AuthRepository {
    override suspend fun signUp(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun signIn(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun checkCurrentUser(): Boolean {
        TODO("Not yet implemented")
    }
}