package kz.abyl.relogapp.presentation.sign_up

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kz.abyl.relogapp.domain.repository.AuthRepository

class SignUpViewModel(
    private val repository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpState())
    val uiState: StateFlow<SignUpState> = _uiState.asStateFlow()

    fun onEvent(event: SignUpEvent) {
        when (event) {
            is SignUpEvent.RegisterButtonClicked ->
                registerButtonClicked(event.email, event.password, event.repeatPassword)
        }
    }

    private fun registerButtonClicked(email: String, password: String, repeatPassword: String) {
        if (email.isBlank()) _uiState.value =
            _uiState.value.copy(
                error = "Please enter email",
                isLoading = false
            )
        else if (password.isBlank()) _uiState.value =
            _uiState.value.copy(
                error = "Please enter password",
                isLoading = false
            )
        else if (password != repeatPassword) {
            _uiState.value =
                _uiState.value.copy(
                    error = "Passwords do not match",
                    isLoading = false
                )
        } else {

        }
    }
}