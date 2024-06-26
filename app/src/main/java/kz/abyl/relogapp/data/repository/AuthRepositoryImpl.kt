package kz.abyl.relogapp.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import kz.abyl.relogapp.domain.repository.AuthRepository
import kz.abyl.relogapp.util.Resource

class AuthRepositoryImpl(
    private val authApi: FirebaseAuth
) : AuthRepository {
    override suspend fun signUp(email: String, password: String): Flow<Resource<FirebaseUser>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            try {
                val result = authApi.createUserWithEmailAndPassword(email, password).await()
                emit(Resource.Success(result.user))
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Unexpected error"))
            }
            emit(Resource.Loading(isLoading = false))
        }
    }

    override suspend fun signIn(email: String, password: String): Flow<Resource<FirebaseUser>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            try {
                val result = authApi.signInWithEmailAndPassword(email, password).await()
                emit(Resource.Success(result.user))
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Unexpected error"))
            }
            emit(Resource.Loading(isLoading = false))
        }
    }

    override suspend fun signOut(): Boolean {
        return try {
            authApi.signOut()
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun checkCurrentUser(): Boolean {
        return try {
            val currentUser = authApi.currentUser
            currentUser != null
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun getCurrentUser(): FirebaseUser? {
        return try {
            authApi.currentUser
        } catch (e: Exception) {
            null
        }
    }
}