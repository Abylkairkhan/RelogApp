package kz.abyl.relogapp.presentation.sign_up

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kz.abyl.relogapp.R
import kz.abyl.relogapp.domain.repository.AuthRepository
import kz.abyl.relogapp.util.Resource

class SignUpViewModel(
    private val repository: AuthRepository,
    private val context: Context
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
                error = context.getString(R.string.please_enter_email),
                isLoading = false
            )
        else if (password.isBlank()) _uiState.value =
            _uiState.value.copy(
                error = context.getString(R.string.please_enter_password),
                isLoading = false
            )
        else if (password != repeatPassword) {
            _uiState.value =
                _uiState.value.copy(
                    error = "Passwords do not match",
                    isLoading = false
                )
        } else {
            viewModelScope.launch {
                repository.signUp(email, password).collect { response ->
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