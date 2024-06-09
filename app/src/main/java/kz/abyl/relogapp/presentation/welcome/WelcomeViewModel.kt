package kz.abyl.relogapp.presentation.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kz.abyl.relogapp.domain.repository.AuthRepository
import kz.abyl.relogapp.presentation.sign_in.SignInState

class WelcomeViewModel(
    private val repository: AuthRepository
): ViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()

    private val _signOut = MutableStateFlow(false)
    val signOut: StateFlow<Boolean> = _signOut.asStateFlow()

    init {
        getEmail()
    }

    private fun getEmail() {
        viewModelScope.launch {
            try {
                val currentUser = repository.getCurrentUser()
                _email.value = currentUser?.email ?: "Guest"
            } catch (e: Exception) {
                _email.value = "Error fetching email"
            }
        }
    }

    fun signOut() {
        viewModelScope.launch {
            try {
                repository.signOut()
                _signOut.value = true
            } catch (e: Exception) {
                TODO()
            }
        }
    }
}