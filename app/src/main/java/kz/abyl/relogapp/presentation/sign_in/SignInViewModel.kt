package kz.abyl.relogapp.presentation.sign_in

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kz.abyl.relogapp.domain.repository.AuthRepository
import kz.abyl.relogapp.util.Resource

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
        else {
            viewModelScope.launch {
                repository.signIn(email, password).collect { response ->
                    when (response) {
                        is Resource.Success -> {
                            _uiState.value =
                                _uiState.value.copy(
                                    success = true,
                                    error = null,
                                    isLoading = false
                                )
                        }

                        is Resource.Error -> {
                            _uiState.value =
                                _uiState.value.copy(
                                    error = response.message,
                                    isLoading = false
                                )
                        }

                        is Resource.Loading -> {
                            _uiState.value =
                                _uiState.value.copy(
                                    isLoading = response.isLoading
                                )
                        }
                    }
                }
            }
        }
    }
}