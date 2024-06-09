package kz.abyl.relogapp.domain.repository

interface AuthRepository {
    suspend fun signUp(email: String, password: String)
//    : Resource<FirebaseUser>

    suspend fun signIn(email: String, password: String)
//    : Resource<FirebaseUser>

    suspend fun checkCurrentUser(): Boolean
}