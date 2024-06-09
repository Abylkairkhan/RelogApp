package kz.abyl.relogapp.presentation.sign_up

import kz.abyl.relogapp.presentation.sign_in.SignInEvent

sealed class SignUpEvent {
    data class RegisterButtonClicked(
        val email: String,
        val password: String,
        val repeatPassword: String
    ) : SignUpEvent()
}