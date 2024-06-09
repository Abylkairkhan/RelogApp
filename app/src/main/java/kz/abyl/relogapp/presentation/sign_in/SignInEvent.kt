package kz.abyl.relogapp.presentation.sign_in

sealed class SignInEvent {
    data class LogInButtonClicked(
        val email: String,
        val password: String,
    ) : SignInEvent()
}