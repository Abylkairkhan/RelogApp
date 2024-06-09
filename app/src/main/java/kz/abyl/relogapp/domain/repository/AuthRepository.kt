package kz.abyl.relogapp.domain.repository

import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import kz.abyl.relogapp.util.Resource

interface AuthRepository {

    suspend fun signUp(email: String, password: String): Flow<Resource<FirebaseUser>>

    suspend fun signIn(email: String, password: String): Flow<Resource<FirebaseUser>>

    suspend fun signOut(): Boolean

    suspend fun checkCurrentUser(): Boolean

    suspend fun getCurrentUser(): FirebaseUser?

}