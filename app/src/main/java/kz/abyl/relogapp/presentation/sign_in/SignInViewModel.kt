package kz.abyl.relogapp.presentation.sign_in

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kz.abyl.relogapp.domain.repository.AuthRepository

class SignInViewModel(
    private val repository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignInState())
    val uiState: StateFlow<SignInState> = _uiState.asStateFlow()

    fun onEvent(event: SignInEvent) {
        when (event) {
            is SignInEvent.LogInButtonClicked -> logInButtonClicked(event.email, event.password)
        }
    }

    private fun logInButtonClicked(email: String, password: String) {

    }
}